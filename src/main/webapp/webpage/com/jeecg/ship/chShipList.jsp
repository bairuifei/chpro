<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chShipList" checkbox="true" pagination="true" fitColumns="true" title="船舶信息" sortName="createDate" actionUrl="chShipController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus" hidden="true" queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="船名"  field="shipName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户"  field="shipClientName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船舶载重吨"  field="shipZaizhong"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="建造日期"  field="shipBuildtime"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="满载吃水"  field="shipWater"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船长"  field="shipLength"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船宽"  field="shipWidth"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船高"  field="shipHigh"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="舱口数量"  field="shipCangCount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="舱口长"  field="shipCangLength"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="舱口宽"  field="shipCangWidth"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="舱口深"  field="shipCangDeep"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驾驶舱位置"  field="shipDriveLocation"  query="true" dictionary="jiashicang" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="封舱设备"  field="shipFengDevice"  query="true" dictionary="fengcang" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="打孔"  field="shipDakong"  query="true" dictionary="dakong" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="水尺"  field="shipShuichi"  query="true" dictionary="shuichi"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="shipNote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="经度"  field="shipLong"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="纬度"  field="shipLat"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="认证图片"  field="shipAuditImg"  queryMode="single" image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="shipAudit"  query="true" dictionary="audit" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="chShipController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="chShipController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="chShipController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="chShipController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="chShipController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/ship/chShipList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'chShipController.do?upload', "chShipList");
}

//导出
function ExportXls() {
	JeecgExcelExport("chShipController.do?exportXls","chShipList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("chShipController.do?exportXlsByT","chShipList");
}

 </script>