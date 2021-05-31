package com.springDev.Pjt210531_02.member.service;

import com.springDev.Pjt210531_02.member.Member;

public interface IMemberService {
	void memberRegister(Member member);
	Member memberSearch(Member member);
	Member memberModify(Member member);
	void memberRemove(Member member);
}
