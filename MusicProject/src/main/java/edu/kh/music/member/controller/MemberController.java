package edu.kh.music.member.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.music.member.model.dto.Member;
import edu.kh.music.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes({"loginMember"})
@RequestMapping("member")
public class MemberController {
	
	private final MemberService service;
	
	// 로그인
	@PostMapping("login")
	public String login(
			Member member,
			@RequestParam(value="saveId", required=false) String saveId,
			Model model,
			RedirectAttributes ra,
			HttpServletResponse resp) {
		
		Member loginMember = service.login(member);
		
		if(loginMember != null) model.addAttribute("loginMember", loginMember);
		
		
		Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
		cookie.setPath("/");
		
		if(saveId != null) cookie.setMaxAge(24 * 60 * 60); // 세션 만료기간 하루
		
		else cookie.setMaxAge(0); // 클라이언트 쿠기 삭제
		
		resp.addCookie(cookie);
		
		return "redirect:/";
	}
	
	
	// 로그아웃
	@GetMapping("logout")
	public String logout (
			SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

}
