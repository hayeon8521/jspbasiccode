package com.Fyou.service;

import java.util.List;

import com.Fyou.vo.AnswerVO;
import com.Fyou.vo.AskVO;

public interface AnswerService {
	public List<AskVO> selectAskList(String member_id, int page);
	public AnswerVO selectAnswer(int seq_ask);
	public boolean deleteAsk(int seq_ask);
	public boolean insertAsk(AskVO ask);
	public List<AskVO> selectAskGoods(int goods_num, int page);
	public boolean deleteAnswer(int seq_answer);
	public boolean updateAsk(String ask, int seq_ask);
	public boolean updateAnswer(int seq_answer, String answer);
	public boolean insertAnswer(AnswerVO answer);
	public int askTotalCnt(int goodsNum);
	public List<AskVO> selectAskSellerlist(String seller_id);
	
	public List<AskVO> selectBSJAskList(String buyerId);
	
	
	//마이페이지: 회원아이디,상품번호 문의 반환
	public AskVO selectMyAskList(AskVO ask);
}
