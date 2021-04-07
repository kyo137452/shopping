package cn.tedu.shopping.mapper;


import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.shopping.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {
	

	@Autowired
	private UserMapper mapper;
	
	@Test 
	public void insert() {
	    User user = new User();
		user.setUsername("root");	
		user.setNickname("word");
		user.setPhone("0977123456");
		user.setEmail("11@gg.com");	
		user.setPassword("1234");
		Integer rows = mapper.insert(user);
		System.err.println("rows=" + rows);
	}
	
	@Test 
	public void updateInfo() {
		User user = new User();
		user.setUid(5);
		user.setNickname("白");
		user.setPhone("99999");
		user.setEmail("11@qq.com");	
		Integer rows = mapper.updateInfo(user);
		System.err.println("rows=" + rows);
	}
	

	@Test 
	public void updatePassword() {
	    Integer uid = 39;
	    String password ="8888";
	    String modifiedUser = "su";
	    Date modifiedTime = new Date();
		Integer rows = mapper.updatePassword(uid, password, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test 
	public void findByUid() {
		Integer uid = 34;
		User user = mapper.findByUid(uid);
		System.err.println(user);
	}
	
	@Test 
	public void findByUsername() {
		String username = "root";	
		User user = mapper.findByUsername(username);
		System.err.println(user);
	}

}




