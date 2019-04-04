package com.shunyk.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.shunyk.weather.Weather;

public class MemberInit {
	//메소드 명은 setMember 리턴은 멤버들 MAP
	//키는 id, 밸류는 member

	private String members;
	private Scanner sc;
	private StringBuffer sb;

	public MemberInit() {
		sb = new StringBuffer();
		sb.append("iu, iu, iu, 26, 1," );
		sb.append("choa, choa, choa, 30, 2,");
		sb.append("suji, suji, suji, 23, 2,");
		sb.append("hani, hani, hani, 15, 0");
		sc = new Scanner(System.in);
	}

	public HashMap<String, Member> setMember() {
		HashMap<String, Member> members = new HashMap<String, Member>();
		this.members = this.sb.toString();
		StringTokenizer st = new StringTokenizer(this.members, ",");


		while(st.hasMoreTokens()) {
			Member member = new Member();
			member.setName(st.nextToken().trim());
			member.setId(st.nextToken().trim());
			member.setPw(st.nextToken().trim());
			member.setAge(Integer.parseInt(st.nextToken().trim()));
			member.setLevel(Integer.parseInt(st.nextToken().trim()));
			members.put(member.getId(), member);
		}
		return members;
	}

	public Member memberJoin() {

		Member m = new Member();
		System.out.println("이름 입력");
		m.setName(sc.next());
		System.out.println("ID 입력");
		m.setId(sc.next());
		System.out.println("PW 입력");
		m.setPw(sc.next());
		System.out.println("나이 입력");
		m.setAge(sc.nextInt());
		System.out.println("Level 입력");
		m.setLevel(sc.nextInt());

		return m;

	}

	public Member memberlogin(HashMap<String, Member> members) {
		Member member = null;
		System.out.println("ID 입력");
		String yId = sc.next();
		System.out.println("PW 입력");
		String yPw = sc.next();

		Iterator<String> it = members.keySet().iterator();

		while(it.hasNext()) {
			String key = it.next();
			if(yId.equals(members.get(key).getId()) && yPw.equals(members.get(key).getPw())) {
				member = members.get(key);
			}

		}
		return member;
	}

	public String memberDelete(HashMap<String, Member> members) {
		System.out.println("삭제하고 싶은 회원의 ID 입력");
		String yId = sc.next();
		String result = "없는 회원";

		Iterator<String> it = members.keySet().iterator();

		while(it.hasNext()) {
			String key = it.next();
			if(yId.equals(members.get(key).getId())) {
				members.remove(key);
				result = "삭제 성공";
			}
		}


		return result;

	}

}
