package com.jeecg.shipdate.service;
import com.jeecg.shipdate.entity.ChShipDateEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChShipDateServiceI extends CommonService{
	
 	public void delete(ChShipDateEntity entity) throws Exception;
 	
 	public Serializable save(ChShipDateEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChShipDateEntity entity) throws Exception;
 	
}
