package com.example.jpetstore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.dao.SequenceDao;
import com.example.jpetstore.dao.mybatis.MybatisAnswerDao;
import com.example.jpetstore.dao.mybatis.MybatisGeneralItemDao;
import com.example.jpetstore.dao.mybatis.MybatisQuestionDao;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Answer;
import com.example.jpetstore.domain.GeneralItem;
import com.example.jpetstore.domain.Question;
import com.example.jpetstore.service.PetStoreFacade;

/* 시라 */
@Controller
@RequestMapping("/shop")
public class QAController {
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	@Autowired
	private MybatisQuestionDao questionDao;
	@Autowired
	private MybatisAnswerDao answerDao;
	
	@Autowired
	private SequenceDao sequenceDao;
	

	/* 질문 제목 클릭 -> 답변 보기 */
	@RequestMapping("/questionClick.do")
	public String clickQuestion(@RequestParam("questionId") String questionId,
			@RequestParam("itemId") String itemId, 
			@RequestParam("isAuction") String isAuction,
			 ModelMap model) throws Exception {
		
		System.out.println("questionId : "+questionId);
		System.out.println("itemId : "+itemId);
		Question itemQuestion = petStore.getQuestion(questionId);		
		
		//0624
		List<Answer> answerList = petStore.getAnswerList(questionId);
	
		model.put("question", itemQuestion);
		model.put("isAuction", isAuction);
		model.put("answerList", answerList);
		model.put("itemId", itemId);

		//0624
		return "tiles/ViewQuestion";
	}
	
	//command 객체 생성
	@ModelAttribute("answer")
	public Answer formBack2() {
		Answer answer = new Answer();
		return answer;
		}
	
	
	/* 질문 등록하기 */
	@RequestMapping("/writeAnswer.do")
	public String writeAnswer(@RequestParam("itemId") String itemId,
			@RequestParam("isAuction") String isAuction, 
			@RequestParam("questionId") String questionId, ModelMap model, HttpServletRequest request ){
		
		UserSession userSession =
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		model.put("itemId", itemId);
		model.put("isAuction", isAuction);
		model.put("questionId", questionId);
		model.put("writer", userSession.getAccount().getUser_id());
		
		
		return "tiles/WriteAnswer";
	}
	
	@RequestMapping("/successAnswer.do")
	public String successAnswer(@ModelAttribute("answer") Answer answer, BindingResult result, 
			@RequestParam("questionId") String questionId,
			@RequestParam("itemId") String itemId,
			@RequestParam("isAuction") String isAuction, ModelMap model) {
		
		System.out.println("답변 등록 시작");
		if(result.hasErrors()) {
			System.out.println("실패");
			return "tiles/WriteAnswer";
		}
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		int answerId = sequenceDao.getNextId("seq_answer");
		//question.setDate(dateFormat.format(date));
		answer.setDate_time(date);
		answer.setAnswerId(String.valueOf(answerId));
		
		System.out.println(answer.toString());
		//petStore.insertAnswer(answer);
		answerDao.insertAnswer(answer);
		
		System.out.println("답변 등록 완료");
		
		model.put("questionId", questionId);
		model.put("itemId", itemId);
		model.put("isAuction", isAuction);
		
		
		return "redirect:/shop/questionClick.do";
		
	}
	
	
	@RequestMapping("/viewItemBack.do")
	public String goBackViewItem(@RequestParam("itemId") String itemId,
			@RequestParam("isAuction") String isAuction,
			ModelMap model) {
		model.put("itemId", itemId);
		model.put("isAuction", isAuction);
		return "redirect:/shop/viewItem.do";
		
	}
	
	
	/* 질문 등록하기 */ 
	
	//command 객체 생성
	@ModelAttribute("question")
	public Question formBack() {
		Question question = new Question();
			return question;
	}
	
	
	@RequestMapping("/doingQuestion.do")
	public String doingQuestionForm(@RequestParam("itemId")String itemId,
		ModelMap model, HttpServletRequest request,HttpServletResponse response,
		@RequestParam("isAuction")String isAuction) throws Exception {
		
		UserSession userSession =
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		if(userSession != null) {
			Account user = petStore.getAccount(userSession.getAccount().getUser_id());
			model.put("userId", user.getUser_id());
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<script charset='UTF-8'>alert('로그인 후 이용이 가능합니다.'); history.go(-1);</script>");
			out.flush();
		}
		model.put("itemId", itemId);
		model.put("isAuction", isAuction);
		System.out.print("1"+isAuction);
		
		return "tiles/QuestionForm";
	}
	
	
	@RequestMapping("/successQuestion.do")
	public String successQuestion(@RequestParam("itemId") String itemId, ModelMap model,
		@ModelAttribute("question") Question question,BindingResult result, HttpServletResponse response,
		@RequestParam("isAuction") String isAuction) throws Exception {
		
		System.out.println("질문 등록 시작");
		System.out.print("2"+isAuction);
		DateFormat dateFormat = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		
		//question.setDate(dateFormat.format(date));
		question.setDate_time(date);
		System.out.print(question.toString());
		
		System.out.println(isAuction);
		
		questionDao.insertQuestion(question);
		
		System.out.println("질문 등록 완료");
		
		model.put("itemId", itemId);
		model.put("isAuction", isAuction);
		
		return "redirect:/shop/viewItemBack.do";
	}
	
	
}
