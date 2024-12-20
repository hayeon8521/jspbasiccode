package com.Fyou.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Fyou.commom.DataSource;
import com.Fyou.mapper.AnswerMapper;
import com.Fyou.vo.AnswerVO;
import com.Fyou.vo.AskVO;

public class AnswerServiceImpl implements AnswerService {
	
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	AnswerMapper mapper = sqlSession.getMapper(AnswerMapper.class);

	@Override
	public List<AskVO> selectAskList(String member_id, int page) {
		return mapper.selectAskList(member_id, page);
	}

	@Override
	public AnswerVO selectAnswer(int seq_ask) {
		return mapper.selectAnswer(seq_ask);
	}

	@Override
	public boolean deleteAsk(int seq_ask) {
		return mapper.deleteAsk(seq_ask) == 1;
	}

	@Override
	public boolean insertAsk(AskVO ask) {
		return mapper.insertAsk(ask) == 1;
	}

	@Override
	public List<AskVO> selectAskGoods(int goods_num, int page) {
		return mapper.selectAskGoods(goods_num, page);
	}

	@Override
	public boolean deleteAnswer(int seq_answer) {
		return mapper.deleteAnswer(seq_answer) == 1;
	}
	
	@Override
	public boolean updateAsk(String ask, int seq_ask) {
		return mapper.updateAsk(ask, seq_ask) == 1;
	}
	
	@Override
	public boolean updateAnswer(int seq_answer, String answer) {
		return mapper.updateAnswer(seq_answer, answer) == 1;
	}
	
	@Override
	public boolean insertAnswer(AnswerVO answer) {
		return mapper.insertAnswer(answer) == 1;
	}

	@Override
	public int askTotalCnt(int goodsNum) {
		return mapper.askTotalCnt(goodsNum);
	}

	@Override
	public List<AskVO> selectAskSellerlist(String seller_id) {
		return mapper.selectAskSellerlist(seller_id);
	}

	@Override
	public AskVO selectMyAskList(AskVO ask) {
		return mapper.selectMyAskList(ask);
	}

	@Override
	public List<AskVO> selectBSJAskList(String buyerId) {
		return mapper.selectBSJAskList(buyerId);
	}
}
