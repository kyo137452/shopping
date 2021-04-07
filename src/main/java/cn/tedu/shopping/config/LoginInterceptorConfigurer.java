package cn.tedu.shopping.config;

import java.util.ArrayList;
import java.util.List;



/**
 * 登入攔截
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cn.tedu.shopping.interceptor.LoginInterceptor;

@Configuration
public class LoginInterceptorConfigurer 
  implements WebMvcConfigurer {

	@Override
	public void addInterceptors(
		  InterceptorRegistry registry) {
		 //新增攔截器的對象
		  LoginInterceptor interceptor
	     	= new LoginInterceptor();
		
		// 白名單
		List<String> excludePaths = new ArrayList<>();
		excludePaths.add("/js/**");
		excludePaths.add("/css/**");
		excludePaths.add("/bootstrap3/**");
		excludePaths.add("/images/**");
		
		excludePaths.add("/web/register.html");
		excludePaths.add("/web/login.html");
		excludePaths.add("/web/index.html");
		excludePaths.add("/web/product.html");
		
		excludePaths.add("/users/reg");
		excludePaths.add("/users/login");
		excludePaths.add("/districts/");
		excludePaths.add("/goods/**");
		
		// 註冊攔截器，設定黑白名單
	     registry.addInterceptor(interceptor)
	    	.addPathPatterns("")
	      	.excludePathPatterns(excludePaths);
	}

	
	
}































