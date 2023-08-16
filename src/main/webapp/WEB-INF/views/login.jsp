<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>로그인 화면</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	<link href="${path}/resources/css/login.css" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="${path}/resources/js/login.js"></script>
</head>
<body>
<div class="container">
  <div class="screen">
    <div class="screen__content">
      <form class="login" action="/login" method="post">
        <div class="login__field">
          <span class="field_id">아이디 : </span>
          <input type="text" class="login__input" id="loginId" name="loginId" placeholder="아이디를 입력해주세요">
        </div>
        <div class="login__field">
          <span>비밀번호 : </span>
          <input type="password" class="login__input" id="loginPw" name="loginPw" placeholder="비밀번호를 입력해주세요">
        </div>
        <button class="button login__submit" id="submit" type="button">
          <span class="button__text">로그인</span>
          <i class="button__icon fas fa-chevron-right"></i>
        </button>
      </form>
    </div>
    
    <form id="loginData" action="/post" method="post">
    
    </form>
    
    <div class="screen__background">
      <span class="screen__background__shape screen__background__shape4"></span>
      <span class="screen__background__shape screen__background__shape3"></span>    
      <span class="screen__background__shape screen__background__shape2"></span>
      <span class="screen__background__shape screen__background__shape1"></span>
    </div>    
  </div>
</div>
</body>
</html>
