package edu.kh.music.board.model.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	
	/** 게시판 종류
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();
	      

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectBoardList(int boardCode, int cp);


	/** 카테고리 가져오기
	 * @param categoryNo
	 * @return
	 */
	String getCategoryName(int categoryNo);

}
