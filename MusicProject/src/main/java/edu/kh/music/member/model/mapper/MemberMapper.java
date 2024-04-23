package edu.kh.music.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.music.member.model.dto.Member;

@Mapper
public interface MemberMapper {

	/** 로그인
	 * @param memberPw
	 * @return
	 */
	Member login(String memberEmail);



}
