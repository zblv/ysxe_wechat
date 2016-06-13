<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>银盛小贷 - 微信服务号管理 - 登录</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
<meta name="Keywords" content="#">
<meta name="Description" content="#">
<!-- Mobile Devices Support @begin -->
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta content="no-cache,must-revalidate" http-equiv="Cache-Control">
<meta content="no-cache" http-equiv="pragma">
<meta content="0" http-equiv="expires">
<meta content="telephone=no, address=no" name="format-detection">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta name="apple-mobile-web-app-capable" content="yes"> <!-- apple devices fullscreen -->
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
    <!--[if lt IE 9]>
    <script src='assets/javascripts/html5shiv.js' type='text/javascript'></script>
    <![endif]-->
    <link href='assets/stylesheets/bootstrap/bootstrap.css' media='all' rel='stylesheet' type='text/css' />
    <link href='assets/stylesheets/bootstrap/bootstrap-responsive.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / jquery ui -->
    <link href='assets/stylesheets/jquery_ui/jquery-ui-1.10.0.custom.css' media='all' rel='stylesheet' type='text/css' />
    <link href='assets/stylesheets/jquery_ui/jquery.ui.1.10.0.ie.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / select2 -->
    <link href='assets/stylesheets/plugins/select2/select2.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / flatty theme -->
    <link href='assets/stylesheets/light-theme.css' id='color-settings-body-color' media='all' rel='stylesheet' type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	if (window != top){
		top.location.href = location.href; 
	} 
</script>
</head>
<body class='contrast-red sign-in contrast-background'>
<div id='wrapper'>
    <div class='application'>
        <div class='application-content'>
            <a href="javascript:void(0);"><div class='icon-heart'></div>
                <span>银盛小贷 </span>
            </a>
        </div>
    </div>
    <div class='controls'>
        <div class='caret'></div>
        <div class='form-wrapper'>
            <h1 class='text-center'>登录</h1>
            <form accept-charset="UTF-8" action="dls/user/userlogin" method="post" id="loginform"/><div style="margin:0;padding:0;display:inline"><input name="utf8" type="hidden" value="&#x2713;" /></div>
                <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
                        <input class="span12" id="userName" name="userName" placeholder="账户" type="text" value="" />
                        <i class='icon-user muted'></i>
                    </div>
                </div>
                <div class='row-fluid'>
                    <div class='span12 icon-over-input'>
                        <input class="span12" id="password" name="password" placeholder="密码" type="password" value="" />
                        <i class='icon-lock muted'></i>
                    </div>
                </div>
                    
                <button class="btn btn-block" name="button" type="button" id="btnlogin">登录</button>
            </form>
        </div>
    </div>
</div>

<!-- / jquery -->
<script src='assets/javascripts/jquery/jquery.min.js' type='text/javascript'></script>
<!-- / jquery mobile events (for touch and slide) -->
<script src='assets/javascripts/plugins/mobile_events/jquery.mobile-events.min.js' type='text/javascript'></script>
<!-- / jquery migrate (for compatibility with new jquery) -->
<script src='assets/javascripts/jquery/jquery-migrate.min.js' type='text/javascript'></script>
<!-- / select2 -->
<script src='assets/javascripts/plugins/select2/select2.js' type='text/javascript'></script>
<script src='assets/javascripts/plugins/modernizr/modernizr.min.js' type='text/javascript'></script>
<script src='assets/javascripts/nav.js' type='text/javascript'></script>
<script src='assets/javascripts/theme.js' type='text/javascript'></script>
</body>

<script type="text/javascript">
$(function(){
	$("#btnlogin").click(function(){
		if ($("#userName").val()=="") {
			alert("请填写用户名");
			return ;
		}
		if ($("#password").val()=="") {
			alert("请填写密码");
			return ;
		}
		$.ajax({
				url : "${basePath}userLogin",
				data : $("#loginform").serialize(),
				type : "post",
				async : false,
				dataType : "json",
				success : function(data) {
					if (data.status == "SUCCESS") {
						window.location.href = '${basePath }system/init';
					} else {
						alert(data.message);
					}
				}
			});
	})
})
</script>

</html>

