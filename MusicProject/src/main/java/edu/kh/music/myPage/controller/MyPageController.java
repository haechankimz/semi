package edu.kh.music.myPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
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
	public String profile() {
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
	
	// 프로필 수정
	@PostMapping("profile")
	public String updateProfile(
		@SessionAttribute("loginMember") Member loginMember,
		Model model) {
		
		String memberAddress = loginMember.getMemberAddress();
		
		if(memberAddress != null) {
			String[] arr = memberAddress.split("\\^\\^\\^");
			
			model.addAttribute("postcode", arr[0]);
			model.addAttribute("address", arr[1]);
			model.addAttribute("detailAddress", arr[2]);
		}
		
		return "/myPage/myPage-profile";
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
			path = "myPage/profile";
		}else {
			message = "비밀번호가 일치하지 않습니다";
			path = "myPage/changePw";
		}
		
		ra.addFlashAttribute("message", message);
	
		return path;
	}
	
	
	// 회원 탈퇴
	@PostMapping("secession")
	public String secsssioin(
		@SessionAttribute("loginMember") Member loginMember,
		@RequestParam("memberPw") String memberPw) {
		
		int result = service.secession(memberPw, loginMember);
		
		return null;
	}
	
	
	
	
	
	
}
