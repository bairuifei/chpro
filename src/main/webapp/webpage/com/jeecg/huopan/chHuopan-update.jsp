<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>货盘</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="chHuopanController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${chHuopanPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								装货港:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="huopanBegin" type="list"  dictTable="ch_position" dictField="id"  dictText="position_name" defaultVal="${chHuopanPage.huopanBegin}" hasLabel="false"  title="装货港" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装货港</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								装货港码头:
							</label>
						</td>
						<td class="value">
						    <input id="huopanBeginPort" name="huopanBeginPort" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanBeginPort}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装货港码头</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								卸货港:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="huopanEnd" type="list"  dictTable="ch_position" dictField="id"  dictText="position_name" defaultVal="${chHuopanPage.huopanEnd}" hasLabel="false"  title="卸货港" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">卸货港</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								卸货港码头:
							</label>
						</td>
						<td class="value">
						    <input id="huopanEndPort" name="huopanEndPort" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanEndPort}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">卸货港码头</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								装货日期:
							</label>
						</td>
						<td class="value">
									  <input id="huopanDate" name="huopanDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${chHuopanPage.huopanDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装货日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								装货日期误差:
							</label>
						</td>
						<td class="value">
						    <input id="huopanDateWucha" name="huopanDateWucha" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${chHuopanPage.huopanDateWucha}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">装货日期误差</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								货物名称:
							</label>
						</td>
						<td class="value">
						    <input id="huopanName" name="huopanName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货物名称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								货量:
							</label>
						</td>
						<td class="value">
						    <input id="huopanCount" name="huopanCount" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value='${chHuopanPage.huopanCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">货量</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="huopanNote" name="huopanNote" type="text" maxlength="200" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanNote}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								空船范围:
							</label>
						</td>
						<td class="value">
							<input id="huopanShipPosition" name="huopanShipPosition" type="hidden" value="${chHuopanPage.huopanShipPosition}"/>
							<input name="chooseText" class="inputxt" value="${chHuopanPage.huopanShipPositionStr}" id="chooseText" readonly="readonly" datatype="*"/>
							<t:choose hiddenName="huopanShipPosition" inputTextname="chooseText" hiddenid="id"
									  textname="positionName" url="chPositionController.do?choose" name="chPositionList"
									  icon="icon-search" title="选择操作标签" isclear="true" isInit="true"></t:choose>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								船舶载重吨最小:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipZaizhongMin" name="huopanShipZaizhongMin" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${chHuopanPage.huopanShipZaizhongMin}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船舶载重吨最小</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								船舶载重吨最大:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipZaizhongMax" name="huopanShipZaizhongMax" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${chHuopanPage.huopanShipZaizhongMax}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船舶载重吨最大</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								船舶数量:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipCount" name="huopanShipCount" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore"  value='${chHuopanPage.huopanShipCount}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船舶数量</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								封舱:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="huopanShipFengcang" type="list"  typeGroupCode="fengcang"   defaultVal="${chHuopanPage.huopanShipFengcang}" hasLabel="false"  title="封舱" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">封舱</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								水尺:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="huopanShipShuichi" type="list"  typeGroupCode="shuichi"   defaultVal="${chHuopanPage.huopanShipShuichi}" hasLabel="false"  title="水尺" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">水尺</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								驾驶舱位置:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="huopanShipDriveLocation" type="list"  typeGroupCode="jiashicang"   defaultVal="${chHuopanPage.huopanShipDriveLocation}" hasLabel="false"  title="驾驶舱位置" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">驾驶舱位置</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								船口结构:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="huopanShipChuankou" type="list"  typeGroupCode="cangkou"   defaultVal="${chHuopanPage.huopanShipChuankou}" hasLabel="false"  title="船口结构" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船口结构</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								打孔:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="huopanShipDakong" type="list"  typeGroupCode="dakong"   defaultVal="${chHuopanPage.huopanShipDakong}" hasLabel="false"  title="打孔" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">打孔</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								吃水:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipChishui" name="huopanShipChishui" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanShipChishui}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">吃水</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								船长:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipLength" name="huopanShipLength" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanShipLength}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船长</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								船宽:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipWidth" name="huopanShipWidth" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanShipWidth}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船宽</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								船高:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipHigh" name="huopanShipHigh" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanShipHigh}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">船高</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								舱口长:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipCangLength" name="huopanShipCangLength" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanShipCangLength}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">舱口长</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								舱口宽:
							</label>
						</td>
						<td class="value">
						    <input id="huopanShipCangWidth" name="huopanShipCangWidth" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanShipCangWidth}'/>
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
						    <input id="huopanShipCangDeep" name="huopanShipCangDeep" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanShipCangDeep}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">舱口深</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								运价:
							</label>
						</td>
						<td class="value">
						    <input id="huopanFeeYun" name="huopanFeeYun" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanFeeYun}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">运价</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								开航费:
							</label>
						</td>
						<td class="value">
						    <input id="huopanFeeKaihang" name="huopanFeeKaihang" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanFeeKaihang}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开航费</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								滞期费:
							</label>
						</td>
						<td class="value">
						    <input id="huopanFeeZhiqi" name="huopanFeeZhiqi" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanFeeZhiqi}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">滞期费</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								两港装卸时间:
							</label>
						</td>
						<td class="value">
						    <input id="huopanFeeLoadtime" name="huopanFeeLoadtime" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanFeeLoadtime}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">两港装卸时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								结算方式:
							</label>
						</td>
						<td class="value">
						    <input id="huopanFeeJstype" name="huopanFeeJstype" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanFeeJstype}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">结算方式</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								付款方式:
							</label>
						</td>
						<td class="value">
						    <input id="huopanFeePaytype" name="huopanFeePaytype" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chHuopanPage.huopanFeePaytype}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">付款方式</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/huopan/chHuopan.js"></script>		
