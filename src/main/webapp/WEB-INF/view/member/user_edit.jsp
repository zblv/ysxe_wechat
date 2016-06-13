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
		<jsp:include page="/WEB-INF/view/common/content_header.jsp" />
		<div class='row-fluid'>

			<div class='span12 box bordered-box orange-border'
				style='margin-bottom:0;'>
				<div class='box-header purple-background'>
					<div class='title'>管理员基本信息</div>
					
					<div class='actions'>
						<button class='btn btn-success' type="button"
							onclick="showUser('','','','','','','');">
							<i class='icon-plus'></i> 新增管理员
						</button>
						<a href="#" class="btn box-collapse btn-mini btn-link"><i></i>
						</a>
					</div>
				</div>
				<div class='box-content box-no-padding'>

					<div class='responsive-table'>

						<div class='scrollable-area'>

							<table
								class='data-table-column-filter table table-bordered table-striped'
								style='margin-bottom:0;'>

								<thead>
									<tr>
										<th>编号</th>
										<th>账户名</th>
										<th>邮箱</th>
										<th>手机</th>
										<th>姓名</th>
										<th>状态</th>
										<th width="250px;">操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${admins}" var="bean">
										<tr ondblclick="showUser(${bean.id },'${bean.userName }','${bean.mobilePhone }','${bean.email }','${bean.relName }','${bean.status }','<fmt:formatDate value="${bean.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/>');">
											<td>${bean.id }</td>
											<td>${bean.userName }</td>
											<td>${bean.email }</td>
											<td>${bean.mobilePhone }</td>
											<td>${bean.relName }</td>
											<c:if test="${bean.status == 'open' }">
									       		<td>
									           		<span class='label label-success'>正&nbsp;&nbsp;常</span>
									           	</td>
									           	<td>
									           		<div >
									           			<a class='btn btn-danger' href='javascript:delOrOpenUser(${bean.id},"close");' title="禁用">
									                   		<i class='icon-remove'>&nbsp;禁&nbsp;&nbsp;用</i>
									               		</a>
									               		<a class='btn btn-info' href='javascript:showAdminPerm(${bean.id });' title="权限设置" style="margin-left: 50px;">
								                   			<i class='icon-unlock-alt'>&nbsp;&nbsp;权限设置</i>
								               			</a>
									           		</div>
									           </td>
								           </c:if>
								           <c:if test="${bean.status == 'close' }">
								           		<td>
								           			<span class='label label-important'>禁&nbsp;&nbsp;用</span>
								           		</td>
								           		<td>
								           			<div >
								           				<a class='btn btn-success' href='javascript:delOrOpenUser(${bean.id},"open");' title="启用">
								                   			<i class='icon-ok'>启&nbsp;&nbsp;用</i>
								               			</a>
								               			<a class='btn btn-info' href='javascript:showAdminPerm(${bean.id });' title="权限设置" style="margin-left: 50px;">
								                   			<i class='icon-unlock-alt'>&nbsp;&nbsp;权限设置</i>
								               			</a>
								           			</div>
								           		</td>
								           </c:if>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<th>搜索编号</th>
										<th>搜索用户名</th>
										<th>搜索邮箱</th>
										<th>搜索联系方式</th>
										<th>搜索姓名</th>
										<th colspan='2'>搜索状态</th>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="hiddenDiv" style="display: none;">
	<div class='box' style="margin-bottom: 0px;">
		<div class='box-header blue-background'>
			<div class='title'>编辑管理员信息</div>
			<div class="actions">
				<a href="javascript:void(0);" class="btn btn-warning"
					onclick="layer.closeAll('page');return false;";> <i
					class="icon-remove-sign">关闭</i> </a>
			</div>
		</div>
		<div class='box-content'>
			<form id="editUserForm" class='form form-horizontal'
				style='margin-bottom: 0;' />
			<input id='hid' name='id' type="hidden" />
			<div class='control-group'>
				<label class='control-label' for='userName'>用户名</label>
				<div class='controls'>
					<input id='huserName' name='userName' placeholder='用户名' />
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='password'>登录密码</label>
				<div class='controls'>
					<input id='hpassword' name='password' placeholder='登录密码' />
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='mobilePhone'>手机号码</label>
				<div class='controls'>
					<input id='hmobilePhone' name='mobilePhone' placeholder='手机号码' />
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='email'>邮箱</label>
				<div class='controls'>
					<input id='hemail' name='email' placeholder='邮箱' />
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='relName'>真实姓名</label>
				<div class='controls'>
					<input id='hrelName' name='relName' placeholder='真实姓名' />
				</div>
			</div>
			
			<div class='control-group'>
				<label class='control-label' for='status'>状态</label>
				<div class='controls'>
					<select id="hstatus" name="status">
						<option value="open">启用</option>
						<option value="close">禁用</option>
					</select>
				</div>
			</div>
			<div class='control-group' id='createDateDiv' style="display: none;">
				<label class='control-label' for='createDate'>创建时间</label>
				<div class='controls'>
					<input id='createDate' name='createDate' placeholder='未设置' readonly="readonly"/>
				</div>
			</div>
			<div class='form-actions' style='margin-bottom: 0'>
				<button class='btn btn-primary'
					onclick="addOrUpdateUser();return false;">
					<i class='icon-save'></i> &nbsp;确&nbsp;&nbsp;&nbsp;&nbsp;定
				</button>
			</div>
			</form>
		</div>
	</div>
</div>

<!-- 用户分配权限 -->
<div id="hiddenAdminPerm" style="display: none;">
	<div class='box' style="margin-bottom: 0px;">
		<input type="hidden" name="adminId" id="hiddenAdminId" />
		<div class='box-header blue-background'>
			<div class='title'>管理员权限分配</div>
			<div class="actions">
				<a href="javascript:void(0);" class="btn btn-warning" onclick="layer.closeAll('page');return false;";> 
				<i class="icon-remove-sign">关闭</i>
				</a>
			</div>
		</div>
		<div class='box-content'>
			<div style="height:343px;overflow:auto;">
				<div id="permissionZtree" class="ztree"></div>
			</div>
			<div class='form-actions' style='margin:0;'>
				<button class='btn btn-primary' onclick="saveAdminPermission();">
					<i class='icon-save'>&nbsp;&nbsp;确&nbsp;&nbsp;&nbsp;定</i>
				</button>
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

	//禁用或启用管理员
	function delOrOpenUser(id, status) {
		$.ajax({
			url : "${basePath}system/admin/delOrOpenAdmin",
			data : {
				id : id,
				status : status
			},
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.status == "SUCCESS") {
					window.location.href="${basePath}system/admin/init?fMenuUrl="+encodeURI(encodeURI("system/admin/init"))+"&currMenuName="+encodeURI(encodeURI("管理员设置"))+"&fMenuName="+encodeURI(encodeURI("后台管理"))+"";
				} else {
					alert(data.message);
				}
			}
		});
	}

	function showUser(id, userName, mobilePhone, email, relName,
			status,createDate) {
		if (id != "") {
			$("#hid").val(id);
			$("#huserName").val(userName);
			$("#hmobilePhone").val(mobilePhone);
			$("#hemail").val(email);
			$("#hrelName").val(relName);
			$("#hstatus").val(status);
			$("#createDate").val(createDate);
			$("#createDateDiv").show();
		} else {
			$("#hid").val("");
			$("#huserName").val("");
			$("#hmobilePhone").val("");
			$("#hpassword").val("");
			$("#hemail").val("");
			$("#hrelName").val("");
			$("#hstatus").val("");
			$("#createDateDiv").hide();
		}
		layer.open({
			title : false,
			closeBtn : false,
			area : [ '700px', '503px' ],
			type : 1,
			shade : [ 0.01, '#000' ],
			content : $("#hiddenDiv")
		//这里content是一个普通的String
		});
	}

	function addOrUpdateUser() {
		if ($("#huserName").val() == "") {
			alert("请填写用户名");
			return;
		}
		$.ajax({
			url : "${basePath}/system/admin/addOrUpdateAdmin",
			data : $("#editUserForm").serialize(),
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.status == "SUCCESS") {
				window.location.href="${basePath}system/admin/init?fMenuUrl="+encodeURI(encodeURI("system/admin/init"))+"&currMenuName="+encodeURI(encodeURI("管理员设置"))+"&fMenuName="+encodeURI(encodeURI("后台管理"))+"";
				} else {
					alert(data.message);
				}
			}
		});
	}
	
	//管理员权限设地begin
	var setting = {
			check:{enable:true},
			data:{
					simpleData: {
						enable: false
					},
					key:{
						children:'subMenuVos',
						name:'name',
						code:'id'
					}
				},
				view: {
					showIcon: false,
					dblClickExpand: false,
				}
		  };
		  
	function showAdminPerm(adminId){
		$("#hiddenAdminId").val(adminId);
		$.ajax({
			url : "${basePath}system/admin/getPermForDiv",
			data : {adminId : adminId},
			type : "post",
			success : function(returnVal) {
				if(returnVal.status=="SUCCESS"){
					var rootNode = {id:"root",name:"得莱斯",open:true,nocheck:true,subMenuVos:returnVal.resultData}
					$.fn.zTree.init($("#permissionZtree"), setting, rootNode);
					layer.open({
						title : false,
						closeBtn : false,
						area : ['500px','484px'],
						type : 1,
						shade : [ 0.01, '#000' ],
						content : $("#hiddenAdminPerm")
					});
				}else{
					alert(returnVal.message);					
				}
			}
		});
	}
	
	function saveAdminPermission(){
		var treeObj = $.fn.zTree.getZTreeObj("permissionZtree");
		var nodes = treeObj.getCheckedNodes(true);
		var menuIds = [];
		if(nodes.length == 0){
			layer.msg("请至少选择一个菜单!");			
			return false;
		}
		for(var i=0;i<nodes.length;i++){
			menuIds.push(nodes[i].id);
		}
		$.ajax({
			url : "${basePath}system/admin/savePermessions",
			data : {adminId : $("#hiddenAdminId").val(), menuIds:menuIds.join()},
			type : "post",
			success : function(returnVal) {
				if(returnVal.status == "SUCCESS"){
					layer.closeAll('page');
					alert(returnVal.resultData);
				}else{
					alert(returnVal.message);
				}
			}
		});
	}
</script>