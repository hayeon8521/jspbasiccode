package com.Fyou.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.Fyou.vo.AnswerVO;
import com.Fyou.vo.AskVO;

public interface AnswerMapper {
	// 유저 ID로 문의한 전체 페이징 리스트 반환
	public List<AskVO> selectAskList(@Param("buyer_id") String buyer_id, @Param("page") int page);
	// 문의 번호로 문의 답변 검색
	public AnswerVO selectAnswer(int seq_ask);
	// 문의 번호로 문의 내역 삭제
	public int deleteAsk(int seq_ask);
	// 문의 내역 작성
	public int insertAsk(AskVO ask);
	// 개별 상품의 문의 전체 페이징 리스트 반환
	public List<AskVO> selectAskGoods(@Param("goods_num") int goods_num,  @Param("page") int page);
	// 문의 번호로 문의 답변 삭제
	public int deleteAnswer(int seq_answer);
	// 문의 번호로 문의 내역 수정
	public int updateAsk(@Param("ask")String ask, @Param("seqAsk")int seqAsk);
	// 문의 번호로 답변 내역 수정
	public int updateAnswer(@Param("seq_answer") int seq_answer, @Param("answer") String answer);
	// 답변 내역 작성
	public int insertAnswer(AnswerVO answer);
	//문의 총 개수 가져오기
	public int askTotalCnt(@Param("goods_num") int goodsNum);	
	
	public List<AskVO> selectAskSellerlist(@Param("seller_id") String seller_id);
	
	public List<AskVO> selectBSJAskList(String buyerId);
	
	
	
	// 유저 ID로 문의한 전체 목록 반환
	public AskVO selectMyAskList(AskVO ask);
}
