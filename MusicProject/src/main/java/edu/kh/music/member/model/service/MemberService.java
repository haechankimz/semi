package edu.kh.music.member.model.service;

import edu.kh.music.member.model.dto.Member;

public interface MemberService {

	/** 로그인
	 * @param member
	 * @return
	 */
	Member login(Member member);

}