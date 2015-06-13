<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	$(function() {
		$("#checkin, #checkout").datepicker({
			dateFormat : 'yy-mm-dd'
		});
		$("#searchForm").submit(function(){
			if($("#innCity").val()==""){
				alert("지역을 입력해주세요!");
				return false;
			}
		});
	});
</script>
<img id="img1" src="${initParam.root}img/house.jpg" style="position: relative; top: 80px; left: 330px;">

<div style="position: relative; top: 150px; left: 230px; opacity: 0.7">
	<form action="searchByCityDateNo.do" id="searchForm" class="navbar-form navbar-left" role="search">
		<input type="text" class="form-control" name="innCity" id="innCity" placeholder="State"> <input
			type="text" class="form-control" name="startDate" id="checkin" size="15"
			onfocus="this.value=''" placeholder="Checkin"> <input type="text"
			class="form-control" name="endDate" size="15" id="checkout"
			onfocus="this.value=''" placeholder="Checkout"> <select
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
