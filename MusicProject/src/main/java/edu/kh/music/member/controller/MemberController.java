package edu.kh.music.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@SessionAttributes({"loginMember"})
@RequestMapping("member")
@Slf4j
public class MemberController {

}
