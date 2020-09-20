package com.example.jpetstore.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.MySales;
import com.example.jpetstore.service.PetStoreFacade;


@Controller
public class MySalesController {
	
	@Autowired
	private PetStoreFacade petStore;
	
	@SuppressWarnings({ "null", "unchecked" })
	@RequestMapping("/shop/mySales.do")
	public ModelAndView handleRequest(HttpSession session,
			HttpServletRequest request,
			@RequestParam(value="page", required=false) String page,
			@RequestParam(value="tab", required=false) String tab
		) throws Exception {
		

		ModelAndView mv = new ModelAndView("tiles/MySales");
		
		UserSession userSession =(UserSession) session.getAttribute("userSession");
		
		List<MySales> salesList = petStore.getItemListByUserid(userSession.getAccount().getUser_id());
		
		List<MySales> salesList1_temp = new ArrayList<MySales>();
		List<MySales> salesList2_temp = new ArrayList<MySales>();
		
		for(MySales m:salesList) {
			if(m.getStatus().equals("on"))
				salesList1_temp.add(m);
			else
				salesList2_temp.add(m);
		}
		
		
		PagedListHolder<MySales> salesList1 = null;
		PagedListHolder<MySales> salesList2 = null;
		
		
		if(page == null) {
	            // First Request, Return first set of list
			salesList1 = new PagedListHolder<MySales>();
			salesList1.setSource(salesList1_temp);
			
			salesList2 = new PagedListHolder<MySales>();
			salesList2.setSource(salesList2_temp);

			salesList1.setPageSize(10);
			salesList2.setPageSize(10);
	        
	        request.getSession().setAttribute("salesList1", salesList1);
	        request.getSession().setAttribute("salesList2", salesList2);
	        
	        mv.addObject("tab", "1");
	        
		} else if("next".equals(page)) {
			if("1".equals(tab)) {
				salesList1 = (PagedListHolder<MySales>) request.getSession()
	                    .getAttribute("salesList1");
				salesList1.nextPage();
			}
			else {
				salesList2 = (PagedListHolder<MySales>) request.getSession()
	                    .getAttribute("salesList2");
		        
		        salesList2.nextPage();
		        
			}
			mv.addObject("tab", tab);
	        
		} else if("previous".equals(page)) {
			if("1".equals(tab)) {
				salesList1 = (PagedListHolder<MySales>) request.getSession()
	                    .getAttribute("salesList1");
				salesList1.previousPage();
			}
			else {
				salesList2 = (PagedListHolder<MySales>) request.getSession()
	                    .getAttribute("salesList2");
				
				salesList2.previousPage();
			}
			mv.addObject("tab", tab);
		} else {
			if("1".equals(tab)) {
				salesList1 = (PagedListHolder<MySales>) request.getSession()
	                    .getAttribute("salesList1");
				salesList1.setPage(Integer.parseInt(page));
			}
			else {
				salesList2 = (PagedListHolder<MySales>) request.getSession()
	                    .getAttribute("salesList2");
				
				salesList2.setPage(Integer.parseInt(page));
			}
			mv.addObject("tab", tab);
			
		}
		
		mv.addObject("salesList1", salesList1);
		mv.addObject("salesList2", salesList2);
		return mv;
		
	}
}
