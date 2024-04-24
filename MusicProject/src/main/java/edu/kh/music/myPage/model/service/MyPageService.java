package edu.kh.music.myPage.model.service;

import edu.kh.music.member.model.dto.Member;

public interface MyPageService {

	// 비밀번호 변경
	int changePw(String currentPw, String newPw, int memberNo);

	// 회원 탈퇴
	int secession(String memberPw, Member loginMember);

}
