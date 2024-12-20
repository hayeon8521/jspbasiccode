package com.Fyou.control.BSJ;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Fyou.commom.Control;
import com.Fyou.service.GoodsinfoService;
import com.Fyou.service.GoodsinfoServiceImpl;
import com.Fyou.service.ImgService;
import com.Fyou.service.ImgServiceImpl;
import com.Fyou.service.OrderService;
import com.Fyou.service.OrderServiceImpl;
import com.Fyou.service.ReviewService;
import com.Fyou.service.ReviewServiceImpl;
import com.Fyou.vo.GoodsinfoVO;
import com.Fyou.vo.GoodsmylistVO;
import com.Fyou.vo.ImgVO;
import com.Fyou.vo.OrderVO;
import com.Fyou.vo.ReviewVO;

public class MyReviewControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 내 리뷰
		// 정상 구현 확인
		System.out.println("MyReviewControl");
		
		HttpSession session = req.getSession();
		String LOGID = (String) session.getAttribute("LOGID");
		
		//값을 담을 그릇
				List<GoodsmylistVO> goodsmylist = new ArrayList<>();
				
				// 파라미터 선언
				// 검색조건 (1.파라미터 받기)
				String mid = req.getParameter("buyerId");
				
				OrderService svc = new OrderServiceImpl();
				List<OrderVO> list = svc.selectOrder(mid);
				
				System.out.println(list.toString());
				
				for(OrderVO temp : list) {
					temp.getGoodsNum();  //상품번호
					temp.getCount();     //상품수량
					temp.getPrice();     //상품가격
					temp.getOrderDate(); //주문날짜
					temp.getSeqOrder();   //주문번호
					
					//상품번호로 상품제목 가져오기
					GoodsinfoVO gvo = new GoodsinfoVO();
					GoodsinfoService gsvc = new GoodsinfoServiceImpl();
					gvo = gsvc.goodsinfo(temp.getGoodsNum());
					System.out.println(gvo.toString());
					System.out.println(gvo.getGoodsName()); //상품제목
					
					//상품번호로 썸네일이미지 가져오기
					ImgService Isvc = new ImgServiceImpl();
					List<ImgVO> Ivo = Isvc.images(temp.getGoodsNum());
					//System.out.println(Ivo.toString());
					
					ImgVO voI = Ivo.get(0);
					System.out.println(voI.getImgUrl()); //썸네일 이미지 주소
		//확인용			
//					for(ImgVO temp1 : Ivo) {
//						System.out.println(temp1.getImgUrl());
//					}
					
					String imgurl = voI.getImgUrl();
					
					//ID로 리뷰 가져오기
					ReviewService rsvc= new ReviewServiceImpl();
					
					
					ReviewVO rvo3 = new ReviewVO();
					rvo3.setGoodsNum(temp.getGoodsNum());
					rvo3.setBuyerId(mid);
					
					String reviewBSJ = "";
					Date ReviewDateBSJ;
					int ReviewSeqBSJ=0;
					ReviewVO rvo2 = rsvc.reviewOne(rvo3);
					if(rvo2==null) {
						ReviewDateBSJ = temp.getOrderDate();
						System.out.println("값없어요!!!");
						System.out.println("값없어요!!!");
						System.out.println("값없어요!!!");
					}else {
						System.out.println("값있어요!!!");
						System.out.println("값있어요!!!");
						reviewBSJ = rvo2.getReview();
						ReviewDateBSJ = rvo2.getReviewDate();
						ReviewSeqBSJ = rvo2.getSeqReview();
						System.out.println(rvo2.getReview());
						System.out.println("값있어요!!!");
						System.out.println("값있어요!!!");
					}
					
					//rvo2.getBuyerId();        //구매자아이디
					//rvo2.getSeqReview();      //리뷰번호
					//rvo2.getReview();         //리뷰내용
					//rvo2.getReviewDate();     //리뷰날짜
							
							
					
					goodsmylist.add(new GoodsmylistVO(
							temp.getGoodsNum(), //상품번호
							gvo.getGoodsName(), //상품이름
							temp.getPrice(), //가격
							temp.getCount(), //수량
							String.valueOf(temp.getSeqOrder()),//주문번호
							reviewBSJ,//리뷰내용
							String.valueOf(ReviewDateBSJ),//리뷰날짜
							temp.getOrderDate(),//주문날짜
							temp.getOrderDate(),
							imgurl,
							ReviewSeqBSJ //리뷰번호
							));
					
					
				}
				
				
				//System.out.println(goodsmylist.toString());
				
				
				
			
				//조회해서 어트리뷰트에 값담기
				//내 주문 리스트 넘기기
				//req.setAttribute("selectOrder", list);
				
				req.setAttribute("goodsmylist", goodsmylist);
				
				try {
					req.getRequestDispatcher("BuyerTM/myReviewBSJ.tiles").forward(req, resp);
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}

}
