<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html lang="en" class="fullscreen-bg">

<head>
    <title>Login</title>
    <%@include file="WEB-INF/pages/common/include.jsp" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="resources/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/assets/vendor/linearicons/style.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="resources/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="resources/assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="../resources/assetsimg/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="resources/assets/img/favicon.png">
    <script type="text/javascript">
    var user = document.getElementById('username'),
        pass = document.getElementById('password'),
        check = document.getElementById('remember'),
        localUser = localStorage.getItem('user') || ''; //获取到user的值并保存
    localPass = localStorage.getItem('pass') || ''; //获取到pwd的值并保存
    localUser = user.value;
    localPass = pass.value ;
    if (localUser !== '' && localPass !== '') {
        check.setAttribute('checked', '');
    }

    function fn() {
        if (check.checked) {
            localStorage.setItem('user', user.value);
            localStorage.setItem('pass', pass.value);
        } else {
            localStorage.setItem('user', '');
            localStorage.setItem('pass', '');
        }
    }
    </script>

    <body>
        <!-- WRAPPER -->
        <div id="wrapper">
            <div class="vertical-align-wrap">
                <div class="vertical-align-middle">
                    <div class="auth-box ">
                        <div class="left">
                            <div class="content">
                                <div class="header">
                                    <div class="logo text-center"><img src="resources/assets/img/logo.png" alt=" Logo"></div>
                                    <!-- <p class="lead">Login to your account</p> -->
                                </div>
                                <form class="form-auth-small" action="index.html">
                                    <div class="form-group">
                                        <label for="signin-email" class="control-label sr-only">Email</label>
                                        <input type="text" class="form-control" id="username" value="" placeholder="">
                                    </div>
                                    <div class="form-group">
                                        <label for="signin-password" class="control-label sr-only">Password</label>
                                        <input type="password" class="form-control" id="password" value="" placeholder="">
                                    </div>
                                    <div class="form-group clearfix">
                                        <label class="fancy-checkbox element-left">
                                            <input type="checkbox" name="remember" id="remember" onclick="fn()" >
                                            <span>记住我！！！</span>
                                        </label>
                                    </div>
                                    <button type="submit" class="btn btn-primary btn-lg btn-block" >登陆</button>
								<!-- <div class="bottom ">
									<span class="helper-text "><i class="fa fa-lock "></i> <a href="# ">Forgot password?</a></span>
								</div> -->
							</form>
						</div>
					</div>
					<div class="right ">
						<div class="overlay "></div>
						<div class="content text ">
							<h1 class="heading "></h1>
							<p></p>
						</div>
					</div>
					<div class="clearfix "></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>

</html>
