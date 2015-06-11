<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#searchBtn").click(function() {
		var checkedAmenity=$("input[name=chk_amenity]:checked").val();
		alert(checkedAmenity);
	});
});
</script>
<div class="section">
    <div class="container">
        <div class="row">
            <form id="searchForm">
                <input type="checkbox" name="chk_amenity" value="wifi">WiFi
                <input type="checkbox" name="chk_amenity" value="bed">Bed
                <input type="checkbox" name="chk_amenity" value="tv">TV
                <input type="checkbox" name="chk_amenity" value="kitchen">주방
                <input type="checkbox" name="chk_amenity" value="bbq">바베큐
                <input type="button" id="searchBtn" value="검색">
            </form>
        </div>
    </div>
</div>