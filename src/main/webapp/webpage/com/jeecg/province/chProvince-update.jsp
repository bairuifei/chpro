<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>省份</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="chProvinceController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${chProvincePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								省份名称:
							</label>
						</td>
						<td class="value">
						    <input id="provinceName" name="provinceName" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="*"  ignore="checked"  value='${chProvincePage.provinceName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">省份名称</label>
						</td>
					</tr>

			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/province/chProvince.js"></script>		
