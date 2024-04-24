package edu.kh.music.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.music.member.model.dto.Member;
import edu.kh.music.myPage.model.service.MyPageService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("myPage")
public class MyPageController {

	private final MyPageService service;
	
	
	@GetMapping("profile")
	public String profile(
		@SessionAttribute("loginMember") Member loginMember,
		Model model) {
			
		return "myPage/myPage-profile";
	}
	
	
	
	@GetMapping("write")
	public String write() {
		return "myPage/myPage-write";
	}
	
	@GetMapping("changePw")
	public String changePw() {
		return "myPage/myPage-changePw";
	}
	
	
	@GetMapping("secession")
	public String secession() {
		return "myPage/myPage-secession";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// 비밀번호 변경
	@PostMapping("changePw")
	public String changePw(
		@RequestParam("currentPw") String currentPw,
		@RequestParam("newPw") String newPw,
		@SessionAttribute("loginMember") Member loginMember,
		RedirectAttributes ra) {
		
		int memberNo = loginMember.getMemberNo();
		
		int result = service.changePw(currentPw, newPw, memberNo);
		
		String path = null;
		String message = null;
		
		if(result > 0) {
			message = "비밀번호가 변경되었습니다";
			path = "myPage/myPage-profile";
		}else {
			message = "비밀번호가 일치하지 않습니다";
			path = "myPage/myPage-changePw";
		}
		
		ra.addFlashAttribute("message", message);
	
		return path;
	}
	
	
	// 회원 탈퇴
	@PostMapping("secession")
	public String secsssioin(
		@SessionAttribute("loginMember") Member loginMember,
		@RequestParam("memberPw") String memberPw,
		SessionStatus status,
		RedirectAttributes ra) {
		
		int memberNo = loginMember.getMemberNo();
		
		int result = service.secession(memberPw, loginMember);
		
		String path = null;
		String message = null;
		
		if(result > 0) {
			path = "/";
			message = "회원이 탈퇴 되었습니다.";
			status.setComplete();
		} else {
			path = "/myPage/myPage-secession";
			message = "비밀번호가 일치하지 않습니다.";
		}

		ra.addFlashAttribute("message", message);
		
		return "redirect:";
	}
	
	
	
	
	
	
}
