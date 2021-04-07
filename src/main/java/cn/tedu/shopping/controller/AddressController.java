package cn.tedu.shopping.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.tedu.shopping.entity.Address;
import cn.tedu.shopping.service.IAddressService;
import cn.tedu.shopping.util.JsonResult;

@RestController
@RequestMapping("addresses") 
public class AddressController extends BaseController {

	
	@Autowired 
	private IAddressService addressService;
	
	@RequestMapping("addnew")
	public JsonResult<Void> addnew(
		Address address, HttpSession session) {
		// 從Session中獲取uid和username
		Integer uid = getUidFromSession(session);
		String username = getUsernameFromSession(session);
		// 呼叫業務層對象執行增加
		addressService.addnew(address, uid, username);
		// 響應成功
		return new JsonResult<>(SUCCESS);

   }
	
	@GetMapping("/")
	public JsonResult<List<Address>> getByUid(
			HttpSession session){
		// 從session中獲取uid
		Integer uid = getUidFromSession(session);
		// 呼叫業務層對象獲取資料
		List<Address> data = addressService.getByUid(uid);
		// 響應
		return new JsonResult<>(SUCCESS,data);
	}

	@RequestMapping("{aid}/set_default")
	public JsonResult<Void> setDefault(
		@PathVariable("aid") Integer aid,
		HttpSession session) {
    	// 從Session中獲取uid和username
    	Integer uid = getUidFromSession(session);
    	String username = getUsernameFromSession(session);
		// 呼叫業務層對向執行設定預設
    	addressService.setDefault(aid, uid, username);
		// 響應成功
    	return new JsonResult<>(SUCCESS); 
	}
    
    @RequestMapping("{aid}/delete")
    public JsonResult<Void> delete(
    		@PathVariable("aid") Integer aid,
    		HttpSession session) {
    	// 從Session中獲取uid和username
    	Integer uid = getUidFromSession(session);
    	String username = getUsernameFromSession(session);
    	// 呼叫業務層對向執行設定預設
    	addressService.delete(aid, uid, username);
    	// 響應成功
    	return new JsonResult<>(SUCCESS); 
    }
	
}	
	
	








































