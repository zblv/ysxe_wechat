<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<!--[if lt IE 9]>
    <script src='${basePath}${basePath}${basePath}assets/javascripts/html5shiv.js' type='text/javascript'></script>
    <![endif]-->
<link href='${basePath}assets/stylesheets/bootstrap/bootstrap.css'
	media='all' rel='stylesheet' type='text/css' />

<link
	href='${basePath}assets/stylesheets/bootstrap/bootstrap-responsive.css'
	media='all' rel='stylesheet' type='text/css' />

<!-- / jquery ui -->

<link
	href='${basePath}assets/stylesheets/jquery_ui/jquery-ui-1.10.0.custom.css'
	media='all' rel='stylesheet' type='text/css' />

<link
	href='${basePath}assets/stylesheets/jquery_ui/jquery.ui.1.10.0.ie.css'
	media='all' rel='stylesheet' type='text/css' />

<link
	href='${basePath}assets/stylesheets/plugins/bootstrap_colorpicker/bootstrap-colorpicker.css'
	media='all' rel='stylesheet' type='text/css' />

<!-- / flatty theme -->

<link href='${basePath}assets/stylesheets/light-theme.css'
	id='color-settings-body-color' media='all' rel='stylesheet'
	type='text/css' />

<!-- / demo -->
<link href="${basePath}assets/javascripts/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
<link href='${basePath}assets/stylesheets/demo.css' media='all'
	rel='stylesheet' type='text/css' />

<div class='container-fluid'>
<div class='row-fluid' id='content-wrapper'>

<div class='span12'>

<div class='page-header'>

    <h1 class='pull-left'>

        <i class='icon-dashboard'></i>

        <span>快速导航</span>

    </h1>
</div>

<div class='row-fluid'>

    <div class='span12 box box-transparent'>

        <div class='row-fluid'>
			<c:forEach items="${menus}" var="currMenu">
				<c:forEach items="${currMenu.subMenuVos}" var="subMenu">
					<div class='span2 box-quick-link blue-background'>
		                <a href="javascript:tolink('${subMenu.url }', '${subMenu.name }', '${currMenu.name }')">
		                    <div class='header'>
		                        <div class='${subMenu.iconClass }'></div>
		                    </div>
		                    <div class='content'>${subMenu.name }</div>
		                </a>
		                
	            	</div>
	            </c:forEach>
			</c:forEach>  
        </div>
    </div>
</div>
</div>
</div>
</div>
<script src='${basePath}assets/javascripts/jquery/jquery.min.js'
	type='text/javascript'></script>
<script
	src='${basePath}assets/javascripts/plugins/mobile_events/jquery.mobile-events.min.js'
	type='text/javascript'></script>

<!-- / jquery migrate (for compatibility with new jquery) -->

<script src='${basePath}assets/javascripts/jquery/jquery-migrate.min.js'
	type='text/javascript'></script>

<!-- / jquery ui -->

<script src='${basePath}assets/javascripts/jquery_ui/jquery-ui.min.js'
	type='text/javascript'></script>

<!-- / bootstrap -->
<script src='${basePath}assets/javascripts/bootstrap/bootstrap.min.js'
	type='text/javascript'></script>
	
	<!-- / datatables -->
<script src='${basePath}assets/javascripts/plugins/datatables/jquery.dataTables.min.js' type='text/javascript'></script>
<script src='${basePath}assets/javascripts/plugins/datatables/jquery.dataTables.columnFilter.js' type='text/javascript'></script>
<!-- / select2 -->

<script src='${basePath}assets/javascripts/plugins/select2/select2.js'
	type='text/javascript'></script>

<script
	src='${basePath}assets/javascripts/plugins/modernizr/modernizr.min.js'
	type='text/javascript'></script>

<!-- / retina -->

<script src='${basePath}assets/javascripts/plugins/retina/retina.js'
	type='text/javascript'></script>

<script
	src='${basePath}assets/javascripts/plugins/validate/jquery.validate.min.js'
	type='text/javascript'></script>

<script
	src='${basePath}assets/javascripts/plugins/validate/additional-methods.js'
	type='text/javascript'></script>
	
<script src='${basePath}assets/javascripts/tables.js'
	type='text/javascript'></script>

<script src='${basePath}assets/javascripts/theme.js'
	type='text/javascript'></script>

<script src='${basePath}assets/javascripts/ztree/jquery.ztree.all-3.5.js' type='text/javascript'></script>
<script src="${basePath}assets/javascripts/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$(".newsMsg").hide();
		$("#replyType").change(function(){
			var rType = $("#replyType").val();
			if (rType == "news") {
				$(".newsMsg").show();
			}else{
				$(".newsMsg").hide();
			}
		}); 
	})
	function showMessage(id, keyword, keyType, replyType, replyText,
			newsTitle,newsImgLink,newsLink,status,remark,createDate) {
		if (id != "") {
			$("#id").val(id);
			$("#keyword").val(keyword);
			$("#keyType").val(keyType);
			$("#replyType").val(replyType);
			$("#replyText").val(replyText);
			$("#status").val(status);
			$("#remark").val(remark);
			$("#newsTitle").val(newsTitle);
			$("#newsImgLink").val(newsImgLink);
			$("#newsLink").val(newsLink);
			$("#createDate").val(createDate);
			if (replyType == "news") {
				$(".newsMsg").show();
			}else{
				$(".newsMsg").hide();
			}
		} else {
			$("#id").val("");
			$("#keyword").val("");
			$("#keyType").val("");
			$("#replyType").val("");
			$("#replyText").val("");
			$("#newsTitle").val("");
			$("#newsImgLink").val("");
			$("#newsLink").val("");
			$("#status").val("");
			$("#remark").val("");
			$("#createDate").val("");
		}
		layer.open({
			title : false,
			closeBtn : false,
			area : [ '700px', '680px' ],
			type : 1,
			shade : [ 0.01, '#000' ],
			content : $("#hiddenDiv")
		//这里content是一个普通的String
		});
	}

	function addOrUpdateMessage() {
		$.ajax({
			url : "${basePath}/system/message/addOrUpdateReply",
			data : $("#editUserForm").serialize(),
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.status == "SUCCESS") {
				window.location.href="${basePath}system/message/init?fMenuUrl="+encodeURI(encodeURI("system/message/init"))+"&currMenuName="+encodeURI(encodeURI("设置自动回复	"))+"&fMenuName="+encodeURI(encodeURI("消息回复管理"))+"";
				} else {
					alert(data.message);
				}
			}
		});
	}
	
	function tolink(url,name,fname){
	window.location.href = "${basePath}"+url+"?fMenuUrl="
								+ encodeURI(encodeURI(url))
								+ "&currMenuName="
								+ encodeURI(encodeURI(name))
								+ "&fMenuName="
								+ encodeURI(encodeURI(fname)) + "";
	}
</script>