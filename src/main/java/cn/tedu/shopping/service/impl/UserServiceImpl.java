package cn.tedu.shopping.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.tedu.shopping.entity.User;
import cn.tedu.shopping.mapper.UserMapper;
import cn.tedu.shopping.service.IUserService;
import cn.tedu.shopping.service.ex.InsertException;
import cn.tedu.shopping.service.ex.PasswordNotMatchException;
import cn.tedu.shopping.service.ex.UpdateException;
import cn.tedu.shopping.service.ex.UserNotFoundException;
import cn.tedu.shopping.service.ex.UsernameDuplicateException;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void reg(User user) throws UsernameDuplicateException, InsertException { 
		// 根據參數user對象中的username屬性查詢資料：userMapper.findByUsername()
		String username = user.getUsername();
		String nickname = user.getNickname();
		String phone = user.getPhone();
		String email = user.getEmail();
		User result = userMapper.findByUsername(username);
		// 判斷查詢結果是否不為null（查詢結果是存在的）
			if (result != null ) {
		// 是：用户名已被占用，抛出UsernameDuplicateException
		   throw new UsernameDuplicateException(
			 "註冊失敗!嘗試用戶名已經被占用!(" + username + ")已經被使用了!");
		} 
		  if("".equals(username)|| "".equals(nickname)||"".equals(phone)||"".equals(email)) {
			// 是：用户名已被占用，抛出UsernameDuplicateException
			   throw new UsernameDuplicateException(
				 "註冊失敗!請重新輸入!");  
		  }
	     
		//  得到鹽值
		System.out.println("reg() > password=" + user.getPassword());
		String salt = UUID.randomUUID().toString().toUpperCase();
		//  基於參數user對象中的password進行加密過程，得到加密後的密碼
		String md5Password = getMd5Password(user.getPassword(), salt);
		//  將加密後的密碼和鹽值封裝到user中
	    user.setSalt(salt);
	    user.setPassword(md5Password);
	    System.out.println("reg() > salt=" + salt);
	    System.out.println("reg() > md5Password=" + md5Password);
		
	   // 把user中的isDelete設定為0
     	user.setIsDelete(0);	
		
		// 封裝user中的4個日誌属性
		Date now = new Date();
	    user.setCreatedUser(username);   
		user.setCreatedTime(now);
		user.setModifiedUser(username);
		user.setModifiedTime(now);
		
		// 執行註冊：userMapper.insert(user)
	    Integer rows = userMapper.insert(user);
	    if(rows != 1 ) {
	    	throw new InsertException(
	    		"註冊失敗!資料寫入時出現未知錯誤!");
	   }
	}
	
	
	
		
	
	
	@Override
	public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		// 根據參數username執行查詢用戶資料
		User result = userMapper.findByUsername(username);
		// 判斷查詢結果是否為null
		if (result == null) {
			// 拋出：UserNotFoundException
			throw new UserNotFoundException(
				"登入失敗！用戶資料不存在");
		}
		// 判斷查詢結果中的isDelete為1
		if (result.getIsDelete() == 1) {
			// 抛出：UserNotFoundException
			throw new UserNotFoundException(
				"登入失敗！用戶資料不存在");
		}

		// 從查詢結果中獲取鹽值
		String salt = result.getSalt();
		// 根據參數password和鹽值一起進行加密，得到加密後的密碼
		String md5Password = getMd5Password(password, salt);
		// 判断查询结果中的password和以上加密後的密碼是否不一致
		if (!result.getPassword().equals(md5Password)) {
			// 抛出：PasswordNotMatchException
			throw new PasswordNotMatchException(
				"密碼錯誤請重新輸入"); 
		}

		// 將查詢結果中的password、salt、isDelete設定為null
		result.setPassword(null);
		result.setSalt(null);
		result.setIsDelete(null);
		// 返回查詢結果
		return result;
	}
	
	

	@Override
	public void changePassword(Integer uid, String username, String oldPassword,String newPassword)
			throws UserNotFoundException, PasswordNotMatchException, UpdateException {
		System.err.println("changePassword() ---> BEGIN:");
		System.err.println("changePassword() 原密碼=" + oldPassword);
		System.err.println("changePassword() 新密碼=" + newPassword);
		// 根據參數uid查詢用戶資料
		User result = userMapper.findByUid(uid);
		// 判斷查詢結果是否為null
		if (result == null || result.getIsDelete() == 1 && !result.equals("")) {
			// 拋出：UserNotFoundException
			throw new UserNotFoundException(
				"修改密碼失敗！請重新輸入");
		}

		// 查詢結果中獲取鹽值
		String salt = result.getSalt();
		// 根據參數oldPassword和鹽值一起進行加密，得到加密後的密碼
		String oldMd5Password = getMd5Password(oldPassword, salt);
		System.err.println("changePassword() 鹽值=" + salt);
		System.err.println("changePassword() 原密碼加密=" + oldMd5Password);
		System.err.println("changePassword() 正確密碼=" + result.getPassword());
		// 判斷新密碼跟原密碼以及確認密碼是否不一致
		if(!result.getPassword().equals(oldMd5Password)) {
		// 拋出：PasswordNotMatchException
			throw new PasswordNotMatchException(
					"修改密碼失敗!原始密碼錯誤!");
		}
	
		// 根據參數newPassword和鹽值一起進行加密，得到加密後的密碼
		String newMd5Password = getMd5Password(newPassword, salt);
		System.err.println("changePassword() 新密碼加密=" + newMd5Password);	
		// 創建當前時間對象
		Date now = new Date();
		// 執行更新密碼，並獲取返回的受影響的行數
		Integer rows = userMapper.updatePassword(uid, newMd5Password, username, now);
		// 判斷受影響的行數是否不為1
		if(rows!= 1 ) {
			// 拋出：UpdateException
			throw new UpdateException(
				"修改密碼失敗!更新密碼時出現未知錯誤!請重新操作");
		}
		System.err.println("changePassword() ---> END.");
		
	}

	@Override
	public User getByUid(Integer uid) {
		// 根據uid查詢用戶資料
		User result = userMapper.findByUid(uid);
		// 如果查詢到資料，則需要將查詢結果中的password、salt、is_delete設定為null
		if (result != null) {
			result.setPassword(null);
			result.setSalt(null);
			result.setIsDelete(null);
		}

		// 將查詢結果返回
		return result;
	}
	
	@Override
	public void changeInfo(User user) throws UserNotFoundException, UpdateException {
		// 根據參數user中的uid，即user.getUid()查詢資料
		User result = userMapper.findByUid(user.getUid());
		// 檢查查詢結果是否存在，是否標記為刪除
		// 判斷查詢結果是否為null
		// 判斷查詢結果中的isDelete為1
		if (result == null ||(result.getIsDelete() == 1) ) {
			// 拋出：UserNotFoundException
			throw new UserNotFoundException(
				"修改個人資料失敗！用户資料不存在！");
		}

		// 創建當前時間對象
		Date now = new Date();
		// 將時間封裝到參數user中
		user.setModifiedUser(user.getUsername());
		user.setModifiedTime(now);
		//執行修改個人資料：mapper.updateInfo(user) > update t_user set phone=?, email=?, gender=?, modified_user=?, modified_time=? where uid=?
		 Integer rows = userMapper.updateInfo(user);
		// 判斷以上修改時的返回值是否不為1
		if (rows != 1) {
			// 拋出：UpdateException 
			throw new UpdateException(
				"修改個人資料失敗！更新用戶資料時出現未知錯誤！");
		}
	}

	/**
	 * 對密碼進行加密
	 * @param password 原始密碼
	 * @param salt 鹽值
	 * @return 加密後的密碼
	 */
	private String getMd5Password(String password, String salt) {
		// 規則：對password+salt進行三次加密
		String str = password + salt;
		for (int i = 0; i < 3; i++) {
			str = DigestUtils
				.md5DigestAsHex(str.getBytes()).toUpperCase();
		}
		return str;
	}


}
	

	

	








