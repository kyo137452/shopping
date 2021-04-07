package cn.tedu.shopping.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.shopping.entity.Address;
import cn.tedu.shopping.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTests {
	
	@Autowired
	IAddressService service;
	
	@Test
	public void addnew() {
		try {
			Integer uid = 2;
			String username = "管理員";
			Address address = new Address();
			address.setName("小張同學");
			service.addnew(address, uid, username);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void getByUid() {
		Integer uid = 7;
		List<Address> list= service.getByUid(uid);
		System.err.println("BEGIN:");
		for (Address item : list) {
			System.err.println(item);
		}
		System.err.println("END.");
	}

	@Test
	public void setDefault() {
		try {
			Integer aid = 36;
			Integer uid = 7;
			String username = "悟空";
			service.setDefault(aid, uid, username);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	public void delete() {
		try {
			Integer aid = 12;
			Integer uid = 5;
			String username = "悟空";
			service.delete(aid, uid, username);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
}















