package com.Fyou.service;

import com.Fyou.vo.MemberVO;

public interface MemberService {
	//멤버 정보조회
	public MemberVO selectMember(String member_id);
}