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
import com.example.jpetstore.domain.Post;
import com.example.jpetstore.service.PetStoreFacade;


@Controller
public class PostController {
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}
	
	private static final Logger logger = LoggerFactory.getLogger(PostController.class);
	
	@RequestMapping(value = "/postList.do", method = RequestMethod.GET)
	public String postSelectAll(HttpServletRequest request, HttpServletResponse response, HashMap<String, String> param,
			Model model, @RequestParam(defaultValue = "1") int pageNo,
			@RequestParam("sellerid") String sellerid) throws Exception {

		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		//�쁽�옱濡쒓렇�씤�븳 �궗�엺�쓽 �젙蹂�
		Account account= userSession.getAccount();
		String loginid=account.getUser_id();
		logger.debug("----------------"+loginid);
		int rowsPerPage = 3;
		int pagesPerGroup = 5;
		int totalRows = petStore.countAllLetter(loginid);
		int totalPageNo = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int totalGroupNo = (totalPageNo / pagesPerGroup) + ((totalPageNo % pagesPerGroup != 0) ? 1 : 0);
		int groupNo = (pageNo - 1) / pagesPerGroup + 1;
		int startPageNo = (groupNo - 1) * pagesPerGroup + 1;
		int endPageNo = startPageNo + pagesPerGroup - 1;
		if (groupNo == totalGroupNo) {
			endPageNo = totalPageNo;
		}
		System.out.println("pageNo"+pageNo);
		List<Post> postList= petStore.selectPage(pageNo, rowsPerPage);

		model.addAttribute("list", postList);
		model.addAttribute("loginid",loginid);
		model.addAttribute("pagesPerGroup", pagesPerGroup);
		model.addAttribute("totalPageNo", totalPageNo);
		model.addAttribute("totalGroupNo", totalGroupNo);
		model.addAttribute("groupNo", groupNo);
		model.addAttribute("startPageNo", startPageNo);
		model.addAttribute("endPageNo", endPageNo);
		model.addAttribute("pageNo", pageNo);
		
		model.addAttribute("sellerid", sellerid);
		return "/tiles/postList";
	}
	@RequestMapping(value = "/postWrite.do", method = RequestMethod.GET)
	public String postWriteGet(HttpServletRequest request,Model model,
			@RequestParam("sellerid") String sellerid) {
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		//�쁽�옱濡쒓렇�씤�븳 �궗�엺�쓽 �젙蹂�
		Account account= userSession.getAccount();
		String loginid=account.getUser_id();
		model.addAttribute("loginid",loginid);
		
		model.addAttribute("sellerid", sellerid);
		return "/tiles/postWrite";
	}

	@RequestMapping(value = "/postWrite.do", method = RequestMethod.POST)
	public String postWritePost(Post post, HttpServletRequest request, Model model,
			@RequestParam("sellerid") String sellerid) throws IllegalStateException {
		model.addAttribute("sellerid", sellerid);
		petStore.insert(post);
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		//�쁽�옱濡쒓렇�씤�븳 �궗�엺�쓽 �젙蹂�
		Account account= userSession.getAccount();
		String loginid=account.getUser_id();
		
		model.addAttribute("loginid",loginid);
		return "redirect:/postList.do";
	}

	@RequestMapping("/hitcount")
	public String boardHitcount(String loginid, int postid, int pageNo, Model model) {
		
		if (loginid != "") {
			petStore.updateHitcount(postid, loginid, petStore.selectByPostId(postid).getView_count());
		}
		return "redirect:/postDetail?postid=" + postid+ "&pageNo=" + pageNo;
	}

	@RequestMapping("/postDetail")
	public String boardDetailGet(int postid, int pageNo, Model model, HttpServletRequest request) {
		Post post=petStore.selectByPostId(postid);

		String content = post.getContent();
		post.setContent(content);
		UserSession userSession = (UserSession) WebUtils.getSessionAttribute(request, "userSession");
		//�쁽�옱濡쒓렇�씤�븳 �궗�엺�쓽 �젙蹂�
		Account account= userSession.getAccount();
		String loginid=account.getUser_id();
		
		model.addAttribute("loginid",loginid);
		model.addAttribute("post", post);
		model.addAttribute("pageNo", pageNo);
		return "postDetail";
	}

	@RequestMapping("/postDelete")
	public String boardDelete(int postid, HttpServletRequest req) {
		petStore.delete(postid);
		return "redirect:/postList";
	}

/*	@RequestMapping("/postLike")
	public String boardLike(int postid, int pageNo, String loginID, Model model) {
		Post post=petStore.updateLikecount(postid, loginID, petStore.selectByPostId(postid).getLike_count());
		model.addAttribute("post", post);
		return "redirect:/board/boardDetail?bno=" + postid + "&pageNo=" + pageNo + "&loginID=" + loginID;
	}*/

	@RequestMapping(value = "/postUpdate", method = RequestMethod.GET)
	public String boardUpdateGet(int postid, int pageNo, Model model) {
		Post post= petStore.selectByPostId(postid);
		model.addAttribute("post", post);
		model.addAttribute("pageNo", pageNo);
		return "postUpdate";
	}

	@RequestMapping(value = "/postUpdate", method = RequestMethod.POST)
	public String boardUpdatePost(Post post, int pageNo) throws IllegalStateException {
		petStore.update(post);

		return "redirect:/board/boardDetail?postid=" + post.getPostid() + "&pageNo=" + pageNo;
	}

}
