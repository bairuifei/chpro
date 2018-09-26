package com.jeecg.api;

import com.jeecg.huopan.entity.ChHuopanEntity;
import com.jeecg.huopan.service.ChHuopanServiceI;
import com.jeecg.position.entity.ChPositionEntity;
import com.jeecg.position.service.ChPositionServiceI;
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

    @Autowired
    private ChPositionServiceI chPositionService;

    @Autowired
    private ChHuopanServiceI chHuopanServiceI;

    @ApiOperation(value = "发布船期", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public RespResult save(@RequestBody ChShipDateEntity shipdate){
        try {
            shipdate.setShipContinue("Y");
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

    @ApiOperation(value = "继续找货", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "goonHuopan",method = RequestMethod.POST)
    @ResponseBody
    public RespResult goonHuopan(@RequestBody JSONObject json){
        try {
            String id = json.getString("id");
            ChShipDateEntity shipdate = chShipDateServiceI.get(ChShipDateEntity.class,id);
            if (shipdate.getShipContinue().equals("Y")){
                shipdate.setShipContinue("N");
            }else {
                shipdate.setShipContinue("Y");
            }
            chShipDateServiceI.updateEntitie(shipdate);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "查看匹配的货盘", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "suitHuopan",method = RequestMethod.POST)
    @ResponseBody
    public RespResult suitHuopan(@RequestBody JSONObject json){
        try {
            String id = json.getString("id");
            ChShipDateEntity shipdate = chShipDateServiceI.get(ChShipDateEntity.class,id);
            //查看船期空船港
            String positionId = shipdate.getShipFromPort();
            ChPositionEntity position = chPositionService.get(ChPositionEntity.class,positionId);
            //查看同组地点
            List<ChPositionEntity> positions = chPositionService.findByProperty(ChPositionEntity.class,"positionTypeCode",position.getPositionTypeCode());
            //检索同组地点下所有资源
            StringBuffer sb = new StringBuffer();
            for (ChPositionEntity positionEntity : positions){
                sb.append(positionEntity.getId()).append(",");
            }
            String begins = sb.toString();
            List<ChHuopanEntity> huopanEntities = chHuopanServiceI.findHql("from ChHuopanEntity where huopanBegin in (?)",begins.substring(0,begins.length()-1));
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopanEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "ID获取船期", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "shipDateById",method = RequestMethod.POST)
    @ResponseBody
    public RespResult shipDateById(@RequestBody JSONObject json){
        try {
            String shipDateId = json.getString("shipDateId");
            ChShipDateEntity shipdate = chShipDateServiceI.get(ChShipDateEntity.class,shipDateId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),shipdate);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }
}
