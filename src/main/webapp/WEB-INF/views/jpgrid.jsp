<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="./resources/grid/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="./resources/grid/js/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="./resources/grid/js/jquery.jqGrid.src.js"></script>

<link rel="stylesheet" type="text/css" media="screen" href="./resources/grid/css/jquery-ui-1.10.4.custom.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="./resources/grid/css/ui.jqgrid.css">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jqGrid</title>
</head>
<body>
	<table id="jqGrid"></table>
	<div id="pager"></div>
	
	<script type="text/javascript">
	
	$(document).ready(function() {
		$('#jqGrid').jqGrid({
			url : 'getJson',
			datatype : 'json',
			mtype : 'post',
			jsonReader : {
				id : 'id',
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
				}],
			rowNum : 10,
			pager : '#pager'
		});	
	});
	
	</script>
</body>
</html>