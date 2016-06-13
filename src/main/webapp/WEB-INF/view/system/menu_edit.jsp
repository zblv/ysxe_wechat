<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
<!-- / jquery ui -->
<link href='${basePath}assets/stylesheets/bootstrap/bootstrap.css' media='all' rel='stylesheet' type='text/css' />
<link href='${basePath}assets/stylesheets/bootstrap/bootstrap-responsive.css' media='all' rel='stylesheet' type='text/css' />
<link href='${basePath}assets/stylesheets/jquery_ui/jquery-ui-1.10.0.custom.css' media='all' rel='stylesheet' type='text/css' />
<link href='${basePath}assets/stylesheets/jquery_ui/jquery.ui.1.10.0.ie.css' media='all' rel='stylesheet' type='text/css' />
<link href="${basePath}assets/javascripts/ztree/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
<!-- / flatty theme -->
<link href='${basePath}assets/stylesheets/light-theme.css' id='color-settings-body-color' media='all' rel='stylesheet' type='text/css' />
<div class='container-fluid'>
<div class='row-fluid' id='content-wrapper'>
		<jsp:include page="/WEB-INF/view/common/content_header.jsp" />
		<div class='row-fluid'>
		    <div class='span12 box'>
		        <div class='box-header'>
		            <div class='title'>系统菜单管理</div>
		            <div class='actions'>
		            	<a href="javascript:void(0);" class="btn btn-success" onclick="loadMenu();";>
		                	<i class="icon-refresh ">&nbsp;重新加载</i>
		                </a>
		                <a href="javascript:void(0);" class="btn btn-info" onclick="saveMenu();";>
		                	<i class="icon-save">&nbsp;保&nbsp;&nbsp;&nbsp;&nbsp;存</i>
		                </a>
		            </div>
		        </div>
		        <div class='box-content'>
		            <div id="menuZtree" class="ztree" style="min-height:400px;">
		            </div>
		        </div>
             </div>
	</div>
	
</div>
<div id="hiddenDiv" style="display:none;">
  <div class='box' style="margin-bottom:0px;">
         <div class='box-header blue-background'>
             <div class='title'>编辑菜单信息</div>
             <div class="actions">
             	 <a href="javascript:void(0);" class="btn btn-warning" onclick="layer.closeAll('page');return false;";>
                	<i class="icon-remove-sign">关闭</i>
                </a>
             </div>
         </div>
         <div class='box-content'>
             <form id="menuForm" class='form form-horizontal' style='margin-bottom: 0;' />
                 <div class='control-group'>
                     <label class='control-label' for='menuName'>菜单名称</label>
                     <div class='controls'>
                         <input id='menuName' name='menuName' placeholder='菜单名称'/>
                     </div>
                 </div>
                 <div class='control-group'>
                     <label class='control-label' for='menuUrl'>菜单地址</label>
                     <div class='controls'>
                         <input id='menuUrl' name='menuUrl' placeholder='菜单地址'/>
                     </div>
                 </div>
                 <div class='control-group'>
                     <label class='control-label' for='menuIconClass'>菜单图标</label>
                     <div class='controls'>
                         <input id='menuIconClass' name='menuIconClass' placeholder='菜单图标样式' />
                     </div>
                 </div>
                 <div class='control-group'>
                     <label class='control-label' for='menuEnable'>菜单图标</label>
                     <div class='controls'>
                         <select id="menuEnable" name="menuEnable">
                         	<option value="Y">是</option>
                         	<option value="N">否</option>
                         </select>
                     </div>
                 </div>
                 <div class='form-actions' style='margin-bottom:0'>
                     <button class='btn btn-primary' onclick="updateMenuInfo();return false;">
                         <i class='icon-save'></i>
                        	&nbsp;确&nbsp;&nbsp;&nbsp;&nbsp;定
                     </button>
                 </div>
             </form>
         </div>
     </div>
</div>
</div>
<script src='${basePath}assets/javascripts/jquery/jquery.min.js' type='text/javascript'></script>
<script src="${basePath}assets/javascripts/layer/layer.js" type="text/javascript"></script>
<script src='${basePath}assets/javascripts/ztree/jquery.ztree.all-3.5.js' type='text/javascript'></script>
<script type="text/javascript">
	function processStr(currVal){
		if(currVal && currVal.toLowerCase() != "null"){
			return currVal;
		}
		return "";
	}
	
	function updateMenuInfo(){
		var treeObj = $.fn.zTree.getZTreeObj("menuZtree");
		var nodes = treeObj.getSelectedNodes();
		nodes[0].name = processStr($("#menuName").val());
		nodes[0].url = processStr($("#menuUrl").val());
		nodes[0].iconClass = processStr($("#menuIconClass").val());
		nodes[0].enable = processStr($("#menuEnable").val());
		treeObj.updateNode(nodes[0]);
		layer.closeAll('page');
	}
	
	function saveMenu(){
		var treeObj = $.fn.zTree.getZTreeObj("menuZtree");
		var nodes = treeObj.getNodes();
		var menuNodes = nodes[0].subMenuVos;
		var menuNodesData = [];
		for(var i=0;i<menuNodes.length;i++){
			var fmenu = processNodeToMenu(menuNodes[i]);
			var subMenus = menuNodes[i].subMenuVos;
			if(subMenus){
				var currSubMenus = [];
				for(var j=0;j<subMenus.length;j++){
					var subMenu = processNodeToMenu(subMenus[j]);
					currSubMenus.push(subMenu);
				}
				fmenu.subMenuVos = currSubMenus;
			}
			menuNodesData.push(fmenu);
		}
		
		var jsonData = JSON.stringify(menuNodesData);
		 $.ajax({
				url:'${basePath}system/saveMenuTree',
				dataType:'json',
				data:{menuJsonData:jsonData},
				type:'post',
				success:function(returnVal){
					if(returnVal.status == "SUCCESS"){
						var rootNode = {id:"root",name:"得莱斯",open:true,subMenuVos:returnVal.resultData}
						$.fn.zTree.init($("#menuZtree"), setting, rootNode);
					}else{
						alert(returnVal.message);
					}
				},
				error:function(e,status){
				},
				cache:false
		  });
		
		 return false;
	}
	
	function processNodeToMenu(currData){
		var currMenu = {};
		if(currData.id && !(currData.id+"").match("^newMenu")){
			currMenu.id = currData.id;
		}
		currMenu.name = currData.name;
		currMenu.url = processStr(currData.url);
		currMenu.iconClass = processStr(currData.iconClass);
		currMenu.enable = currData.enable;
		return currMenu;
	}
	
	function zTreeBeforeDrop(treeId, treeNodes, targetNode, moveType) {
		var targetNodeLen = targetNode.subMenuVos?targetNode.subMenuVos.length:0;
		var srcNodeLen = treeNodes[0].subMenuVos?treeNodes[0].subMenuVos.length:0;
	    return !(targetNode == null || (targetNodeLen>0 && srcNodeLen>0) || (moveType=="inner" && targetNodeLen==0));
	};
	
	function showRemoveBtn(treeId, treeNode) {
		return !(treeNode.id==1 || treeNode.id == 2 ||treeNode.id=="root");
	}
	
	function removeHoverDom(treeId, treeNode) {
		$("#addBtn_"+treeNode.tId).unbind().remove();
	};
	
	function onMenuDbClick(event, treeId, treeNode){
		var treeObj = $.fn.zTree.getZTreeObj("menuZtree");
		var nodes = treeObj.getSelectedNodes();
		if(nodes.length==0 || nodes[0].id != treeNode.id){
			return false;
		}
		$("#menuName").val(processStr(treeNode.name));
		$("#menuUrl").val(processStr(treeNode.url));
		$("#menuIconClass").val(processStr(treeNode.icon));
		$("#menuEnable option[value='"+treeNode.enable+"']").prop("selected", true);
		layer.open({
			title:false,
			closeBtn:false,
			area:['700px', '342px'],
		    type: 1,
		    shade: [0.01, '#000'],
		    content: $("#hiddenDiv")//这里content是一个普通的String
		});
	}
	
	var newCount = 1;
	function addHoverDom(treeId, treeNode) {
		var sObj = $("#" + treeNode.tId + "_span");
		if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0 || treeNode.level>1) return;
		var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='新增菜单' onfocus='this.blur();'></span>";
		sObj.after(addStr);
		var btn = $("#addBtn_"+treeNode.tId);
		if (btn) btn.bind("click", function(){
			var zTree = $.fn.zTree.getZTreeObj("menuZtree");
			var newNode = {id:('newMenu' + newCount), pId:treeNode.id, enable:"Y",name:"新菜单" + (newCount++)};
			zTree.addNodes(treeNode, newNode);
			var currNode = zTree.getNodeByParam("id", newNode.id, treeNode);
			zTree.selectNode(currNode);
			$("#menuZtree .curSelectedNode").trigger("dblclick");
			return false;
		});
	};
	
	var setting = {
		 data: {
				simpleData: {
					enable: false
				},
				key:{
					children:'subMenuVos',
					name:'name',
					code:'id'
				}
			},callback: {
				onDblClick:onMenuDbClick,
				beforeDrop: zTreeBeforeDrop
			},
			view: {
				showIcon: false,
				dblClickExpand: false,
				addHoverDom: addHoverDom,
				removeHoverDom: removeHoverDom
			},
			edit:{
				enable:true,
				showRenameBtn: false,
				showRemoveBtn: showRemoveBtn
			}
	  };
	
	function loadMenu(){
		$.ajax({
			url:'${basePath}system/initMenuTree',
			dataType:'json',
			type:'post',
			success:function(returnVal){
				if(returnVal.status == "SUCCESS"){
					var rootNode = {id:"root",name:"得莱斯",open:true,subMenuVos:returnVal.resultData}
					$.fn.zTree.init($("#menuZtree"), setting, rootNode);
				}else{
					alert(returnVal.message);
				}
			},
			error:function(e,status){
			},
			cache:false
	  });
	}
	
	$(function(){
		loadMenu();
	});
</script>