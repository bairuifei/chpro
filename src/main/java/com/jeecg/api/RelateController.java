package com.jeecg.api;

import com.jeecg.client.entity.ChClientEntity;
import com.jeecg.relate.entity.ChClientRelateEntity;
import com.jeecg.relate.service.ChClientRelateServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.jeecgframework.core.common.service.impl.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/relate")
@Api(value = "客户关系接口", description = "客户关系接口", tags = "relateAPI")
public class RelateController {
    private static final Logger logger = LoggerFactory.getLogger(RelateController.class);

    @Resource
    private RedisService redisService;

    @Autowired
    private ChClientRelateServiceI chClientRelateServiceI;

    @ApiOperation(value = "保存客户关系", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public RespResult save(@RequestBody ChClientRelateEntity relateEntity){
        try {
            chClientRelateServiceI.save(relateEntity);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "客户关系列表", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public RespResult list(@RequestBody JSONObject json){
        try {
            String clientId = json.getString("clientId");
            String type = json.getString("type");
            List<Map<String, Object>> relateEntities = chClientRelateServiceI.findForJdbc("select client.* from ch_client client left join ch_client_relate relate on client.id = relate.relate_id where relate.client_id = ? and relate.type = ?",clientId,type);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),relateEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }
}
