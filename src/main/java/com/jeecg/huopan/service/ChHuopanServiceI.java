package com.jeecg.huopan.service;
import com.jeecg.huopan.entity.ChHuopanEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChHuopanServiceI extends CommonService{
	
 	public void delete(ChHuopanEntity entity) throws Exception;
 	
 	public Serializable save(ChHuopanEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChHuopanEntity entity) throws Exception;
 	
}
