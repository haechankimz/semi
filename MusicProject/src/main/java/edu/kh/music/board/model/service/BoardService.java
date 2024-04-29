package edu.kh.music.board.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.music.board.model.dto.Board;
import oracle.jdbc.proxy.annotation.Post;

public interface BoardService {
	
	/** 게시판 종류
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();
	
	
	// 카테고리 버튼 가져오기
	List<Map<String, Object>> selectCategoryList(int boardCode);

	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @return
	 */
	Map<String, Object> selectBoardList(int boardCode, int cp);

	/** 특정 카테고리 게시글 목록
	 * @param boardCode
	 * @param cp
	 * @param categoryNo
	 * @return
	 */
	Map<String, Object> selectCategoryBoardList(int boardCode, int cp, int categoryNo);

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


	/** 조회수 증가
	 * @param boardNo
	 * @return
	 */
	int updateReadCount(int boardNo);


	/** 좋아요 
	 * @param map
	 * @return
	 */
	int boardLike(Map<String, Integer> map);























}
