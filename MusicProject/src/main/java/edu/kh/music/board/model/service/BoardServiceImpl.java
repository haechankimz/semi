package edu.kh.music.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.music.board.model.dto.Board;
import edu.kh.music.board.model.dto.Pagination;
import edu.kh.music.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	private final BoardMapper mapper;

	
	// 게시판 종류 조회
	@Override
	public List<Map<String, Object>> selectBoardTypeList() {
		return mapper.selectBoardTypeList();
	}
	
	// 카테고리 버튼
	@Override
	public List<String> selectCategoryList(int boardCode) {
		return mapper.selectCategoryList(boardCode);
	}
	
	
	// 게시글 목록 조회
	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {
		
		int listCount = mapper.getListCount(boardCode);
		
		Pagination pagination = new Pagination(cp, listCount);
		
		int limit = pagination.getLimit();
		int offset = (cp-1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		
		List<Board> boardList = mapper.selectBoardList(boardCode, rowBounds);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("pagination", pagination);
		map.put("boardList", boardList);
		
		return map;
	}

	// 게시글에 카테고리 가져오기
	@Override
	public String getCategoryName(int categoryNo) {
		return mapper.getCategoryName();
	}

	// 게시글 상세조회
	@Override
	public Board selectOne(Map<String, Integer> map) {
		return mapper.selectOne(map);
	}






	



}
