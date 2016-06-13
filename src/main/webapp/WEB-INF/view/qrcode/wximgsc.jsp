<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>银盛小贷 - 贷款申请</title>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0"> 
<meta charset="UTF-8">  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="${basePath}weui/dist/style/weui.min.css"/>
<link rel="stylesheet" href="${basePath}weui/dist/example/example.css"/>
</head>
<body>  
<div class="hd">
    <h1 class="page_title">贷款申请</h1>
</div>
<form action="" >
<div class="bd spacing">
	
	<div class="weui_cells weui_cells_radio">
        <label class="weui_cell weui_check_label" for="x11">
            <div class="weui_cell_bd weui_cell_primary">
                <p>个人贷款</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" class="weui_check" name="radio1" id="x11">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
        <label class="weui_cell weui_check_label" for="x12">

            <div class="weui_cell_bd weui_cell_primary">
                <p>企业贷款</p>
            </div>
            <div class="weui_cell_ft">
                <input type="radio" name="radio1" class="weui_check" id="x12" checked="checked">
                <span class="weui_icon_checked"></span>
            </div>
        </label>
    </div>
    <div class="weui_cells_title" style="font-size: 17px;">基本信息</div>
    <div class="weui_cells">
    	<div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label">客户名称：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="text" name="relName" id="relName"/>
	        </div>
	    </div>
        <div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label" style="text-align: right;">手机号：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="number" pattern="[0-9]*"  name="mobilePhone" id="mobilePhone"/>
	        </div>
	    </div>
	     <div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label" style="text-align: right;">邮箱：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="text"  name="email" id="email"/>
	        </div>
	    </div>
	    <div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label">联系地址：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="text"  name="address" id="address"/>
	        </div>
	    </div>
	    <div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label">贷款金额：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="number" pattern="[0-9]*" placeholder="  单位：万" name="loanMoney" id="loanMoney"/>
	        </div>
	    </div>
	    <div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label">贷款期限：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="number" pattern="[0-9]*" placeholder="  单位：月" name="loanTerm" id="loanTerm"/>
	        </div>
	    </div>
	    <div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label">借款用途：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="text"  name="loanPurpose" id="loanPurpose"/>
	        </div>
	    </div>      
	    <div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label">还款来源：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	            <input class="weui_input" type="text"  name="repaySource" id="repaySource"/>
	        </div>
	    </div>  
	    <div class="weui_cell">
	        <div class="weui_cell_hd"><label class="weui_label">有无抵押：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	           <select class="weui_select" name="isMortgage">
                    <option value="有">有</option>
                    <option value="无">无</option>
                </select>
	        </div>
	    </div>   
	    <div class="weui_cell" id="mortgageTypeDiv">
	        <div class="weui_cell_hd"><label class="weui_label">抵押类型：</label></div>
	        <div class="weui_cell_bd weui_cell_primary">
	           <select class="weui_select" name="mortgageType">
                    <option value="房产">房产</option>
                    <option value="土地">土地</option>
                    <option value="设备">设备</option>
                    <option value="股权">股权</option>
                    <option value="其他">其他</option>
                </select>
	        </div>
	    </div>   
    </div>
<!--
    <div class="weui_cells_title">图片上传</div>  
    <div class="weui_cells weui_cells_form">  
      <div class="weui_cell">  
        <div class="weui_cell_bd weui_cell_primary">  
          <div class="weui_uploader">  
            <div class="weui_uploader_hd weui_cell">  
              <div class="weui_cell_bd weui_cell_primary">选择图片</div>  
              <div class="weui_cell_ft js_counter">0/9</div>  
            </div>  
            <div class="weui_uploader_bd">  
              <ul class="weui_uploader_files"> 
              </ul>  
              <div class="weui_uploader_input_wrp">  
                <input class="weui_uploader_input js_file" type="button" id="chooseImage">  
              </div>  
            </div>  
          </div>  
        </div>  
        
      </div>  
    </div>   
    -->
  <a href="javascript:tj();" class="weui_btn weui_btn_primary"  id="uploadImage">确定</a>
  <br><br>
  
  
  <div class="weui_dialog_confirm" id="dialog1" style="display: none;">
	    <div class="weui_mask"></div>
	    <div class="weui_dialog">
	        <div class="weui_dialog_hd"><strong class="weui_dialog_title">删除提醒</strong></div>
	        <div class="weui_dialog_bd">是否确定删除该图片</div>
	        <div class="weui_dialog_ft">
	            <a href="javascript:hidedialog1();" class="weui_btn_dialog default">取消</a>
	            <a href="javascript:succdialog1();" class="weui_btn_dialog primary">确定</a>
	        </div>
	    </div>
	</div> 
  </div>
  </form>
 <script src="${basePath}weui/dist/example/jweixin-1.0.0.js"></script>  
 <script src='${basePath}assets/javascripts/jquery/jquery.min.js' type='text/javascript'></script>
 <script src="${basePath}weui/dist/example/zepto.min.js"></script> 
  </body>  
<script type="text/javascript">
var liids=0;
var maxsum=9;//最大照片上传数量
$(function(){
	var browser = {
	   		versions: function () {
	        var u = navigator.userAgent, app = navigator.appVersion;
	        return {         //移动终端浏览器版本信息
		            trident: u.indexOf('Trident') > -1, //IE内核
		            presto: u.indexOf('Presto') > -1, //opera内核
		            webKit: u.indexOf('AppleWebKit') > -1, //苹果、谷歌内核
		            gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1, //火狐内核
		            mobile: !!u.match(/AppleWebKit.*Mobile.*/), //是否为移动终端
		            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), //ios终端
		            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, //android终端或uc浏览器
		            iPhone: u.indexOf('iPhone') > -1, //是否为iPhone或者QQHD浏览器
		            iPad: u.indexOf('iPad') > -1, //是否iPad
		            webApp: u.indexOf('Safari') == -1 //是否web应该程序，没有头部与底部
		        };
		    }(),
		    language: (navigator.browserLanguage || navigator.language).toLowerCase()
		}
		if (browser.versions.mobile) {//判断是否是移动设备打开。browser代码在下面
	        var ua = navigator.userAgent.toLowerCase();//获取判断用的对象
	        if (ua.match(/MicroMessenger/i) == "micromessenger") {
	           
	        }else {
				//window.location.href="${basePath}wximgerr";
			}
		} else {
		   //window.location.href="${basePath}wximgerr";
		}

	var url = window.location.href;
	$.ajax({
			url : "${basePath}jsGetwejs",
			data : "url="+url,
			type : "post",
			async : false,
			dataType : "json",
			success : function(data) {
				wx.config({
				    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
				    appId: data.wxid, // 必填，公众号的唯一标识
				    timestamp: data.timestamp, // 必填，生成签名的时间戳
				    nonceStr: data.nonceStr, // 必填，生成签名的随机串
				    signature: data.signature,// 必填，签名，见附录1
				    jsApiList: ['closeWindow','chooseImage','previewImage','uploadImage','downloadImage'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
				});
			}
	});
	
	$("#x11").click(function(){
		$("#x11").attr("checked","checked");
		$("#x12").removeAttr("checked");
	});
	$("#x12").click(function(){
		$("#x12").attr("checked","checked");
		$("#x11").removeAttr("checked");
	});
})
wx.ready(function () {

// 5 图片接口
  // 5.1 拍照、本地选图
  var images = {
    localId: [],
    serverId: []
  };
  document.querySelector('#chooseImage').onclick = function () {
    wx.chooseImage({
      count: maxsum-$('.weui_uploader_file').length, // 默认9
      success: function (res) {
        if ((res.localIds.length+$('.weui_uploader_file').length)>9) {
			alert("最多上传"+maxsum+"张图片");
			return;
		}
        for(var i =0;i<res.localIds.length;i++){
        images.localId.push(res.localIds[i])
       		// 循环将所选择的照片插入到预览区  
       	  var lid ="li"+liids;
       	  liids++;
          var $preview = $('<li id="'+ lid +'" onclick="ckli(this)" class="weui_uploader_file weui_uploader_status" style="background-image:url(' + res.localIds[i] + ')"><div class="weui_uploader_status_content"><img src="${basePath}weui/dist/example/images/icon_err_msg.png"></div></li>');  
          $('.weui_uploader_files').append($preview);  
          var num = $('.weui_uploader_file').length;
          $('.js_counter').text(num + '/' + maxsum);
        }
        /**
         var progress = 0;  
          function uploading() {  
              $('.weui_uploader_files').find('.weui_uploader_status_content').text(++progress + '%');  
              if (progress < 100) {  
                  setTimeout(uploading, 20);  
              }  
              else {  
                  // 如果是失败，塞一个失败图标  
                  //$preview.find('.weui_uploader_status_content').html('');  
                  $('.weui_uploader_files li').removeClass('weui_uploader_status').find('.weui_uploader_status_content').remove();  
              }  
          }  
          setTimeout(uploading, 20);  */
      }
    });
    
    	
     
  };
  // 5.3 上传图片
  /**
  document.querySelector('#uploadImage').onclick = function () {
  	if ($("#uploadImage").hasClass("weui_btn_disabled")) {//判断按钮状态
		return;
	}
	
  	$("#uploadImage").addClass("weui_btn_disabled");//标记按钮已被点击

  	if ($("#relName").val()=="") {//真实姓名验证
		alert("请输入真实姓名");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	
	if ($("#identity").val()=="") {//手机号验证
		alert("请输入身份证号");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}else if ($("#identity").val().length !=15 && $("#identity").val().length !=18 ) {
		alert("请输入正确的身份证号");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
  	
  	
  	if ($("#mobilePhone").val()=="" || $("#mobilePhone").val().length!=11) {//手机号验证
		alert("请输入正确的手机号");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#date").val()=="") {//日期验证
		alert("请输入日期");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#dateTime").val()=="" ) {//时间验证
		alert("请输入时间");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
  	var marriage;
  	if ($("#x11").attr("checked")) {//婚姻状况验证
		marriage = "y";
	}else if ($("#x12").attr("checked")) {
		marriage = "n";
	}else {
		alert("请选择婚姻状况");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	
  	
    if (images.localId.length == 0) {//判断是否有选择图片
      alert('请先选择要上传的图片');
      $("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
      return;
    }
    
    var delids1 = delids.split(",");
    for(var i =0;i<delids1.length;i++){
    	for(var j =i+1;j<delids1.length;j++){
    		if (delids1[i]<delids1[j]) {
				var temp = delids1[i];
				delids1[i] = delids1[j];
				delids1[j] = temp;
			}
    	}
    }
    for(var i =0;i<delids1.length;i++){
    	images.localId.splice(delids1[i],1);
    }
    var i = 0, length = images.localId.length;
    images.serverId = [];
    function upload() {
      wx.uploadImage({
        localId: images.localId[i],
        success: function (res) {
        $("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
	        i++;
	        images.serverId.push(res.serverId);
	        $(".weui_uploader_files li:eq("+(i-1)+")").removeClass('weui_uploader_status').find('.weui_uploader_status_content').remove();
	        if (i < length) {
	        	upload();
	        }else {
				$.ajax({
					url : "${basePath}imgsctp?serverIds="+images.serverId+"&marriage="+marriage,
					data : $("form").serialize(),
					type : "post",
					async : false,
					dataType : "json",
					success : function(data) {
						if (data.status == "SUCCESS") {
							//if (confirm("已成功上传"+data.resultData.sum+"张图片，是否预览确认？")) {
								//var src = data.resultData.srcs;
								//var imgsrcs = src.split(",");
								//var srcurl;
								//for(var i = 0;i<imgsrcs.length ; i++){
								//	imgsrcs[i] = '${basePath}'+imgsrcs[i];
								//}
								//wx.previewImage({
							      //current: imgsrcs[0],
							      //urls: imgsrcs
							    //});
							//}else {
								//wx.closeWindow();
							//}
							alert("恭喜您，已成功上传"+data.resultData.sum+"张图片，我们将会在3个工作日内完成审核。");
							wx.closeWindow();
						} else {
							alert(data.message);
							$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
						}
					}
				});
			}
        },
        fail: function (res) {
          alert(JSON.stringify(res));
        }
      });
    }
    upload();
  };
  
*/
});
wx.error(function (res) {
  alert("错误"+res.errMsg);
});
function tj(){
	if ($("#uploadImage").hasClass("weui_btn_disabled")) {//判断按钮状态
		return;
	}
  	$("#uploadImage").addClass("weui_btn_disabled");//标记按钮已被点击

  	if ($("#relName").val()=="") {//真实姓名验证
		alert("请输入客户姓名");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#mobilePhone").val()=="") {
		alert("请输入手机号");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#email").val()=="") {
		alert("请输入邮箱");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#address").val()=="") {
		alert("请输入联系地址");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#loanMoney").val()=="") {
		alert("请输入贷款金额");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#loanTerm").val()=="") {
		alert("请输入贷款期限");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#loanPurpose").val()=="") {//真实姓名验证
		alert("请输入借款用途");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#loanPurpose").val()=="") {//真实姓名验证
		alert("请输入借款用途");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	if ($("#repaySource").val()=="") {//真实姓名验证
		alert("请输入还款来源");
		$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
		return;
	}
	var cusType;
  	if ($("#x11").attr("checked")) {//客户类型
		cusType = "个人";
	}else if ($("#x12").attr("checked")) {
		cusType = "企业";
	}
	$.ajax({
		url : "${basePath}imgsctp?cusType="+cusType,
		data : $("form").serialize(),
		type : "post",
		async : false,
		dataType : "json",
		success : function(data) {
			if (data.status == "SUCCESS") {
				alert("恭喜您，已成功提交贷款申请，我们将会在3个工作日内审核并与您联系。");
				wx.closeWindow();
			} else {
				alert(data.message);
				$("#uploadImage").removeClass("weui_btn_disabled");//释放按钮
			}
		}
	});
}





var imgthis;
var delids="";
function ckli(obj){
	imgthis = obj;
	$("#dialog1").show();
}

function hidedialog1(){
	$("#dialog1").hide();
}

function succdialog1(){
	$("#dialog1").hide();
	if (delids != "") {
		delids = delids+",";
	}
	delids = delids + $(imgthis).attr("id").substring("2");
	$(imgthis).remove();
	var num = $('.weui_uploader_file').length;
    $('.js_counter').text(num + '/' + maxsum);
    
}
</script>
  
</html>