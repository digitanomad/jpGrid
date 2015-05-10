<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="./resources/grid/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="./resources/grid/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="./resources/grid/js/jquery.jqGrid.src.js"></script>
<script type="text/javascript" src="./resources/js/jquery.form.js"></script>

<link rel="stylesheet" type="text/css" media="screen" href="./resources/grid/css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="./resources/grid/css/ui.jqgrid.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jqGrid</title>
</head>
<body>
	<table id="jqGrid"></table>
	<div id="pager"></div>
	<br><br>
	<h3><a href="downloadExcel">엑셀 파일로 다운로드</a></h3>
	<form id="excelUpForm"  method="post" enctype="multipart/form-data">
		<input id="excelUploadFile" type="file" name="excelUploadFile" />
		<button type="button" id="excelUpload" onclick="check()">엑셀 파일로 업로드</button>
	</form>
	
	
	<script type="text/javascript">
	var jqGrid;
	$(document).ready(function() {
		drawJqGrid();
	});
	
	function drawJqGrid() {
		jqGrid = $('#jqGrid').jqGrid({
			url : 'getJson',
			datatype : 'json',
			mtype : 'post',
			jsonReader : {
				root : 'data',
				repeatitems : false
			},
			colModel : [
				{
					label : 'ID',
					name : 'id'
				}, 
				{
					label : '이름',
					name : 'name'
				},
				{
					label : '회사',
					name : 'company'
				},
				{
					label : '시작일',
					name : 'startdate'
				},
				{
					label : '카드번호',
					name : 'cardnum'
				}],
				
			rowNum : 20,
			loadonce : true,
			pager : '#pager'
		});	
	}
	
	function checkFileType(filePath) {
		var fileFormat = filePath.split(".");
		if (fileFormat.indexOf("xls") > -1) {
			return true;
		} else {
			return false;
		}
	}
	
	function check() {
		var file = $("#excelUploadFile").val();
		if (file == "" || file == null) {
			alert("파일을 선택해주세요.");
			return false;
		} else if (!checkFileType(file)) {
			alert("엑셀 파일만 업로드 해주세요.");
			return false;
		}
		
		if (confirm("업로드 하시겠습니까?")) {
			$('#excelUpForm').attr("action", "uploadExcel");
			var options = {
					success : function(data) {
						alert("모든 데이터가 업로드 되었습니다.");
					},
					type : "post",
			};
			$('#excelUpForm').ajaxSubmit(options);
		}
	}
	
	</script>
</body>
</html>