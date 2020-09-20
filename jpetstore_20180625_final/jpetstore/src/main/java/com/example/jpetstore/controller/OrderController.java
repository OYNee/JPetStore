package com.example.jpetstore.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.util.WebUtils;

import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.LineItem;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.service.OrderValidator;
import com.example.jpetstore.service.PetStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes({"sessionCart", "orderForm"})
public class OrderController {
	@Autowired
	private PetStoreFacade petStore;
	@Autowired
	private OrderValidator orderValidator;
	


	@Autowired(required=false)
	private JavaMailSender mailSender;
	
	@ModelAttribute("orderForm")
	public OrderForm createOrderForm() {
		return new OrderForm();
	}

	@ModelAttribute("creditCardTypes")
	public List<String> referenceData() {
		ArrayList<String> creditCardTypes = new ArrayList<String>();
		creditCardTypes.add("Visa");
		creditCardTypes.add("MasterCard");
		creditCardTypes.add("American Express");
		return creditCardTypes;			
	}
	
	@RequestMapping("/shop/newOrder.do")
	public String initNewOrder(HttpServletRequest request,
			@ModelAttribute("sessionCart") Cart cart,
			@ModelAttribute("orderForm") OrderForm orderForm,
			@RequestParam("useMileage") int mileage
			) throws ModelAndViewDefiningException {
		
		if (cart != null) {
			// Re-read account from DB at team's request.
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			Account account = petStore.getAccount(userSession.getAccount().getUser_id());
			
			orderForm.getOrder().initOrder(account, cart);
			
			orderForm.getOrder().setMileage(mileage);
			return "NewOrderForm";	
		}
		else {
			ModelAndView modelAndView = new ModelAndView("Error");
			modelAndView.addObject("message", "An order could not be created because a cart could not be found.");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}
	
	@RequestMapping("/shop/newOrderSubmitted.do")
	public String bindAndValidateOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			BindingResult result) {
		if (orderForm.didShippingAddressProvided() == false) {	
			// from NewOrderForm
			orderValidator.validateCreditCard(orderForm.getOrder(), result);
			orderValidator.validateBillingAddress(orderForm.getOrder(), result);
			if (result.hasErrors()) return "NewOrderForm";
			
			if (orderForm.isShippingAddressRequired() == true) {
				orderForm.setShippingAddressProvided(true);
				return "tiles/ShippingForm";
			}
			else {			
				return "tiles/ConfirmOrder";
			}
		}
		else {		// from ShippingForm
			orderValidator.validateShippingAddress(orderForm.getOrder(), result);
			if (result.hasErrors()) return "ShippingForm";
			return "tiles/ConfirmOrder";
		}
	}
	
	@RequestMapping("/shop/confirmOrder.do")
	protected ModelAndView confirmOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			SessionStatus status) {
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		try {
			petStore.insertOrder(orderForm.getOrder(), userSession);
		}
		catch (Exception ex){
			//���������� ����� ���� ��
			status.setComplete();
			return new ModelAndView("tiles/orderError", "msg", "Sorry, your order has failed.");
		}
		ModelAndView mav = new ModelAndView("tiles/ViewOrder");
		Order order = orderForm.getOrder();
		order.setTotalPrice(order.getTotalPrice()-order.getMileage());
		mav.addObject("order", orderForm.getOrder());
		mav.addObject("message", "Thank you, your order has been submitted.");
		status.setComplete();  // remove sessionCart and orderForm from session
		

		String setfrom = "springtest45@gmail.com";
		String title="Thank you, your order has been submitted.";
		String tomail = userSession.getAccount().getEmail(); 
		String address = order.getShipCountry()+" "+order.getShipCity()+" "+order.getShipAddress1()+ " "+order.getShipAddress2();
		
		String to_msg = order.getUsername()+"'s Order";
		String orderDate = order.getOrderDate().toString();
		double totalPrice = order.getTotalPrice();

//		System.out.println("content : "+title+address+numberOfPerson+building+time+timeSelect+roomType+beam+beamSelect+date+notebook+notebookSelect);


//		String htmlContent = "<strong>Thank you for your order!</strong>";
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
				"            <div class=\"logo-center\" align=\"center\" id=\"emb-email-header\"><img style=\"display: block;height: auto;width: 100%;border: 0;max-width: 86px;\" src=\"C:\\\\Users\\\\20150\\\\jejudo2\\\\jpetstore\\\\src\\\\main\\\\webapp\\\\images\\\\logo2.png\" alt=\"\" width=\"86\" /></div>\n" + 
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
				"        <p style=\"Margin-top: 0;Margin-bottom: 20px;text-align: center;\">Thank you for your order!</p>\n" + 
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
				"        <p class=\"size-16\" style=\"Margin-top: 0;Margin-bottom: 20px;font-size: 16px;line-height: 24px;text-align: center;\" lang=\"x-size-16\">Check Out Your Order.</p>\n" + 
				"      </div>\n" + 
				"    </div>\n" + 
				"        \n" + 
				"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\n" + 
				"      <div style=\"mso-line-height-rule: exactly;line-height: 20px;font-size: 1px;\">&nbsp;</div>\n" + 
				"    </div>\n" + 
				"        \n" + 
				"        <div style=\"font-size: 12px;font-style: normal;font-weight: normal;line-height: 19px;\" align=\"center\">\n" + 
				"          <img style=\"border: 0;display: block;height: auto;width: 100%;max-width: 174px;\" alt=\"\" width=\"174\" src=\"https://i.imgur.com/ss56Krv.png\" />\n");
				sb.append(to_msg+
						"      \n"+"<p style=\"Margin-top: 20px;Margin-bottom: 0;\">Address</p>");
				sb.append(address);
				sb.append("<p style=\"Margin-top: 20px;Margin-bottom: 0;\">Order Date</p>");
				sb.append(orderDate);
				sb.append("<p style=\"Margin-top: 20px;Margin-bottom: 0;\">Total Price</p>");
				sb.append(totalPrice+"<p></p><table style=\'text-align:center\'><tr><td>Item Title</td><td>Quantity</td><td>Price</td><td>Total Price</td><tr>");
				for(LineItem lineItem : order.getLineItems()) {
					sb.append(
						"<tr><td>"+lineItem.getItem().getItemTitle()+"</td><td>"+lineItem.getQuantity()+"</td><td>"+lineItem.getUnitPrice()+"</td><td>"+lineItem.getTotalPrice()+"</td><tr>");
				}
				
				sb.append(
						
				"        </table><p></p>"+
						"        <p></p><p></p><![if !mso]><a style=\"border-radius: 4px;display: inline-block;font-size: 14px;font-weight: bold;line-height: 24px;padding: 12px 24px;text-align: center;text-decoration: none !important;transition: opacity 0.1s ease-in;color: #ffffff !important;background-color: #b31b1b;font-family: PT Sans, Trebuchet MS, sans-serif;\" href=\"http://localhost:8112/jpetstore/shop/index.do\">Go JPetStore!</a><![endif]>\n" +
				"</div>\n" + 

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
			messageHelper.setTo(tomail); 
			messageHelper.setSubject(title);
			messageHelper.setText(sb.toString(),true); 

			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		ModelAndView mv = new ModelAndView("ViewOrder");
//		mv.addObject("order",order);
//		mv.addObject("message", "Thank you, your order has been submitted.");
		
		
		return mav;
	}
}
