<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!doctype html>
<html class="no-js" lang="zxx">
<head>
   <meta charset="utf-8">
   <meta http-equiv="x-ua-compatible" content="ie=edge">
   <title>Oction - NFT Marketplace HTML Template</title>
   <meta name="description" content="">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="theme-style-mode" content="1">

   <!-- Place favicon.ico in the root directory -->
   <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/static/security/assets/img/favicon.png">
   <!-- CSS here -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/preloader.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/bootstrap.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/meanmenu.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/animate.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/owl.carousel.min.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/swiper-bundle.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/backToTop.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/magnific-popup.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/nice-select.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/fontAwesome5Pro.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/flaticon.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/default.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/static/security/assets/css/style.css">
</head>

<body class="body-bg">
   <!--[if lte IE 9]>
      <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
      <![endif]-->

   <!-- Add your site or application content here -->
   <main>
      <!-- header area start  -->
      <header class="header1">
         <div id="header-sticky" class="header-main header-main1">
            <div class="container header-container">
               <div class="row align-items-center">
                  <div class="col-xl-2 col-lg-2 col-md-4 col-4">
                     <div class="header-main-left">
                        <div class="header-logo header1-logo">
                           <a href="index.html" class="logo-bb"><img src="${pageContext.request.contextPath}/static/security/assets/img/logo/oction-logo.png"
                                 alt="logo-img"></a>
                           <a href="index.html" class="logo-bw"><img src="${pageContext.request.contextPath}/static/security/assets/img/logo/oction-logo-bw.png"
                                 alt="logo-img"></a>
                        </div>
                     </div>
                  </div>
                  <div class="col-xl-10 col-lg-10 col-md-8 col-8">
                     <div class="header-main-right">
                        <div class="main-menu main-menu1 d-none d-lg-block">
                           <nav id="mobile-menu">
                              <ul>
                                 <li class="menu-item-has-children"><a href="index.html">خانه</a>
                                    <ul class="sub-menu">
                                       <li><a href="${pageContext.request.contextPath}/">خانه 1</a></li>
                                       <li><a href="index-2.html">خانه 2</a></li>
                                       <li><a href="index-3.html">خانه 3</a></li>
                                    </ul>
                                 </li>
                                 <li><a href="explore-arts.html">نمایشگاه</a></li>
                                 <li><a href="creators.html">طراحان</a></li>
                                 <li class="menu-item-has-children"><a href="#">برگه ها</a>
                                    <ul class="sub-menu">
                                       <li class="menu-item-has-children"><a href="creator-profile.html">طراح</a>
                                          <ul class="sub-menu">
                                             <li><a href="creator-profile.html">پروفایل طراح</a></li>
                                             <li><a href="creator-profile-info-personal.html">اطلاعات شخصی طراح</a>
                                             </li>
                                          </ul>
                                       </li>
                                       <li class="menu-item-has-children"><a href="art-details.html">طرح</a>
                                          <ul class="sub-menu">
                                             <li><a href="art-details.html">جزئیات طرح</a></li>
                                             <li><a href="upload-category.html">بارگذاری دسته ای</a></li>
                                             <li><a href="upload.html">بارگذاری طرح</a></li>
                                          </ul>
                                       </li>
                                       <li><a href="faq.html">سوالات متداول</a></li>
                                       <li><a href="register.jsp">ثبت نام</a></li>
                                       <li><a href="login.jsp">ورود</a></li>
                                       <li><a href="terms.html">قوانین</a></li>
                                       <li><a href="wallet-connect.html">کیف پول</a></li>
                                       <li><a href="activity.html">تاریخچه فعالیت</a></li>
                                       <li><a href="art-ranking.html">امتیاز</a></li>
                                       <li><a href="error-404.html">برگه 404</a></li>
                                    </ul>
                                 </li>
                                 <li><a href="forum.html">انجمن</a></li>
                                 <li><a href="contact.html">تماس با ما</a>
                                 </li>
                              </ul>
                           </nav>
                        </div>
                        <form action="#" class="filter-search-input header-search d-none d-xl-inline-block">
                           <input type="text" placeholder="عبارت مورد نظر">
                           <button><i class="fal fa-search"></i></button>
                        </form>
                        <div class="header-btn ml-20 d-none d-xxl-inline-block">
                           <a href="wallet-connect.html" class="fill-btn">کیف پول</a>
                        </div>
                        <div class="profile-item profile-item-header ml-20 d-none d-md-inline-block pos-rel">
                           <div class="profile-img pos-rel">
                              <div class="profile-action">
                                 <ul>
                                    <li><a href="creator-profile-info-personal.html"><i
                                             class="fal fa-user"></i>پروفایل</a>
                                    </li>
                                    <li><a href="login.jsp"><i class="fal fa-sign-out"></i>خروج</a></li>
                                 </ul>
                              </div>
                              <img src="${pageContext.request.contextPath}/static/security/assets/img/profile/profile4.jpg" alt="profile-img">
                              <div class="profile-verification verified">
                                 <i class="fas fa-check"></i>
                              </div>
                           </div>
                        </div>
                        <div class="menu-bar d-xl-none ml-20">
                           <a class="side-toggle" href="javascript:void(0)">
                              <div class="bar-icon">
                                 <span></span>
                                 <span></span>
                                 <span></span>
                              </div>
                           </a>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </header>
      <!-- header area end -->

      <!-- side toggle start -->
      <div class="fix">
         <div class="side-info">
            <div class="side-info-content">
               <div class="offset-widget offset-logo mb-40">
                  <div class="row align-items-center">
                     <div class="col-9">
                        <a href="index.html">
                           <img src="${pageContext.request.contextPath}/static/security/assets/img/logo/oction-logo-bw.png" alt="Logo">
                        </a>
                     </div>
                     <div class="col-3 text-end"><button class="side-info-close"><i class="fal fa-times"></i></button>
                     </div>
                  </div>
               </div>
               <div class="mobile-menu d-lg-none fix"></div>
               <div class="offset-profile-action d-md-none">
                  <div class="offset-widget mb-40">
                     <div class="profile-item profile-item-header into-sidebar d-md-none">
                        <div class="profile-img pos-rel">
                           <div class="profile-action">
                              <ul>
                                 <li><a href="creator-profile-info-personal.html"><i class="fal fa-user"></i>پروفایل</a>
                                 </li>
                                 <li><a href="login.jsp"><i class="fal fa-sign-out"></i>خروج</a></li>
                              </ul>
                           </div>
                           <img src="${pageContext.request.contextPath}/static/security/assets/img/profile/profile4.jpg" alt="profile-img">
                           <div class="profile-verification verified">
                              <i class="fas fa-check"></i>
                           </div>
                        </div>
                     </div>
                  </div>

               </div>
               <div class="offset-widget offset_searchbar mb-30">
                  <form action="#" class="filter-search-input">
                     <input type="text" placeholder="عبارت مورد نظر">
                     <button><i class="fal fa-search"></i></button>
                  </form>
               </div>
               <div class="offset-widget mb-40">
                  <a href="upload-category.html" class="fill-btn">بارگذاری طرح</a>
               </div>
               <div class="offset-widget mb-40 d-none d-lg-block">
                  <div class="info-widget">
                     <h4 class="offset-title mb-20 d-none">اطلاعات تماس</h4>
                     <p class="mb-30">توکن‌های غیرقابل تعویض و قراردادهای هوشمند آن‌ها، ویژگی‌های دقیق را امکان‌پذیر می‌کنند
                         اضافه شده، مانند هویت مالک،
                         ابرداده غنی یا پیوندهای فایل امن.</p>
                     <a href="contact.html" class="fill-btn">تماس با ما</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <div class="offcanvas-overlay"></div>
      <div class="offcanvas-overlay-white"></div>
      <!-- side toggle end -->

      <!-- page-title area start -->
      <section class="page-title-area">
         <div class="container">
            <div class="row wow fadeInUp">
               <div class="col-lg-12">
                  <div class="page-title">
                     <h2 class="breadcrumb-title mb-10">ورود</h2>
                     <div class="breadcrumb-menu">
                        <nav class="breadcrumb-trail breadcrumbs">
                           <ul class="trail-items">
                              <li class="trail-item trail-begin"><a href="index.html">خانه</a>
                              </li>
                              <li class="trail-item trail-end"><span>ورود</span></li>
                           </ul>
                        </nav>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- page-title area end -->

      <!-- login area start  -->
      <section class="login-area pt-130 pb-90" data-background="${pageContext.request.contextPath}/static/security/assets/img/bg/sign-up-bg.jpg">
         <div class="container">
            <div class="row justify-content-center">
               <div class="col-xxl-6 col-xl-7 col-lg-8">
                  <div class="login-wrapper pos-rel mb-40 wow fadeInUp">
                     <div class=" login-inner">
                        <div class="login-content">
                           <h4>ورود به حساب کاربری</h4>

<%--                           <form class="login-form" action="#">--%>
                           <form method="POST" action="${contextPath}/login" class="form-signin">
                           <div class="row">
<%--                                 <div class="col-md-12">--%>
<%--                                    <div class="single-input-unit">--%>
<%--                                       <label for="m-id">ایمیل</label>--%>
<%--                                       <input type="email" name="m-id" id="m-id" placeholder="ایمیل">--%>
<%--                                    </div>--%>
<%--                                 </div>--%>
                                 <div class="col-md-6">
                                    <div class="single-input-unit">
                                       <label for="u-name">نام کاربری</label>
<%--                                       <input type="text" name="u-name" id="u-name" placeholder="نام کاربری">--%>
                                       <input type="text" name="username" id="u-name" placeholder="نام کاربری" autofocus="true">
                                    </div>
                                 </div>
                                 <div class="col-md-6">
                                    <div class="single-input-unit">
                                       <label for="password">گذرواژه</label>
                                       <input type="password" name="password" id="password" placeholder="********">
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                 </div>
                              </div>
                              <div class="login-btn">
                                 <button class="fill-btn" type="submit">ورود</button>
<%--                                 <div class="note">حساب کاربری ندارید؟  <a href="register.jsp" class="text-btn">ثبت نام</a>--%>
                                 <div class="note">حساب کاربری ندارید؟  <a href="${pageContext.request.contextPath}/registration" class="text-btn">ثبت نام</a>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <!-- login area end  -->

   </main>

   <!-- footer area start  -->
   <footer data-background="" class="footer1-bg">
      <section class="footer-area footer-area1 footer-area1-bg pt-100 pb-50">
         <div class="container">
            <div class="row">
               <div class="col-lg-3 col-md-6">
                  <div class="footer-widget footer1-widget footer1-widget1 mb-40">
                     <div class="footer-logo mb-30">
                        <a href="index.html" class="logo-bb"><img src="${pageContext.request.contextPath}/static/security/assets/img/logo/oction-logo.png"
                              alt="logo-img"></a>
                        <a href="index.html" class="logo-bw"><img src="${pageContext.request.contextPath}/static/security/assets/img/logo/oction-logo-bw.png"
                              alt="logo-img"></a>
                     </div>
                     <p class="mb-35">لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ، و با استفاده از طراحان گرافیک است، چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است</p>
                     <div class="social__links footer__social">
                        <ul>
                           <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                           <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                           <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                           <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                        </ul>
                     </div>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6">
                  <div class="footer-widget footer1-widget footer1-widget2 mb-40">
                     <div class="footer-widget-title">
                        <h4>بازار</h4>
                     </div>
                     <ul>
                        <li><a href="#">دستورالعمل ها</a></li>
                        <li><a href="#">خرید محصولات</a></li>
                        <li><a href="#">مقایسه کنید</a></li>
                        <li><a href="#">همکاری</a></li>
                        <li><a href="#">تجارت الکترونیک</a></li>
                     </ul>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6">
                  <div class="footer-widget footer1-widget footer1-widget3 mb-40 ">
                     <div class="footer-widget-title">
                        <h4>آثار هنری</h4>
                     </div>
                     <ul>
                        <li><a href="#">سه بعدی</a></li>
                        <li><a href="#">عکاسی</a></li>
                        <li><a href="#">تصویر تخت</a></li>
                        <li><a href="#">چاپ</a></li>
                        <li><a href="#">ویدئو</a></li>
                     </ul>
                  </div>
               </div>
               <div class="col-lg-3 col-md-6">
                  <div class="footer-widget footer1-widget footer1-widget4 mb-40 ">
                     <div class="footer-widget-title">
                        <h4>جامعه بینش</h4>
                     </div>
                     <ul>
                        <li><a href="#">شرکای تجاری</a></li>
                        <li><a href="#">انجمن</a></li>
                        <li><a href="#">دهکده جهانی</a></li>
                        <li><a href="#">گفتمان</a></li>
                        <li><a href="#">دارایی های برند</a></li>
                     </ul>
                  </div>
               </div>
            </div>
         </div>
      </section>
      <div class="copyright-area copyright1-area">
         <div class="container">
            <div class="copyright1-inner">
               <div class="row align-items-center">
                  <div class="col-lg-3 col-md-6">
                     <div class="copyright-text copyright1-text">
                        © طراحی و توسعه
                        <a href="#">تیم تِک</a>
                     </div>
                  </div>
                  <div class="col-lg-4 col-md-6">
                     <div class="irc-item copyright-support copyright1-support copyright-support-lines">
                        <div class="irc-item-icon">
                           <i class="flaticon-support"></i>
                        </div>
                        <div class="irc-item-content">
                           <p>پشتیبانی 24/7</p>
                           <a href="tel:02122334455">02122334455</a>
                        </div>
                     </div>
                  </div>
                  <div class="col-lg-5 col-md-12">
                     <form class="subscribe-form subscribe-form-copyright1">
                        <input type="text" placeholder="ایمیل معتبر وارد کنید">
                        <button type="submit">عضویت<i class="fas fa-paper-plane"></i></button>
                     </form>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </footer>
   <!-- footer area end  -->


   <!-- pre loader area start -->
   <div id="loading">
      <div id="loading-center">
         <div id="loading-center-absolute">
            <div class="loading-icon text-center d-flex flex-column align-items-center justify-content-center">
               <img src="${pageContext.request.contextPath}/static/security/assets/img/logo/logo-text.png" alt="logo-img">
               <img class="loading-logo" src="${pageContext.request.contextPath}/static/security/assets/img/logo/preloader.svg" alt="">
            </div>
         </div>
      </div>
   </div>
   <!-- pre loader area end -->

   <!-- back to top start -->
   <div class="progress-wrap">
      <svg class="progress-circle svg-content" width="100%" height="100%" viewBox="-1 -1 102 102">
         <path d="M50,1 a49,49 0 0,1 0,98 a49,49 0 0,1 0,-98" />
      </svg>
   </div>
   <!-- back to top end -->

   <!-- dark mode button start -->
   <div class="mode-switch-wrapper my_switcher setting-option">
      <input type="checkbox" class="checkbox" id="chk" />
      <label class="label" for="chk">
         <i class="fas fa-moon setColor dark theme__switcher-btn" data-theme="dark"></i>
         <i class="fas fa-sun setColor light theme__switcher-btn" data-theme="light"></i>
         <span class="ball"></span>
      </label>
   </div>
   <!-- dark mode button end  -->


   <!-- JS here -->
   <script src="${pageContext.request.contextPath}/static/security/assets/js/vendor/jquery-3.6.0.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/vendor/waypoints.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/bootstrap.bundle.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/meanmenu.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/swiper-bundle.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/owl.carousel.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/magnific-popup.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/parallax.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/backToTop.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/cookie.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/style-switcher.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/nice-select.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/parallax.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/counterup.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/jquery.countdown.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/ajax-form.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/wow.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/isotope.pkgd.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/imagesloaded.pkgd.min.js"></script>
   <script src="${pageContext.request.contextPath}/static/security/assets/js/main.js"></script>
</body>
</html>