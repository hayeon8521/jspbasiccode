package com.Fyou.control.goodsinfoCTB;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Fyou.commom.Control;
import com.Fyou.service.AnswerService;
import com.Fyou.service.AnswerServiceImpl;
import com.Fyou.service.GoodsinfoService;
import com.Fyou.service.GoodsinfoServiceImpl;
import com.Fyou.service.ImgService;
import com.Fyou.service.ImgServiceImpl;
import com.Fyou.service.ReviewService;
import com.Fyou.service.ReviewServiceImpl;
import com.Fyou.vo.AskVO;
import com.Fyou.vo.GoodsinfoVO;
import com.Fyou.vo.ImgVO;
import com.Fyou.vo.ReviewVO;

public class goodsinfoCont implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//상품
		GoodsinfoService gsvc = new GoodsinfoServiceImpl();
		//리뷰
		ReviewService rsvc = new ReviewServiceImpl();
		//문의
		AnswerService asvc = new AnswerServiceImpl();
		//이미지
		ImgService isvc = new ImgServiceImpl();
		
		//초기 페이지
		int page = 1;
		//상품리스트 페이지에서 파라미터 변수이름을 뭘로 넘겨줄지 알아야 됨 임시로 이렇게 적었음. 나중에 파라미터 String seqGoods = "1"; 지우고 주석처리된 위에 코드 사용하기
		//String seqGoods = req.getParameter("seqGoods");
		String seqGoods = "3";
		
		//상품 정보 객체 넘기기
		GoodsinfoVO goods = gsvc.goodsinfo(Integer.parseInt(seqGoods));
		req.setAttribute("goodsinfo", goods);	
		
		//리뷰 리스트 넘기기
		List<ReviewVO> reviews = rsvc.reviews(Integer.parseInt(seqGoods));
		req.setAttribute("reviews", reviews);
		
		//문의 리스트 넘기기	--> 해당 문의에 대한 답변은 ajax로 해야됨. AnserMapper-selectAnswer사용하기
		List<AskVO> asks = asvc.selectAskGoods(Integer.parseInt(seqGoods), page);
		req.setAttribute("asks", asks);
		
		//이미지 리스트 넘기기
		List<ImgVO> imgs = isvc.images(Integer.parseInt(seqGoods));
		req.setAttribute("imgs", imgs);
		
		
		req.getRequestDispatcher("BuyerTM/goodsinfoCTB.tiles").forward(req, resp);
		
	}

}
