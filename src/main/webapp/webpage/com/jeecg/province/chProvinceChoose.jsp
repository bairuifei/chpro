<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="chProvinceList" checkbox="true" pagination="true" fitColumns="true" title="省份" sortName="createDate" actionUrl="chProvinceController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="initCheck">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="省份名称"  field="provinceName"  query="true"  queryMode="single"  width="120"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
<script type="text/javascript">
    function initCheck(data){
        var ids = "${ids}";
        var idArr = ids.split(",");
        for(var i=0;i<idArr.length;i++){
            if(idArr[i]!=""){
                $("#chProvinceList").datagrid("selectRecord",idArr[i]);
            }
        }
    }
</script>