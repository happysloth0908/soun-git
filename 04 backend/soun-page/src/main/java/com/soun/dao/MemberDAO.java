package com.soun.dao;

import java.util.HashMap;
import java.util.Map;

import com.soun.dto.Member;

public class MemberDAO {
	Map<String, Member> members = new HashMap();
	
	private MemberDAO() {}
	private static MemberDAO memberDao = new MemberDAO(); // 얘 덕분에 memberController 에서 클래스면.get 바로 쓸 수 잇음 
	public static MemberDAO getMemberDao () {
		return memberDao;
	}
	//// --- 이것이 바로 싱글톤, 매니저는 한 명만 있으면 되니까---- 
	
	public void insertMember(Member member) {
		members.put(member.getId(), member);
	}
	
	public Member loginMember(Member member) {
		Member m = members.get(member.getId()); // ID가 키 값이니까 
		if (m != null && m.getPassword().equals(member.getPassword())) return m;
		return null;
		
	}
}
