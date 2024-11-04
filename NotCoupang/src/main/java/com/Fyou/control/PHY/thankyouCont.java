package com.Fyou.control.PHY;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Fyou.commom.Control;
import com.Fyou.service.CartService;
import com.Fyou.service.CartServiceImpl;
import com.Fyou.service.GoodsinfoService;
import com.Fyou.service.GoodsinfoServiceImpl;
import com.Fyou.service.OrderService;
import com.Fyou.service.OrderServiceImpl;
import com.Fyou.vo.CartVO;
import com.Fyou.vo.GoodsinfoVO;
import com.Fyou.vo.OrderVO;

public class thankyouCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String LOGID = (String) session.getAttribute("LOGID");
		
		String hiddenGoods = req.getParameter("hiddenGoods");
		if(hiddenGoods != null && hiddenGoods.endsWith("_")) {
			hiddenGoods = hiddenGoods.substring(0, hiddenGoods.length() - 1);
		}
		
		System.out.println(hiddenGoods);
		
		//장바구니 서비스
		CartService svcC = new CartServiceImpl();
		//상품정보 서비스
		GoodsinfoService svcG = new GoodsinfoServiceImpl();
		//주문완료 서비스
		OrderService svcO = new OrderServiceImpl();
		
		String[] parts = hiddenGoods.split("_");
		for(int i=0; i<parts.length; i++) {
			//장바구니정보가져오기
			CartVO cart = svcC.selectOneCart(LOGID, Integer.parseInt(parts[i]));
			
			//상품정보 당기기
			GoodsinfoVO goods = svcG.goodsinfo(cart.getGoodsNum());
			OrderVO order = new OrderVO();
			order.setBuyerId(LOGID);
			order.setGoodsNum(cart.getGoodsNum());
			order.setCount(cart.getCount());
			order.setPrice(goods.getGoodsPrice());
			
			//구매내역 삽입
			svcO.insertOrder(order);
			
			//장바구니삭제
			svcC.deleteCart(cart);
		}
		req.getRequestDispatcher("BuyerTM/thank-youPHY.tiles").forward(req, resp);
	}
}