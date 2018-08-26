<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chShipDateList" checkbox="true" pagination="true" fitColumns="true" title="船期" sortName="createDate" actionUrl="chShipDateController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="船ID"  field="shipId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船名"  field="shipName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="载重吨数"  field="shipZaizhong"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="空船日期"  field="shipEmptyDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="日期偏移天数"  field="shipEmptyDateCha"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船图片"  field="shipImg"  queryMode="single"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="空船港"  field="shipFromPortStr"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="目的港"  field="shipToPortsStr"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="shipNote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用装货港"  field="shipStayPortsStr"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="chShipDateController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="chShipDateController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="chShipDateController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="chShipDateController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="chShipDateController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/shipdate/chShipDateList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'chShipDateController.do?upload', "chShipDateList");
}

//导出
function ExportXls() {
	JeecgExcelExport("chShipDateController.do?exportXls","chShipDateList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("chShipDateController.do?exportXlsByT","chShipDateList");
}

 </script>