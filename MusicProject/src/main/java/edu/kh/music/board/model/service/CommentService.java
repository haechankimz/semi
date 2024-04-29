package edu.kh.music.board.model.service;

import java.util.List;

import edu.kh.music.board.model.dto.Comment;

public interface CommentService {

	/** 댓글 조회
	 * @param boardNo
	 * @return
	 */
	List<Comment> select(int boardNo);

}
