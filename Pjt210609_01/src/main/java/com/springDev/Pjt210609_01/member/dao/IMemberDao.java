package com.springDev.Pjt210609_01.member.dao;

import com.springDev.Pjt210609_01.member.Member;

public interface IMemberDao {
	int memberInsert(Member member);
	Member memberSelect(Member member);
	int memberUpdate(Member member);
	int memberDelete(Member member);
}