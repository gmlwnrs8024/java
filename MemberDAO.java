package com.kgitbank.mvc101;



import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository

public class MemberDAO {
	Connection con;
	
	public MemberDAO() {
		try {
		//model
		//1.커넥터 설정
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("1.커넥터 설저ok");
		
		//2.db연결
		
		String url="jdbc:mysql://localhost:3309/spring";
		String user="root";
		String password="1234";
		con= DriverManager.getConnection(url, user, password);
		System.out.print("2.db 연결 ok");
		}catch (Exception e) {
		}
	}

	
	public void insert(MemberDTO dto) {
		try{
			
			
			//3.sql문 결정
			
			String sql="insert into member values (?,?,?,?)";
			//string->sql객체 변환시켜줘야함
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTel());

			System.out.print("3.sql문 객체화 ok");
			
			//4.sql문 전송
			ps.executeUpdate();
			System.out.print("4.sql문 전송 ok");	
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void update(MemberDTO dto) {
		try{
			
			
			//3.sql문 결정
			
			String sql="update member set tel = ? where id = ?";
			//string->sql객체 변환시켜줘야함
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getTel());
			ps.setString(2, dto.getId());

			System.out.print("3.sql문 객체화 ok");
			
			//4.sql문 전송
			ps.executeUpdate();
			System.out.print("4.sql문 전송 ok");	
			
		}catch(Exception e) {
			
		}
		
	}
	
	public MemberDTO select(MemberDTO dto) {
		MemberDTO dto2=null;
		try{
			
			//3.sql문 결정
			
			String sql="select* from member where id =? ";
			//string->sql객체 변환시켜줘야함
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getId());

			System.out.print("3.sql문 객체화 ok");
			
			//4.sql문 전송
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				
				dto2=new MemberDTO();
				dto2.setId(rs.getString(1));
				dto2.setPw(rs.getString(2));
				dto2.setName(rs.getString(3));
				dto2.setTel(rs.getString(4));				
				/*
				 * System.out.print(id); System.out.print(pw); System.out.print(name);
				 * System.out.print(tel);
				 */
			}
			//5.검색결과 받아와야함(record 하나)
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto2;
	}
	
	
	public void selectAll(MemberDTO dto) {
		try{
			
			
			//3.sql문 결정
			
			String sql="select*from member ";
			//string->sql객체 변환시켜줘야함
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getId());

			System.out.print("3.sql문 객체화 ok");
			
			//4.sql문 전송
			ps.executeUpdate();
			System.out.print("4.sql문 전송 ok");	
			
		}catch(Exception e) {
			
		}
		
	}
	
	public void delete(MemberDTO dto) {
		try{
			
			
			//3.sql문 결정
			
			String sql="delete from member where id = ?";
			//string->sql객체 변환시켜줘야함
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			

			System.out.print("3.sql문 객체화 ok");
			
			//4.sql문 전송
			ps.executeUpdate();
			System.out.print("4.sql문 전송 ok");	
			
		}catch(Exception e) {
			
		}
		
	}
	
	
}
