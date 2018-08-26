<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>船期</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
	<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="chShipDateController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${chShipDatePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								船名:
							</label>
						</td>
						<td class="value">
						    <input id="shipName" name="shipName" type="text" maxlength="200" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chShipDatePage.shipName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船名</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								载重吨数:
							</label>
						</td>
						<td class="value">
						    <input id="shipZaizhong" name="shipZaizhong" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${chShipDatePage.shipZaizhong}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">载重吨数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								空船日期:
							</label>
						</td>
						<td class="value">
									  <input id="shipEmptyDate" name="shipEmptyDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${chShipDatePage.shipEmptyDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">空船日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								日期偏移天数:
							</label>
						</td>
						<td class="value">
						    <input id="shipEmptyDateCha" name="shipEmptyDateCha" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${chShipDatePage.shipEmptyDateCha}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日期偏移天数</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								船图片:
							</label>
						</td>
						<td class="value">
		<table id="ship_img_fileTable"></table>
		<div class="form jeecgDetail">
			<t:webUploader name="shipImg" displayTxt="false" auto="true" buttonText="选择图片" buttonStyle="btn-blue btn-S" type="image" fileNumLimit="1" pathValues="${chShipDatePage.shipImg}"></t:webUploader>
		</div>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船图片</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								空船港:
							</label>
						</td>
						<td class="value">
							<input id="shipFromPort" name="shipFromPort" type="hidden" value="${chShipDatePage.shipFromPort}"/>
							<input name="chooseText" class="inputxt" value="${chShipDatePage.shipFromPortStr}" id="chooseText" readonly="readonly" datatype="*"/>
							<t:choose hiddenName="shipFromPort" inputTextname="chooseText" hiddenid="id"
									  textname="positionName" url="chPositionController.do?choose" name="chPositionList"
									  icon="icon-search" title="选择操作标签" isclear="true" isInit="true"></t:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								目的港:
							</label>
						</td>
						<td class="value">
							<input id="shipToPorts" name="shipToPorts" type="hidden" value="${chShipDatePage.shipToPorts}"/>
							<input name="chooseText1" class="inputxt" value="${chShipDatePage.shipToPortsStr}" id="chooseText1" readonly="readonly" datatype="*"/>
							<t:choose hiddenName="shipToPorts" inputTextname="chooseText1" hiddenid="id"
									  textname="positionName" url="chPositionController.do?choose" name="chPositionList"
									  icon="icon-search" title="选择操作标签" isclear="true" isInit="true"></t:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备用装货港:
							</label>
						</td>
						<td class="value">
							<input id="shipStayPorts" name="shipStayPorts" type="hidden" value="${chShipDatePage.shipStayPorts}"/>
							<input name="chooseText2" class="inputxt" value="${chShipDatePage.shipStayPortsStr}" id="chooseText2" readonly="readonly" datatype="*"/>
							<t:choose hiddenName="shipStayPorts" inputTextname="chooseText2" hiddenid="id"
									  textname="positionName" url="chPositionController.do?choose" name="chPositionList"
									  icon="icon-search" title="选择操作标签" isclear="true" isInit="true"></t:choose>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="shipNote" style="width:600px;" class="inputxt" rows="6" name="shipNote"  ignore="ignore" >${chShipDatePage.shipNote}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/shipdate/chShipDate.js"></script>		
	  	<script type="text/javascript">
		  	//加载 已存在的 文件
		  	$(function(){
	  			var cgFormId=$("input[name='id']").val();
		  		$.ajax({
		  		   type: "post",
		  		   url: "chShipDateController.do?getFiles&id=" +  cgFormId,
		  		   success: function(data){
		  			 var arrayFileObj = jQuery.parseJSON(data).obj;
		  			 
		  			$.each(arrayFileObj,function(n,file){
		  				var fieldName = file.field.toLowerCase();
		  				var table = $("#"+fieldName+"_fileTable");
		  				var tr = $("<tr style=\"height:34px;\"></tr>");
		  				var title = file.title;
		  				if(title.length > 15){
		  					title = title.substring(0,12) + "...";
		  				}
		  				var td_title = $("<td>" + title + "</td>");
		  		  		var td_download = $("<td><a style=\"margin-left:10px;\" href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
		  		  		var td_view = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
		  		  		tr.appendTo(table);
		  		  		td_title.appendTo(tr);
		  		  		td_download.appendTo(tr);
		  		  		td_view.appendTo(tr);
		  		  		if(location.href.indexOf("load=detail")==-1){
			  		  		var td_del = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
			  		  		td_del.appendTo(tr);
		  		  		}
		  			 });
		  		   }
		  		});
		  	});
		  	
		  	/**
		 	 * 删除图片数据资源
		 	 */
		  	function del(url,obj){
		  		var content = "请问是否要删除该资源";
		  		var navigatorName = "Microsoft Internet Explorer"; 
		  		if( navigator.appName == navigatorName ){ 
		  			$.dialog.confirm(content, function(){
		  				submit(url,obj);
		  			}, function(){
		  			});
		  		}else{
		  			layer.open({
						title:"提示",
						content:content,
						icon:7,
						yes:function(index){
							submit(url,obj);
						},
						btn:['确定','取消'],
						btn2:function(index){
							layer.close(index);
						}
					});
		  		}
		  	}
		  	
		  	function submit(url,obj){
		  		$.ajax({
		  			async : false,
		  			cache : false,
		  			type : 'POST',
		  			url : url,// 请求的action路径
		  			error : function() {// 请求失败处理函数
		  			},
		  			success : function(data) {
		  				var d = $.parseJSON(data);
		  				if (d.success) {
		  					var msg = d.msg;
		  					tip(msg);
		  					obj.parentNode.parentNode.parentNode.deleteRow(obj.parentNode.parentNode);
		  				} else {
		  					tip(d.msg);
		  				}
		  			}
		  		});
		  	}
		  	
	  		function jeecgFormFileCallBack(data){
	  			if (data.success == true) {
					uploadFile(data);
				} else {
					if (data.responseText == '' || data.responseText == undefined) {
						$.messager.alert('错误', data.msg);
						$.Hidemsg();
					} else {
						try {
							var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
							$.messager.alert('错误', emsg);
							$.Hidemsg();
						} catch(ex) {
							$.messager.alert('错误', data.responseText + '');
						}
					}
					return false;
				}
				if (!neibuClickFlag) {
					var win = frameElement.api.opener;
					win.reloadTable();
				}
	  		}
	  		function upload() {
					$('#shipImg').uploadify('upload', '*');	
			}
			
			var neibuClickFlag = false;
			function neibuClick() {
				neibuClickFlag = true; 
				$('#btn_sub').trigger('click');
			}
			function cancel() {
					$('#shipImg').uploadify('cancel', '*');	
			}
			function uploadFile(data){
				if(!$("input[name='id']").val()){
					if(data.obj!=null && data.obj!='undefined'){
						$("input[name='id']").val(data.obj.id);
					}
				}
				if($(".uploadify-queue-item").length>0){
					upload();
				}else{
					if (neibuClickFlag){
						alert(data.msg);
						neibuClickFlag = false;
					}else {
						var win = frameElement.api.opener;
						win.reloadTable();
						win.tip(data.msg);
						frameElement.api.close();
					}
				}
			}
	  	</script>
