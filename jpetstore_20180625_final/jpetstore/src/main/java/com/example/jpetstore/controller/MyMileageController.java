package com.example.jpetstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Mileage;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
public class MyMileageController {
	
	@Autowired
	private PetStoreFacade petStore;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/shop/myMileage.do")
	public ModelAndView handleRequest(HttpSession session,
			HttpServletRequest request,
			@RequestParam(value="page", required=false) String page
		) throws Exception {
		
		UserSession userSession =(UserSession) session.getAttribute("userSession");
		
		
		PagedListHolder<Mileage> mileageList = null;
		
		
		if(page == null) {
	            // First Request, Return first set of list
			mileageList = new PagedListHolder<Mileage>();
			mileageList.setSource(petStore.getMileageListByUsername(userSession.getAccount().getUser_id()));

			mileageList.setPageSize(10);
	        
	        request.getSession().setAttribute("mileageList", mileageList);
	        
	        
		} else if("next".equals(page)) {
			mileageList = (PagedListHolder<Mileage>) request.getSession().getAttribute("mileageList");
			mileageList.nextPage();
	        
		} else if("previous".equals(page)) {
			mileageList = (PagedListHolder<Mileage>) request.getSession()
					.getAttribute("mileageList");
			mileageList.previousPage();
		} else {
			mileageList = (PagedListHolder<Mileage>) request.getSession()
	                    .getAttribute("mileageList");
			mileageList.setPage(Integer.parseInt(page));
		}
		return new ModelAndView("tiles/MyMileage", 
				"mileageList", mileageList);
	}
}
