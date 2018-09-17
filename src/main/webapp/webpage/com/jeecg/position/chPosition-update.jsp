<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>地点</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="chPositionController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${chPositionPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								名称:
							</label>
						</td>
						<td class="value">
						    <input id="positionName" name="positionName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${chPositionPage.positionName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								所属省份:
							</label>
						</td>
						<td class="value">
							<input id="provinceId" name="provinceId" type="hidden" value="${chPositionPage.provinceId}"/>
							<input name="provinceName" class="inputxt" value="${chPositionPage.provinceName}" id="provinceName" readonly="readonly" datatype="*"/>
							<t:choose hiddenName="provinceId" inputTextname="provinceName" hiddenid="id"
									  textname="provinceName" url="chProvinceController.do?choose" name="chProvinceList"
									  icon="icon-search" title="选择操作标签" isclear="true" isInit="true"></t:choose>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/position/chPosition.js"></script>		
