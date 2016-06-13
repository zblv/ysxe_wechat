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
					<div class='title'>资料基本信息</div>
					
					<div class='actions'>
						
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
										<th>客户姓名</th>
										<th>联系方式</th>
										<th>联系地址</th>
										<th>贷款金额(万)</th>
										<th>贷款期限(月)</th>
										<th>有无抵押</th>
										<th>抵押类型</th>
										<th>状态</th>
									</tr>
								</thead>
								<tbody>
									
									<c:forEach items="${wechatDataAudits}" var="bean">
										<tr ondblclick="showData(${bean.id },'${bean.relName }','${bean.mobilePhone }','${bean.address}','${bean.loanMoney}','${bean.loanTerm}','${bean.loanPurpose}','${bean.repaySource}','${bean.isMortgage}','${bean.mortgageType}','${bean.state}','${bean.auditPeople}','${bean.remark }','<fmt:formatDate value="${bean.createDate }" pattern="yyyy-MM-dd HH:mm:ss"/>','<fmt:formatDate value="${bean.updateDate }" pattern="yyyy-MM-dd HH:mm:ss"/>');">
											<td>${bean.relName }</td>
											<td>${bean.mobilePhone }</td>
											<td>${bean.address}</td>
											<td>
												${bean.loanMoney}
											</td>
											<td>${bean.loanTerm }</td>
											<td>${bean.isMortgage }</td>
											<td>${bean.mortgageType }</td>
											<c:if test="${bean.state == 'audit'}">
												<td>
													待审核
												</td>
												
											</c:if>
											<c:if test="${bean.state == 'close'}">
												<td>
													审核未通过
												</td>
											</c:if>
											<c:if test="${bean.state == 'open'}">
												<td>
													审核通过
												</td>
											</c:if>
										</tr>
										
									</c:forEach>
								</tbody>
								<tfoot>
									<tr>
										<th>搜索客户姓名</th>
										<th>搜索联系方式</th>
										<th>搜索联系地址</th>
										<th>搜索贷款金额</th>
										<th>搜索贷款期限</th>
										<th>搜索有无抵押</th>
										<th>搜索抵押类型</th>
										<th >搜索状态</th>
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
			<div class='title'>编辑资料审核信息</div>
			<div class="actions">
				<a href="javascript:void(0);" class="btn btn-warning"
					onclick="layer.closeAll('page');return false;";> <i
					class="icon-remove-sign">关闭</i> </a>
			</div>
		</div>
		<div class='box-content'>
			<form id="editDataForm" class='form form-horizontal'
				style='margin-bottom: 0;' />
			<input id='hid' name='id' type="hidden" />
			<div class='control-group'>
				<label class='control-label' for='relName'>客户姓名</label>
				<div class='controls'>
					<input id='hrelName' name='relName' placeholder='客户姓名' readonly="readonly"/>
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='mobilePhone'>联系方式</label>
				<div class='controls'>
					<input id='hmobilePhone' name='mobilePhone' placeholder='联系方式' readonly="readonly"/>
				</div>
			</div>
			<div class='control-group'>
				<label class='control-label' for='address'>联系地址</label>
				<div class='controls'>
					<input id='haddress' name='address' placeholder='联系地址' readonly="readonly"/>
				</div>
			</div>
			<div class='control-group'  >
				<label class='control-label' for='loanMoney'>贷款金额（单位：万）</label>
				<div class='controls'>
					<input id='hloanMoney' name='loanMoney' placeholder='贷款金额（单位：万）'readonly="readonly"/>
				</div>
			</div>
			<div class='control-group' >
				<label class='control-label' for='loanTerm'>贷款期限（单位：月）</label>
				<div class='controls'>
					<input id='hloanTerm' name='loanTerm' placeholder='贷款期限（单位：月）' readonly="readonly"/>
				</div>
			</div>
			<div class='control-group' >
				<label class='control-label' for='loanPurpose'>借款用途</label>
				<div class='controls'>
					<input id='hloanPurpose' name='loanPurpose' placeholder='借款用途' readonly="readonly"/>
				</div>
			</div>
			<div class='control-group' >
				<label class='control-label' for='repaySource'>还款来源</label>
				<div class='controls'>
					<input id='hrepaySource' name='repaySource' placeholder='还款来源' readonly="readonly" />
				</div>
			</div>
			<div class='control-group' >
				<label class='control-label' for='isMortgage'>有无抵押</label>
				<div class='controls'>
					<input id='hisMortgage' name='isMortgage' placeholder='有无抵押' readonly="readonly"/>
				</div>
			</div>
			<div class='control-group' >
				<label class='control-label' for='mortgageType'>抵押类型</label>
				<div class='controls'>
					<input id='hmortgageType' name='mortgageType' placeholder='抵押类型' readonly="readonly"/>
				</div>
			</div>
			<div class='control-group'>
                <label class='control-label' for='remark'>备注</label>
                <div class='controls'>
                    <textarea class='input-block-level' id='hremark' name="remark" placeholder='备注' rows='2' readonly="readonly"></textarea>
                </div>
            </div>
	            <div class='control-group' >
	            		<label class='control-label' for='createDate'>申请时间</label>
						<div class='controls'>
							<input id='hcreateDate' name='createDate' placeholder='申请时间' readonly="readonly"/>
						</div>
				</div>
				<div class='control-group' >
					<label class='control-label' for='updateDate'>上一次修改时间</label>
					<div class='controls'>
						<input id='hupdateDate' name='updateDate' placeholder='上一次修改时间' readonly="readonly"/>
					</div>
				</div>
			<div class='control-group'>
				<label class='control-label' for='state'>当前状态</label>
				<div class='controls'>
					<select  name="state" id="hstate" readonly="readonly">
						<option value="audit" >审核中</option>
						<option value="close" >审核不通过</option>
						<option value="open" >审核通过</option>
					</select>
				</div>
			</div>
			<div class='control-group' >
				<label class='control-label' for='auditPeople'>审核人员</label>
				<div class='controls'>
					<input id='hauditPeople' name='auditPeople' placeholder='审核人员' readonly="readonly"/>
				</div>
			</div>
			<div class='form-actions' style='margin-bottom: 0'>
				<button class='btn btn-primary'>
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




<script src="${basePath}assets/javascripts/common.js" type="text/javascript" ></script>


<script type="text/javascript">

	function showData(id, relName,mobilePhone,address,loanMoney,loanTerm,
				loanPurpose,repaySource,isMortgage,mortgageType,state,
				auditPeople,remark,createDate,updateDate) {
		$("#hid").val(id);
		$("#hrelName").val(relName);
		$("#hmobilePhone").val(mobilePhone);
		$("#haddress").val(address);
		$("#hloanMoney").val(loanMoney);
		$("#hloanTerm").val(loanTerm);
		$("#hloanPurpose").val(loanPurpose);
		$("#hrepaySource").val(repaySource);
		$("#hisMortgage").val(isMortgage);
		$("#hmortgageType").val(mortgageType);
		$("#hstate").val(state);
		$("#hauditPeople").val(auditPeople);
		$("#hremark").val(remark);
		$("#hcreateDate").val(createDate);
		$("#hupdateDate").val(updateDate);
		layer.open({
			title : false,
			closeBtn : false,
			area : [ '500px', '700px' ],
			type : 1,
			shade : [ 0.01, '#000' ],
			content : $("#hiddenDiv")
		//这里content是一个普通的String
		});
	}
</script>