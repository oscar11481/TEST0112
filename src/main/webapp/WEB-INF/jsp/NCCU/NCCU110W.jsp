<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NCCU110W</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/NCCU110W/addInsurance.do" method="post">
	親愛的客戶您好，感謝您使用本系統，請填寫保單資料<br>
	保戶姓名    　　：<input type = "text" id = "name" name = "name"/><br>
	聯繫地址   　　：<input type = "text" id = "address" name = "address"/><br>
	撥款/扣款帳戶密碼：<input type = "text" id = "privateKey" name = "privateKey"/><br>(實驗性質，實務上不會要求用戶輸入)
	<div class="panel-heading">醫療保險類型:
		<div class="panel-body">
			<label class="radio-inline">
				<input id="normalDeploy" type="radio" name="rdoMode" value="normal" checked="checked">防疫​保單(預設)
				<br>
				(投保金額為1ETH，理賠金額為住院天數*住院金額，例如住院1天，為10ETH)
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
	<input type ="submit" value="提交"/>
	<br>
	貼心提醒：理賠金額及繳納金額單位ETH，投保前請先確認帳戶餘額，避免影響您的權益!
</form>

<p><a href="${pageContext.request.contextPath}">返回首頁</a></p>

</body>
</html>