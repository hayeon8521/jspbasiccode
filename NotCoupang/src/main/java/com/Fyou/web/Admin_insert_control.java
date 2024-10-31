package com.Fyou.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Fyou.commom.Control;
import com.Fyou.service.GoodsinfoService;
import com.Fyou.service.GoodsinfoServiceImpl;
import com.Fyou.vo.GoodsinfoVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Admin_insert_control implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String savePath = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = new MultipartRequest(
				req, // 요청정보
				savePath, // 저장경로
				maxSize, // 최대크기
				"utf-8", // 인코딩 방식
				new DefaultFileRenamePolicy() // 리네임 정책
				);
		
		String goods_name = mr.getParameter("goods_name");
		int goods_price = Integer.parseInt(mr.getParameter("goods_price"));
		int goods_inven = Integer.parseInt(mr.getParameter("goods_inven"));
		String goods_catename = mr.getParameter("goods_catename");
		String img_thumbnail = mr.getParameter("img_thumbnail");
		
		GoodsinfoVO result = new GoodsinfoVO();
		result.setGoodsName(goods_name);
		result.setGoodsPrice(goods_price);
		result.setGoodsInven(goods_inven);
		result.setGoodsState("state");
		result.setGoodsMid("test"); // 나중에 세션으로 받는 아이디로 변경
		result.setGoodsCatename(goods_catename);
		
		GoodsinfoService gsvc = new GoodsinfoServiceImpl();
		
		if (gsvc.registerGoods(result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

}
