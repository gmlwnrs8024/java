<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>회원가입처리가 잘 되었습니다.</h3>
<br color="blue">
<h3>당신의 회원가입 정보</h3>
아이디:${memberDTO.id }<br>
비밀번호:${memberDTO.pw }<br>
이름:${memberDTO.name }<br>
핸드폰번호:${memberDTO.tel }<br>

</body>
</html>