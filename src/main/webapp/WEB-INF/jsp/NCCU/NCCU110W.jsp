<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NCCU110W</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/NCCU110W/deployInsuranceContract.do">醫療保險合約上鏈(記得輸入private key)</a></p>
<form action="${pageContext.request.contextPath}/TEST0112F1/addReqForm.do" method="post">
	name<input type = "text" id = "name" name = "name"/><br>
	age<input type = "text" id = "age" name = "age"/><br>
	<input type ="submit" value="提交"/>
</form>

<p><a href="${pageContext.request.contextPath}">返回首頁</a></p>

</body>
</html>