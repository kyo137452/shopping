package cn.tedu.shopping.service;

import java.util.List;

/**
 * 處裡收件地址資料的業務層接口
 */
import cn.tedu.shopping.entity.Address;
import cn.tedu.shopping.service.ex.AccessDeniedException;
import cn.tedu.shopping.service.ex.AddressCountLimitException;
import cn.tedu.shopping.service.ex.AddressNotFoundException;
import cn.tedu.shopping.service.ex.DeleteException;
import cn.tedu.shopping.service.ex.InsertException;
import cn.tedu.shopping.service.ex.UpdateException;

public interface IAddressService {
	
	/**
	 * 收件地址數量上限
	 */
	int ADDRESS_MAX_COUNT = 20;
	
	/**
	 * 增加新的收件地址
	 * @param address 收件地址資料
	 * @param uid 用戶id
	 * @param username 用戶名稱
	 * @throws AddressCountLimitException 收件地址數量達到上限
	 * @throws InsertException 插入資料時的異常
	 */
	void addnew(Address address, Integer uid, String username) 
		throws AddressCountLimitException, 
			InsertException;

	
	/**
	 * 根據用戶id查詢該用戶的收件地址列表
	 * @param uid 用户id該用戶的收件地址列表
	 */
	List<Address> getByUid(Integer uid);
	
	
	/**
	 * 把指定的收件地址設定為預設
	 * @param aid 收件地址
	 * @param uid 當前登入的用戶id
	 * @param username 當前登入名
	 * @throws AddressNotFoundException 收件地址資料不存在
	 * @throws AccessDeniedException 嘗試訪問他人的收件地址資料
	 * @throws UpdateException 更新資料異常
	 */
	void setDefault(Integer aid, 
		Integer uid, String username) 
		   throws AddressNotFoundException, 
			AccessDeniedException, 
			UpdateException;
	
	/**
	 * 刪除收件地址
	 * @param aid 收件地址
	 * @param uid 當前登入的用戶id
	 * @param username 當前登入名
	 * @throws AddressNotFoundException 收件地址資料不存在
	 * @throws AccessDeniedException 嘗試訪問他人的收件地址資料
	 * @throws DeleteException 刪除資料異常
	 * @throws UpdateException 更新資料異常
	 */
	void delete(Integer aid, 
		Integer uid, String username) 
		  throws AddressNotFoundException, 
				 AccessDeniedException, 
			     DeleteException, 
				 UpdateException;
	
}


























