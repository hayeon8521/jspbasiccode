package com.Fyou.service;

import java.util.List;

import com.Fyou.vo.CategoriVO;

public interface CategoriService {
	//테스트완료
	
	//대분류 카테고리
	public List<CategoriVO> Tcates(String Tcate);
	
	//소분류 카테고리
	public List<CategoriVO> Bcates(String Bcate);
	
	//상단 메뉴용 대분류 카테고리 리스트
	public List<CategoriVO> listOfTcate();
}
