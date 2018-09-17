package com.jeecg.province.service;
import com.jeecg.province.entity.ChProvinceEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChProvinceServiceI extends CommonService{
	
 	public void delete(ChProvinceEntity entity) throws Exception;
 	
 	public Serializable save(ChProvinceEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChProvinceEntity entity) throws Exception;
 	
}
