package com.example.jpetstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.dao.mybatis.MybatisLetterDao;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Letter;
import com.example.jpetstore.service.PetStoreFacade;


@Controller
@RequestMapping("/shop")
public class LetterController {
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(LetterController.class);
	
	@RequestMapping(value = "/letterView.do", method = RequestMethod.GET)
	public String messageSelectAll(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
			Model model, @RequestParam(defaultValue = "1") int pageNo) throws Exception {

		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		//����α����� ����� ����
		Account account= userSession.getAccount();
		String loginID=account.getUser_id();
		logger.debug("----------------"+loginID);
		int rowsPerPage = 3;
		int pagesPerGroup = 5;
		int totalRows = petStore.countAllLetter(loginID);
		int totalPageNo = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int totalGroupNo = (totalPageNo / pagesPerGroup) + ((totalPageNo % pagesPerGroup != 0) ? 1 : 0);
		int groupNo = (pageNo - 1) / pagesPerGroup + 1;
		int startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if (groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}
//		List<LetterVO> messageList= messageService.selectAllLetter(employeeVO.getEmployeeName());
		System.out.println("pageNo"+pageNo);
		List<Letter> letterList= petStore.selectByPage(loginID, pageNo, rowsPerPage);

		model.addAttribute("list", letterList);
		model.addAttribute("account",account);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		return "tiles/letterView";
	}
	
	
	
	@RequestMapping(value = "/searchLetter.do", method = RequestMethod.GET)
	public String searchByLetter(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
			Model model ) throws Exception {
		String searchLetter=request.getParameter("searchLetter");
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		//����α����� ����� ����
		Account account= userSession.getAccount();
		String loginID=account.getUser_id();
		System.out.println("--------------"+loginID);
		System.out.println("--------------"+searchLetter);
		Map<String, String> parameters = new HashMap<String, String>();
	    parameters.put("searchLetter", searchLetter);
	    parameters.put("loginID", loginID);
	    
		List<Letter> letterList= petStore.selectBySearchWord(parameters);

		
		
		model.addAttribute("loginedAccount",account);
		model.addAttribute("list", letterList);
		return "letterView";
	}
	
	@RequestMapping(value = "/searchAjax.do", method = RequestMethod.POST)
	@ResponseBody
	public Object searchPerson(@RequestParam(value="searchword") String searchword,HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
			Model model) throws Exception {
		System.out.println("searchword : "+searchword);
		
		List<Account> accountList = petStore.findListById(searchword);
		System.out.println(accountList.size());
		for (int i = 0; i < accountList.size(); i++) {
			System.out.println(accountList.get(i).getUser_id());
		}

		System.out.println("sCDS"+accountList.get(0).getUser_id());
		Map<String, Object> retVal = new HashMap<String, Object>();
		retVal.put("accountList", accountList);
		return retVal;
	}
	
	@RequestMapping(value = "/writeLetter.do", method = RequestMethod.POST)
	public String writeLetter(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
			Model model, Letter letter) throws Exception {
		
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		//����α����� ����� ����
		Account account= userSession.getAccount();
		String loginID=account.getUser_id();
		
		String receiverId=request.getParameter("inputHidden");
		logger.info("receiverId"+"--------------"+receiverId);
		
		List<Account> receiverAccountList=petStore.findListById(receiverId);		
		for (int i = 0; i < receiverAccountList.size(); i++) {
			letter.setSender(loginID);
			letter.setReceiver(receiverAccountList.get(0).getUser_id());
			int result= petStore.insertLetter(letter);
			logger.info(letter.getReceiver()+"--------------"+result);
		}
		return "redirect:/shop/letterView.do";
	}
	

}
