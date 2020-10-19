<%@page import="com.example.dao.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.example.dto.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB - Member</title>
</head>
<body>
<%
	MemberDAO dao = new MemberDAOImpl();

	List<MemberDTO> list = dao.selectAllMember();
%>

<table>
<%
	for (MemberDTO dto : list ){
%>
	<tr>
		<td>
			<%= dto.getIdx() %>
		</td>
		<td>
			<%= dto.getUsername() %>
		</td>
	</tr>
<%
	}
%>
</table>

</body>
</html>