package com.jeecg.position.service;
import com.jeecg.position.entity.ChPositionEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChPositionServiceI extends CommonService{
	
 	public void delete(ChPositionEntity entity) throws Exception;
 	
 	public Serializable save(ChPositionEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChPositionEntity entity) throws Exception;
 	
}
