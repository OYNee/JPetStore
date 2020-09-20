package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.jpetstore.service.PetStoreFacade;

public class PageInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private PetStoreFacade petStore;
	

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if( handler instanceof HandlerMethod == false ) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod)handler;

		CheckPage cp= handlerMethod.getMethodAnnotation(CheckPage.class);


		if( cp == null ) {
			System.out.println("1");
			return true;
		}
		
		HttpSession session = request.getSession();
		
		UserSession authUser =(UserSession) session.getAttribute("userSession");
		if(authUser != null) {
			System.out.println("관리자");
			if( "admin".equals(authUser.getAccount().getUser_id()) == true ){
		    	return true;
		    }
		}


		String url = request.getRequestURL().toString();
	    if ( request.getQueryString() != null ) {
	    	url = url + "?" + request.getQueryString();
	    	  
	    	String splitUrl[] = url.split("jpetstore");
	    	url = splitUrl[1];
	    }

	    int count = petStore.pageComplainCount(url);

	    if(count > 10) {
	    	System.out.println("블라인드 걸림");
	    	ModelAndView modelAndView = new ModelAndView("tiles/BlindPage");
	    	throw new ModelAndViewDefiningException(modelAndView);
	    }
	    
	    return true;
	}
}
