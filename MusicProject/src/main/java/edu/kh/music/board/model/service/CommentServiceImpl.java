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

	// 댓글 작성
	@Override
	public int insertComment(Comment comment) {
		return mapper.insertComment(comment);
	}

	// 댓글 삭제
	@Override
	public int deletecomment(int comment) {
		return mapper.deleteComment(comment);
	}
	
	// 댓글 수정
	@Override
	public int updateComment(Comment comment) {
		return mapper.updateComment(comment);
	}

}
