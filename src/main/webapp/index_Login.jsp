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
                <a class="navbar-brand " >醫療區塊鏈</a> <!--左上-->
                </div>
                <div class="col-md-2">
                <a id="button-submit" >TEST 歡迎</a><!--右上-->
                <a class="navbar-brand" href="index_.jsp"><button class="btn btn-primary" href="index_.jsp" id="button-submit" type="button">登出</button></a>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead">
            <div class="container position-relative">
                <div class="row justify-content-center">
                    <div class="col-xl-6">
                        <div class="text-center text-white">
                            <!-- Page heading-->
                            <h1 class="mb-5">醫療保險理賠區塊鏈</h1>
                            <h3 class="mb-5">保險理賠免煩惱，無須單據快速核保。</h3>
                            <!-- Signup form-->
                            
                        </div>
                    </div>
                                       
                            <div class="row justify-content-center" ></div>
                                <div class="col-lg-4 text-center" >
                                    <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                                        <a href="person.jsp"><button type="button"><img src="assets/img/pic1.png" alt="..." /> </button></a>
                                        <h3 style="color: seashell;">投保人</h3>
                                        <p class="font-weight-light mb-0" style="color: seashell;">線上投保<br>快速理賠</p>
                                    </div>
                                </div>
                                <div class="col-lg-4 text-center">
                                    <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                                        <a href="insurer.jsp"><button type="button"><img src="assets/img/pic2.png" alt="..." /> </button></a>
                                        <h3 style="color: seashell;">保險公司</h3>
                                        <p class="font-weight-light mb-0" style="color: seashell;">智能合約上鏈</p>
                                    </div>
                                </div>
                                <div class="col-lg-4 text-center">
                                    <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                                        <a href="hospital.jsp"><button type="button"><img src="assets/img/pic3.png" alt="..." /> </button></a>
                                        <h3 style="color: seashell;">醫療院所</h3>
                                        <p class="font-weight-light mb-0" style="color: seashell;">就診記錄上鏈</p>
                                    </div>
                                </div>
                            </div>
                        
                    
                </div>
            </div>
        </header>

        <!-- Image Showcases-->
        <section class="showcase">
            <div class="container-fluid p-0">
                <div class="row g-0">
                    <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('assets/img/bg-showcase-1.jpg')"></div>
                    <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                        <h2>無須擔心紙本單據遺失</h2>
                        <p class="lead mb-0">保險⼈不再需要收集各式醫療單據，透過醫療院所就診記錄上鏈，便能快速核保。</p>
                    </div>
                </div>
                <div class="row g-0">
                    <div class="col-lg-6 text-white showcase-img" style="background-image: url('assets/img/bg-showcase-2.jpg')"></div>
                    <div class="col-lg-6 my-auto showcase-text">
                        <h2>達成條件立即核保</h2>
                        <p class="lead mb-0">透過智能合約，一旦核保條件成立，立刻撥款至您的錢包。</p>
                    </div>
                </div>
                <div class="row g-0">
                    <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('assets/img/bg-showcase-3.jpg')"></div>
                    <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                        <h2>網路投保簡單易用</h2>
                        <p class="lead mb-0">無須再填寫紙本投保單，無須再找保險業務員，網路投保輕鬆方便。</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- Testimonials-->
<!--         <section class="testimonials text-center bg-light">
            <div class="container">
                <h2 class="mb-5">What people are saying...</h2>
                <div class="row">
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="assets/img/testimonials-1.jpg" alt="..." /> 
                            <h5>Margaret E.</h5>
                            <p class="font-weight-light mb-0">"This is fantastic! Thanks so much guys!"</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="assets/img/testimonials-2.jpg" alt="..." />
                            <h5>Fred S.</h5>
                            <p class="font-weight-light mb-0">"Bootstrap is amazing. I've been using it to create lots of super nice landing pages."</p>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                            <img class="img-fluid rounded-circle mb-3" src="assets/img/testimonials-3.jpg" alt="..." />
                            <h5>Sarah W.</h5>
                            <p class="font-weight-light mb-0">"Thanks so much for making these free resources available to us!"</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
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
