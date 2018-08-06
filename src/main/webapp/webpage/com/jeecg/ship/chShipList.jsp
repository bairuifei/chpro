<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chShipList" checkbox="true" pagination="true" fitColumns="true" title="船舶信息" actionUrl="chShipController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"   queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="船名"  field="shipName"  query="true"  queryMode="single"  width="120"></t:dgCol>
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
   <t:dgCol title="驾驶舱位置"  field="shipDriveLocation"  query="true"  queryMode="single" dictionary="jiashicang" width="120"></t:dgCol>
   <t:dgCol title="封舱设备"  field="shipFengDevice"  query="true"  queryMode="single" dictionary="fengcang" width="120"></t:dgCol>
   <t:dgCol title="打孔"  field="shipDakong"  query="true"  queryMode="single" dictionary="dakong" width="120"></t:dgCol>
   <t:dgCol title="水尺"  field="shipShuichi"  query="true"  queryMode="single" dictionary="shuichi" width="120"></t:dgCol>
   <t:dgCol title="备注"  field="shipNote"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核状态"  field="shipAudit"  query="true"  queryMode="single" dictionary="audit" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="chShipController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="chShipController.do?goAdd" funname="add"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="chShipController.do?goUpdate" funname="update"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="chShipController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="chShipController.do?goUpdate" funname="detail"  width="800" height="500"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
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

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}

//列表文件图片 列格式化方法
function listFileImgFormat(value,type){
	var href='';
	if(value==null || value.length==0){
		return href;
	}
	var value1 = "img/server/"+value;
	if("image"==type){
 		href+="<img src='"+value1+"' width=30 height=30  onmouseover='tipImg(this)' onmouseout='moveTipImg()' style='vertical-align:middle'/>";
	}else{
 		if(value.indexOf(".jpg")>-1 || value.indexOf(".gif")>-1 || value.indexOf(".png")>-1){
 			href+="<img src='"+value1+"' onmouseover='tipImg(this)' onmouseout='moveTipImg()' width=30 height=30 style='vertical-align:middle'/>";
 		}else{
 			var value2 = "img/server/"+value+"?down=true";
 			href+="<a href='"+value2+"' class='ace_button' style='text-decoration:none;' target=_blank><u><i class='fa fa-download'></i>点击下载</u></a>";
 		}
	}
	return href;
}

</script>
