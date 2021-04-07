package cn.tedu.shopping.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;


/**
 * 登入攔截
 */
public class LoginInterceptor 
     implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 驗證用戶登入與否,如果登入就不攔截,為登入就攔截,並重定向到登入頁面
		// 拿到Session對象
		HttpSession session = request.getSession();
		
		// 判斷Session中有無uid,因為登入成功的時候往Session中存了uid,所以可以用uid作為判斷標準
		if (session.getAttribute("uid") == null) {
			// 重定向
			response.sendRedirect("/web/login.html");
			//攔截
			return false;
		}
		// 放行
		return true;
	}
	

}




























