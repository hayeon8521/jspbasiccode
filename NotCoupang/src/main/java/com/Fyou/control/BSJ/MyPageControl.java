package com.Fyou.control.BSJ;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Fyou.commom.Control;
import com.Fyou.service.MemberService;
import com.Fyou.service.MemberServiceImpl;
import com.Fyou.vo.MemberVO;

public class MyPageControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("MyInfoControl");
		
		
		String mid = req.getParameter("memberId");
		
		MemberService svc = new MemberServiceImpl();
		MemberVO mvo = svc.selectMember(mid);
		System.out.println(mvo.toString());
		
		req.setAttribute("memberId", mid);
		req.setAttribute("membervo", mvo);
		
		//오픈할 페이지 설정
		req.getRequestDispatcher("BuyerTAM/myPageBSJ.tiles").forward(req, resp);
		

	}

}