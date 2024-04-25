package edu.kh.music.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.music.board.model.dto.Board;

public interface BoardService {
	
	/** 게시판 종류
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();
	
	
	// 카테고리 버튼 가져오기
	List<String> selectCategoryList(int boardCode);

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectBoardList(int boardCode, int cp);


	/** 게시글에 카테고리 가져오기
	 * @param categoryNo
	 * @return
	 */
	String getCategoryName(int categoryNo);


	/** 게시글 상세 조회
	 * @param map
	 * @return
	 */
	Board selectOne(Map<String, Integer> map);







}
