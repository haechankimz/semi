package edu.kh.music.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.music.board.model.dto.Comment;
import edu.kh.music.board.model.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	
	private final CommentMapper mapper;
	
	
	// 댓글 조회
	@Override
	public List<Comment> select(int boardNo) {
		return mapper.select(boardNo);
	}

}
