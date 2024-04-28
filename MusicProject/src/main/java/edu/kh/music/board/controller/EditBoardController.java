package edu.kh.music.board.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.music.board.model.dto.Board;
import edu.kh.music.board.model.service.EditBoardService;
import edu.kh.music.member.model.dto.Member;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("editBoard")
public class EditBoardController {

	private final EditBoardService service;
	
	@GetMapping("/{boardCode:[0-9]+}/insert")
	public String insertBoard(
		@PathVariable("boardCode") int boardCode) {
		return "board/boardWrite";
	}
	
	
	@PostMapping("/{boardCode:[0-9]+}/insert")
	public String boardInsert(
		@PathVariable("boardCode") int boardCode,
		Board inputBoard,
		@SessionAttribute("loginMember") Member loginMember,
		@RequestParam("images") List<MultipartFile> images,
		RedirectAttributes ra) throws IllegalStateException, IOException {
		
		inputBoard.setBoardCode(boardCode);
		inputBoard.setMemberNo(loginMember.getMemberNo());
		
		int boardNo = service.boardInsert(inputBoard,images);
		
		String path = null;
		String message = null;
		
		if(boardNo > 0 ) {
			path = "/board/" + boardCode + "/" + boardNo;
			message = "게시글이 작성되었습니다.";
		}else {
			path = "insert";
			message = "게시글 작성 실패";
		}
		
		ra.addFlashAttribute("message",message);
		
		return "redirect:" + path;
	}
	
	
	
	
	
	
	
	
	
	
}
