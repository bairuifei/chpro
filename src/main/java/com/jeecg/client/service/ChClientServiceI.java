package com.jeecg.client.service;
import com.jeecg.client.entity.ChClientEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChClientServiceI extends CommonService{
	
 	public void delete(ChClientEntity entity) throws Exception;
 	
 	public Serializable save(ChClientEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChClientEntity entity) throws Exception;
 	
}
