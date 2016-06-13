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
					<div class='title'>服务号自动回复</div>
					
					<div class='actions'>
						<button class='btn btn-success' type="button"
							onclick="showMessage('','','','','','');">
							<i class='icon-plus'></i> 新增自动回复
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
										<th>关键词</th>
										<th>索引方式</th>
										<th>回复方式</th>
										<th width="250px;">回复内容</th>
										<th>状态</th>
										<th>备注</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${replies}" var="bean">
										<tr ondblclick="showMessage(${bean.id },'${bean.keyword }','${bean.keyType }','${bean.replyType }','${bean.replyText }','${bean.newsTitle }','${bean.newsImgLink }','${bean.newsLink }','${bean.status }','${bean.remark }','<fmt:formatDate value="${bean.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/>');">
											<td>${bean.keyword }</td>
											<c:if test="${bean.keyType == 'accurate' }">
												<td>精确查询</td>
											</c:if>
											<c:if test="${bean.keyType == 'vague' }">
												<td>模糊查询</td>
											</c:if>
											<c:if test="${bean.replyType == 'text' }">
												<td>文本消息</td>
											</c:if>
											<c:if test="${bean.replyType == 'news' }">
												<td>图文消息</td>
											</c:if>
											<td >
												<c:if test="${bean.replyText.length()>20}">
													<a href="javascript:void(0);"  style="cursor:default;text-decoration:none;" title="${bean.replyText }">${bean.replyText.substring(0,20)}...</a>
												</c:if>
												<c:if test="${bean.replyText.length()<=20}">
													${bean.replyText}
												</c:if>
											</td>
											<c:if test="${bean.status == 'open' }">
									       		<td>
									           		<span class='label label-success'>使用中</span>
									           	</td>
								           </c:if>
								           <c:if test="${bean.status == 'close' }">
								           		<td>
								           			<span class='label label-important'>已停用</span>
								           		</td>
								           </c:if>
								           <td>
												<c:if test="${bean.remark.length()>20}">
													<a href="javascript:void(0);"  style="cursor:default;text-decoration:none;" title="${bean.remark }">${bean.remark.substring(0,20)}...</a>
												</c:if>
												<c:if test="${bean.remark.length()<=20}">
													${bean.remark}
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<th>搜索关键词</th>
										<th>搜索索引方式</th>
										<th>搜索回复方式</th>
										<th>搜索回复内容</th>
										<th>搜索状态</th>
										<th>搜索备注</th>
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
			<div class='title'>编辑自动回复</div>
			<div class="actions">
				<a href="javascript:void(0);" class="btn btn-warning"
					onclick="layer.closeAll('page');return false;";> <i
					class="icon-remove-sign">关闭</i> </a>
			</div>
		</div>
		<div class='box-content'>
			<form id="editUserForm" class='form form-horizontal'
				style='margin-bottom: 0;' />
			<input id='id' name='id' type="hidden" />
			<div class='control-group'>
				<label class='control-label' for='keyword'>关键词</label>
				<div class='controls'>
					<input id='keyword' name='keyword' placeholder='关键词' />
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='keyType'>关键词索引方式</label>
				<div class='controls'>
					<select id="keyType" name="keyType">
						<option value="accurate">精确</option>
						<option value="vague">模糊</option>
					</select>
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='replyType'>回复方式</label>
				<div class='controls'>
					<select id="replyType" name="replyType">
						<option value="text">文本消息</option>
						<option value="news">图文消息</option>
					</select>
				</div>
			</div>
			
			<div class='control-group'>
                <label class='control-label' for='replyText'>回复内容</label>
                <div class='controls'>
                    <textarea class='input-block-level' id='replyText' name="replyText" placeholder='回复内容' rows='3'></textarea>
                </div>
            </div>
			<div class='control-group newsMsg'>
				<label class='control-label' for='newsTitle'>图文消息标题</label>
				<div class='controls'>
					<input class="span4" id='newsTitle' name='newsTitle' placeholder='图文消息标题' />
				</div>
			</div>
			<div class='control-group newsMsg'>
				<label class='control-label' for='newsImgLink'>图片地址</label>
				<div class='controls'>
					<input class="span4" id='newsImgLink' name='newsImgLink' placeholder='图片地址' />
				</div>
			</div>
			<div class='control-group newsMsg'>
				<label class='control-label' for='newsLink'>图文消息跳转地址</label>
				<div class='controls'>
					<input class="span4" onfocus="czbtn();" id='newsLink' name='newsLink' placeholder='图文消息跳转地址' />
					<button class='btn btn-save' type="button" id="mdlurl" 
							onclick="getMdlUrl();">
							 生成网页授权链接
					</button>
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='status'>状态</label>
				<div class='controls'>
					<select id="status" name="status">
						<option value="open">启用</option>
						<option value="close">停用</option>
					</select>
				</div>
			</div>
			
			<div class='control-group'>
                <label class='control-label' for='remark'>备注</label>
                <div class='controls'>
                    <textarea class='input-block-level' id='remark' name="remark" placeholder='备注' rows='2'></textarea>
                </div>
            </div>
			<div class='form-actions' style='margin-bottom: 0'>
				<button class='btn btn-primary'
					onclick="addOrUpdateMessage();return false;">
					<i class='icon-save'></i> &nbsp;确&nbsp;&nbsp;&nbsp;&nbsp;定
				</button>
			</div>
			</form>
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
				window.location.href="${basePath}system/message/init?fMenuUrl="+encodeURI(encodeURI("system/message/init"))+"&currMenuName="+encodeURI(encodeURI("设置自动回复"))+"&fMenuName="+encodeURI(encodeURI("消息回复管理"))+"";
				} else {
					alert(data.message);
				}
			}
		});
	}
	function getMdlUrl(){
		$("#mdlurl").attr("disabled","disabled");
		$.ajax({
			url : "${basePath}/system/getloginUrl",
			data : $("#editUserForm").serialize(),
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				if (data.status == "SUCCESS") {
				$("#newsLink").val(data.resultData);
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