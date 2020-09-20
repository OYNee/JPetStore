package com.example.jpetstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Bid;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
public class ListOrdersController {

	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@RequestMapping("/shop/listOrders.do")
	public ModelAndView handleRequest(
		@ModelAttribute("userSession") UserSession userSession
		) throws Exception {
		String username = userSession.getAccount().getUser_id();
		
		ModelAndView mv = new ModelAndView("tiles/ListOrders");
		
		List<Bid> bidList = petStore.getAuctionItemsByUsername(username);
		if(!CollectionUtils.isEmpty(bidList)) {
			for(int i=0; i<bidList.size(); i++) 
				bidList.get(i).setHighestBidPrice(petStore.getHighestBidPrice(bidList.get(i).getAuction_id()));
		}

		mv.addObject("orderList", petStore.getOrdersByUsername(username));
		System.out.println(petStore.getOrdersByUsername(username).toString());
		mv.addObject("bidList",bidList);
		
		return mv;
	}

}
