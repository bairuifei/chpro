package com.jeecg.relate.service;
import com.jeecg.relate.entity.ChClientRelateEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ChClientRelateServiceI extends CommonService{
	
 	public void delete(ChClientRelateEntity entity) throws Exception;
 	
 	public Serializable save(ChClientRelateEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ChClientRelateEntity entity) throws Exception;
 	
}
