package cn.tedu.shopping.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import cn.tedu.shopping.entity.Cart;

/**
 * 處理購物車資料的持久層接口
 */
public interface CartMapper {
	
	/**
	  * 插入購物車資料
	 * @param cart 購物車資料
	 * @return 受影響的行數
	 */
	Integer insert(Cart cart);

	/**
	 * 修改購物車中商品的數量
	 * @param cid 購物車資料的id
	 * @param num 新的數量
	 * @param modifiedUser 修改執行人
	 * @param modifiedTime 修改時間
	 * @return 受影響的行數
	 */
	Integer updateNum(
		@Param("cid") Integer cid, 
		@Param("num") Integer num, 
		@Param("modifiedUser") String modifiedUser, 
		@Param("modifiedTime") Date modifiedTime);

	/**
	  * 根據用戶id和商品id查詢購物車資料
	 * @param uid 用戶id 
	 * @param gid 商品id
	 * @return 匹配的購物車資料,如果沒有匹配的購物車資料,則返回null
	 */
	Cart findByUidAndGid(
		@Param("uid") Integer uid,
		@Param("gid") Long gid);

}














