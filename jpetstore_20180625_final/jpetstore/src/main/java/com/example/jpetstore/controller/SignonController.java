package com.example.jpetstore.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Advertisement;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.PetStoreFacade;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
public class SignonController { 

	private PetStoreFacade petStore;
	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/shop/signon.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) throws Exception {
		
		Account account = petStore.getAccount(username, password);
		if (account == null) {
			return new ModelAndView("Error", "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			UserSession userSession = new UserSession(account);
			PagedListHolder<Product> myList = new PagedListHolder<Product>(this.petStore.getProductListByCategory(account.getFavouriteCategoryId()));
			myList.setPageSize(4);
			userSession.setMyList(myList);
			model.addAttribute("userSession", userSession);
			if (forwardAction != null) 
				return new ModelAndView("redirect:" + forwardAction);
			else 
				return adList(account.getFavouriteCategoryId());
		}
	}
	public ModelAndView adList(String favcate) {
		//1. 광고 품목들 불러오기(status가 2면서 오늘 날짜가 기간 안에 있어야 한다)
		Calendar c = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String today = dateFormat.format(c.getTime());
		List<Advertisement> list = new ArrayList<Advertisement>();
		list = this.petStore.favAdvertise(favcate, today);
		List<Advertisement> firstAdList = new ArrayList<Advertisement>();
		List<Advertisement> secondAdList = new ArrayList<Advertisement>();
		
		int idx[] = new int[6];
		if(!CollectionUtils.isEmpty(list)) {
			for(int i=0; i<idx.length && i<list.size(); i++) {
				idx[i]=(int)(Math.random()*list.size());
				for(int j=0; j<i; j++) {
					if(i!=0 && idx[i] == idx[j]) {
						i--;
						break;
					}
				}
				System.out.println(idx[i]);
			}
			for(int i=0; i<idx.length && i<list.size(); i++) {
				
				if(i<idx.length/2) {
					firstAdList.add(list.get(idx[i]));
				}
				else {
					secondAdList.add(list.get(idx[i]));
				}
			}
		}
		ModelAndView m = new ModelAndView("tiles/index");
		m.addObject("firstAdList", firstAdList);
		m.addObject("secondAdList",secondAdList);
		//2. 불러온 품목의 이미지명, itemid, bannertitle을 banner에 담아서 model에 담아 보내기
		return m;
		
	}
}
