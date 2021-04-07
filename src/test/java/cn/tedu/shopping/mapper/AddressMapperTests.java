package cn.tedu.shopping.mapper;



import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.shopping.entity.Address;



@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTests {
	
	@Autowired
	AddressMapper mapper;
	
	@Test
	public void insert() {
		Address address = new Address();
		address.setUid(15);
		address.setName("七七");
		Integer rows = mapper.insert(address);
		System.err.println("rows=" + rows);
		System.err.println("id=" + address.getAid());
	}

	
	@Test
	public void deleteByAid() {	
		Integer aid = 11;
		Integer rows = mapper.deleteByAid(aid);
		System.err.println("rows=" + rows);
	}

	@Test
	public void updateNonDefault() {
		Integer uid = 5;
		Integer rows = mapper.updateNonDefault(uid);
		System.err.println("rows=" + rows);
	}
	@Test
	public void updateDefault() {
		Integer aid = 12;
		String modifiedUser = "系統管理員";
		Date modifiedTime = new Date();	
		Integer rows = mapper.updateDefault(aid,modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	
	@Test
	public void countByUid() {
		Integer uid = 1;
		Integer count = mapper.countByUid(uid);
		System.err.println("count=" + count);
	}
	
	@Test
	public void findByUid() {
		Integer uid = 5;
		List<Address> list = mapper.findByUid(uid);
		System.err.println("BEGIN:");
		for (Address item : list) {
			System.err.println(item);
		}
		System.err.println("END.");
	}
	
	@Test
	public void findByAid() {
		Integer aid = 12;
		Address result = mapper.findByAid(aid);
		System.err.println(result);
	}
	
	@Test
	public void findLastModified() {
		Integer uid = 5;
		Address result = mapper.findLastModified(uid);
		System.err.println(result);
	}
	
}











