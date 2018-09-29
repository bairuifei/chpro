package com.jeecg.api;

import com.jeecg.ship.entity.ChShipEntity;
import com.jeecg.ship.service.ChShipServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jodd.util.StringUtil;
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
    public RespResult list(@RequestBody JSONObject json){
        try {
            String clientId = json.getString("clientId");
            List<ChShipEntity> ships = chShipServiceI.findByProperty(ChShipEntity.class,"shipClientId",clientId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),ships);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "获取船舶档案信息", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "find",method = RequestMethod.POST)
    @ResponseBody
    public RespResult find(@RequestBody JSONObject json){
        try {
            String shipId = json.getString("shipId");
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
            String id = (String) chShipServiceI.save(ship);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),id);
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
            ChShipEntity oShip = chShipServiceI.get(ChShipEntity.class,ship.getId());
            if (oShip==null){
                return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
            }
            if(StringUtil.isNotEmpty(ship.getShipName())){
                oShip.setShipName(ship.getShipName());
            }
            if(ship.getShipZaizhong()!=null){
                oShip.setShipZaizhong(ship.getShipZaizhong());
            }
            if(ship.getShipBuildtime()!=null){
                oShip.setShipBuildtime(ship.getShipBuildtime());
            }
            if(ship.getShipWater()!=null){
                oShip.setShipWater(ship.getShipWater());
            }
            if(ship.getShipLength()!=null){
                oShip.setShipLength(ship.getShipLength());
            }
            if(ship.getShipWidth()!=null){
                oShip.setShipWidth(ship.getShipWidth());
            }
            if(ship.getShipHigh()!=null){
                oShip.setShipHigh(ship.getShipHigh());
            }
            if(ship.getShipCangCount()!=null){
                oShip.setShipCangCount(ship.getShipCangCount());
            }
            if(ship.getShipCangLength()!=null){
                oShip.setShipCangLength(ship.getShipCangLength());
            }
            if(ship.getShipCangWidth()!=null){
                oShip.setShipCangWidth(ship.getShipCangWidth());
            }
            if(ship.getShipCangDeep()!=null){
                oShip.setShipCangDeep(ship.getShipCangDeep());
            }
            if(StringUtil.isNotEmpty(ship.getShipDriveLocation())){
                oShip.setShipDriveLocation(ship.getShipDriveLocation());
            }
            if(StringUtil.isNotEmpty(ship.getShipFengDevice())){
                oShip.setShipFengDevice(ship.getShipFengDevice());
            }
            if(StringUtil.isNotEmpty(ship.getShipDakong())){
                oShip.setShipDakong(ship.getShipDakong());
            }
            if(StringUtil.isNotEmpty(ship.getShipShuichi())){
                oShip.setShipShuichi(ship.getShipShuichi());
            }
            if(StringUtil.isNotEmpty(ship.getShipNote())){
                oShip.setShipNote(ship.getShipNote());
            }
            if(StringUtil.isNotEmpty(ship.getShipAudit())){
                oShip.setShipAudit(ship.getShipAudit());
            }
            if(StringUtil.isNotEmpty(ship.getShipClientId())){
                oShip.setShipClientId(ship.getShipClientId());
            }
            if(StringUtil.isNotEmpty(ship.getShipClientName())){
                oShip.setShipClientName(ship.getShipClientName());
            }
            if(StringUtil.isNotEmpty(ship.getShipAuditImg())){
                oShip.setShipAuditImg(ship.getShipAuditImg());
            }
            if(StringUtil.isNotEmpty(ship.getShipLong())){
                oShip.setShipLong(ship.getShipLong());
            }
            if(StringUtil.isNotEmpty(ship.getShipLat())){
                oShip.setShipLat(ship.getShipLat());
            }
            chShipServiceI.updateEntitie(oShip);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "删除船舶", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public RespResult delete(@RequestBody JSONObject json){
        try {
            String shipId = json.getString("shipId");
            chShipServiceI.deleteEntityById(ChShipEntity.class,shipId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }


}
