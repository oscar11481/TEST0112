<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-tw">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Landing Page - Start Bootstrap Theme</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" type="text/css" />
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-light bg-light static-top">
            <div class="container">
                <a class="navbar-brand" href="index_Login.jsp">回首頁</a>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container position-relative">
                <div class="row justify-content-center">
                    <div class="col-xl-8">
                        <div class="text-center text-white">
                            <!-- Page heading-->
                            <h1 class="mb-5">親愛的客戶您好</h1>
                            <h3 class="mb-5">感謝您使用本系統，請填寫保單資料</h3>
                            <div class="text-left text-white">
                            <form action="${pageContext.request.contextPath}/NCCU110W/addInsurance.do" method="post">
                                保　戶　姓　名 ：<input type = "text" id = "name" name = "name"/><br>
	                            <h6></h6>
                                聯　繫　地　址 ：<input type = "text" id = "address" name = "address"/><br>
                                <h6></h6>
	                            撥/扣款帳戶密碼：<input type = "text" id = "privateKey" name = "privateKey"/><br>(實驗性質，實務上不會要求用戶輸入)
                                <div class="panel-heading text-left">醫療保險類型:
		                            <div class="panel-body">
			                        <label class="radio-inline">
				                    <input id="normalDeploy" type="radio" name="rdoMode" value="normal" checked="checked">防疫​保單(預設)
				                    <br>
				                    (投保金額為1ETH，理賠金額為住院天數*住院金額，例如住院1天，為20ETH)
			                        </label>
			                        <br>
			                        <label class="radio-inline">
				                    <input id="urgentDeploy" type="radio" name="rdoMode" value="urgent" disabled>醫療保單-住院(開發中)
			                        </label>
			                        <br>
			                        <label class="radio-inline">
				                    <input id="urgentDeploy" type="radio" name="rdoMode" value="urgent" disabled>醫療保單-手術(開發中)
			                        </label>							
		                            </div>		
	                            </div>
                                <div  style="text-align:center">      
                                <input class="btn btn-primary" type ="submit" value="提交"/>
                                <br> 
                                貼心提醒：理賠金額及繳納金額單位ETH，投保前請先確認帳戶餘額，避免影響您的權益!
                                </div>
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- Icons Grid-->
        
        <!-- Image Showcases-->
        
        <!-- Testimonials-->
        
        <!-- Call to Action-->
       
        <!-- Footer-->
        <footer class="footer bg-light">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 h-100 text-center text-lg-start my-auto">
                        <ul class="list-inline mb-2">
                            <li class="list-inline-item"><a href="#!">About</a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a href="#!">Contact</a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a href="#!">Terms of Use</a></li>
                            <li class="list-inline-item">⋅</li>
                            <li class="list-inline-item"><a href="#!">Privacy Policy</a></li>
                        </ul>
                        <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2021. All Rights Reserved.</p>
                    </div>
                    <div class="col-lg-6 h-100 text-center text-lg-end my-auto">
                        <ul class="list-inline mb-0">
                            <li class="list-inline-item me-4">
                                <a href="#!"><i class="bi-facebook fs-3"></i></a>
                            </li>
                            <li class="list-inline-item me-4">
                                <a href="#!"><i class="bi-twitter fs-3"></i></a>
                            </li>
                            <li class="list-inline-item">
                                <a href="#!"><i class="bi-instagram fs-3"></i></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
