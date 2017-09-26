<%@ page import="com.model.Content" %>
<%@ page import="com.model.User" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>zh博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Free HTML5 Template by FREEHTML5" />
    <meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
    <!-- Facebook and Twitter integration -->
    <meta property="og:title" content=""/>
    <meta property="og:image" content=""/>
    <meta property="og:url" content=""/>
    <meta property="og:site_name" content=""/>
    <meta property="og:description" content=""/>
    <meta name="twitter:title" content="" />
    <meta name="twitter:image" content="" />
    <meta name="twitter:url" content="" />
    <meta name="twitter:card" content="" />

    <!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
    <link rel="shortcut icon" href="favicon.ico">
    <!-- Google Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Playfair+Display:400,700,400italic|Roboto:400,300,700' rel='stylesheet' type='text/css'>
    <!-- Animate -->
    <link rel="stylesheet" href="/static/css/animate.css">
    <!-- Icomoon -->
    <link rel="stylesheet" href="/static/css/icomoon.css">
    <!-- Bootstrap  -->
    <link rel="stylesheet" href="/static/css/bootstrap.css">

    <link rel="stylesheet" href="/static/css/style.css">
    <!-- Modernizr JS -->
    <script src="/static/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body style="background-color: antiquewhite">
<!-- 左侧个人信息 -->
<div id="fh5co-offcanvas">
    <a href="#" class="fh5co-close-offcanvas js-fh5co-close-offcanvas"><span><i
            class="icon-cross3"></i> <span>Close</span></span></a>
    <!-- 个人信息栏 -->
    <div class="fh5co-bio" id="personmes">
        <figure>
            <img src="/images/person1.jpg" alt="Free HTML5 Bootstrap Template" class="img-responsive">
        </figure>
        <h3 class="heading">个人信息</h3>
        <h2><%=((User)request.getSession().getAttribute("currentUser")).getUsername()%></h2>
        <p>&ldquo;已经走到尽头的东西，重生也不过是再一次的消亡。就像所有的开始，其实都只是一个写好了的结局。 &rdquo;</p>
        <ul class="fh5co-social">
            <li title="分享到twitter"><a href="#"><i class="icon-twitter"></i></a></li>
            <li title="分享到facebook"><a href="#"><i class="icon-facebook"></i></a></li>
            <li title="分享到instagram"><a href="#"><i class="icon-instagram"></i></a></li>
        </ul>
    </div>
    <!-- 博客类型搜索 -->
    <div class="fh5co-menu">
        <div class="fh5co-box">
            <h3 class="heading">个人博客类型</h3>
            <ul>
                <li><a href="#">C++</a></li>
                <li><a href="#">JAVA</a></li>
                <li><a href="#">WEB</a></li>
                <li><a href="#">Node &amp; Vue</a></li>
                <li><a href="#">Spring</a></li>
            </ul>
        </div>
        <div class="fh5co-box">
            <h3 class="heading">Search</h3>
            <form action="#">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Type a keyword">
                </div>
            </form>
        </div>
    </div>
</div>

<!-- 头部 -->
<header id="fh5co-header">
    <div class="container-fluid">
        <div class="row">
            <a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
            <ul class="fh5co-social">
                <li title="新建博客"><a href="/newblog"><i class="icon-pencil"></i></a></li>
                <li title="分享到twitter"><a href="#"><i class="icon-twitter"></i></a></li>
                <li title="分享到facebook"><a href="#"><i class="icon-facebook"></i></a></li>
                <li title="分享到instagram"><a href="#"><i class="icon-instagram"></i></a></li>
            </ul>
            <div class="col-lg-12 col-md-12 text-center">
                <h1 id="fh5co-logo"><a href="/seeBlog">博客详情 <sup>ZH</sup></a></h1>
            </div>
        </div>
    </div>
</header>
<% Content content = (Content) request.getAttribute("content");%>
<%Map<String,String> sortMap = (Map<String, String>) request.getAttribute("sort");%>
<a href="/blogContent?id=<%=sortMap.get("pre")%>" class="fh5co-post-prev"><span><i class="icon-chevron-left"></i> Prev</span></a>
<a href="/blogContent?id=<%=sortMap.get("next")%>" class="fh5co-post-next"><span>Next <i class="icon-chevron-right"></i></span></a>
<!-- END #fh5co-header -->
<div class="container-fluid">
    <div class="row fh5co-post-entry single-entry">
        <article class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-8 col-sm-offset-2 col-xs-12 col-xs-offset-0">
            <!-- 标题部分 -->
            <%--<figure class="animate-box">--%>
                <%--<img src="<%=content.getCoverUrl()%>" alt="Image" class="img-responsive">--%>
            <%--</figure>--%>
            <%--<span class="fh5co-meta animate-box"><a href="single.html"><%=content.getType()%></a></span>--%>
            <%--<h2 class="fh5co-article-title animate-box"><a href="single.html"><%=content.getTitle()%></a></h2>--%>
            <!-- 内容部分 -->
            <div class="col-lg-12 col-lg-offset-0 col-md-12 col-md-offset-0 col-sm-12 col-sm-offset-0 col-xs-12 col-xs-offset-0 text-left content-article">
                <!-- 引言-->
                <div class="row rp-b">
                    <div class="col-md-12 animate-box">
                        <blockquote>
                            <p>&ldquo;已经走到尽头的东西，重生也不过是再一次的消亡。就像所有的开始，其实都只是一个写好了的结局。&rdquo; <cite>&mdash; 宫崎骏</cite></p>
                        </blockquote>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 animate-box">
                        <h2 style="text-align: center"><%=content.getTitle()%></h2>
                        <p><%=content.getSlug()%></p>
                        <span class="fh5co-meta fh5co-date animate-box"><%=content.getCreated()%></span>
                    </div>
                    <div class="col-md-4 animate-box">
                        <figure>
                            <img src="<%=content.getCoverUrl()%>" alt="Free HTML5 Bootstrap Template by FREEHTML5.co" class="img-responsive">
                            <figcaption><%=content.getSlug()%></figcaption><!--图片描述-->
                        </figure>
                    </div>
                    <div class="col-md-4 animate-box">
                        <figure>
                            <img src="<%=content.getCoverUrl()%>" alt="Free HTML5 Bootstrap Template by FREEHTML5.co" class="img-responsive">
                            <figcaption><%=content.getSlug()%></figcaption><!--图片描述-->
                        </figure>
                    </div>
                    <div class="col-md-4 animate-box">
                        <figure>
                            <img src="<%=content.getCoverUrl()%>" alt="Free HTML5 Bootstrap Template by FREEHTML5.co" class="img-responsive">
                            <figcaption><%=content.getSlug()%></figcaption><!--图片描述-->
                        </figure>
                    </div>
                    <div class="col-md-12 animate-box">
                        <%=content.getContent()%>
                    </div>
                </div>
            </div>
        </article>
    </div>
</div>

<footer id="fh5co-footer">
    <p>
        <small>&copy; zh博客. <br>学习参考使用</small>
    </p>
</footer>

<!-- jQuery -->
<script src="/static/js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="/static/js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="/static/js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="/static/js/jquery.waypoints.min.js"></script>
<!-- Main JS -->
<script src="/static/js/main.js"></script>

</body>
</html>

