<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>客户关系</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="chClientRelateController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${chClientRelatePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								客户id:
							</label>
						</td>
						<td class="value">
							<input id="clientId" name="clientId" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*"  ignore="checked"  value='${chClientRelatePage.clientId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">客户id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								关系客户id:
							</label>
						</td>
						<td class="value">
							<input id="relateId" name="relateId" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*"  ignore="checked"  value='${chClientRelatePage.relateId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">关系客户id</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								关系类型:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="type" type="list"  datatype="*"  typeGroupCode=""   defaultVal="${chClientRelatePage.type}" hasLabel="false"  title="关系类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">关系类型</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/jeecg/relate/chClientRelate.js"></script>		
