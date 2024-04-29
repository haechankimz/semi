package edu.kh.music.board.model.mapper;

import java.util.List;
import java.util.Locale.Category;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import edu.kh.music.board.model.dto.Board;
import oracle.jdbc.proxy.annotation.Post;

/**
 * 
 */
@Mapper
public interface BoardMapper {
	
	

	/** 게시판 종류
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();

	
	/** 카테고리 버튼 가져오기
	 * @return
	 */
	List<Map<String, Object>> selectCategoryList(int boardCode);
	
	/** 게시글 수 조회
	 * @param boardCode
	 * @return
	 */
	int getListCount(int boardCode);


	/** 게시글 목록 조회
	 * @param boardCode
	 * @param rowBounds
	 * @return
	 */
	List<Board> selectBoardList(int boardCode, RowBounds rowBounds);

	/** 특정 카테고리의 게시글
	 * @param boardCode
	 * @param categoryNo
	 * @param rowBounds
	 * @return
	 */
	List<Board> selectCategoryBoardList(@Param("boardCode") int boardCode, @Param("categoryNo") int categoryNo, RowBounds rowBounds);

	/** 게시글에 카테고리 이름 가져오기
	 * @param categoryNo
	 * @return
	 */
	String getCategoryName();

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


	/** 조회수 조회
	 * @param boardNo
	 * @return
	 */
	int selectReadCount(int boardNo);


	/** 좋아요 취소
	 * @param map
	 * @return
	 */
	int deleteBoardLike(Map<String, Integer> map);


	/** 좋아요 누르기
	 * @param map
	 * @return
	 */
	int addBoardLike(Map<String, Integer> map);


	/** 좋아요 조회
	 * @param temp
	 * @return
	 */
	int selectLikeCount(int temp);



















	
	


}
