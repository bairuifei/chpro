<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>用户表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,webuploader,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="chClientController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="clientName" class="col-sm-3 control-label">姓名：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="clientName" name="clientName" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入姓名"  datatype="*"  ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="clientSex" class="col-sm-3 control-label">性别：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="clientSex" type="radio" extendJson="{class:'i-checks'}"  typeGroupCode="sex"  hasLabel="false"  title="性别"></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="clientMobile" class="col-sm-3 control-label">手机号码：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="clientMobile" name="clientMobile" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入手机号码"  datatype="m" ignore="checked" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="clientHeadimg" class="col-sm-3 control-label">头像：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
				<t:webUploader name="clientHeadimg" outJs="true" auto="true" showImgDiv="filediv_clientHeadimg" type="image" buttonText='添加图片' displayTxt="false"></t:webUploader>
				<div class="form" id="filediv_clientHeadimg"></div>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="clientRealname" class="col-sm-3 control-label">真实姓名：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="clientRealname" name="clientRealname" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入真实姓名"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="clientCreditid" class="col-sm-3 control-label">身份证号：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="clientCreditid" name="clientCreditid" type="text" maxlength="32" class="form-control input-sm" datatype="/^\d{17}[\d|x]$/" placeholder="请输入身份证号"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="clientVip" class="col-sm-3 control-label">是否VIP：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="clientVip" type="radio" extendJson="{class:'i-checks'}"  typeGroupCode="sf_yn"  hasLabel="false"  title="是否VIP"></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="clientVipend" class="col-sm-3 control-label">VIP截止时间：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
				<input name="clientVipend" type="text" class="form-control laydate-datetime"  ignore="ignore"  />
				<span class="input-group-addon" ><span class="glyphicon glyphicon-calendar"></span></span>
				</div>
			</div>
		</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
//日期时间选择器
laydate.render({
	elem: '.laydate-datetime'
	,type: 'datetime'
});
var subDlgIndex = '';
$(document).ready(function() {
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-blue',
		radioClass : 'iradio_square-blue',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
		
});
</script>
</body>
</html>