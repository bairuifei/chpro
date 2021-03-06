package com.jeecg.shipdate.controller;
import com.jeecg.position.entity.ChPositionEntity;
import com.jeecg.ship.entity.ChShipEntity;
import com.jeecg.ship.service.ChShipServiceI;
import com.jeecg.shipdate.entity.ChShipDateEntity;
import com.jeecg.shipdate.service.ChShipDateServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.common.TreeChildCount;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.util.Map;
import java.util.HashMap;
import org.jeecgframework.core.util.ExceptionUtil;


import org.jeecgframework.web.cgform.entity.upload.CgUploadEntity;
import org.jeecgframework.web.cgform.service.config.CgFormFieldServiceI;
import java.util.HashMap;
/**   
 * @Title: Controller  
 * @Description: 船期
 * @author onlineGenerator
 * @date 2018-08-26 18:14:00
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/chShipDateController")
public class ChShipDateController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ChShipDateController.class);

	@Autowired
	private ChShipDateServiceI chShipDateService;
	@Autowired
	private ChShipServiceI chShipServiceI;
	@Autowired
	private SystemService systemService;
	@Autowired
	private CgFormFieldServiceI cgFormFieldService;
	


	/**
	 * 船期列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/shipdate/chShipDateList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ChShipDateEntity chShipDate,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ChShipDateEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, chShipDate, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.chShipDateService.getDataGridReturn(cq, true);
		//处理码头显示
		List<ChShipDateEntity> shipDates = dataGrid.getResults();
		for (ChShipDateEntity shipDate : shipDates){
			if (StringUtil.isNotEmpty(shipDate.getShipFromPort())){
				StringBuffer sb = new StringBuffer();
				String[] ids = shipDate.getShipFromPort().split(",");
				for (String id : ids){
					ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
					sb.append(position.getPositionName()).append(",");
				}
				shipDate.setShipFromPortStr(sb.toString().substring(0,sb.toString().length()-1));
			}
			if (StringUtil.isNotEmpty(shipDate.getShipToPorts())){
				StringBuffer sb = new StringBuffer();
				String[] ids = shipDate.getShipToPorts().split(",");
				for (String id : ids){
					ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
					sb.append(position.getPositionName()).append(",");
				}
				shipDate.setShipToPortsStr(sb.toString().substring(0,sb.toString().length()-1));
			}
			if (StringUtil.isNotEmpty(shipDate.getShipStayPorts())){
				StringBuffer sb = new StringBuffer();
				String[] ids = shipDate.getShipStayPorts().split(",");
				for (String id : ids){
					ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
					sb.append(position.getPositionName()).append(",");
				}
				shipDate.setShipStayPortsStr(sb.toString().substring(0,sb.toString().length()-1));
			}
		}
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除船期
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ChShipDateEntity chShipDate, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		chShipDate = systemService.getEntity(ChShipDateEntity.class, chShipDate.getId());
		message = "船期删除成功";
		try{
			chShipDateService.delete(chShipDate);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "船期删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除船期
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "船期删除成功";
		try{
			for(String id:ids.split(",")){
				ChShipDateEntity chShipDate = systemService.getEntity(ChShipDateEntity.class, 
				id
				);
				chShipDateService.delete(chShipDate);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "船期删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加船期
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ChShipDateEntity chShipDate, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "船期添加成功";
		try{
			ChShipEntity ship = chShipServiceI.get(ChShipEntity.class,chShipDate.getShipId());
			chShipDate.setShipContinue("Y");
			chShipDate.setShipClientId(ship.getShipClientId());
			chShipDateService.save(chShipDate);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "船期添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		j.setObj(chShipDate);
		return j;
	}
	
	/**
	 * 更新船期
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ChShipDateEntity chShipDate, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "船期更新成功";
		ChShipDateEntity t = chShipDateService.get(ChShipDateEntity.class, chShipDate.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(chShipDate, t);
			ChShipEntity ship = chShipServiceI.get(ChShipEntity.class,t.getShipId());
			t.setShipClientId(ship.getShipClientId());
			chShipDateService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "船期更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 船期新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ChShipDateEntity chShipDate, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(chShipDate.getId())) {
			chShipDate = chShipDateService.getEntity(ChShipDateEntity.class, chShipDate.getId());
			req.setAttribute("chShipDatePage", chShipDate);
		}
		return new ModelAndView("com/jeecg/shipdate/chShipDate-add");
	}
	/**
	 * 船期编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ChShipDateEntity chShipDate, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(chShipDate.getId())) {
			chShipDate = chShipDateService.getEntity(ChShipDateEntity.class, chShipDate.getId());
			if (StringUtil.isNotEmpty(chShipDate.getShipFromPort())){
				StringBuffer sb = new StringBuffer();
				String[] ids = chShipDate.getShipFromPort().split(",");
				for (String id : ids){
					ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
					sb.append(position.getPositionName()).append(",");
				}
				chShipDate.setShipFromPortStr(sb.toString().substring(0,sb.toString().length()-1));
			}
			if (StringUtil.isNotEmpty(chShipDate.getShipToPorts())){
				StringBuffer sb = new StringBuffer();
				String[] ids = chShipDate.getShipToPorts().split(",");
				for (String id : ids){
					ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
					sb.append(position.getPositionName()).append(",");
				}
				chShipDate.setShipToPortsStr(sb.toString().substring(0,sb.toString().length()-1));
			}
			if (StringUtil.isNotEmpty(chShipDate.getShipStayPorts())){
				StringBuffer sb = new StringBuffer();
				String[] ids = chShipDate.getShipStayPorts().split(",");
				for (String id : ids){
					ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
					sb.append(position.getPositionName()).append(",");
				}
				chShipDate.setShipStayPortsStr(sb.toString().substring(0,sb.toString().length()-1));
			}
			req.setAttribute("chShipDatePage", chShipDate);
		}
		return new ModelAndView("com/jeecg/shipdate/chShipDate-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","chShipDateController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(ChShipDateEntity chShipDate,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(ChShipDateEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, chShipDate, request.getParameterMap());
		List<ChShipDateEntity> chShipDates = this.chShipDateService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"船期");
		modelMap.put(NormalExcelConstants.CLASS,ChShipDateEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("船期列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,chShipDates);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ChShipDateEntity chShipDate,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"船期");
    	modelMap.put(NormalExcelConstants.CLASS,ChShipDateEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("船期列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<ChShipDateEntity> listChShipDateEntitys = ExcelImportUtil.importExcel(file.getInputStream(),ChShipDateEntity.class,params);
				for (ChShipDateEntity chShipDate : listChShipDateEntitys) {
					chShipDateService.save(chShipDate);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(e.getMessage());
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	/**
	 * 获取文件附件信息
	 * 
	 * @param id chShipDate主键id
	 */
	@RequestMapping(params = "getFiles")
	@ResponseBody
	public AjaxJson getFiles(String id){
		List<CgUploadEntity> uploadBeans = cgFormFieldService.findByProperty(CgUploadEntity.class, "cgformId", id);
		List<Map<String,Object>> files = new ArrayList<Map<String,Object>>(0);
		for(CgUploadEntity b:uploadBeans){
			String title = b.getAttachmenttitle();//附件名
			String fileKey = b.getId();//附件主键
			String path = b.getRealpath();//附件路径
			String field = b.getCgformField();//表单中作为附件控件的字段
			Map<String, Object> file = new HashMap<String, Object>();
			file.put("title", title);
			file.put("fileKey", fileKey);
			file.put("path", path);
			file.put("field", field==null?"":field);
			files.add(file);
		}
		AjaxJson j = new AjaxJson();
		j.setObj(files);
		return j;
	}
	
}
