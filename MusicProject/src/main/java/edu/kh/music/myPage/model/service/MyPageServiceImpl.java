package edu.kh.music.myPage.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.music.member.model.dto.Member;
import edu.kh.music.myPage.model.mapper.MyPageMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MyPageServiceImpl implements MyPageService {

	private final MyPageMapper mapper;
	
	private final BCryptPasswordEncoder bcrypt;
	
	// 비밀번호 변경
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {

		String result = mapper.selectPw(memberNo);
		
		if(!bcrypt.matches(currentPw, result)) {
			return 0;
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberNo", memberNo);
		map.put("newPw", bcrypt.encode(newPw));
		
		return mapper.changePw(map);
	}
	
	
	// 회원 탈퇴
	@Override
	public int secession(String memberPw, Member loginMember) {
		
		int memberNo = loginMember.getMemberNo();
		
		String pw = mapper.selectPw(memberNo);
		
		if(!bcrypt.matches(memberPw, pw)) return 0;
		
		return mapper.secession(memberNo);
	}
	
	
}
