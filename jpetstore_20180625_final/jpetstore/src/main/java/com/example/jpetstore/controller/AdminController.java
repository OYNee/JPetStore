package com.example.jpetstore.controller;

import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.controller.Auth;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Advertisement;
import com.example.jpetstore.domain.BlackList;
import com.example.jpetstore.service.PetStoreFacade;


@Controller
public class AdminController {
	
	private PetStoreFacade petStore;

	@Autowired
	public void setPetStore(PetStoreFacade petStore) {
		this.petStore = petStore;
	}

	@Autowired(required=false)
	private JavaMailSender mailSender;
	
	@Auth
	@RequestMapping("/shop/admin.do")
	public String handleRequest(HttpSession session
		) throws Exception {
		return "tiles/Admin";
	}
	
	@Auth
	@RequestMapping(value="/shop/blackListForAdmin.do", method = RequestMethod.GET)
	public ModelAndView handleRequest2(HttpSession session
		) throws Exception {
		
		return new ModelAndView("tiles/BlackListForAdmin","blackList", getBlackList() );
	}
	
	@Auth
	@RequestMapping(value="/shop/reasonForComplaint.do", method = RequestMethod.GET)
	public ModelAndView handleRequest4(HttpSession session, @RequestParam("id") String username
		) throws Exception {
		ModelAndView mv = new ModelAndView("tiles/ReasonForComplaint");
		mv.addObject("reasonList", petStore.getReasonByPage(petStore.getDetail(username).getPage()));
		mv.addObject("username", username);
		
		return mv;
	}
	
	@Auth
	@RequestMapping(value="/shop/blackListForAdmin.do", method = RequestMethod.POST)
	public ModelAndView removeUsernameOnBlackList(HttpSession session, 
			@RequestParam("removeUser") String removeUser
		) throws Exception {
		String[] userArr = removeUser.split("-"); 
		String[] email = new String[userArr.length];
		if(!removeUser.isEmpty()){
			for(int i=0 ; i<userArr.length ; i++){
				petStore.updateBlackList(userArr[i], 0);
				email[i] = petStore.getAccount(userArr[i]).getEmail();
				//���� �߰�
			}
			sendAdminMail(email, 3);
		}
		return new ModelAndView("tiles/BlackListForAdmin", "blackList", getBlackList());
	}
	
	@Auth
	public List<BlackList> getBlackList() {
		List<BlackList> blackList = new ArrayList<BlackList>();
		List<String> userlist = petStore.getUserOnBlackList();
		for(String u : userlist) {
			BlackList b = petStore.getDetail(u);
			if(b!=null)
				blackList.add(petStore.getDetail(u));
		}
		return blackList;
	}
	
	@Auth
	@RequestMapping(value="/shop/adForAdmin.do", method = RequestMethod.GET)
	public ModelAndView handleRequest3(HttpSession session
		) throws Exception {
		
		return new ModelAndView("tiles/AdForAdmin", "adList", petStore.getApprovalList());
	}
	
	@Auth
	@RequestMapping(value="/shop/adForAdmin.do", method = RequestMethod.POST)
	@Transactional 
	public ModelAndView handleRequest5(HttpSession session,
			@RequestParam("approvalList") String approvalList,
			@RequestParam("rejectList") String rejectList
		) throws Exception {
		String[] approvalArr = approvalList.split("-");
		String[] userList1 = new String[approvalArr.length];
		
		//������ ���� �� ���ƾ��ҵ�
		System.out.println(approvalArr.equals(null)+" "+approvalArr.length+" "+approvalList.isEmpty());
		if(!approvalList.isEmpty()){
			for(int i=0 ; i<approvalArr.length ; i++){
				petStore.updateAdStatus(approvalArr[i], "2");
				//�߰��ϴ� �κ�, ����
				String seller =  petStore.getItem(approvalArr[i]).getSeller();
				
				userList1[i] = petStore.getAccount(seller).getEmail();
			}
			sendAdminMail(userList1, 1);
		}
		String[] rejectArr = rejectList.split("-"); 
		String[] userList2 = new String[rejectArr.length];
		if(!rejectList.isEmpty()){
			for(int i=0 ; i<rejectArr.length ; i++){
				petStore.updateAdStatus(rejectArr[i], "0");
				//�߰�, ����
				String seller = petStore.getItem(rejectArr[i]).getSeller();
				userList2[i] = petStore.getAccount(seller).getEmail();
			}
			sendAdminMail(userList2, 2);
		}
		
		List<Advertisement> adList = petStore.getApprovalList();
		
		for(Advertisement a:adList) {
			System.out.println(a.getItemid());
		}
		return new ModelAndView("tiles/AdForAdmin","adList", adList);
		
	}
	
	public void sendAdminMail(String[] users, int type) {
		String setfrom = "springTest45@gmail.com";
		String title = "";
		String shortMsg = "";
		String msg="";
		if(type==1) {
			title = "Your ad request was approved.";
			shortMsg = "Now your ad will be put on JPetStore!";
			msg ="Your ad request was approved.";
		}
		else if(type==2) {
			title="Your ad request was not permitted.";
			shortMsg = "The ad you requested is not appropriate for JPetStore!";
			msg="Your ad request was not permitted.";
		}
		else {
			title="Now you are not on the blacklist.";
			shortMsg = "Now you are not on the blacklist.";
			msg="You are now allowed to do the things which you've been so far prohibited from doing!";
		}
		

		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><!--[if IE]><html xmlns=\"http://www.w3.org/1999/xhtml\" class=\"ie\"><![endif]--><!--[if !IE]><!--><html style=\"margin: 0;padding: 0;\" xmlns=\"http://www.w3.org/1999/xhtml\"><!--<![endif]--><head>\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n" + 
				"  </head>\n" + 
				"   <body class=\"full-padding\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;\">\n" + 
				"<!--<![endif]-->\n" + 
				"    <table class=\"wrapper\" style=\"border-collapse: collapse;table-layout: fixed;min-width: 320px;width: 100%;background-color: #f6f6f6;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tbody><tr><td>\n" + 
				"      <div role=\"banner\">\n" + 
				"        <div class=\"preheader\" style=\"Margin: 0 auto;max-width: 560px;min-width: 280px; width: 280px;width: calc(28000% - 167440px);\">\n" + 
				"          <div style=\"border-collapse: collapse;display: table;width: 100%;\">\n" + 
				"          <!--[if (mso)|(IE)]><table align=\"center\" class=\"preheader\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 280px\" valign=\"top\"><![endif]-->\n" + 
				"            <div class=\"snippet\" style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 140px; width: 140px;width: calc(14000% - 78120px);padding: 10px 0 5px 0;color: #8e8e8e;font-family: PT Sans,Trebuchet MS,sans-serif;\">\n" + 
				"              \n" + 
				"            </div>\n" + 
				"          <!--[if (mso)|(IE)]></td><td style=\"width: 280px\" valign=\"top\"><![endif]-->\n" + 
				"            <div class=\"webversion\" style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 139px; width: 139px;width: calc(14100% - 78680px);padding: 10px 0 5px 0;text-align: right;color: #8e8e8e;font-family: PT Sans,Trebuchet MS,sans-serif;\">\n" + 
				"              \n" + 
				"            </div>\n" + 
				"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" + 
				"          </div>\n" + 
				"        </div>\n" + 
				"        <div class=\"header\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);\" id=\"emb-email-header-container\">\n" + 
				"        <!--[if (mso)|(IE)]><table align=\"center\" class=\"header\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 600px\"><![endif]-->\n" + 
				"          <div class=\"logo emb-logo-margin-box\" style=\"font-size: 26px;line-height: 32px;Margin-top: 6px;Margin-bottom: 20px;color: #c3ced9;font-family: Roboto,Tahoma,sans-serif;Margin-left: 20px;Margin-right: 20px;\" align=\"center\">\n" + 
				"            <div class=\"logo-center\" align=\"center\" id=\"emb-email-header\"><img style=\"display: block;height: auto;width: 100%;border: 0;max-width: 86px;\" src=\"C:\\Users\\20150\\jejudo2\\jpetstore\\src\\main\\webapp\\images\\logo2.png\" alt=\"\" width=\"86\" /></div>\n" + 
				"          </div>\n" + 
				"        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" + 
				"        </div>\n" + 
				"      </div>\n" + 
				"      <div role=\"section\">\n" + 
				"      <div class=\"layout one-col fixed-width\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\n" + 
				"        <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;background-color: #ffffff;\" emb-background-style>\n" + 
				"        <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-fixed-width\" emb-background-style><td style=\"width: 600px\" class=\"w560\"><![endif]-->\n" + 
				"          <div class=\"column\" style=\"text-align: left;color: #8e8e8e;font-size: 16px;line-height: 24px;font-family: PT Sans,Trebuchet MS,sans-serif;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);\">\n" + 
				"        \n" + 
				"            <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 24px;\">\n" + 
				"      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 4px;\">\n" + 
				"        <p style=\"Margin-top: 0;Margin-bottom: 20px;text-align: center;\">"+shortMsg+"</p>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"        \n" + 
				"        <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\" align=\"center\">\n" + 
				"          <img style=\"border: 0;display: block;height: auto;width: 100%;max-width: 81px;\" alt=\"\" width=\"81\" src=\"https://i.imgur.com/IjH65Q8.png\" />\n" + 
				"        </div>\n" + 
				"      \n" + 
				"            <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 20px;\">\n" + 
				"      <div style=\"mso-line-height-rule: exactly;line-height: 20px;font-size: 1px;\">&nbsp;</div>\n" + 
				"    </div>\n" + 
				"        \n" + 
				"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\n" + 
				"      <div style=\"mso-line-height-rule: exactly;line-height: 25px;font-size: 1px;\">&nbsp;</div>\n" + 
				"    </div>\n" + 
				"        \n" + 
				"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\n" + 
				"      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 4px;\">\n" + 
				"        <p class=\"size-16\" style=\"Margin-top: 0;Margin-bottom: 20px;font-size: 16px;line-height: 24px;text-align: center;\" lang=\"x-size-16\">"+msg+"</p>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"        \n" + 
				"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\n" + 
				"      <div style=\"mso-line-height-rule: exactly;line-height: 20px;font-size: 1px;\">&nbsp;</div>\n" + 
				"    </div>\n" + 
				"        \n" + 
				"        <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\" align=\"center\">\n" + 
				"          <img style=\"border: 0;display: block;height: auto;width: 100%;max-width: 174px;\" alt=\"\" width=\"174\" src=\"https://i.imgur.com/ss56Krv.png\" />\n");
				if(type==2) {
					sb.append("<p style=\"Margin-top: 20px;Margin-bottom: 0;\">The reason why your ad was not permitted.</p>"+
					"      \n"+"<p style=\"Margin-top: 20px;Margin-bottom: 0;\">- inappropriate images.</p>");
					sb.append("<p style=\"Margin-top: 20px;Margin-bottom: 0;\">- ad title with expletives.</p>");
					sb.append("<p style=\"Margin-top: 20px;Margin-bottom: 0;\">- send letters.</p>");
				}
				else if(type==3) {
					sb.append("<p style=\"Margin-top: 20px;Margin-bottom: 0;\">When you are on the blacklist, you can't...</p>"+
					"      \n"+"<p style=\"Margin-top: 20px;Margin-bottom: 0;\">- sell pets.</p>");
					sb.append("<p style=\"Margin-top: 20px;Margin-bottom: 0;\">- write something on boards.</p>");
					sb.append("<p style=\"Margin-top: 20px;Margin-bottom: 0;\">- send letters.</p>");
				}
				sb.append(
				"        <p></p>"+
						"<a style=\"border-radius: 4px;display: inline-block;font-size: 14px;font-weight: bold;line-height: 24px;padding: 12px 24px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #ffffff !important;background-color: #b31b1b;font-family: PT Sans, Trebuchet MS, sans-serif;\" href=\"http://localhost:8112/jpetstore/shop/index.do\">Go JPetStore!</a><![endif]>\n" +
				"</div>\n" + 
				"        <p></p><![if !mso]>"+
 
				"        <p></p><p></p></div>\n" + 
				"      \n" + 
				"          </div>\n" + 
				"        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" + 
				"        </div>\n" + 
				"      </div>\n");

				sb.append(
				"      <div style=\"mso-line-height-rule: exactly;\" role=\"contentinfo\">\n" + 
				"        <div class=\"layout email-footer\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\n" + 
				"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\n" + 
				"          <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 400px;\" valign=\"top\" class=\"w360\"><![endif]-->\n" + 
				"            <div class=\"column wide\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #8e8e8e;font-family: PT Sans,Trebuchet MS,sans-serif;Float: left;max-width: 400px;min-width: 320px; width: 320px;width: calc(8000% - 47600px);\">\n" + 
				"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\n" + 
				"                \n" + 
				"                <div style=\"font-size: 12px;line-height: 19px;\">\n" + 
				"                  <div>S&Y PetStore</div>\n" + 
				"                </div>\n" + 
				"                <div style=\"font-size: 12px;line-height: 19px;Margin-top: 18px;\">\n" + 
				"                  <div>&#51060; &#47700;&#51068;&#51008; &#48156;&#49888;&#51204;&#50857;&#47700;&#51068;&#51077;&#45768;&#45796;.</div>\n" + 
				"                </div>\n" + 
				"                <!--[if mso]>&nbsp;<![endif]-->\n" + 
				"              </div>\n" + 
				"            </div>\n" + 
				"          <!--[if (mso)|(IE)]></td><td style=\"width: 200px;\" valign=\"top\" class=\"w160\"><![endif]-->\n" + 
				"            <div class=\"column narrow\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #8e8e8e;font-family: PT Sans,Trebuchet MS,sans-serif;Float: left;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);\">\n" + 
				"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\n" + 
				"                \n" + 
				"              </div>\n" + 
				"            </div>\n" + 
				"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" + 
				"          </div>\n" + 
				"        </div>\n" + 
				"        <div class=\"layout one-col email-footer\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\n" + 
				"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\n" + 
				"          <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 600px;\" class=\"w560\"><![endif]-->\n" + 
				"            <div class=\"column\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #8e8e8e;font-family: PT Sans,Trebuchet MS,sans-serif;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);\">\n" + 
				"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\n" + 
				"                <div style=\"font-size: 12px;line-height: 19px;\">\n" + 
				"                  <unsubscribe style=\"text-decoration: underline;\">Unsubscribe</unsubscribe>\n" + 
				"                </div>\n" + 
				"              </div>\n" + 
				"            </div>\n" + 
				"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" + 
				"          </div>\n" + 
				"        </div>\n" + 
				"      </div>\n" + 
				"      <div style=\"mso-line-height-rule: exactly;line-height: 40px;font-size: 40px;\">&nbsp;</div>\n" + 
				"    </div></td></tr></tbody></table>\n" + 
				"  \n" + 
				"</body></html>");
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

			messageHelper.setFrom(setfrom); 
			messageHelper.setTo(users); 
			messageHelper.setSubject(title);
			messageHelper.setText(sb.toString(),true); 

			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
