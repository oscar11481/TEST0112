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
                <div class="col-md-8" >
                <a class="navbar-brand" href="index_Login.jsp">回首頁</a>
                </div>
                <div class="col-md-1" >
                <a class="navbar-brand" href="insurer.jsp"><button class="btn btn-primary" href="signup.html" id="button-submit" type="button">監聽區塊鏈</button></a>
                </div>
                <div class="col-md-1" >
                <a class="navbar-brand" href="onchain.jsp"><button class="btn btn-primary" href="signup.html" id="button-submit" type="button">合約上鏈</button></a>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container position-relative">
                <div class="row justify-content-center">
                    <div class="col-xl-8">
                        <div class="text-center text-white">
                            <!-- Page heading-->
                            <form action="${pageContext.request.contextPath}/NCCU150W/setHospitalEOA.do" method="post">
                            <h1 class="mb-5">XX保險公司您好</h1>
                            <h3 class="mb-5">歡迎使用本系統，設置醫療院所EOA</h3>
                            <div class="text-center text-white">
                                醫療院所：<input type = "text" id = "EOA" name = "EOA"/><br>
	                            <div class="panel-heading">設置本智能合約適用之醫療院所帳號，請勿輸入private key
		                            <div class="panel-body">
			                        <label class="radio-inline">
				                    <input id="normalDeploy" type="radio" name="rdoMode" value="normal" checked="checked">防疫​保單(預設)
				                    <br>
				                    (投保金額為1ETH，理賠金額為10ETH)
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
                                <input class="btn btn-primary" type ="submit" value="確認設置完成"/>
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
