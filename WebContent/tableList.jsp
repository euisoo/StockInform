<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="tg" style="width: 100%;">
	<tr>
		<th class="tg-kb3h" width="30%">업종</th>
		<th class="tg-kb3h" width="69%">종목</th>
	</tr>
	<c:forEach items="${requestScope.data}" var="data">
		<tr>
			<td class="tg-1twi">${data.busName}</td>
			<td class="tg-1twi"><a href='select.do?cmpName=${data.cmpName}&busName=${data.busName}'>${data.cmpName}</a></td>
		</tr>
	</c:forEach>
</table>