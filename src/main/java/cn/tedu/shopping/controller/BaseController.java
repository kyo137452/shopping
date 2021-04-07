package cn.tedu.shopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ExceptionHandler;


import cn.tedu.shopping.service.ex.AddressCountLimitException;
import cn.tedu.shopping.service.ex.DeleteException;
import cn.tedu.shopping.service.ex.InsertException;
import cn.tedu.shopping.service.ex.PasswordNotMatchException;
import cn.tedu.shopping.service.ex.ServiceException;
import cn.tedu.shopping.service.ex.UpdateException;
import cn.tedu.shopping.service.ex.UserNotFoundException;
import cn.tedu.shopping.service.ex.UsernameDuplicateException;
import cn.tedu.shopping.util.JsonResult;

/**
  * 控制器的基類
 */
public abstract class BaseController {
	
	/**
	 * 操作結果的"成功"狀態
	 */
	public static final Integer SUCCESS = 2000;
	
	/**
	 * 從Session中獲取當前登入的用戶id
	 * @param session
	 * @return 當前登入的用戶id
	 */
	protected final Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}
	
	/**
	 * 從Session中獲取當前登入的用戶名
	 * @param session
	 * @return 當前登入的用戶
	 */
	protected final String getUsernameFromSession(HttpSession session) {
		return session.getAttribute("username").toString();
	}
	
	@ExceptionHandler(ServiceException.class)
	public JsonResult<Void> handlerException(Throwable e){
		JsonResult<Void> jr = new JsonResult<>();	
		jr.setMessage(e.getMessage());
		
		if (e instanceof UsernameDuplicateException) {
			// 4000-用戶不存在,例如尚未註冊,或註冊時名稱已經被使用
			jr.setState(4000);
		} else if (e instanceof UserNotFoundException) {
			// 4001-用戶資料不存在
			jr.setState(4001);
		} else if (e instanceof PasswordNotMatchException) {
			// 4002-密碼錯誤請重新輸入
			jr.setState(4002);
		} else if (e instanceof AddressCountLimitException) {
			// 4003-收件地址數量達到上限
			jr.setState(4003);
		} else if (e instanceof InsertException) {
			// 5000-插入資料時的異常
			jr.setState(5000);
		} else if (e instanceof UpdateException) {
			// 5001-更新資料異常
			jr.setState(5001);
	    } else if (e instanceof DeleteException) {
		    // 5002-刪除資料異常
		    jr.setState(5002);
	    }
		return jr;
	}

	
}



















