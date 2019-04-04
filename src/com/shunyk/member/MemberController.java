package com.shunyk.member;

import java.util.HashMap;
import java.util.Scanner;

public class MemberController {
	
	private MemberInit mi;
	private MemberView mv;
	private Scanner sc;
	private HashMap<String, Member> members;
	private Member member;
	
	public MemberController() {
		mi = new MemberInit();
		mv = new MemberView();
		sc = new Scanner(System.in);
		members = new HashMap<String, Member>();
		member = new Member();
	}
	
	public void start() {
		boolean check = true;
		members = mi.setMember();
		while(check) {
			System.out.println("원하는 번호 입력");
			System.out.println("1. 회원       가입");
			System.out.println("2. 로     그    인");
			System.out.println("3. 회원       탈퇴");
			System.out.println("4. 회원 정보 조회");
			System.out.println("5. 종            료");
			int select = sc.nextInt();
			switch(select) {
			case 1:
				member = mi.memberJoin();
				members.put(member.getId(), member);
				break;
			case 2:
				member = mi.memberlogin(members);
				mv.view(member);
				break;
			case 3:
				String s = mi.memberDelete(members);
				mv.view(s);
				break;
			case 4:
				mv.view(members);
				break;
			case 5:
				check = !check;
				System.out.println("종료합니다");
				break;
			}
		}
	}

}
