package com.springDev.Pjt210528_01.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.springDev.Pjt210528_01.member.Member;
import com.springDev.Pjt210528_01.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements IMemberService {
	
	@Autowired
    MemberDao dao;
	
	@Override
	public void memberRegister(Member member) {
		printMembers(dao.memberInsert(member));
	}

	@Override
	public Member memberSearch(Member member) {
		Member mem = dao.memberSelect(member);
		printMember(mem);
		
		return mem;
	}

	@Override
	public Member memberModify(Member member) {
		
		Member memAft = dao.memberUpdate(member);
		printMember(memAft);
		
		return memAft;
	}
	
	@Override
	public void memberRemove(Member member) {
		printMembers(dao.memberDelete(member));
	}
	
	private void printMembers(Map<String, Member> map) {
		
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			Member mem = map.get(key);
			printMember(mem);
		}
		
	}
	
	private void printMember(Member mem) {
		
		System.out.print("ID:" + mem.getMemId() + "\t");
		System.out.print("|PW:" + mem.getMemPw() + "\t");
		System.out.print("|MAIL:" + mem.getMemMail() + "\n");
		
	}

}
