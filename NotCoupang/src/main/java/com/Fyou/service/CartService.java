package com.Fyou.service;

import java.util.List;

import com.Fyou.vo.CartVO;

public interface CartService {
	
	//카트 전체 목록조회
	List<CartVO> cartList();
	
	//카트 조회(로그인 id별)
	public List<CartVO> selectCart(String memberId);
	
	//카트 추가
	boolean insertCart(CartVO cart);
	
	//카트 삭제
	boolean deleteCart(CartVO cart);
	
	//카트 수정
	boolean updateCart(CartVO cart);
	
	
}