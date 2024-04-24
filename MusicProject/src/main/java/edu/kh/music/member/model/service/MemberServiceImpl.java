package edu.kh.music.member.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.music.member.model.dto.Member;
import edu.kh.music.member.model.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
	
	private final MemberMapper mapper;
	
	private final BCryptPasswordEncoder bcrypt;
	
	// 로그인
	@Override
	public Member login(Member member) {
		
		// 입력 받은 pw
//		String pw = member.getMemberPw();
		
		String bcryptPw = bcrypt.encode(member.getMemberPw());
		
		Member loginMember = mapper.login(member.getMemberEmail());
		
		if(loginMember == null) return null;
		
		if( !bcrypt.matches(member.getMemberPw(), loginMember.getMemberPw()) ) return null;
		
		loginMember.setMemberPw(null);
		
		return loginMember;
	}
	
	
	// 회원가입
	@Override
	public int signup(Map<String, Object> map) {
		
		
		return 0;
	}

}
