package com.springDev.Pjt210516_01.member.controller;

import com.springDev.Pjt210516_01.member.Member;
import com.springDev.Pjt210516_01.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member")
public class MemberController {

	//	MemberService service = new MemberService();
	//	@Resource(name="memService")
	@Autowired
	MemberService service;

	@RequestMapping(value="/memJoin", method=RequestMethod.POST)
	public String memJoin(Member member) {
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");
//		String memMail = request.getParameter("memMail");
//		String memPhone1 = request.getParameter("memPhone1");
//		String memPhone2 = request.getParameter("memPhone2");
//		String memPhone3 = request.getParameter("memPhone3");

		service.memberRegister(member.getMemId(), member.getMemPw(),
				member.getMemMail(), member.getMemPhone1(),
				member.getMemPhone2(), member.getMemPhone3());

//		model.addAttribute("memId", memId);
//		model.addAttribute("memPw", memPw);
//		model.addAttribute("memMail", memMail);
//		model.addAttribute("memPhone", memPhone1 + " - " + memPhone2 + " - " + memPhone3);

		return "memJoinOk";
	}

	@RequestMapping(value="/memLogin", method=RequestMethod.POST)
	public String memLogin(Member member) {
//	public String memLogin(Model model, @RequestParam("memId") String memId, @RequestParam("memPw") String memPw) {
//		String memId = request.getParameter("memId");
//		String memPw = request.getParameter("memPw");

		Member myMember = service.memberSearch(member.getMemId(), member.getMemPw());

//		try {
//			model.addAttribute("memId", member.getMemId());
//			model.addAttribute("memPw", member.getMemPw());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return "memLoginOk";
	}

}



