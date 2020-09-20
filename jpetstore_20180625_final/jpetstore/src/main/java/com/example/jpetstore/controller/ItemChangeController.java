package com.example.jpetstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.GeneralItem;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.service.PetStoreFacade;

@Controller
@RequestMapping("/shop")
public class ItemChangeController {
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@ModelAttribute("generalItem")
	public GeneralItem formBack() {
		GeneralItem gItem = new GeneralItem();
		return gItem;
	}
	
	@ModelAttribute("auctionItem")
	public AuctionItem formBack2() {
		AuctionItem aItem = new AuctionItem();
		return aItem;
	}
	
	
	@RequestMapping("/deleteItem.do")
	public String deleteItem(@RequestParam("itemId")String itemId) {
		String isAuction = this.petStore.getItem(itemId).getIsAuction();
		System.out.println("아이템 삭제 시작");
		
		if(isAuction.equals("on")) {
			AuctionItem item = this.petStore.getAuctionItem(itemId);
			petStore.deleteAuctionInfoAll(item.getAuctionId());
			petStore.deleteItemAll(itemId);
			System.out.println("itemId :"+itemId + ", auctionId:"+item.getAuctionId());
		}
		else {
			petStore.deleteItemAll(itemId);
			System.out.println("itemId :"+itemId);
		}
		
		System.out.println("아이템 삭제 완료");
		return "redirect:/shop/mySales.do";
	}
	
	
	//아이템 수정
	@RequestMapping("/updateItem.do")
	public String updateItem(ModelMap model, @RequestParam("itemId")String itemId) {
		String isAuction = this.petStore.getItem(itemId).getIsAuction();
		
		if(isAuction.equals("on")) {
			
			AuctionItem auctionItem = petStore.getAuctionItem(itemId);
			
			System.out.println(auctionItem.toString());
			System.out.println("경매 아이템 수정 시작");
			
			model.put("item", auctionItem);
			return "tiles/UpdateAuctionForm";
		}
		
		else {
			GeneralItem generalItem = petStore.getGeneralItem(itemId);
			System.out.println(generalItem.toString());
			System.out.println("일반 아이템 수정 시작");
		
			model.put("item", generalItem);
			
			return "tiles/UpdateGeneralForm";
			
		}
		
	}
	
	//일반 아이템 수정
	@RequestMapping(value="/updateGeneral.do", method = RequestMethod.POST, headers=("content-type=multipart/*"))
	public String updateGenralItem(@ModelAttribute("generalItem") GeneralItem generalItem,
    		BindingResult result, ModelMap model) {
		
		if(result.hasErrors()) {
			return "tiles/UpdateGeneralForm";
		}
		
		petStore.updateGeneralItemAll(generalItem);
		System.out.println(generalItem.toString());
		System.out.println("일반 아이템 수정 완료");
		return "redirect:/shop/mySales.do";
	}
	
	
	//경매 아이템 수정
	@RequestMapping(value="/updateAuctionItem.do", method = RequestMethod.POST, headers=("content-type=multipart/*"))
	public String updateAuctionItem(@ModelAttribute("auctionItem") AuctionItem auctionItem, BindingResult result, ModelMap model) {
		
		System.out.println("호잇");
		if(result.hasErrors()) {
			return "tiles/UpdateAuctionForm";
		}
		
		petStore.updateAuctionItemAll(auctionItem);
		System.out.println(auctionItem.toString());
		System.out.println("경매 아이템 수정 완료");
		
		return "redirect:/shop/mySales.do";
	}
	
	

}
