<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NCCU140W</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/NCCU140W/insRecord.do" method="post">
	XX醫療院所您好，感謝您使用本系統，請登載病患病歷資料<br>
	病患帳戶：<input type = "text" id = "EOA" name = "EOA"/>(實驗性質，實務上應為病患姓名)<br>
	病患情況：<input type = "text" id = "symptom" name = "symptom"/><br>
	事由：<input type = "text" id = "cause" name = "cause"/><br>
	住院天數：<input type = "text" id = "day" name = "day"/><br>
	PrivateKey：<input type = "text" id = "privateKey" name = "privateKey"/>(實驗性質，實務上不會要求醫療院所輸入)<br>	
	<input type ="submit" value="提交病歷"/>
	<br>
	貼心提醒：本功能為維護病患隱私，本功能限制醫療院所使用
</form>

<p><a href="${pageContext.request.contextPath}">返回首頁</a></p>

</body>
</html>