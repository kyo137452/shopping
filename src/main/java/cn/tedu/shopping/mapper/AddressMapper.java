package cn.tedu.shopping.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.shopping.entity.Address;

/**
 * 處裡收件地址資料的持久層接口
 */
public interface AddressMapper {
	
	/**
	 * 插入收件地址資料
	 * @param address 收件地址資料
	 * @return 返回受影響的行數
	 */
	Integer insert(Address address);
	
	/**
	 * 根據收件地址id刪除資料
	 * @param aid 收件地址id
	 * @return 受影響的行數
	 */
	Integer deleteByAid(Integer aid);
	
	/**
	 * 根據收件地址id修改資料
	 * @param aid 收件地址id
	 * @return 受影響的行數
	 */
	Integer updateaddress(Integer aid);
	
	
	
	/**
	 * 把某用戶的所有收件地址設定為非預設
	 * @param uid 用戶id
	 * @return 受影響的行數
	 */
	Integer updateNonDefault(Integer uid);
	
	/**
	 * 把指定的收件地址設定為預設
	 * @param aid 收件地址的資料id
	 * @param modifiedUser 修改執行人
	 * @param modifiedTime 修改時間
	 * @return 返回受影響的行數
	 */
	Integer updateDefault(
		@Param("aid") Integer aid, 
		@Param("modifiedUser") String modifiedUser, 
		@Param("modifiedTime") Date modifiedTime);
	
	/**
	 * 統計某個用戶收件地址資料的數量
	 * @param uid 用戶的id
	 * @return 返回該用戶的收件地址資料的數量
	 */
	Integer countByUid(Integer uid);

	/**
	 * 根據用戶id查詢該用戶的收件地址列表
	 * @param uid 用戶id
	 * @return 該用戶的收件地址列表
	 */
	List<Address> findByUid(Integer uid);
	
	/**
	 * 根據資料收件地址的資料id查詢詳情
	 * @param aid 收件地址的資料id
	 * @return 匹配收件地址的詳情,如果沒有則返回null
	 */
	Address findByAid(Integer aid);
	
	/**
	 * 查詢某用戶最後一次修改的收件地址資料
	 * @param uid 用戶的id
	 * @return 匹配的收件地址的詳情,如果沒有則返回null
	 */
	Address findLastModified(Integer uid);
	
	

	
	
}














