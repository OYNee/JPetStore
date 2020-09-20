package com.example.jpetstore.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Post;
import com.example.jpetstore.domain.QAndA;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
public class MyPostController {
	
	@Autowired
	private PetStoreFacade petStore;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/shop/myPosting.do")
	public ModelAndView handleRequest(HttpSession session,
			HttpServletRequest request,
			@RequestParam(value="page", required=false) String page,
			@RequestParam(value="tab", required=false) String tab
		) throws Exception {
		
		ModelAndView mv = new ModelAndView("tiles/MyPosting");
		
		UserSession userSession =(UserSession) session.getAttribute("userSession");
		
		PagedListHolder<Post> reviewList = null;
		PagedListHolder<QAndA> QuestionList = null;
		PagedListHolder<QAndA> AnswerList = null;
		
		if(page == null) {
	            // First Request, Return first set of list

			reviewList = new PagedListHolder<Post>(petStore.getReviewByUsername(userSession.getAccount().getUser_id()));
			reviewList.setPageSize(10);
	
			QuestionList = new PagedListHolder<QAndA>(petStore.getQuestionByUsername(userSession.getAccount().getUser_id()));
			QuestionList.setPageSize(10);
	
			AnswerList = new PagedListHolder<QAndA>(petStore.getAnswerByUsername(userSession.getAccount().getUser_id()));
			AnswerList.setPageSize(10);
			
	        request.getSession().setAttribute("reviewList", reviewList);
	        request.getSession().setAttribute("QuestionList", QuestionList);
	        request.getSession().setAttribute("AnswerList", AnswerList);
	        
	        mv.addObject("tab", "1");
	        
		} else if("next".equals(page)) {
			if("1".equals(tab)) {
				reviewList = (PagedListHolder<Post>) request.getSession()
	                    .getAttribute("reviewList");
				reviewList.nextPage();
			}
			else if("2".equals(tab)){
				QuestionList = (PagedListHolder<QAndA>) request.getSession()
	                    .getAttribute("QuestionList");
		        
				QuestionList.nextPage();
		        
			}
			else {
				AnswerList = (PagedListHolder<QAndA>) request.getSession()
	                    .getAttribute("AnswerList");
		        
				AnswerList.nextPage();
			}
			mv.addObject("tab", tab);
	        
		} else if("previous".equals(page)) {
			if("1".equals(tab)) {
				reviewList = (PagedListHolder<Post>) request.getSession()
	                    .getAttribute("reviewList");
				reviewList.previousPage();
			}
			else if("2".equals(tab)){
				QuestionList = (PagedListHolder<QAndA>) request.getSession()
	                    .getAttribute("QuestionList");
				
				QuestionList.previousPage();
			} else {
				AnswerList = (PagedListHolder<QAndA>) request.getSession()
	                    .getAttribute("AnswerList");
				
				AnswerList.previousPage();
			}
			mv.addObject("tab", tab);
		} else {
			if("1".equals(tab)) {
				reviewList = (PagedListHolder<Post>) request.getSession()
	                    .getAttribute("reviewList");
				reviewList.setPage(Integer.parseInt(page));
			}
			else if("2".equals(tab)){
				QuestionList = (PagedListHolder<QAndA>) request.getSession()
	                    .getAttribute("QuestionList");
				QuestionList.setPage(Integer.parseInt(page));
			} else {
				AnswerList = (PagedListHolder<QAndA>) request.getSession()
	                    .getAttribute("AnswerList");
				
				AnswerList.setPage(Integer.parseInt(page));
			}
			mv.addObject("tab", tab);
			
		}
		mv.addObject("reviewList", reviewList);
		mv.addObject("QuestionList", QuestionList);
		mv.addObject("AnswerList", AnswerList);
		return mv;
	}
}
