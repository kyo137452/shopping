package cn.tedu.shopping.mapper;

import java.util.List;

import cn.tedu.shopping.entity.Goods;

/**
 * 處理商品資料的持久層接口
 */
public interface GoodsMapper {
	
	/**
	  * 獲取暢銷商品列表
	 * @return
	 */
	List<Goods> findHotList();

	/**
	  * 根據商品id查詢商品詳情
	 * @param id 商品id
	 * @return 匹配的商品詳情,如果沒有匹配的資料,則返回null
	 */
	Goods findById(Long id);
	
	
}

















