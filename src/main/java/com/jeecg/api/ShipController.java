package com.jeecg.api;

import com.jeecg.ship.entity.ChShipEntity;
import com.jeecg.ship.service.ChShipServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecgframework.core.common.service.impl.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/ship")
@Api(value = "船舶模块", description = "船舶模块", tags = "shipAPI")
public class ShipController {
    private static final Logger logger = LoggerFactory.getLogger(ShipController.class);

    @Resource
    private RedisService redisService;

    @Autowired
    private ChShipServiceI chShipServiceI;

    @ApiOperation(value = "获取已发布船舶列表", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public RespResult list(@RequestParam String clientId){
        try {
            List<ChShipEntity> ships = chShipServiceI.findByProperty(ChShipEntity.class,"shipClientId",clientId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),ships);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "获取船舶档案信息", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "find",method = RequestMethod.GET)
    @ResponseBody
    public RespResult find(@RequestParam String shipId){
        try {
            ChShipEntity ship = chShipServiceI.get(ChShipEntity.class,shipId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),ship);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "添加船舶", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public RespResult save(@RequestBody ChShipEntity ship){
        try {
            ship.setShipAudit("auditing");
            chShipServiceI.save(ship);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "更新船舶/认证船舶/上传船舶位置", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public RespResult update(@RequestBody ChShipEntity ship){
        try {
            chShipServiceI.updateEntitie(ship);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "删除船舶", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public RespResult delete(@RequestParam String shipId){
        try {
            chShipServiceI.deleteEntityById(ChShipEntity.class,shipId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }


}
