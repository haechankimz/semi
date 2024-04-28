package edu.kh.music.board.controller;

import org.springframework.stereotype.Controller;

import edu.kh.music.board.model.service.CommentService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CommentController {
	
	private final CommentService service;

}
