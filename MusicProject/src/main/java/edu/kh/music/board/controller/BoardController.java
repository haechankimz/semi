package edu.kh.music.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.music.board.model.dto.Board;
import edu.kh.music.board.model.service.BoardService;
import edu.kh.music.member.model.dto.Member;
import jakarta.mail.internet.ParseException;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		
		// 카테고리 버튼이름 가져오기
		List<String> categoryNames = service.selectCategoryList(boardCode);
		
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
		model.addAttribute("categoryNames", categoryNames);
		
		return "board/boardList";
	}

	
	
	// 게시글 상세 조회
	@GetMapping("{boardCode:[0-9]+}/{boardNo:[0-9]+}")
	public String boardDetail(
		@PathVariable("boardCode") int boardCode,
		@PathVariable("boardNo") int boardNo,
		Model model,
		RedirectAttributes ra,
		@SessionAttribute(value="loginMember", required=false) Member loginMember,
		HttpServletRequest req,
		HttpServletResponse resp) throws ParseException {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("boardCode", boardCode);
		map.put("boardNo", boardNo);
		
		if(loginMember != null) {
			map.put("memberNo", loginMember.getMemberNo());
		}
		
		Board board = service.selectOne(map);
		
		String path = null;
		
		if(board == null) {
			path = "redirect:/board/" + boardCode;
			ra.addAttribute("message", "게시글이 존재하지 않습니다.");
			
		} else {
			if(loginMember == null || loginMember.getMemberNo() != board.getMemberNo()) {
				
				Cookie[] cookies = req.getCookies();
				Cookie c = null;
				for(Cookie temp : cookies) {
					
					if(temp.getName().equals("readBoardNo")) {
						c = temp;
						break;
					}
				}
				
				int result = 0;
				
//				if(c == null) {
//					c = new Cookie("readBoardNo", "[" + boardNo + "]");
//					result = service.updateReadCount(boardNo);
//				}
//				
//				else {
//					if(c.getValue().indexOf("[" + boardNo +"]") == -1) {
//						c.setValue(c.getValue() + "[" + boardNo + "]");
//						result = service.updateReadCount(boardNo);
//					}
//				}
				
				path = "board/boardDetail";
				
				model.addAttribute("board", board);
				
				
			}
		}
		return path;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
