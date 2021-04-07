package cn.tedu.shopping.service;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import cn.tedu.shopping.entity.Goods;



@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTests {
	
	@Autowired
	private IGoodsService serive;
	
	@Test
	public void findHoList() {
		List<Goods> list = serive.getHotList();
		System.err.println("BEGIN:");
		for (Goods item : list) {
			System.err.println(item);
		}
		System.err.println("END.");
	}
	
	

}















