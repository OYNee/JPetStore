package com.example.jpetstore.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.dao.SequenceDao;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.FileVO;
import com.example.jpetstore.service.PetStoreFacade;


@Controller
@RequestMapping("/shop")
public class AuctionSaleController {
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@Autowired
	private SequenceDao sequenceDao;
	
	@ModelAttribute("auctionItem")
	public AuctionItem formBack() {
		AuctionItem auctionItem = new AuctionItem();
		 auctionItem.setIsAd("0");
		 auctionItem.setStatus("on");
		 auctionItem.setIsAuction("on");
		return auctionItem;
	}
	
	@BlackList
	@RequestMapping(value="/auctionSave.do", method = RequestMethod.POST, headers=("content-type=multipart/*"))
	public String auctionSubmit(@ModelAttribute("auctionItem") AuctionItem auctionItem,
	    		BindingResult result, MultipartHttpServletRequest request, ModelMap model, @RequestParam("files") MultipartFile files) throws Exception {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		if(result.hasErrors()) {
			return "tiles/AuctionSellForm";
		}
		//�̹����� itemid
		int tmp_itemId = sequenceDao.getNextId("seq_item");
//		System.out.println(itemId);
//	    model.put("itemId", itemId);
		
	
			
//		Inventory inventory = new Inventory();
//		inventory.setItemId(String.valueOf(itemId));
//		inventory.setQuantity(1);
			
		FileVO  file  = new FileVO();

		String fileName = files.getOriginalFilename(); 
		
	    File destinationFile; 
	    String destinationFileName; 
	    String fileUrl = "C:/Users/20150/jejudo2/jpetstore/src/main/webapp/images/";
	
	    System.out.println("fileName :"+fileName);
	    destinationFileName = tmp_itemId+"_"+fileName; 
	    destinationFile = new File(fileUrl+destinationFileName); 
	    
	    System.out.println(fileUrl+destinationFileName);
	    System.out.println("destinationFileName:"+destinationFileName);
	        
	    destinationFile.getParentFile().mkdirs(); 
	    files.transferTo(destinationFile); 

	    file.setFileName(destinationFileName);
	    auctionItem.setImage(destinationFileName);
	    auctionItem.setSeller(userSession.getAccount().getUser_id());
	    
	    //format �����ϰ� �ϴ� �� ����
	    Calendar ec = Calendar.getInstance();
	    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T' HH:mm");
	    SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    String endDateString =auctionItem.getLastDate()+"T "+ec.getTime().getHours()+":"+ec.getTime().getMinutes()+":"+ec.getTime().getSeconds();
//	    System.out.println(endDateString);
	    java.util.Date endDate = dateFormat.parse(endDateString);
	    dateFormat2.format(endDate);
	    
	    //���� �۾� �����ٷ� ���񽺿��� ����
	    petStore.auctionedOffScheduler(endDate, auctionItem, tmp_itemId);
	    
	  //180623
//	    auctionItem.setItemId(String.valueOf(tmp_itemId));
	    System.out.println(auctionItem.toString());

	    
	    model.put("itemId", tmp_itemId);
		return "tiles/ConfirmAuction";
	  }
		
		
	
	@RequestMapping("/confirmAuctionSale.do")
	public String handleRequest() throws Exception {
		return "redirect:/shop/index.do";
	}

}
