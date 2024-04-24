package edu.kh.music.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.music.board.model.dto.Board;
import edu.kh.music.board.model.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService service;
	
	/** 게시글 목록 조회
	 * @param boardCode
	 * @param cp
	 * @param model
	 * @param paramMap
	 * @return
	 */
	@GetMapping("{boardCode:[0-9]+}")
	public String selectBoardList(
		
		@PathVariable("boardCode") int boardCode,
		@RequestParam(value="cp", required=false, defaultValue="1") int cp,
		Model model,
		@RequestParam Map<String, Object> paramMap) {
		
		Map<String, Object> map = null;
		
		if(paramMap.get("key") == null) {
			map = service.selectBoardList(boardCode, cp);
			
			List<Board> boardList = (List<Board>) map.get("boardList");
			for(Board board : boardList) {
				int categoryNo = board.getCategoryNo();

				if(board.getBoardCode() == 1 || board.getBoardCode() == 2) {
					String categoryName = service.getCategoryName(categoryNo);
					board.setCategoryName(categoryName);
				}
			}
			
		}
		model.addAttribute("pagination", map.get("pagination"));
		model.addAttribute("boardList", map.get("boardList"));
		
		return "board/boardList";
	}

}
