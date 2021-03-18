package com.google.s1.test;

import com.google.s1.member.MemberDAO;
import com.google.s1.member.MemberDTO;

public class MemberDAOTest {

	public static void main(String[] args) {
		//Web 에서 메인 메서드는 테스트 용도로만 사용
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id3");
		memberDTO.setPw("pw3");
		memberDTO.setName("iu");
		memberDTO.setPhone("01033333333");
		memberDTO.setEmail("id3@naver.com");
		
		try {
			int result = memberDAO.memberJoin(memberDTO);
			System.out.println(memberDTO != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}