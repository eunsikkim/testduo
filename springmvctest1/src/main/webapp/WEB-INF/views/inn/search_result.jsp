<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <c:choose>
<c:when test="${requestScope.list.size()==0}" >
검색실패
</c:when>
<c:otherwise>
<c:forEach var="list" items="${requestScope.list}">
${list.innName }  / ${list.innCity } / ${list.innArea } / ${list.innAddress } / ${list.acceptableNo } / ${list.innPrice } / ${list.innInfo }<br>
</c:forEach>
</c:otherwise>
</c:choose> --%>

<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th >숙소 번호</th>
							<th>숙소명</th>
							<th>지역(대)</th>
							<th>지역(중)</th>
							<th>상세 주소</th>
							<th>유형</th>
							<th>수용가능인원</th>
							<th>가격</th>
						</tr>
					</thead>
					<tbody>
					<c:choose>
					<c:when test="${requestScope.list.size()==0}" >
					<tr align="center"><td colspan="8">검색결과가 존재하지 않습니다.</td></tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="list" items="${requestScope.list}">
							<tr>
								<td><!-- <div id="showInnNo"></div> -->${list.innNo }</td>
								<td><!-- <div id="showInnName"></div> -->${list.innName }</td>
								<td><!-- <div id="showInnCity"></div> -->${list.innCity }</td>
								<td><!-- <div id="showInnArea"></div> -->${list.innArea }</td>
								<td><!-- <div id="showInnInfo"></div> -->${list.innAddress }</td>
								<td><!-- <div id="showInnType"></div> -->${list.innType }</td>
								<td><!-- <div id="showInnAcceptable"></div> -->${list.acceptableNo }</td>
								<td><!-- <div id="showInnPrice"></div> -->${list.innPrice }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

