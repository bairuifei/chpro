<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>船舶信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="chShipController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${chShipPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户:
						</label>
					</td>
					<td class="value" colspan="3">
						<input id="shipClientId" name="shipClientId" type="hidden" value=""/>
						<input name="shipClientName" class="inputxt" value="" id="shipClientName" readonly="readonly" datatype="*"/>
						<t:choose hiddenName="shipClientId" inputTextname="shipClientName" hiddenid="id"
								  textname="clientName" url="chClientController.do?choose" name="chClientList"
								  icon="icon-search" title="选择操作标签" isclear="true" isInit="true"></t:choose>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">用户</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							船名:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipName" name="shipName" type="text" maxlength="100" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船名</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							船舶载重吨:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipZaizhong" name="shipZaizhong" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="checked" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船舶载重吨</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							建造日期:
						</label>
					</td>
					<td class="value">
							   <input id="shipBuildtime" name="shipBuildtime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" />    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">建造日期</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							满载吃水:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipWater" name="shipWater" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">满载吃水</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							船长:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipLength" name="shipLength" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船长</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							船宽:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipWidth" name="shipWidth" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船宽</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							船高:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipHigh" name="shipHigh" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船高</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							舱口数量:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipCangCount" name="shipCangCount" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">舱口数量</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							舱口长:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipCangLength" name="shipCangLength" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">舱口长</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							舱口宽:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipCangWidth" name="shipCangWidth" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">舱口宽</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							舱口深:
						</label>
					</td>
					<td class="value">
					     	 <input id="shipCangDeep" name="shipCangDeep" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">舱口深</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							驾驶舱位置:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="shipDriveLocation" type="list"  typeGroupCode="jiashicang"  defaultVal="${chShipPage.shipDriveLocation}" hasLabel="false"  title="驾驶舱位置" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶舱位置</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							封舱设备:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="shipFengDevice" type="list"  typeGroupCode="fengcang"  defaultVal="${chShipPage.shipFengDevice}" hasLabel="false"  title="封舱设备" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">封舱设备</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							打孔:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="shipDakong" type="list"  typeGroupCode="dakong"  defaultVal="${chShipPage.shipDakong}" hasLabel="false"  title="打孔" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">打孔</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							水尺:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="shipShuichi" type="list"  typeGroupCode="shuichi"  defaultVal="${chShipPage.shipShuichi}" hasLabel="false"  title="水尺" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">水尺</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							认证图片:
						</label>
					</td>
					<td class="value">
						<div class="form jeecgDetail">
							<t:webUploader name="shipAuditImg" displayTxt="false" auto="true" buttonText="选择图片" buttonStyle="btn-blue btn-S" type="image" fileNumLimit="1"></t:webUploader>
						</div>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">认证图片</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								经度:
							</label>
						</td>
						<td class="value">
							<input id="shipLong" name="shipLong" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">经度</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								纬度:
							</label>
						</td>
						<td class="value">
							<input id="shipLat" name="shipLat" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="*"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">纬度</label>
						</td>
					</tr>

				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value"  colspan="3" >
						  	 <textarea style="width:600px;" class="inputxt" rows="6" id="shipNote" name="shipNote"  ignore="ignore" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/ship/chShip.js"></script>		
