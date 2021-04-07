package cn.tedu.shopping.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import cn.tedu.shopping.entity.User;
import cn.tedu.shopping.service.ex.ServiceException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {
	
	@Autowired
	IUserService service;
	
	
	@Test
	public void reg() {
		try {
		User user = new User();
		user.setUsername("kyo"); 
		user.setPassword("1234");
		user.setNickname("be");
		user.setEmail("1@gmail.com");
		user.setPhone("12345678");
		service.reg(user);
		System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
		
		
    }
	@Test 
	public void login() {
		try {
			String username = "900";
			String password = "1234";
			User user = service.login(username, password);
			System.err.println(user);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	
	
	@Test
	public void changePassword() {
		try {
		Integer uid = 4;
		String username = "rockman";
		String oldPassword = "1234";
		String newPassword = "0000";
		service.changePassword(uid, username, oldPassword, newPassword);
		System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}

		
	}	
	
	@Test
	public void getByUid() {
		Integer uid = 4;
		User user = service.getByUid(uid);
		System.err.println(user);
	}

	
	@Test
	public void changeInfo() {
		try {
			User user = new User();
			user.setUid(3);
			user.setUsername("L");
			user.setNickname("nick");
			user.setPhone("14381438");
			user.setEmail("100@777.com");
			service.changeInfo(user);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
}




























