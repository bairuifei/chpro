package com.jeecg.watchlog.service;
import com.jeecg.watchlog.entity.ChWatchLogEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChWatchLogServiceI extends CommonService{
	
 	public void delete(ChWatchLogEntity entity) throws Exception;
 	
 	public Serializable save(ChWatchLogEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChWatchLogEntity entity) throws Exception;
 	
}
