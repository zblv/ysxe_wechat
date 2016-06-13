<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/taglib.jsp"%>
  <!-- / jquery file upload -->
<link href='${basePath}assets/stylesheets/plugins/jquery_fileupload/jquery.fileupload-ui.css' media='all' rel='stylesheet' type='text/css' />
<div id="hiddenUploadDiv" style="display:none;">
  <div class='row-fluid'>
    <div class='span12 box'>
        <div class='box-header'>
            <div class='title'>
                <i class='icon-file'></i>
                	${param.title }
            </div>
            <div class="actions">
				<a href="javascript:void(0);" class="btn btn-warning" onclick="layer.closeAll('page');return false;";> 
				<i class="icon-remove-sign">&nbsp;关&nbsp;&nbsp;闭</i>
				</a>
			</div>
        </div>
        <div class='box-content'>
            <form action='${basePath}${param.uploadUrl}' enctype='multipart/form-data' id='fileupload' method='POST' />
                <div class='row-fluid fileupload-buttonbar'>
                    <div class='span7'>
					   <span class='btn btn-success fileinput-button'>
					     <i class='icon-plus icon-white'></i>
					     <span>添加文件...</span>
					     <input data-bfi-disabled='' multiple='' name='files' type='file' />
					   </span>
                        <button class='btn btn-primary start' type='submit'>
                            <i class='icon-upload icon-white'></i>
                            <span>开始上传</span>
                        </button>
                        <button class='btn btn-warning cancel' type='reset'>
                            <i class='icon-ban-circle icon-white'></i>
                            <span>取消上传</span>
                        </button>
                    </div>
                    <div class='span5 fileupload-progress fade'>
                        <div aria-valuemax='100' aria-valuemin='0' class='progress progress-success progress-striped active' role='progressbar'>
                            <div class='bar' style='width:0%;'></div>
                        </div>
                        <div class='progress-extended'> </div>
                    </div>
                </div>
                <div class='fileupload-loading'></div>
                <br />
                <div style="height:200px;overflow:auto;">
	                <table class='table table-striped' role='presentation'>
	                    <tbody class='files' data-target='#modal-gallery' data-toggle='modal-gallery'></tbody>
	                </table>
                </div>
            </form>
	        <hr class="hr-normal">
	        <strong style="margin-bottom:10px">导入消息:</strong>
	        <div id="uploadMsg" style="height:90px;overflow:auto;">
			</div>
        </div>
        
    </div>
 </div>
</div>
<script id="template-upload" type="text/x-tmpl">
  {% for (var i=0, file; file=o.files[i]; i++) { %}
    <tr class="template-upload fade">
		<td class="preview"><span class="fade"></span></td>
        <td class="name"><span>{%=file.name%}</span></td>
        <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
        {% if (file.error) { %}
          <td class="error" colspan="2"><span class="label label-important">Error</span> {%=file.error%}</td>
        {% } else if (o.files.valid && !i) { %}
        <td>
           <div class="progress progress-success progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100" aria-valuenow="0"><div class="bar" style="width:0%;"></div></div>
        </td>
        <td>
			{% if (!o.options.autoUpload) { %}
            <button class="btn btn-primary start">
				<i class="icon-upload icon-white"></i>
                <span>导入</span>
            </button>
        	{% } %}
		</td>
         {% } else { %}
          <td colspan="2"></td>
         {% } %}
        <td>{% if (!i) { %}
             <button class="btn btn-warning cancel">
              <i class="icon-ban-circle icon-white"></i>
                 <span>取消</span>
                 </button>
         {% } %}</td>
    </tr>
	{% } %}
</script>
    <script id="template-download" type="text/x-tmpl">
                    {% for (var i=0, file; file=o.files[i]; i++) { %}
                    <tr class="template-download fade">
                        {% if (file.error) { %}
                        <td></td>
                        <td class="name"><span>{%=file.name%}</span></td>
                        <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
                        <td class="error" colspan="2"><span class="label label-important">Error</span> {%=file.error%}</td>
                        {% } else { %}
                        <td class="preview">{% if (file.thumbnail_url) { %}
                            <a href="{%=file.url%}" title="{%=file.name%}" data-gallery="gallery" download="{%=file.name%}"><img src="{%=file.thumbnail_url%}"></a>
                            {% } %}</td>
                        <td class="name">
                            <a href="{%=file.url%}" title="{%=file.name%}" data-gallery="{%=file.thumbnail_url&&'gallery'%}" download="{%=file.name%}">{%=file.name%}</a>
                        </td>
                        <td class="size"><span>{%=o.formatFileSize(file.size)%}</span></td>
                        <td colspan="2"></td>
                        {% } %}
                        <td>
                            <button class="btn btn-danger delete" data-type="{%=file.delete_type%}" data-url="{%=file.delete_url%}"{% if (file.delete_with_credentials) { %} data-xhr-fields='{"withCredentials":true}'{% } %}>
                            <i class="icon-trash icon-white"></i>
                            <span>Delete</span>
                            </button>
                            <input type="checkbox" name="delete" value="1" class="toggle">
                        </td>
                    </tr>
                    {% } %}
                </script>
<script src='${basePath}assets/javascripts/plugins/fileupload/tmpl.min.js' type='text/javascript'></script>
<script src='${basePath}assets/javascripts/plugins/fileupload/load-image.min.js' type='text/javascript'></script>
<script src='${basePath}assets/javascripts/plugins/fileupload/canvas-to-blob.min.js' type='text/javascript'></script>
<script src='${basePath}assets/javascripts/plugins/fileupload/jquery.iframe-transport.min.js' type='text/javascript'></script>
<script src='${basePath}assets/javascripts/plugins/fileupload/jquery.fileupload.min.js' type='text/javascript'></script>
<script src='${basePath}assets/javascripts/plugins/fileupload/jquery.fileupload-fp.min.js' type='text/javascript'></script>
<script src='${basePath}assets/javascripts/plugins/fileupload/jquery.fileupload-ui.min.js' type='text/javascript'></script>
<script src='${basePath}assets/javascripts/plugins/fileupload/jquery.fileupload-init.js' type='text/javascript'></script>