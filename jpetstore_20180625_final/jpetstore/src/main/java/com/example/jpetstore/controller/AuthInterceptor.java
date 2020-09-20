package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if( handler instanceof HandlerMethod == false ) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;

		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);


		if( auth == null ) {
			System.out.println("1");
			return true;
		}
		
		HttpSession session = request.getSession();
		if( session == null ) {
			response.sendRedirect(request.getContextPath() + "/shop/signonForm.do");
			return false;
		}

		UserSession authUser =(UserSession) session.getAttribute("userSession");
	    

	    if ( authUser == null ) {
	    	response.sendRedirect(request.getContextPath() + "/shop/signonForm.do");
	    	return false;
	    }
	    	
	    if( "admin".equals(authUser.getAccount().getUser_id()) == false ){
	    	response.sendRedirect(request.getContextPath() + "/shop/index.do");
	    	return false;
	    }
	    return true;
	}
}