package cn.tedu.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.shopping.entity.Goods;
import cn.tedu.shopping.service.IGoodsService;
import cn.tedu.shopping.util.JsonResult;

@RestController
@RequestMapping("goods")
public class GoodsController extends BaseController{
	
	@Autowired
	private IGoodsService goodsService;
	
	@GetMapping("hot")
	public JsonResult<List<Goods>> getHotList(){
		// 呼叫業務層對象獲取資料
		List<Goods> data = goodsService.getHotList();
		// 返回
		return new JsonResult<>(SUCCESS,data);
		
	}

}




















