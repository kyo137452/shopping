package cn.tedu.shopping.mapper;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.shopping.entity.Cart;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTests {
	
	@Autowired
	private CartMapper mapper;
	
	@Test
	public void insert() {
		Cart cart = new Cart();
		cart.setUid(7);
		cart.setGid(1L);
		cart.setNum(4);
		Integer rows = mapper.insert(cart);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateNum() {
		Integer cid = 2;
		Integer num = 6;
		String modifiedUser = "管理員";
		Date modifiedTime = new Date();
		Integer rows = mapper.updateNum(cid, num, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByUidAndGid() {
		Integer uid = 7;
		Long gid = 1L;
		Cart result = mapper.findByUidAndGid(uid, gid);
		System.err.println(result);
	}

}








