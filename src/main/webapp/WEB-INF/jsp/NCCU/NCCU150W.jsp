<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NCCU150W</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/NCCU150W/setHospitalEOA.do" method="post">
	XX保險公司您好，歡迎使用本系統，設置醫療院所EOA<br>
	醫療院所：<input type = "text" id = "EOA" name = "EOA"/><br>
	<div class="panel-heading">設置本智能合約適用之醫療院所帳號，請勿輸入private key:
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
	<input type ="submit" value="確認設置完成"/>
	<br>
</form>

<p><a href="${pageContext.request.contextPath}">返回</a></p>

</body>
</html>