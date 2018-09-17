<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chPositionList" checkbox="true" pagination="true" fitColumns="true" title="地点" sortName="createDate" actionUrl="chPositionController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="名称"  field="positionName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属省份"  field="provinceId" query="true" queryMode="single"  dictionary="ch_province,id,province_name" width="120"></t:dgCol>
   <t:dgCol title="类型编码"  field="positionTypeCode"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="chPositionController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="chPositionController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="chPositionController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="chPositionController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="关联"  icon="icon-remove" url="chPositionController.do?doBatchLink" funname="linkALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="chPositionController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/jeecg/position/chPositionList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'chPositionController.do?upload', "chPositionList");
}

//导出
function ExportXls() {
	JeecgExcelExport("chPositionController.do?exportXls","chPositionList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("chPositionController.do?exportXlsByT","chPositionList");
}

 /**
  * 多记录关联請求
  * @param title
  * @param url
  * @param gname
  * @return
  */
 function linkALLSelect(title,url,gname) {
     gridname=gname;
     var ids = [];
     var rows = $("#"+gname).datagrid('getSelections');
     if (rows.length > 0) {
         $.dialog.setting.zIndex = getzIndex(true);
         $.dialog.confirm("确认关联选中数据？", function(r) {
             if (r) {
                 for ( var i = 0; i < rows.length; i++) {
                     ids.push(rows[i].id);
                 }
                 $.ajax({
                     url : url,
                     type : 'post',
                     data : {
                         ids : ids.join(',')
                     },
                     cache : false,
                     success : function(data) {
                         var d = $.parseJSON(data);
                         if (d.success) {
                             var msg = d.msg;
                             tip(msg);
                             reloadTable();
                             $("#"+gname).datagrid('unselectAll');
                             ids='';
                         }
                     }
                 });
             }
         });
     } else {
         tip($.i18n.prop('del.selectData.tip'));
     }
 }
 </script>