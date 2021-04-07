package cn.tedu.shopping.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.shopping.entity.Goods;
import cn.tedu.shopping.mapper.GoodsMapper;
import cn.tedu.shopping.service.IGoodsService;

/**
  * 處理商品的業務層實現類
 */
@Service
public class GoodsServiceImpl implements IGoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> getHotList() {
		return findHotList();
	}
	
	@Override
	public Goods getById(Long id) {
		return findById(id);
	}

	/**
	  * 獲取促銷商品列表
	 * 
	 * @return 促銷商品列表
	 */
	private List<Goods> findHotList() {	
		return goodsMapper.findHotList();
	}
	
	/**
	 * 根據商品id查詢商品詳情
	 * @param id 商品id
	 * @return 匹配的商品詳情，如果没有匹配的資料，則返回null
	 */
	private Goods findById(Long id) {
		return goodsMapper.findById(id);
	}

	
}
