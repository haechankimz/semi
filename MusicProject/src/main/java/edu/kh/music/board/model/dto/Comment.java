package edu.kh.music.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	private int commentNo;
	private String commentContent;
	private String commentWriteDate;
	private String commentDelFl;
	
	
	private int memberNo;
	private int boardNo;
	private int parentCommentNo;
	
	private String memberNickname;
	

}
