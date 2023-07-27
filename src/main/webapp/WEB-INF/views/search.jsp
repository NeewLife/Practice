<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:forEach items="${list}" var="list">
	<tr>
		<td><input type="checkbox"></td>
		<td><c:out value="${list.seq}"></c:out></td>
		<td><c:out value="${list.memName}"></c:out></td>
		<td>
			<a href="javascript:void(0);" onclick="goViewPage(${list.seq})">
				<c:out value="${list.boardSubject}"></c:out>
			</a>
		</td>
		<td><c:out value="${list.regDate }"></c:out></td>
		<td><c:out value="${list.uptDate }"></c:out></td>
		<td><c:out value="${list.viewCnt }"></c:out></td>
	</tr>
</c:forEach>