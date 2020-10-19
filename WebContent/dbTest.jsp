<%@page import="com.example.db.DBConnector"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB - Test</title>
</head>
<body>
<%
	DBConnector dbConn = new DBConnector();
	Connection conn = dbConn.connection();
	
	if ( conn != null ){
%>
		연결 풀 찾음
<%
	}else{
%>
		연결 풀 찾지 못함.
<%
	}
	
%>

</body>
</html>