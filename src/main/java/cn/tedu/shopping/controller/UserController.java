package cn.tedu.shopping.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.tedu.shopping.entity.User;
import cn.tedu.shopping.service.IUserService;
import cn.tedu.shopping.util.JsonResult;


@RestController
@RequestMapping("users")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("reg")
	public JsonResult<Void> reg(User user) {
        // 執行註冊
		userService.reg(user);
		// 響應操作成功
		return new JsonResult<Void>(SUCCESS);
	}
	
	@RequestMapping("login")
	public JsonResult<User> login(
		String username, String password,
		HttpSession session) {		
		User user = userService.login(username, password);	    
		session.setAttribute("uid", user.getUid());
		session.setAttribute("username", user.getUsername());
		// 向客戶端響應操作成功
		return new JsonResult<>(SUCCESS, user);
	}
	
	@RequestMapping("change_password")
	public JsonResult<Void> changePassword(
			@RequestParam("old_password")String oldPassword,
			@RequestParam("new_password")String newPassword,
			HttpSession session){
		    // 從session中獲取uid和username
		    Integer uid = getUidFromSession(session);
		    String username = getUsernameFromSession(session);
		    // 執行修改密碼
		    userService.changePassword(uid, username, oldPassword, newPassword);
		    // 響應修改成功
	        return new JsonResult<Void>(SUCCESS);
	}
	
	@GetMapping("get_info")
	public JsonResult<User> getByUid(
			HttpSession session) {
		// 從session中獲取uid
		Integer uid = getUidFromSession(session);
		// 查詢匹配的資料
		User data = userService.getByUid(uid);
		// 響應
		return new JsonResult<>(SUCCESS, data);
	}

	@RequestMapping("change_info")
	public JsonResult<Void> changeInfo(
		User user, HttpSession session) {
		// 從session中獲取uid和username
		Integer uid = getUidFromSession(session);
	    String username = getUsernameFromSession(session);
		// 將uid和username封裝到user中
		user.setUid(uid);
		user.setUsername(username);
		// 執行修改
		userService.changeInfo(user);
		// 響應
		return new JsonResult<>(SUCCESS);
	}
}	
	
	
	


















	
	
	
	
	
	
	