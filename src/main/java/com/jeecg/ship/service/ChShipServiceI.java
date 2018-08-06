package com.jeecg.ship.service;
import com.jeecg.ship.entity.ChShipEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChShipServiceI extends CommonService{
	
 	public void delete(ChShipEntity entity) throws Exception;
 	
 	public Serializable save(ChShipEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChShipEntity entity) throws Exception;
 	
}
