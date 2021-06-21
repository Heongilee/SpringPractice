package com.springDev.Pjt210621_01.member.service;

import com.springDev.Pjt210621_01.member.Member;

public interface IMemberService {
	void memberRegister(Member member);
	Member memberSearch(Member member);
	Member memberModify(Member member);
	int memberRemove(Member member);
}