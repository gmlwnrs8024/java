package com.kgitbank.mvc101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@특정한 처리이름 표시  annotation(표시)
//controller클래스 상속받앗서 controller역할을 하게 클래스로 만들어주고 spring framework에 등록

@Controller

public class MemberController {
	
	@Autowired
	MemberDAO dao;
	//스프링이 주도적으로 객체를 만들고, 프로그래머는 스프링이 만들어준 객체의 주소를 사용
	//스프링이 내가 만든 변수에 넣어준다.
	//제어의 역행( Inversion of Control )
	
	@RequestMapping("delete")
	public void delete(MemberDTO memberDTO) {
		System.out.println("delete 요청됨");
		System.out.println("DB 삭제 처리");
		dao.delete(memberDTO);
	}
	
	@RequestMapping("update")
	public void update(MemberDTO memberDTO) {
		System.out.println("update 요청됨");
		System.out.println("DB 수정 처리");
		dao.update(memberDTO);
	}
	
	@RequestMapping("select")
	public void select(MemberDTO memberDTO, Model model) {
		System.out.println("select 요청됨");
		System.out.println("DB 조건 검색 처리");
		MemberDTO dto2=dao.select(memberDTO);
		
		model.addAttribute("dto2",dto2 );
		System.out.println(dto2.getId());
		System.out.println(dto2.getPw());
		System.out.println(dto2.getName());
		System.out.println(dto2.getTel());
	}
	
	@RequestMapping("selectAll")
	public void selectAll(MemberDTO memberDTO) {
		System.out.println("selectAll 요청됨");
		System.out.println("DB 전체 검색 처리");
		dao.selectAll(memberDTO);
	}
	
	
	@RequestMapping("insert")
	public void insert(MemberDTO memberDTO) {
		System.out.println("컨트롤러 호출된");
		dao.insert(memberDTO);
		
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPw());
		System.out.println(memberDTO.getName());
		System.out.println(memberDTO.getTel());

		
	}
	

}
