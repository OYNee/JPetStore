package com.example.jpetstore.controller;

import java.io.File;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.dao.SequenceDao;
import com.example.jpetstore.dao.mybatis.MybatisGeneralItemDao;
import com.example.jpetstore.domain.AuctionItem;
import com.example.jpetstore.domain.FileVO;
import com.example.jpetstore.domain.GeneralItem;
import com.example.jpetstore.domain.Inventory;
import com.example.jpetstore.domain.Product;
import com.example.jpetstore.service.PetStoreFacade;



@Controller
@RequestMapping("/shop")
@SessionAttributes("userSession")
public class GeneralSaleController {
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@Autowired
	private SequenceDao sequenceDao;
	

	@RequestMapping("/SellCategory.do")
	public String showSellCat() {
		return "tiles/SellCategory";
	}
	
	

	@ModelAttribute("generalItem")
	public GeneralItem formBack() {
		GeneralItem gItem = new GeneralItem();
		gItem.setIsAd("0");
		gItem.setStatus("on");
		gItem.setIsAuction("off");
	
		return gItem;
	}

	@ModelAttribute("auctionItem")
	public AuctionItem formBack2() {
		AuctionItem aItem = new AuctionItem();
	
		return aItem;
	}
	

	@RequestMapping(value = {"/generalForm.do", "/auctionForm.do"})
    public String selectCatForm(ModelMap model, @RequestParam("isAuction") int isAuction) {
		
		List<String> cats = new ArrayList<String>();
		cats.add("FISH");
		cats.add("DOGS");
		cats.add("CATS");
		cats.add("REPTILES");
		cats.add("BIRDS");
		model.put("cats", cats);
		model.put("isAuction", isAuction);

		
		return "tiles/RegistCatForm";		
    }
	
	

	@RequestMapping("/selectCat.do")
    public String selectProductForm(ModelMap model,
    		@RequestParam("cat") String categoryId,
    		@RequestParam("isAuction") int isAuction) {
		
		System.out.println(categoryId);
		
		List<String> names = new ArrayList<String>();
		names = petStore.productNameList(categoryId);
		
		System.out.println(names);
		
		model.put("names", names);
		model.put("categoryId", categoryId);
		model.put("isAuction", isAuction);
		
		return "tiles/RegistProductForm";
	
	}
	
	@BlackList
	@RequestMapping("/selectProduct.do")
    public String form(@RequestParam("name") String name, ModelMap model, HttpServletRequest request,
    		@RequestParam("isAuction") int isAuction)throws Exception {
		
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		//Account seller = petStore.getAccount(userSession.getAccount().getUser_id());
		
		
		String productId = this.petStore.getProductIdByName(name);
		Product product = this.petStore.getProduct(productId);
		//int itemId = this.petStore.getItemID() + 1;
		
		System.out.println("product name:"+name+productId);
		System.out.println("catId:"+ product.getCategoryId());
		
		//������ ���� �ٸ��ϱ� �ߺ��Ǵ� �ڵ� ������ ������
		model.put("seller", userSession.getAccount().getUser_id());
		model.put("product", product);
		
		if(isAuction == 1) {
			System.out.println("auction:"+ product.getCategoryId());
			
			return "tiles/AuctionSellForm";
		}
		
		return "tiles/GeneralSellForm";

    }
	
	
	@BlackList
	@RequestMapping(value="/save.do", method = RequestMethod.POST, headers=("content-type=multipart/*"))
    public String generalSubmit(@ModelAttribute("generalItem") GeneralItem gItem,
    		BindingResult result, MultipartHttpServletRequest request, ModelMap model, @RequestParam("files") MultipartFile files) throws Exception {

		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		if(result.hasErrors()) {
			return "tiles/GeneralSellForm";
		}
		
		int itemId = sequenceDao.getNextId("seq_item");
		gItem.setItemId(String.valueOf(itemId));

        model.put("itemId", itemId);

		
		/*Inventory inventory = new Inventory();
		inventory.setItemId(String.valueOf(itemId));
		inventory.setQuantity(1);*/
		

		FileVO  file  = new FileVO();

		String fileName = files.getOriginalFilename(); 

	
        File destinationFile; 
        String destinationFileName; 

        String fileUrl = "C:\\Users\\20150\\jejudo2\\jpetstore\\src\\main\\webapp\\images\\sales_images\\";

        System.out.println("fileName :"+fileName);
        
       /* do { 
            destinationFileName = gItem.getItemId()+"_"+fileName; 
            destinationFile = new File(fileUrl+destinationFileName); 
        } while (destinationFile.exists()); */
        
        destinationFileName = itemId+"_"+fileName; 
        destinationFile = new File(fileUrl+destinationFileName); 
        
        System.out.println(fileUrl+destinationFileName);
        
   
        System.out.println("destinationFileName:"+destinationFileName);
        
        destinationFile.getParentFile().mkdirs(); 
        files.transferTo(destinationFile); 

     
        file.setFileName(destinationFileName);
        gItem.setImage(destinationFileName);
        gItem.setSeller(userSession.getAccount().getUser_id());
		
		System.out.print(gItem.toString());
		/*petStore.insertGeneralItem(gItem);
		petStore.insertQuantity(inventory);*/
		petStore.insertGeneralItemAll(gItem);
		return "tiles/ConfirmGeneral";
    }
	
	

	@RequestMapping("/confirmGeneralSale.do")
	public String handleRequest() throws Exception {
	
		return "redirect:/shop/index.do";
	}
	
}
