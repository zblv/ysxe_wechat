/**
 * author:yangmingli
 * 提供公用的js,以及ajax请求遮罩,ajax Session 超时,jquery公共方法扩展
 */
jQuery.fn.extend({
  loadFormData: function(data) {
	  for(var key in data){
			var currInput = $(this).find(":input[name='"+key+"']");
			if(currInput.length>0){
				currInput = $(currInput[0]);
				if(currInput.is("select")){
					currInput.find("option[value='"+data[key]+"']").prop("selected", true);
				}else{
					currInput.val(data[key]);
				}	
			}
		}
    return true;
  },
  clearFormData: function() {
	  $("#editKindForm").find(":input").each(function(){
			$(this).val("");
	  });
    return true;
  }
});

if(layer !== undefined){
	var layer_index = 0;
	$(document).ajaxStart(function() {
		if(layer_index++ == 0){
			layer.load(1);
		}
	});
	
	$(document).ajaxStop(function() {
		if(layer_index -- == 1){
			layer.closeAll("loading");
		}
	});
	
	window.alert = function(msg){
		layer.msg(msg);
	}
}

$.ajaxSetup({
    contentType:"application/x-www-form-urlencoded;charset=utf-8",
        complete:function(xrt,ts){
        	var data = null;
        	try{
        		data = $.parseJSON(xrt.responseText);
        	}catch(e){
        	}
        	if(data){
        		if(data.invalidSession){
        			top.location.href = data.loginUrl; 
        		}
        	}
        }
 });

function exportFile(url,data){
	var exportIframe = document.createElement('iframe');
	exportIframe.style.display = "none";
	if(data){
		var form = $("<form action='"+url+"' method='post'></form>");
		for(var key in data){
			form.append("<input type='hidden' name='"+key+"' value='"+data[key]+"' />");
		}
		document.body.appendChild(exportIframe);
		$(exportIframe).append(form);
		$(form).submit();
	}else{
		exportIframe.src = url;
		document.body.appendChild(exportIframe);
	}
}