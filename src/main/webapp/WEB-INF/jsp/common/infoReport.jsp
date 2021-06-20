<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
<title>訊息顯示</title>
<script type="text/javascript">
</script>
</head>
<body id="body">
	<div id="wrapper">
		<div id="page-content-wrapper" style="padding: 0px;">
			<div class="panel panel-warning">
				<div class="panel-heading">
	  				提示訊息:
				</div>
	  			<div class="panel-body">
	  				${fn:escapeXml(message)}
				</div>
			</div>
			<p><a href="${pageContext.request.contextPath}">返回首頁</a></p>	
		</div>
	</div>
</body>
</html>