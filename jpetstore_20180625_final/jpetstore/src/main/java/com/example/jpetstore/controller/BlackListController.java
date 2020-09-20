package com.example.jpetstore.controller;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.BlackList;
import com.example.jpetstore.service.PetStoreFacade;

/* 시라 */
@RequestMapping("/shop")
@Controller
public class BlackListController {
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	//command 객체 생성
	@ModelAttribute("blackList")
	public BlackList formBack() {
		BlackList blackCommand = new BlackList();
		return blackCommand;
	}
	
		
	//블랙리스트 form에 신고자 이름 전달
	@RequestMapping("/blackList.do")
	public String blackListForm(@RequestParam("seller") String blackId,
			@RequestParam("itemId") String itemId,
			@RequestParam("page") String page,
			ModelMap model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("blackList")BlackList black)throws Exception {
			
			UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
			
//			/* 매핑 url 구하는 방법 */
//		      String url = request.getRequestURL().toString();
//		      if ( request.getQueryString() != null ) {
//		    	  url = url + "?" + request.getQueryString();
//		    	  //String url2[] = url.split("jpetstore");
//			      //System.out.println(url2[1]);
//		    	  System.out.print("url :" +url);
//		    	  
//		    	  String url2[] = url.split("jpetstore");
//		    	  System.out.println(url2[1]);
//		    	  url = url2[1];
//			      model.put("page", url2[1]);
//		      }
//		       
		      
			PrintWriter out = response.getWriter();
			if(userSession != null) {
				//180624 신고자 제한 추가
//				Account complainant = petStore.getAccount(userSession.getAccount().getUser_id()); 조장님, 이 코드의 의미가 무엇인가요? 세션을 받아왔으니 디비에서 account를 가져올 필요 없지 않을까요??(아래 코드로 대체해도 되는지 의논)
				Account complainant = userSession.getAccount();
				
				if(complainant.getUser_id().equals(blackId)) {

					
					out.println("<script charset='UTF-8'>alert('The complainant\'s ID can\'t be the same as the seller\'s.'); history.go(-1);</script>");
					out.flush();
				}
				int userComplainCountThisPage = petStore.getPageComplainCountByUser(page, complainant.getUser_id());
				if(userComplainCountThisPage!=0) {

					
					out.println("<script charset='UTF-8'>alert('You\'ve already complained about this.'); history.go(-1);</script>");
					out.flush();
				}
				//여기까지
				model.put("complainant", complainant);
			
				model.put("blackId", blackId);
				model.put("itemId", itemId);
				model.put("page", page);
				
				List<String> reasons = new ArrayList<String>();
				reasons.add("부적절한 홍보 게시물");
				reasons.add("음란성 또는 부적합한 내용");
				reasons.add("비방/욕설");
				reasons.add("인신공격/명예훼손");
				reasons.add("불법적인 유출");
				reasons.add("같은 내용의 반복(도배)");
				reasons.add("지역감정 조장");
				reasons.add("기타 게시물과 관계없는 내용");
				
				model.put("reasons", reasons);	
				//return "BlackListForm";
				
			}
			else {
				out.println("<script charset='UTF-8'>alert('You need to log in for using our website.'); history.go(-1);</script>");
				out.flush();
			}
		
			return "tiles/BlackListForm";
		}
	
	
	//command 객체 바인딩
	@RequestMapping(value="/blackListForm.do", method = RequestMethod.POST)
	public String generalSubmit(@ModelAttribute("blackList")BlackList black,
			    	BindingResult result) {
		
/*		if(result.hasErrors()) {
			return "BlackListForm";
		}*/
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		black.setDateTime(dateFormat.format(date));
		System.out.println(black.toString());
		
		petStore.insertBlackList(black);
		
		return "tiles/ConfirmBlackList";
		}


}
