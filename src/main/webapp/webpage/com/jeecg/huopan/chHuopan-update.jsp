<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>货盘</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="chHuopanController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${chHuopan.id}"/>
		<div class="row">
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					装货港：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="huopanBegin" defaultVal = "${chHuopan.huopanBegin}" type="select" hasLabel="false" title="装货港" extendJson="{class:'form-control'}"   typeGroupCode="" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					装货港码头：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanBeginPort" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanBeginPort}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					卸货港：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="huopanEnd" defaultVal = "${chHuopan.huopanEnd}" type="select" hasLabel="false" title="卸货港" extendJson="{class:'form-control'}"   typeGroupCode="" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					卸货港码头：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanEndPort" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanEndPort}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					装货日期：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanDate" type="text" class="form-control input-sm laydate-date" value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${chHuopan.huopanDate}'/>"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					装货日期误差：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanDateWucha" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanDateWucha}"  datatype="n"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					货物名称：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanName" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanName}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					货量：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanCount" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanCount}"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					备注：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanNote" type="text" class="form-control" maxlength="200" value = "${chHuopan.huopanNote}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					空船范围：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipPosition" type="text" class="form-control" maxlength="200" value = "${chHuopan.huopanShipPosition}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船舶载重吨最小：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipZaizhongMin" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipZaizhongMin}"  datatype="n"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船舶载重吨最大：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipZaizhongMax" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipZaizhongMax}"  datatype="n"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船舶数量：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipCount" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipCount}"  datatype="n"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					封舱：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="huopanShipFengcang" defaultVal = "${chHuopan.huopanShipFengcang}" type="select" hasLabel="false" title="封舱" extendJson="{class:'form-control'}"   typeGroupCode="" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					水尺：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="huopanShipShuichi" defaultVal = "${chHuopan.huopanShipShuichi}" type="select" hasLabel="false" title="水尺" extendJson="{class:'form-control'}"   typeGroupCode="" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					驾驶舱位置：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="huopanShipDriveLocation" defaultVal = "${chHuopan.huopanShipDriveLocation}" type="select" hasLabel="false" title="驾驶舱位置" extendJson="{class:'form-control'}"   typeGroupCode="" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船口结构：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="huopanShipChuankou" defaultVal = "${chHuopan.huopanShipChuankou}" type="select" hasLabel="false" title="船口结构" extendJson="{class:'form-control'}"   typeGroupCode="" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					打孔：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="huopanShipDakong" defaultVal = "${chHuopan.huopanShipDakong}" type="select" hasLabel="false" title="打孔" extendJson="{class:'form-control'}"   typeGroupCode="" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					吃水：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipChishui" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipChishui}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船长：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipLength" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipLength}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船宽：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipWidth" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipWidth}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船高：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipHigh" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipHigh}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					舱口长：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipCangLength" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipCangLength}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					舱口宽：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipCangWidth" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipCangWidth}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					舱口深：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanShipCangDeep" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanShipCangDeep}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					运价：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanFeeYun" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanFeeYun}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					开航费：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanFeeKaihang" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanFeeKaihang}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					滞期费：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanFeeZhiqi" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanFeeZhiqi}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					两港装卸时间：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanFeeLoadtime" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanFeeLoadtime}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					结算方式：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanFeeJstype" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanFeeJstype}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					付款方式：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="huopanFeePaytype" type="text" class="form-control" maxlength="32" value = "${chHuopan.huopanFeePaytype}"  ignore="ignore"  />
				</div>
			</div>
		</div>
		</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	$(".laydate-datetime").each(function(){
		var _this = this;
		laydate.render({
		  elem: _this,
		  format: 'yyyy-MM-dd HH:mm:ss',
		  type: 'datetime',
		  ready: function(date){
		  	 $(_this).val(DateJsonFormat(date,this.format));
		  }
		});
	});
	$(".laydate-date").each(function(){
		var _this = this;
		laydate.render({
		  elem: _this,
		  format: 'yyyy-MM-dd',
		  ready: function(date){
		  	 $(_this).val(DateJsonFormat(date,this.format));
		  }
		});
	});
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