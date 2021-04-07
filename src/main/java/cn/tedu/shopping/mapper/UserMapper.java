package cn.tedu.shopping.mapper;





import java.util.Date;

import org.apache.ibatis.annotations.Param;


import cn.tedu.shopping.entity.User;
/**
 * 處理用戶資料的持久層接口
 */
public interface UserMapper {

	/**
	 * 插入用戶資料
	 * @param user 用戶資料對象
	 * @return 受影響的行數
	 */
	Integer insert(User user);
	
	
	
	/**
	 * 更新用戶基本資料
	 * @param user 用戶資料
	 * @return 受影響的行數
	 */
	Integer updateInfo(User user);
	
	
	/**
	 * 更新密碼
	 * @param uid 用戶的id
	 * @param password 新密碼
	 * @param modifiedUser 修改執行的人
	 * @param modifiedTime 修改時間
	 * @return 受影響的行數
	 */

	Integer updatePassword(
			@Param("uid") Integer uid,
			@Param("password") String password,
			@Param("modifiedUser") String modifiedUser,
			@Param("modifiedTime") Date modifiedTime);
	
	
	/**
	  * 根據用戶id查詢資料
	 * @param uid 用戶id
	 * @return 配的用戶資料,如果沒有匹配的用戶資料,則返回null
	 */
	User findByUid(Integer uid);
	
	
	
	/**
	  * 根據用戶名稱查詢用戶資料
	 * @param username 用戶名稱
	 * @return 匹配的用戶資料,如果沒有匹配的用戶資料,則返回null
	 */
	User findByUsername(String username);
	


}

















