package com.Fyou.service;

import org.apache.ibatis.session.SqlSession;

import com.Fyou.commom.DataSource;
import com.Fyou.mapper.MemberMapper;
import com.Fyou.vo.MemberVO;


public class MemberServiceImpl implements MemberService{
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);

	@Override
	public MemberVO selectMember(String member_id) {
		return mapper.selectMember(member_id);
	}

	@Override
	public boolean addMember(MemberVO member) {
		return mapper.insertMember(member) == 1;
	}

	@Override
	public boolean modifyMember(MemberVO member) {
		return mapper.updateMember(member) == 1;
	}

	@Override
	public MemberVO loginCheck(String id, String pw) {
		return mapper.loginMember(id, pw);
	}

}