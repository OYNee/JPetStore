package com.example.jpetstore.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Bid;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@RequestMapping("/shop")
@SessionAttributes("userSession")
public class PartInAuctionController {
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@RequestMapping(value={"/partInAuction.do", "/updateBid.do", "/deleteBid.do"}, method = RequestMethod.GET)
	public ModelAndView showAuction(HttpServletRequest request,
			@RequestParam("auctionId") String auctionId,
			@RequestParam("itemId") String itemId) {
		
		//��������
		List<Bid> bidList = petStore.getBidByAuctionId(auctionId);
		//추가
		List<Bid> bidListChart = petStore.getBidByAuctionIdASC(auctionId);
		int highestBidPrice = 0;
		try {
			highestBidPrice = bidList.get(0).getBid_price();
		}
		catch(IndexOutOfBoundsException ex){
			highestBidPrice = petStore.getAuctionItem(itemId).getStartPrice();
		}
		//����� bid
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		Integer myBidPrice = petStore.getBidPriceByUsername(userSession.getAccount().getUser_id(), auctionId);
		if(myBidPrice == null)
			myBidPrice = 0;
		
		int theNumberOfParticipant = bidList.size();
		
		ModelAndView mv = new ModelAndView("tiles/PartInAuction");
		
		mv.addObject("highestBidPrice", highestBidPrice);
		mv.addObject("bidList", bidList);
		mv.addObject("myBidPrice", myBidPrice);
		mv.addObject("theNumberOfParticipant", theNumberOfParticipant);
		mv.addObject("auctionId", auctionId);
		mv.addObject("itemId", itemId);
		mv.addObject("bidderInfo", "None");
		
		mv.addObject("bidListChart", bidListChart);

		//���� ��Ű� ����� ��ǰ�̶��?
		if(petStore.getItem(itemId).getStatus().equals("off")) {
			mv.addObject("bidderInfo", petStore.getHighestBidder(auctionId));
			mv.addObject("userId", userSession.getAccount().getUser_id());
		}
		return mv;
	}
	
	@RequestMapping(value = "/updateBid.do", method = RequestMethod.POST)
	public String updateBid(HttpServletRequest request,
			@RequestParam("auctionId") String auctionId,
			@RequestParam("itemId") String itemId,
			@RequestParam("price") int price,
			@RequestParam("myBidPrice") int myBidPrice,
			@RequestParam("highestBidPrice") int highestBidPrice) {
		
		if(highestBidPrice>=price)
			return "redirect:/shop/updateBid.do?auctionId="+auctionId+"&&"+"itemId="+itemId;
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if(myBidPrice == 0) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
			Bid bid = new Bid(auctionId, userSession.getAccount().getUser_id(), dateFormat.format(Calendar.getInstance().getTime()), price);
			petStore.insertBid(bid);
		} else
			petStore.updateBid(userSession.getAccount().getUser_id(), price);
		
		return "redirect:/shop/updateBid.do?auctionId="+auctionId+"&&"+"itemId="+itemId;
	}
	
	@RequestMapping(value = "/deleteBid.do", method = RequestMethod.POST)
	public String deleteBid(HttpServletRequest request,
			@RequestParam("auctionId") String auctionId,
			@RequestParam("itemId") String itemId,
			@RequestParam("deleteOk") String deleteOk) {
		if(deleteOk.equals("No"))
			return "redirect:/shop/updateBid.do?auctionId="+auctionId+"&&"+"itemId="+itemId;
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		petStore.deleteBid(userSession.getAccount().getUser_id(), auctionId);
		return "redirect:/shop/deleteBid.do?auctionId="+auctionId+"&&"+"itemId="+itemId;
	}
}
