package com.jeecg.api;

import com.jeecg.shipdate.entity.ChShipDateEntity;
import com.jeecg.shipdate.service.ChShipDateServiceI;
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

@Controller
@RequestMapping("/shipdate")
@Api(value = "船期模块", description = "船期模块", tags = "shipDateAPI")
public class ShipDateController {
    private static final Logger logger = LoggerFactory.getLogger(ShipDateController.class);

    @Resource
    private RedisService redisService;

    @Autowired
    private ChShipDateServiceI chShipDateServiceI;

    @ApiOperation(value = "发布船期", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public RespResult save(@RequestBody ChShipDateEntity shipdate){
        try {
            chShipDateServiceI.save(shipdate);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "获取已发布船期列表", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public RespResult list(@RequestBody JSONObject json){
        try {
            String clientId = json.getString("clientId");
            List<ChShipDateEntity> shipDates = chShipDateServiceI.findByProperty(ChShipDateEntity.class,"shipClientId",clientId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),shipDates);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "删除船期", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public RespResult delete(@RequestBody JSONObject json){
        try {
            String id = json.getString("id");
            chShipDateServiceI.deleteEntityById(ChShipDateEntity.class,id);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }
}
