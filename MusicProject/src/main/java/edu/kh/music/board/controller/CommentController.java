package edu.kh.music.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.kh.music.board.model.dto.Comment;
import edu.kh.music.board.model.service.CommentService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("comment")
public class CommentController {
	
	private final CommentService service;
	
	// 댓글 조회
	@GetMapping(value="", produces="application/json")
	public List<Comment> select(
			@RequestParam("boardNo") int boardNo){
		
		return service.select(boardNo);
	}

}
