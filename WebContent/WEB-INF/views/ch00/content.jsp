<%--
	[page 지시자]
	language	: .jsp 파일에서 사용되는 프로그래밍 언어 (생략 가능)
	pageEncoding: .jsp 파일로 저장할 때 사용되는 문자셋 (생략 가능)
	contentType	: .jsp가 실행 후 만들어지는 결과물의 종류
	
		MIME 타입을 지정
			text/html		: 문자 내용으로 html 태그로 구성된 것
			application/json: 문자 내용으로 json 표기로 구성된 것 
			image/jpeg		: 이미지 내용으로 .jpeg으로 인코딩한 것
			image/png		: 이미지 내용으로 .png로 인코딩한 것
	
		문자셋 지정
			브라우저로 전달할 때 사용되는 문자셋 (문자 내용은 반드시 기술을 해야함)
			
		
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- import 속성 --%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="<%=application.getContextPath() %>/resources/css/main.css">
	</head>

	<body>
		<div class="wrap">
			<%-- 공통 헤더 --%>
			<jsp:include page="/WEB-INF/views/include/header.jsp"/>
			<div class="mainCenter">
				<%-- 공통 메뉴 --%>
				<jsp:include page="/WEB-INF/views/include/menu.jsp"/>
				<%-- 내용 --%>
				<div class="content">
					<div class="sector">
						<h5>개발 환경 구축</h5>
						<div>
							교재를 참고해서 1장을 진행하면 됩니다.
						</div>
					</div>
					
					<div class="sector">
						<h5>개발 환경 구축</h5>
						<div>
							교재를 참고해서 1장을 진행하면 됩니다.
						</div>
					</div>
					
					<div class="sector">
						<h5>개발 환경 구축</h5>
						<div>
							교재를 참고해서 1장을 진행하면 됩니다.
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</body>
</html>