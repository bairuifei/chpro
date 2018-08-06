<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>船舶信息</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="chShipController.do?doUpdate" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id" value="${chShip.id}"/>
		<div class="row">
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船名：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipName" type="text" class="form-control" maxlength="100" value = "${chShip.shipName}"  datatype="*"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船舶载重吨：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipZaizhong" type="text" class="form-control" maxlength="32" value = "${chShip.shipZaizhong}"  datatype="n"  ignore="checked"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					建造日期：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipBuildtime" type="text" class="form-control input-sm laydate-date" value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${chShip.shipBuildtime}'/>"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					满载吃水：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipWater" type="text" class="form-control" maxlength="32" value = "${chShip.shipWater}"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船长：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipLength" type="text" class="form-control" maxlength="32" value = "${chShip.shipLength}"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船宽：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipWidth" type="text" class="form-control" maxlength="32" value = "${chShip.shipWidth}"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					船高：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipHigh" type="text" class="form-control" maxlength="32" value = "${chShip.shipHigh}"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					舱口数量：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipCangCount" type="text" class="form-control" maxlength="32" value = "${chShip.shipCangCount}"  datatype="n"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					舱口长：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipCangLength" type="text" class="form-control" maxlength="32" value = "${chShip.shipCangLength}"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					舱口宽：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipCangWidth" type="text" class="form-control" maxlength="32" value = "${chShip.shipCangWidth}"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					舱口深：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
					<input name="shipCangDeep" type="text" class="form-control" maxlength="32" value = "${chShip.shipCangDeep}"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  />
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					驾驶舱位置：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="shipDriveLocation" defaultVal = "${chShip.shipDriveLocation}" type="select" hasLabel="false" title="驾驶舱位置" extendJson="{class:'form-control'}"   typeGroupCode="jiashicang" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					封舱设备：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="shipFengDevice" defaultVal = "${chShip.shipFengDevice}" type="select" hasLabel="false" title="封舱设备" extendJson="{class:'form-control'}"   typeGroupCode="fengcang" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					打孔：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="shipDakong" defaultVal = "${chShip.shipDakong}" type="select" hasLabel="false" title="打孔" extendJson="{class:'form-control'}"   typeGroupCode="dakong" ></t:dictSelect>
				</div>
			</div>
		</div>
		<div class="bt-item col-md-6 col-sm-6">
			<div class="row">
				<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
					水尺：
				</div>
				<div class="col-md-9 col-sm-9 col-xs-9 bt-content">
	            	<t:dictSelect field="shipShuichi" defaultVal = "${chShip.shipShuichi}" type="select" hasLabel="false" title="水尺" extendJson="{class:'form-control'}"   typeGroupCode="shuichi" ></t:dictSelect>
				</div>
			</div>
		</div>
					<div class="bt-item col-md-6 col-sm-6">
			        <div class="row">
						<div class="col-md-3 col-sm-3 col-xs-3 bt-label">
							备注：
						</div>
				     <div class="col-md-9 col-sm-9 col-xs-9 bt-content">
						  	 	<textarea name="shipNote" value = "${chShip.shipNote}" class="form-control input-sm" rows="6"  ignore="ignore" ></textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">备注</label>
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