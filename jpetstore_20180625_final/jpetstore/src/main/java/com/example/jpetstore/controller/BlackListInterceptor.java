package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class BlackListInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if( handler instanceof HandlerMethod == false ) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;

		BlackList black = handlerMethod.getMethodAnnotation(BlackList.class);


		if( black == null ) {
			System.out.println("1");
			return true;
		}
		
		HttpSession session = request.getSession();
		System.out.println("어노테이션 처리");
		UserSession authUser =(UserSession) session.getAttribute("userSession");
		if(authUser != null) {
			ModelAndView modelAndView = new ModelAndView("tiles/NoAuth");
			System.out.println("블랙 유저 체크");
			if( authUser.getAccount().getOnBlackList() == 1 ) {
				throw new ModelAndViewDefiningException(modelAndView);
		    }
		}
		return true;

	}
}
