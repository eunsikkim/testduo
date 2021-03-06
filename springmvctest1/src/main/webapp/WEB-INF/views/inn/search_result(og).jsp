<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	$(function() {
		$("#checkin, #checkout").datepicker({
			dateFormat : 'yy-mm-dd'
		});
		$("#filterForm").change(function() {
			$.ajax({
				type : "Post",
				url : "selectInnByCheckedAmenity.do",
				data : $("#filterForm").serialize(),
				dataType : "json",
				success : function(innInfoList) {
					if (innInfoList.length != 0) {
						var tableInfo=
						$.each(innInfoList, function(index, info) {
							$("#showInnNo").html(info.innNo);
							$("#showInnName").html(info.innName);
							$("#showInnCity").html(info.innCity);
							$("#showInnArea").html(info.innArea);
							$("#showInnInfo").html(info.innInfo);
							$("#showInnType").html(info.innType);
							$("#showInnAcceptable").html(info.innAvailability);
							$("#showInnPrice").html(info.innPrice);
						}); //each
					}//if
					else if(innInfoList.length == 0){
						$("#showInnNo").html("");
						$("#showInnName").html("");
						$("#showInnCity").html("");
						$("#showInnArea").html("");
						$("#showInnInfo").html("");
						$("#showInnType").html("");
						$("#showInnAcceptable").html("");
						$("#showInnPrice").html("");
					}
				}
			});//ajax 			 	 			
		}); //change
	});
</script>
<div class="section">
	<div class="container">
	<form action="searchByCityDateNo.do" id="searchForm" class="navbar-form navbar-left" role="search">
			<input type="text" class="form-control" name="innCity" placeholder="State" style="width: 300px;"><br>
			<input
			type="text" class="form-control" name="startDate" id="checkin" size="15"
			onfocus="this.value=''" placeholder="Checkin" style="width: 150px;"> <input type="text"
			class="form-control" name="endDate" size="15" id="checkout"
			onfocus="this.value=''" placeholder="Checkout" style="width: 150px;"><select
			class="form-control" name="acceptableNo" id="select">
			<option value="1">게스트 1명</option>
			<option value="2">게스트 2명</option>
			<option value="3">게스트 3명</option>
			<option value="4">게스트 4명</option>
			<option value="5">게스트 5명</option>
		</select>
			<button type="submit" class="btn btn-default">검색</button>
			</form>
	</div>
</div>
<div class="section">
	<div class="container">
			<form id="filterForm" action="selectInnByCheckedAmenity.do">	
				<input type="checkbox" name="amenityWiFi" value="Y">WiFi <input
					type="checkbox" name="amenityBed" value="Y">Bed <input
					type="checkbox" name="amenityTV" value="Y">TV <input
					type="checkbox" name="amenityKitchen" value="Y">주방 <input
					type="checkbox" name="amenityBBQ" value="Y">바베큐
					<input type="hidden" name="firstSearchCity" value="${requestScope.searchVO.innCity }">
					<input type="hidden" name="firstSearchStartDate" value="${requestScope.searchVO.startDate }">
					<input type="hidden" name="firstSearchEndDate" value="${requestScope.searchVO.endDate }">
					<input type="hidden" name="firstSearchPeopleNo" value="${requestScope.searchVO.acceptableNo }">
			</form>
	</div>
</div>
<br>
<br>
<br>
<br>
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
							<tr>
								<td><div id="showInnNo"></div></td>
								<td><div id="showInnName"></div></td>
								<td><div id="showInnCity"></div></td>
								<td><div id="showInnArea"></div></td>
								<td><div id="showInnInfo"></div></td>
								<td><div id="showInnType"></div></td>
								<td><div id="showInnAcceptable"></div></td>
								<td><div id="showInnPrice"></div></td>
							</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="list" items="${requestScope.list}">
							<tr>
								<td>${list.innNo }</td>
								<td>${list.innName }</td>
								<td>${list.innCity }</td>
								<td>${list.innArea }</td>
								<td>${list.innAddress }</td>
								<td>${list.innType }</td>
								<td>${list.acceptableNo }</td>
								<td>${list.innPrice }</td>
							</tr>
						</c:forEach>
							<tr>
								<td><div id="showInnNo"></div></td>
								<td><div id="showInnName"></div></td>
								<td><div id="showInnCity"></div></td>
								<td><div id="showInnArea"></div></td>
								<td><div id="showInnInfo"></div></td>
								<td><div id="showInnType"></div></td>
								<td><div id="showInnAcceptable"></div></td>
								<td><div id="showInnPrice"></div></td>
							</tr>
					</c:otherwise>
					</c:choose>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

