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
<style>
*{ margin:0; padding:0;}
ul li{ list-style:none;}
ul,
ol {
    padding: 0;
    margin: 0 0 12px 0;
}
#xx{  height:35px; float:left; background:#fff; border:1px solid #ccc; margin-top:200px;}
#xx div.area{ width:200px; float:left; position:relative;}
#xx div.two{ width:198px; border-left:1px solid #ccc; border-right:1px solid #ccc;}
#xx div.area p{ font-size:28px; height:28px; line-height:28px; color:#505050; text-align:center; cursor:pointer;}
#xx div.area ul{ width:100%; position:absolute; bottom:35px; left:0;background:#a0a0a0; display:none;}
#xx div.area ul li{ width:100%; height:30px; font-size:24px; text-align:center; line-height:30px; float:left; cursor:pointer;}
#xx div.area ul li:hover{ background:#f0f0f0;}
#xx div.area ul li.more{ font-size:35px; font-weight:bold;}
</style>
<div class='container-fluid'>

	<div class='row-fluid' id='content-wrapper'>
		<jsp:include page="/WEB-INF/view/common/content_header.jsp" />
		<div class='row-fluid'>
			
			<!-- 自定义菜单展示end -->
			<div class='span7 box bordered-box blue-border'>
				<div class='box-header blue-background'>
					<div class='title'>自定义菜单模型</div>
					<div class='actions'>
						<button class='btn btn-success'
							onclick="release();">
							<i class='icon-save'></i> &nbsp;提交发布
						</button>
						<a href="#" class="btn box-collapse btn-mini btn-link"><i></i></a>
					</div>
				</div>
				<div class='box-content box-no-padding'>
					<div id="xx" class="box-content">
						<div class="area">
							<c:if test="${menu0 ==null }">
								<p id="c-1" onclick="showMenu('','','f','','','0','','');">+</p>
							</c:if>
							<c:if test="${menu0 !=null }">
								<p id="c-1" onclick="showMenu(${menu0.id },'${menu0.name }','${menu0.type }','${menu0.url }','${menu0.keyword }','${menu0.fid }','${menu0.sort }','${menu0.isdel }');">${menu0.name }</p>
						        <ul id="S-1" >
						        	<c:forEach items="${menu0.menus}" var="bean">
						        		<li onclick="showMenu(${bean.id },'${bean.name }','${bean.type }','${bean.url }','${bean.keyword }','${bean.fid }','${bean.sort }','${bean.isdel }');">${bean.name }</li>
						        	</c:forEach>
						        	<c:if test="${menu0.menus.size() < 5  && menu0.type=='f'}">
						        		<li class="more" onclick="showMenu('','','view','','','${menu0.id }','','');">+</li>
						        	</c:if>
						        </ul>
							</c:if>
					    </div>
						<div class="area two">
					    	<c:if test="${menu1 ==null }">
								<p id="c-2" onclick="showMenu('','','f','','','0','','');">+</p>
							</c:if>
							<c:if test="${menu1 !=null }">
								<p id="c-2" onclick="showMenu(${menu1.id },'${menu1.name }','${menu1.type }','${menu1.url }','${menu1.keyword }','${menu1.fid }','${menu1.sort }','${menu1.isdel }');">${menu1.name }</p>
						        <ul id="S-2">
						        	<c:forEach items="${menu1.menus}" var="bean">
						        		<li onclick="showMenu(${bean.id },'${bean.name }','${bean.type }','${bean.url }','${bean.keyword }','${bean.fid }','${bean.sort }','${bean.isdel }');">${bean.name }</li>
						        	</c:forEach>
						        	<c:if test="${menu1.menus.size() < 5 && menu1.type=='f'}">
						        		<li class="more" onclick="showMenu('','','view','','','${menu1.id }','','');">+</li>
						        	</c:if>
						        </ul>
							</c:if>
					    </div>
						<div class="area">
					    	<c:if test="${menu2 ==null }">
								<p id="c-3" onclick="showMenu('','','f','','','0','','');">+</p>
							</c:if>
							<c:if test="${menu2 !=null }">
								<p id="c-3" onclick="showMenu(${menu2.id },'${menu2.name }','${menu2.type }','${menu2.url }','${menu2.keyword }','${menu2.fid }','${menu2.sort }','${menu2.isdel }');">${menu2.name }</p>
						        <ul id="S-3">
						        	<c:forEach items="${menu2.menus}" var="bean">
						        		<li onclick="showMenu(${bean.id },'${bean.name }','${bean.type }','${bean.url }','${bean.keyword }','${bean.fid }','${bean.sort }','${bean.isdel }');">${bean.name }</li>
						        	</c:forEach>
						        	<c:if test="${menu2.menus.size() < 5   && menu2.type=='f'}">
						        		<li class="more" onclick="showMenu('','','view','','','${menu2.id }','','');">+</li>
						        	</c:if>
						        </ul>
							</c:if>
					    </div>
					</div>
				</div>
			</div>
			
			<div class='span5 box'>
                        <div class='box-header blue-background'>
                            <div class='title'>菜单设置</div>
                            <div class='actions'>
                                <a href="#" class="btn box-collapse btn-mini btn-link"><i></i>
                                </a>
                            </div>
                        </div>
                        <div class='box-content'>
                            <form id="editUserForm" class='form form-horizontal'
				style='margin-bottom: 0;' />
			<input id='id' name='id' type="hidden" />
			<div class='control-group'>
				<label class='control-label' for='name'>菜单名称</label>
				<div class='controls'>
					<input id='name' name='name' placeholder='菜单名称' />
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='type'>菜单类型</label>
				<div class='controls'>
					<select id="type" name="type">
						<option value="f">一级菜单</option>
						<option value="click">自动回复</option>
						<option value="view">页面跳转</option>
					</select>
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='url'>页面跳转地址</label>
				<div class='controls'>
					<input onfocus="czbtn();" id='url' name='url' placeholder='当菜单类型为页面跳转时必填' disabled="disabled" class="span11"/>
					<button class='btn btn-save' type="button" id="mdlurl" 
							onclick="getMdlUrl();">
							 生成网页授权链接
					</button>
				</div>
			</div>

			<div class='control-group'>
				<label class='control-label' for='keyword'>自动回复关键词</label>
				<div class='controls'>
					<input id='keyword' name='keyword' placeholder='当菜单类型为自动回复时必填' disabled="disabled"/>
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='fid'>父级菜单</label>
				<div class='controls'>
					<select id="fid"  disabled="disabled">
						<option value="">无父级菜单</option>
						<c:forEach items="${menus}" var="bean">
						<option value="${bean.id }">${bean.name }</option>
						</c:forEach>
					</select>
					<input type="hidden" name="fid" id="inputfid">
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='sort'>排序</label>
				<div class='controls'>
					<input id='sort' name='sort' placeholder='排序' />
					<input id='isdel' name='isdel' type="hidden" />
				</div>
			</div>
			<div class='form-actions' style='margin-bottom: 0'>
				<button class='btn btn-primary'
					onclick="addOrUpdateMenu('n');return false;">
					<i class='icon-save'></i> &nbsp;确&nbsp;&nbsp;&nbsp;&nbsp;定
				</button>
				
				<button class='btn btn-danger'
					onclick="addOrUpdateMenu('y');return false;" style="margin-left: 50px;">
					<i class='icon-remove'></i> &nbsp;删&nbsp;&nbsp;&nbsp;&nbsp;除
				</button>
			</div>
			</form>
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
	function showMenu(id, name, type, url, keyword, fid,
			sort, isdel) {
		if (id != "") {
			$("#id").val(id);
			$("#name").val(name);
			$("#type").val(type);
			$("#url").val(url);
			$("#keyword").val(keyword);
			$("#fid").val(fid);
			$("#inputfid").val(fid);
			$("#sort").val(sort);
			$("#isdel").val(isdel);
		} else {
			$("#id").val("");
			$("#name").val("");
			$("#type").val(type);
			$("#url").val("");
			$("#keyword").val("");
			$("#fid").val(fid);
			$("#inputfid").val(fid);
			$("#sort").val("");
			$("#isdel").val("n");
		}
		upType();
	}

	function addOrUpdateMenu(isdel) {
	$("#isdel").val(isdel);
		$.ajax({
				url : "${basePath}/system/wechatmenu/addOrUpdateMenu",
				data : $("#editUserForm").serialize(),
				type : "post",
				async : false,
				dataType : "json",
				success : function(data) {
					if (data.status == "SUCCESS") {
						window.location.href = "${basePath}system/wechatmenu/init?fMenuUrl="
								+ encodeURI(encodeURI("system/wechatmenu/init"))
								+ "&currMenuName="
								+ encodeURI(encodeURI("设置自定义菜单"))
								+ "&fMenuName="
								+ encodeURI(encodeURI("自定义菜单管理管理")) + "";
					} else {
						alert(data.message);
					}
				}
			});
	}
	
	
	function release() {
		$.ajax({
				url : "${basePath}/system/wechatmenu/release",
				type : "post",
				async : false,
				dataType : "json",
				success : function(data) {
					if (data.status == "SUCCESS") {
						alert(data.resultData);
					} else {
						alert(data.message);
					}
				}
			});
	}
	
	function upType(){
		var type = $("#type").val();
		if (type == "click") {
			$("#keyword").removeAttr("disabled");
			$("#url").attr("disabled","disabled");
		}else if (type == "view") {
			$("#url").removeAttr("disabled");
			$("#keyword").attr("disabled","disabled");
		}else {
			$("#keyword").attr("disabled","disabled");
			$("#url").attr("disabled","disabled");
		}
	}
	
	$(document).ready(function(){
		$('#xx .area').children('p').click(function(){
			var i=$(this).attr('id').substr(2,1);
			$('#S-'+i).slideToggle();
		
		});

		$("#type").change(function(){
			upType();
		}); 
	})
	
	function getMdlUrl(){
		$("#mdlurl").attr("disabled","disabled");
		$.ajax({
			url : "${basePath}/system/getloginUrl",
			data : "newsLink="+$("#url").val(),
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.status == "SUCCESS") {
				$("#url").val(data.resultData);
				} else {
					alert(data.message);
				}
			}
		});
	}
	
	function czbtn(){
		$("#mdlurl").removeAttr("disabled");
	}
</script>