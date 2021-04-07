package cn.tedu.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tedu.shopping.entity.District;
import cn.tedu.shopping.service.IDistrictService;
import cn.tedu.shopping.util.JsonResult;

@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController {
	
	@Autowired
	private IDistrictService districtService;
	

	@GetMapping("/")
	public JsonResult<List<District>> getByParent(String parent) {
		List<District> data = districtService.getByParent(parent);
		return new JsonResult<List<District>>(SUCCESS, data);
	}
	
	
	
}




















