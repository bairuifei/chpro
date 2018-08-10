<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chClientList" checkbox="true" pagination="true" fitColumns="true" title="用户表" sortName="createDate" actionUrl="chClientController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus" hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="clientName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="clientSex"  query="true" dictionary="sex"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="手机号码"  field="clientMobile"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="微信openID"  field="clientOpenid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公众号"  field="clientGzwx"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="头像"  field="clientHeadimg"  queryMode="single"  image="true" imageSize="50,50"  width="120"></t:dgCol>
   <t:dgCol title="真实姓名"  field="clientRealname"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="clientCreditid"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否VIP"  field="clientVip"  query="true" dictionary="sf_yn"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="VIP截止时间"  field="clientVipend"  formatter="yyyy-MM-dd hh:mm:ss"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="密码"  field="clientPwd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="chClientController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="chClientController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="chClientController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="chClientController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="chClientController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/client/chClientList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'chClientController.do?upload', "chClientList");
}

//导出
function ExportXls() {
	JeecgExcelExport("chClientController.do?exportXls","chClientList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("chClientController.do?exportXlsByT","chClientList");
}

 </script>