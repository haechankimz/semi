package edu.kh.music.member.model.service;

import java.util.Map;

import edu.kh.music.member.model.dto.Member;

public interface MemberService {

	/** 로그인
	 * @param member
	 * @return
	 */
	Member login(Member member);

	/** 회원가입
	 * @param map
	 * @return
	 */
	int signup(Map<String, Object> map);

}
