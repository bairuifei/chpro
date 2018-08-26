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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="chShipDateController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${chShipDatePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							船名:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipName" name="shipName" type="text" maxlength="200" style="width: 150px" class="inputxt"  ignore="ignore" />
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
					     	 <input id="shipZaizhong" name="shipZaizhong" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
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
							   <input id="shipEmptyDate" name="shipEmptyDate" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
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
					     	 <input id="shipEmptyDateCha" name="shipEmptyDateCha" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
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
		<div class="form jeecgDetail">
			<t:webUploader name="shipImg" displayTxt="false" auto="true" buttonText="选择图片" buttonStyle="btn-blue btn-S" type="image" fileNumLimit="1"></t:webUploader>
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
						<input id="shipFromPort" name="shipFromPort" type="hidden" value=""/>
						<input name="chooseText" class="inputxt" value="" id="chooseText" readonly="readonly" datatype="*"/>
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
						<input id="shipToPorts" name="shipToPorts" type="hidden" value=""/>
						<input name="chooseText1" class="inputxt" value="" id="chooseText1" readonly="readonly" datatype="*"/>
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
						<input id="shipStayPorts" name="shipStayPorts" type="hidden" value=""/>
						<input name="chooseText2" class="inputxt" value="" id="chooseText2" readonly="readonly" datatype="*"/>
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
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="shipNote" name="shipNote"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/shipdate/chShipDate.js"></script>		
	  	<script type="text/javascript">
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
