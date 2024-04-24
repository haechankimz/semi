package edu.kh.music.myPage.model.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import edu.kh.music.member.model.dto.Member;

public interface MyPageService {

	// 비밀번호 변경
	int changePw(String currentPw, String newPw, int memberNo);

	// 회원 탈퇴
	int secession(String memberPw, Member loginMember);

	// 회원 정보 수정
	int updateProfile(Member member, MultipartFile profileImg, int memberNo) throws IllegalStateException, IOException ;


}
