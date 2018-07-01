<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="tg" style="width: 100%;">
				<tr>
					<th class="tg-kb3h" width="5%" background="red">year</th>
					<th class="tg-kb3h" width="5%">Revenue</th>
					<th class="tg-kb3h" width="5%">OperatingIncome</th>
					<th class="tg-kb3h" width="5%">1</th>
					<th class="tg-kb3h" width="5%">2</th>
					<th class="tg-kb3h" width="5%">3</th>
					<th class="tg-kb3h" width="5%">4</th>
					<th class="tg-kb3h" width="5%">5</th>
					<th class="tg-kb3h" width="5%">6</th>
					<th class="tg-kb3h" width="5%">7</th>
					<th class="tg-kb3h" width="5%">8</th>
					<th class="tg-kb3h" width="5%">9</th>
					<th class="tg-kb3h" width="5%">10</th>
					<th class="tg-kb3h" width="5%">11</th>
					<th class="tg-kb3h" width="5%">12</th>
					<th class="tg-kb3h" width="5%">13</th>
				</tr>
				<c:forEach items='${requestScope.financeData3}' var="data">
					<tr>
						<td class="tg-1twi">${data.year}</td>
						<td class="tg-1twi">${data.revenue}</td>
						<td class="tg-1twi">${data.operatingIncome}</td>
						<td class="tg-1twi">${data.netIncome}</td>
						<td class="tg-1twi">${data.totalAsset}</td>
						<td class="tg-1twi">${data.totalDebt}</td>
						<td class="tg-1twi">${data.capitalGross}</td>
						<td class="tg-1twi">${data.capex}</td>
						<td class="tg-1twi">${data.fcf}</td>
						<td class="tg-1twi">${data.netProfitRatio}</td>
						<td class="tg-1twi">${data.roe}</td>
						<td class="tg-1twi">${data.roa}</td>
						<td class="tg-1twi">${data.eps}</td>
						<td class="tg-1twi">${data.per}</td>
						<td class="tg-1twi">${data.bps}</td>
						<td class="tg-1twi">${data.pbr}</td>
					</tr>
				</c:forEach>
			</table>