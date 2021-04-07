package cn.tedu.shopping.service;

import java.util.List;

import cn.tedu.shopping.entity.Goods;

public interface IGoodsService {

	/**
	  * 獲取熱銷商品列表
	 * @return 熱銷商品列表
	 */
	List<Goods> getHotList();
	
	/**
	 * 根據商品id查詢商品詳情
	 * @param id 商品id
	 * @return 匹配的商品詳情，如果没有匹配的資料，則返回null
	 */
	Goods getById(Long id);
	
}



















