package edu.kh.music.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.music.board.model.service.EditBoardService;
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
	
}
