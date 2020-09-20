package com.example.jpetstore.controller;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.jpetstore.domain.Cart;
import com.example.jpetstore.domain.CartItem;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("sessionCart")
public class UpdateCartQuantitiesController { 

	@RequestMapping("/shop/updateCartQuantities.do")
	public ModelAndView handleRequest(
			HttpServletRequest request,	
			@ModelAttribute("sessionCart") Cart cart) throws Exception {
		Iterator<CartItem> cartItems = cart.getAllCartItems();
		while (cartItems.hasNext()) {
			CartItem cartItem = (CartItem) cartItems.next();
			String itemId = cartItem.getItem().getItemId();
			try {
				int quantity = Integer.parseInt(request.getParameter(itemId));
				int qty = cart.getQuantityInStockByItemId(itemId);
				if (quantity < 1) {
					cartItems.remove();
				}
				else if (qty<quantity) {
					ModelAndView mav = new ModelAndView("tiles/Cart");
					mav.addObject("cart", cart);
					mav.addObject("reject",1);
					return mav;
				}
				cart.setQuantityByItemId(itemId, quantity);
			}
			catch (NumberFormatException ex) {
				// ignore on purpose
			}
		}
		return new ModelAndView("tiles/Cart", "cart", cart);
	}

}
