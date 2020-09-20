package com.example.jpetstore.controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */

//가격 범위 설정 query & 가격 범위 설정 x query
@Controller
public class SearchProductsController { 

	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/shop/searchProducts.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="array", required=false) String array,
			@RequestParam(value="price_max", required=false) String priceMax,
			@RequestParam(value="price_min", required=false) String priceMin,
			@RequestParam(value="option", required=false) String option,
			@RequestParam(value="page", required=false) String page
			) throws Exception {
		if (keyword != null) {
			if (!StringUtils.hasLength(keyword)) {
				return new ModelAndView("Error", "message", "Please enter a keyword to search for, then press the search button.");
			}
			int pmax = -1;
			int pmin = 0;
			if(StringUtils.hasLength(priceMax))
				pmax = Integer.parseInt(priceMax);
			if(StringUtils.hasLength(priceMin))
				pmin = Integer.parseInt(priceMin);
			//System.out.println(keyword +" " + array + " pmax->" + pmax + "pmin->" + pmin +" " + option);

			PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.petStore.searchItemList(keyword.toLowerCase(), array, pmax, pmin, option));
			itemList.setPageSize(10);
			System.out.println(" ");
			request.getSession().setAttribute("SearchProductsController_productList", itemList);
			return new ModelAndView("tiles/SearchProducts", "productList", itemList);
		}
		else {
			@SuppressWarnings("unchecked")
			PagedListHolder<Item> itemList = (PagedListHolder<Item>)request.getSession().getAttribute("SearchProductsController_productList");
			//<Product일 때는 됐음>
			if (itemList == null) {
				return new ModelAndView("Error", "message", "Your session has timed out. Please start over again.");
			}
			if ("next".equals(page)) {
				itemList.nextPage();
			}
			else if ("previous".equals(page)) {
				itemList.previousPage();
			}
			else {
				itemList.setPage(Integer.parseInt(page));
			}
			return new ModelAndView("tiles/SearchProducts", "productList", itemList);
		}
	}
}
