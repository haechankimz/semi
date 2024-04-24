package edu.kh.music.myPage.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {

	// 회원 비밀번호 조회
	String selectPw(int memberNo);

	// 비밀번호 변경
	int changePw(Map<String, Object> map);

	// 회원 탈퇴
	int secession(int memberNo);

}
