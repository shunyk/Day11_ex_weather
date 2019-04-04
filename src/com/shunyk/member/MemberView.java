package com.shunyk.member;

import java.util.HashMap;
import java.util.Iterator;

public class MemberView {

	public void view(String s) {
		System.out.println(s);
	}

	public void view (Member member) {
		if(member != null) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}

	public void view (HashMap<String, Member> members) {
		Iterator<String> it = members.keySet().iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			Member value = members.get(key);
			System.out.println("Name : " + value.getName());
			System.out.println("Id : " + value.getId());
			System.out.println("Pw : " + value.getPw());
			System.out.println("Age : " + value.getAge());
			System.out.println("Level : " + value.getLevel());
			System.out.println("=======================");
		}
	}

}
