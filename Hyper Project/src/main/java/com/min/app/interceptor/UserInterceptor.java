package com.min.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.min.app.dto.User_Dto;

public class UserInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User_Dto dto = (User_Dto)session.getAttribute("Ldto");
		if(dto == null) {
			response.sendRedirect("/home");
			return false;
		}
		
		return true;
	}

}
