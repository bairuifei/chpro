<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chHuopanList" checkbox="true" pagination="true" fitColumns="true" title="货盘" sortName="createDate" actionUrl="chHuopanController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="装货港"  field="huopanBegin"  query="true"  dictionary="ch_position,id,position_name" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装货港码头"  field="huopanBeginPort"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="卸货港"  field="huopanEnd"  query="true" dictionary="ch_position,id,position_name" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="卸货港码头"  field="huopanEndPort"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="装货日期"  field="huopanDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="装货日期误差"  field="huopanDateWucha"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货物名称"  field="huopanName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货量"  field="huopanCount"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="huopanNote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="空船范围"  field="huopanShipPosition"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船舶载重吨最小"  field="huopanShipZaizhongMin"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="船舶载重吨最大"  field="huopanShipZaizhongMax"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="船舶数量"  field="huopanShipCount"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="封舱"  field="huopanShipFengcang"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="水尺"  field="huopanShipShuichi"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="驾驶舱位置"  field="huopanShipDriveLocation"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船口结构"  field="huopanShipChuankou"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="打孔"  field="huopanShipDakong"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="吃水"  field="huopanShipChishui"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船长"  field="huopanShipLength"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船宽"  field="huopanShipWidth"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="船高"  field="huopanShipHigh"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="舱口长"  field="huopanShipCangLength"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="舱口宽"  field="huopanShipCangWidth"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="舱口深"  field="huopanShipCangDeep"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="运价"  field="huopanFeeYun"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="开航费"  field="huopanFeeKaihang"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="滞期费"  field="huopanFeeZhiqi"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="两港装卸时间"  field="huopanFeeLoadtime"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="结算方式"  field="huopanFeeJstype"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="付款方式"  field="huopanFeePaytype"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="huopanAudit"  query="true" dictionary="audit"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="货盘类型"  field="huopantype"  query="true" dictionary="huopantype"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="chHuopanController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="chHuopanController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="chHuopanController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="chHuopanController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="chHuopanController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/huopan/chHuopanList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'chHuopanController.do?upload', "chHuopanList");
}

//导出
function ExportXls() {
	JeecgExcelExport("chHuopanController.do?exportXls","chHuopanList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("chHuopanController.do?exportXlsByT","chHuopanList");
}

 </script>