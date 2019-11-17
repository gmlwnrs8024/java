package com.kgitbank.mvc101;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Ư���� ó���̸� ǥ��  annotation(ǥ��)
//controllerŬ���� ��ӹ޾Ѽ� controller������ �ϰ� Ŭ������ ������ְ� spring framework�� ���

@Controller

public class MemberController {
	
	@Autowired
	MemberDAO dao;
	//�������� �ֵ������� ��ü�� �����, ���α׷��Ӵ� �������� ������� ��ü�� �ּҸ� ���
	//�������� ���� ���� ������ �־��ش�.
	//������ ����( Inversion of Control )
	
	@RequestMapping("delete")
	public void delete(MemberDTO memberDTO) {
		System.out.println("delete ��û��");
		System.out.println("DB ���� ó��");
		dao.delete(memberDTO);
	}
	
	@RequestMapping("update")
	public void update(MemberDTO memberDTO) {
		System.out.println("update ��û��");
		System.out.println("DB ���� ó��");
		dao.update(memberDTO);
	}
	
	@RequestMapping("select")
	public void select(MemberDTO memberDTO, Model model) {
		System.out.println("select ��û��");
		System.out.println("DB ���� �˻� ó��");
		MemberDTO dto2=dao.select(memberDTO);
		
		model.addAttribute("dto2",dto2 );
		System.out.println(dto2.getId());
		System.out.println(dto2.getPw());
		System.out.println(dto2.getName());
		System.out.println(dto2.getTel());
	}
	
	@RequestMapping("selectAll")
	public void selectAll(MemberDTO memberDTO) {
		System.out.println("selectAll ��û��");
		System.out.println("DB ��ü �˻� ó��");
		dao.selectAll(memberDTO);
	}
	
	
	@RequestMapping("insert")
	public void insert(MemberDTO memberDTO) {
		System.out.println("��Ʈ�ѷ� ȣ���");
		dao.insert(memberDTO);
		
		System.out.println(memberDTO.getId());
		System.out.println(memberDTO.getPw());
		System.out.println(memberDTO.getName());
		System.out.println(memberDTO.getTel());

		
	}
	

}
