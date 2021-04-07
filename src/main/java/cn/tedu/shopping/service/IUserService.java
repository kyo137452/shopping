package cn.tedu.shopping.service;

import cn.tedu.shopping.entity.User;
import cn.tedu.shopping.service.ex.InsertException;
import cn.tedu.shopping.service.ex.PasswordNotMatchException;
import cn.tedu.shopping.service.ex.UpdateException;
import cn.tedu.shopping.service.ex.UserNotFoundException;
import cn.tedu.shopping.service.ex.UsernameDuplicateException;

/**
 *處理用戶資料的業務層接口
 */
public interface IUserService {
	
	/**
	 * 用戶註冊
	 * @param user 用戶資料對象
	 * @throws UsernameDuplicateException 用戶不存在,例如尚未註冊,或註冊時名稱已經被使用
	 * @throws InsertException 插入用戶資料失敗的異常
	 */
	void reg(User user) 
		throws UsernameDuplicateException, 
		    InsertException;

	
	/**
	 * 用户登入
	 * @param username 用户名
	 * @param password 密碼
	 * @return 登入成功的用戶訊息
	 * @throws UserNotFoundException 用戶資料不存在，例如用戶尚未註冊，或用戶資料被標記為已刪除
	 * @throws PasswordNotMatchException 密碼錯誤
	 */
	User login(String username, String password) 
		throws UserNotFoundException, 
			PasswordNotMatchException; 



	/**
	 * 修改密碼
	 * @param uid 用戶的id
	 * @param username 用戶名稱
	 * @param oldPassword 原密碼
	 * @param newPassword 新密碼
	 * @throws UserNotFoundException 用戶資料不存在，或用戶資料被標記為已刪除
	 * @throws PasswordNotMatchException 原密碼錯誤
	 * @throws UpdateException 更新資料失敗
	 */
	void changePassword(
		Integer uid, String username, 
		  String oldPassword, String newPassword) 
			throws UserNotFoundException, 
				PasswordNotMatchException, UpdateException;

    /**
           * 根據用戶id查詢用戶資料
     * @param uid 用戶的id
     * @return 匹配的用戶資料,如果沒有匹配的資料,則返回null
     */
	User getByUid(Integer uid);
	
	/**
	 * 更新用戶基本資料
	 * @param user 封裝了用戶基本資料的對象，至少需要封裝用戶的id和用戶名，可選擇性的封裝用戶的手機號碼、電子信箱、年齡等
	 * @throws UserNotFoundException 嘗試訪問的用戶數據不存在，或者被標記為已刪除
	 * @throws UpdateException 更新用戶數據失敗
	 */
	void changeInfo(User user) 
		throws UserNotFoundException, UpdateException;



}



















