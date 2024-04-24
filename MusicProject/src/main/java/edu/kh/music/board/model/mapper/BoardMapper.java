package edu.kh.music.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import edu.kh.music.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 게시판 종류
	 * @return
	 */
	List<Map<String, Object>> selectBoardTypeList();
	
	
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


	/** 카테고리 이름 가져오기
	 * @param categoryNo
	 * @return
	 */
	String getCategoryName();
	
	


}
