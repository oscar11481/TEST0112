<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NCCU120W</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/NCCU120W/deployInsuranceContract.do" method="post">
	XX保險公司您好，歡迎使用本系統，請確認是否將合約上鏈<br>
	<div class="panel-heading">本次醫療保險類型:
		<div class="panel-body">
			<label class="radio-inline">
				<input id="normalDeploy" type="radio" name="rdoMode" value="normal" checked="checked">防疫​保單(預設)
				<br>
				(投保金額為1ETH，理賠金額為10ETH)
			</label>
			<br>
			<label class="radio-inline">
				<input id="urgentDeploy" type="radio" name="rdoMode" value="urgent" disabled>醫療保單(住院)
			</label>
			<br>
			<label class="radio-inline">
				<input id="urgentDeploy" type="radio" name="rdoMode" value="urgent" disabled>醫療保單(手術)
			</label>							
		</div>		
	</div>		
	<input type ="submit" value="確認部署合約"/>
	<br>
</form>

<p><a href="${pageContext.request.contextPath}">返回</a></p>

</body>
</html>