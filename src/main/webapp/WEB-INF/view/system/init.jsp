<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>银盛小贷  - 微信服务号管理后台</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport' />
    <!--[if lt IE 9]>
    <script src='assets/javascripts/html5shiv.js' type='text/javascript'></script>
    <![endif]-->
    <link href='${basePath}assets/stylesheets/bootstrap/bootstrap.css' media='all' rel='stylesheet' type='text/css' />
    <link href='${basePath}assets/stylesheets/bootstrap/bootstrap-responsive.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / jquery ui -->
    <link href='${basePath}assets/stylesheets/jquery_ui/jquery-ui-1.10.0.custom.css' media='all' rel='stylesheet' type='text/css' />
    <link href='${basePath}assets/stylesheets/jquery_ui/jquery.ui.1.10.0.ie.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / wysihtml5 (wysywig) -->
    <link href='${basePath}assets/stylesheets/plugins/common/bootstrap-wysihtml5.css' media='all' rel='stylesheet' type='text/css' />
    <!-- / flatty theme -->
    <link href='${basePath}assets/stylesheets/light-theme.css' id='color-settings-body-color' media='all' rel='stylesheet' type='text/css' />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body class='contrast-red '>
	<header>
		<jsp:include page="/WEB-INF/view/common/header.jsp" />
	</header>
	<div id='wrapper'>
		<div id='main-nav-bg'></div>
		<nav class='' id='main-nav'>
			<div class='navigation'>
				<ul class='nav nav-stacked'>
					<li class='active'>
					    <a href='${basePath }system/init'>
					        <i class='icon-dashboard'></i>
					        <span>银盛小贷</span>
					    </a>
					</li>
					<c:forEach items="${menus}" var="currMenu">
						<c:if test="${!empty currMenu.subMenuVos}">
							<li class='menu_yml'>
							    <a class='dropdown-collapse' href='#'>
							        <i class='${(currMenu.iconClass==null||currMenu.iconClass=="")?"icon-edit":currMenu.iconClass}'></i>
							        <span>${currMenu.name }</span>
							        <i class='icon-angle-down angle-down'></i>
							    </a>
							    <ul class='nav nav-stacked'>
							    	<c:forEach items="${currMenu.subMenuVos}" var="currSubMenu">
								        <li class=''>
								            <a href="javascript:menuClickHandle('${currSubMenu.url }','${currSubMenu.name }','${currMenu.name }','${currMenu.url }');">
								                <i class='${(currSubMenu.iconClass==null||currSubMenu.iconClass=="")?"icon-caret-right":currSubMenu.iconClass}'></i>
								                <span>${currSubMenu.name }</span>
								            </a>
								        </li>
							        </c:forEach>
							    </ul>
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</nav>
		<section id='content'>
			<iframe id="content-iframe" width="100%" height="" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto">
		   	 </iframe>
		</section>
	</div>
	<!-- / jquery -->
	<script src='${basePath}assets/javascripts/jquery/jquery.min.js' type='text/javascript'></script>
	<!-- / jquery mobile events (for touch and slide) -->
	<script src='${basePath}assets/javascripts/plugins/mobile_events/jquery.mobile-events.min.js' type='text/javascript'></script>
	<!-- / jquery migrate (for compatibility with new jquery) -->
	<script src='${basePath}assets/javascripts/jquery/jquery-migrate.min.js' type='text/javascript'></script>
	<!-- / jquery ui -->
	<script src='${basePath}assets/javascripts/jquery_ui/jquery-ui.min.js' type='text/javascript'></script>
	<!-- / bootstrap -->
	<script src='${basePath}assets/javascripts/bootstrap/bootstrap.min.js' type='text/javascript'></script>
	<script src='${basePath}assets/javascripts/plugins/flot/excanvas.js' type='text/javascript'></script>
	<!-- / wysihtml5 -->
	<script src='${basePath}assets/javascripts/plugins/common/wysihtml5.min.js' type='text/javascript'></script>
	<script src='${basePath}assets/javascripts/plugins/common/bootstrap-wysihtml5.js' type='text/javascript'></script>
	<!-- / flatty theme -->
	<script src='${basePath}assets/javascripts/nav.js' type='text/javascript'></script>
	<script src="${basePath}assets/javascripts/layer/layer.js" type="text/javascript"></script>
	<script src="${basePath}assets/javascripts/common.js" type="text/javascript" ></script>
	<script type="text/javascript">
		function menuClickHandle(url, currMenuName, fMenuName, fMenuUrl){
			url = url+"?fMenuUrl="+encodeURI(encodeURI(fMenuUrl))
				+"&currMenuName="+encodeURI(encodeURI(currMenuName))
				+"&fMenuName="+encodeURI(encodeURI(fMenuName));
			$("#content-iframe").attr("src", "${basePath}"+url);
		}
		$(function(){
			$("#content-iframe").load(function(){
				$(this).height($("#wrapper").height());
			});
			
			
			if($(".menu_yml").length == 0){
				layer.alert('噢!您还没有菜单权限,请联系您的管理员!', {
				    skin: 'layui-layer-molv' //样式类名
				    ,closeBtn: 0
				}, function(){
					window.location.href="${basePath}logout"
				});
			}
			$("#content-iframe").attr("src", "${basePath}system/index");
		});
	</script>
</body>
</html>
    