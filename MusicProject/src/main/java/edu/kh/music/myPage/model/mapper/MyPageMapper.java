package edu.kh.music.myPage.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.music.board.model.dto.Board;
import edu.kh.music.board.model.dto.Comment;
import edu.kh.music.member.model.dto.Member;

@Mapper
public interface MyPageMapper {

	// 회원 비밀번호 조회
	String selectPw(int memberNo);

	// 비밀번호 변경
	int changePw(Map<String, Object> map);

	// 회원 탈퇴
	int secession(int memberNo);

	// 회원 수정
	int updateInfo(Member member);

	// 프로필 이미지 수정
	int updateProfile(Member mem);


	// 내가 쓴 글 조회
	List<Board> selectBoard(int memberNo);

	// 내가 쓴 댓글 조회
	List<Comment> selectComment(int memberNo);


	

}
