package cn.tedu.shopping.service;



import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.shopping.entity.District;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictServiceTests {
	
	@Autowired
	private IDistrictService service;
	
	@Test
	public void getdByParent() {
		String parent ="86";
		List<District> list = service.getByParent(parent);
		System.err.println("BEGIN:");
		for (District item : list) {
			
			System.err.println(item);
		}
		System.err.println("END.");
	}

	
	
	
}











