package com.jeecg.api;

import com.jeecg.client.entity.ChClientEntity;
import com.jeecg.client.service.ChClientServiceI;
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
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/huopan")
@Api(value = "货盘模块", description = "货盘模块", tags = "huopanAPI")
public class HuoPanController {
    private static final Logger logger = LoggerFactory.getLogger(HuoPanController.class);

    @Resource
    private RedisService redisService;

    @Autowired
    private ChHuopanServiceI chHuopanServiceI;

    @Autowired
    private ChShipDateServiceI chShipDateServiceI;

    @Autowired
    private ChPositionServiceI chPositionService;

    @Autowired
    private ChClientServiceI chClientServiceI;

    @Autowired
    private SystemService systemService;

    private void showHuopan(ChHuopanEntity huopan){
        String begin = huopan.getHuopanBegin();
        String end = huopan.getHuopanEnd();
        ChPositionEntity pobegin = systemService.getEntity(ChPositionEntity.class,begin);
        ChPositionEntity poend = systemService.getEntity(ChPositionEntity.class,end);
        huopan.setHuopanBeginStr(pobegin.getPositionName());
        huopan.setHuopanEndStr(poend.getPositionName());
        String[] ids = huopan.getHuopanShipPosition().split(",");
        StringBuffer sb = new StringBuffer();
        for (String id : ids){
            ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
            sb.append(position.getPositionName()).append(",");
        }
        huopan.setHuopanShipPositionStr(sb.toString().substring(0,sb.toString().length()-1));
    }

    private void showShipdate(ChShipDateEntity chShipDate){
        if (StringUtil.isNotEmpty(chShipDate.getShipFromPort())){
            StringBuffer sb = new StringBuffer();
            String[] ids = chShipDate.getShipFromPort().split(",");
            for (String id : ids){
                ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
                sb.append(position.getPositionName()).append(",");
            }
            chShipDate.setShipFromPortStr(sb.toString().substring(0,sb.toString().length()-1));
        }
        if (StringUtil.isNotEmpty(chShipDate.getShipToPorts())){
            StringBuffer sb = new StringBuffer();
            String[] ids = chShipDate.getShipToPorts().split(",");
            for (String id : ids){
                ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
                sb.append(position.getPositionName()).append(",");
            }
            chShipDate.setShipToPortsStr(sb.toString().substring(0,sb.toString().length()-1));
        }
        if (StringUtil.isNotEmpty(chShipDate.getShipStayPorts())){
            StringBuffer sb = new StringBuffer();
            String[] ids = chShipDate.getShipStayPorts().split(",");
            for (String id : ids){
                ChPositionEntity position = systemService.getEntity(ChPositionEntity.class,id);
                sb.append(position.getPositionName()).append(",");
            }
            chShipDate.setShipStayPortsStr(sb.toString().substring(0,sb.toString().length()-1));
        }
    }

    @ApiOperation(value = "查看历史货盘", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "list",method = RequestMethod.POST)
    @ResponseBody
    public RespResult list(@RequestBody JSONObject json){
        try {
            String clientId = json.getString("clientId");
            List<ChHuopanEntity> huopans = chHuopanServiceI.findByProperty(ChHuopanEntity.class,"huopanClientId",clientId);
            //处理货盘显示字段
            for(ChHuopanEntity huopan : huopans){
                showHuopan(huopan);
            }
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopans);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "获取货盘信息", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "find",method = RequestMethod.POST)
    @ResponseBody
    public RespResult find(@RequestBody JSONObject json){
        try {
            String huopanId = json.getString("huopanId");
            ChHuopanEntity huopan = chHuopanServiceI.get(ChHuopanEntity.class,huopanId);
            showHuopan(huopan);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopan);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }


    @ApiOperation(value = "搜索货盘模块", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "search",method = RequestMethod.POST)
    @ResponseBody
    public RespResult search(@RequestBody JSONObject json){
        try {
            String huopanBegin = null;
            String huopanEnd = null;
            Integer zaiZhongMin = null;
            Integer zaiZhongMax = null;
            if (json.has("huopanBegin")){
                huopanBegin = json.getString("huopanBegin");

            }
            if (json.has("huopanEnd")){
                huopanEnd = json.getString("huopanEnd");

            }
            if (json.has("zaiZhongMin")){
                zaiZhongMin = json.getInt("zaiZhongMin");

            }
            if (json.has("zaiZhongMax")){
                zaiZhongMax = json.getInt("zaiZhongMax");

            }
            StringBuffer hql = new StringBuffer("from ChHuopanEntity where 1=1");
            if (StringUtil.isNotEmpty(huopanBegin)){
                huopanBegin = huopanBegin.replaceAll(",","\",\"");
                hql.append(" and huopanBegin in ").append("(\"").append(huopanBegin).append("\")");
            }
            if (StringUtil.isNotEmpty(huopanEnd)){
                huopanEnd = huopanEnd.replaceAll(",","\",\"");
                hql.append(" and huopanEnd in ").append("(\"").append(huopanEnd).append("\")");
            }
            if (zaiZhongMin!=null && zaiZhongMax!=null){
                //全包含
                hql.append(" and ((huopanShipZaizhongMin >= ").append(zaiZhongMin).append(" and huopanShipZaizhongMax <= ").append(zaiZhongMax).append(")");
                hql.append(" or (huopanShipZaizhongMin <= ").append(zaiZhongMin).append(" and huopanShipZaizhongMax >= ").append(zaiZhongMin).append(")");
                hql.append(" or (huopanShipZaizhongMin <= ").append(zaiZhongMax).append(" and huopanShipZaizhongMax >= ").append(zaiZhongMax).append("))");
            }
            if (zaiZhongMin!=null && zaiZhongMax==null){
                hql.append(" and huopanShipZaizhongMax >= ").append(zaiZhongMin);
            }
            if (zaiZhongMin==null && zaiZhongMax!=null){
                hql.append(" and huopanShipZaizhongMin <= ").append(zaiZhongMax);
            }
            List<ChHuopanEntity> huopans = chHuopanServiceI.findByQueryString(hql.toString());
            //处理货盘显示字段
            for(ChHuopanEntity huopan : huopans){
                showHuopan(huopan);
            }
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopans);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "获取官方货盘", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "office",method = RequestMethod.POST)
    @ResponseBody
    public RespResult office(){
        try {
            List<ChHuopanEntity> huopans = chHuopanServiceI.findByProperty(ChHuopanEntity.class,"huopantype","office");
            //处理货盘显示字段
            for(ChHuopanEntity huopan : huopans){
                showHuopan(huopan);
            }
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopans);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "发布货盘", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "save",method = RequestMethod.POST,consumes ="application/json")
    @ResponseBody
    public RespResult save(@RequestBody ChHuopanEntity huopan){
        try {
            huopan.setHuopanContinue("Y");
            chHuopanServiceI.save(huopan);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "更新货盘", httpMethod = "POST")
    @RequestMapping(value = "updateInfo",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public RespResult updateInfo(@RequestBody ChHuopanEntity huopan){
        ChHuopanEntity ohuopan= chHuopanServiceI.get(ChHuopanEntity.class,huopan.getId());
        if (ohuopan==null){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        try {
            if(huopan.getHuopanBegin()!=null){
                ohuopan.setHuopanBegin(huopan.getHuopanBegin());
            }
            if(huopan.getHuopanBeginPort()!=null){
                ohuopan.setHuopanBeginPort(huopan.getHuopanBeginPort());
            }
            if(huopan.getHuopanEnd()!=null){
                ohuopan.setHuopanEnd(huopan.getHuopanEnd());
            }
            if(huopan.getHuopanEndPort()!=null){
                ohuopan.setHuopanEndPort(huopan.getHuopanEndPort());
            }
            if(huopan.getHuopanDate()!=null){
                ohuopan.setHuopanDate(huopan.getHuopanDate());
            }
            if(huopan.getHuopanDateWucha()!=null){
                ohuopan.setHuopanDateWucha(huopan.getHuopanDateWucha());
            }
            if(huopan.getHuopanName()!=null){
                ohuopan.setHuopanName(huopan.getHuopanName());
            }
            if(huopan.getHuopanCount()!=null){
                ohuopan.setHuopanCount(huopan.getHuopanCount());
            }
            if(huopan.getHuopanNote()!=null){
                ohuopan.setHuopanNote(huopan.getHuopanNote());
            }
            if(huopan.getHuopanShipPosition()!=null){
                ohuopan.setHuopanShipPosition(huopan.getHuopanShipPosition());
            }
            if(huopan.getHuopanShipZaizhongMin()!=null){
                ohuopan.setHuopanShipZaizhongMin(huopan.getHuopanShipZaizhongMin());
            }
            if(huopan.getHuopanShipZaizhongMax()!=null){
                ohuopan.setHuopanShipZaizhongMax(huopan.getHuopanShipZaizhongMax());
            }
            if(huopan.getHuopanShipCount()!=null){
                ohuopan.setHuopanShipCount(huopan.getHuopanShipCount());
            }
            if(huopan.getHuopanShipFengcang()!=null){
                ohuopan.setHuopanShipFengcang(huopan.getHuopanShipFengcang());
            }
            if(huopan.getHuopanShipShuichi()!=null){
                ohuopan.setHuopanShipShuichi(huopan.getHuopanShipShuichi());
            }
            if(huopan.getHuopanShipDriveLocation()!=null){
                ohuopan.setHuopanShipDriveLocation(huopan.getHuopanShipDriveLocation());
            }
            if(huopan.getHuopanShipChuankou()!=null){
                ohuopan.setHuopanShipChuankou(huopan.getHuopanShipChuankou());
            }
            if(huopan.getHuopanShipDakong()!=null){
                ohuopan.setHuopanShipDakong(huopan.getHuopanShipDakong());
            }
            if(huopan.getHuopanShipChishui()!=null){
                ohuopan.setHuopanShipChishui(huopan.getHuopanShipChishui());
            }
            if(huopan.getHuopanShipLength()!=null){
                ohuopan.setHuopanShipLength(huopan.getHuopanShipLength());
            }
            if(huopan.getHuopanShipWidth()!=null){
                ohuopan.setHuopanShipWidth(huopan.getHuopanShipWidth());
            }
            if(huopan.getHuopanShipHigh()!=null){
                ohuopan.setHuopanShipHigh(huopan.getHuopanShipHigh());
            }
            if(huopan.getHuopanShipCangLength()!=null){
                ohuopan.setHuopanShipCangLength(huopan.getHuopanShipCangLength());
            }
            if(huopan.getHuopanShipCangWidth()!=null){
                ohuopan.setHuopanShipCangWidth(huopan.getHuopanShipCangWidth());
            }
            if(huopan.getHuopanShipCangDeep()!=null){
                ohuopan.setHuopanShipCangDeep(huopan.getHuopanShipCangDeep());
            }
            if(huopan.getHuopanFeeYun()!=null){
                ohuopan.setHuopanFeeYun(huopan.getHuopanFeeYun());
            }
            if(huopan.getHuopanFeeKaihang()!=null){
                ohuopan.setHuopanFeeKaihang(huopan.getHuopanFeeKaihang());
            }
            if(huopan.getHuopanFeeZhiqi()!=null){
                ohuopan.setHuopanFeeZhiqi(huopan.getHuopanFeeZhiqi());
            }
            if(huopan.getHuopanFeeLoadtime()!=null){
                ohuopan.setHuopanFeeLoadtime(huopan.getHuopanFeeLoadtime());
            }
            if(huopan.getHuopanFeeJstype()!=null){
                ohuopan.setHuopanFeeJstype(huopan.getHuopanFeeJstype());
            }
            if(huopan.getHuopanFeePaytype()!=null){
                ohuopan.setHuopanFeePaytype(huopan.getHuopanFeePaytype());
            }
            if(huopan.getHuopanAudit()!=null){
                ohuopan.setHuopanAudit(huopan.getHuopanAudit());
            }
            if(huopan.getHuopanClientId()!=null){
                ohuopan.setHuopanClientId(huopan.getHuopanClientId());
            }
            if(huopan.getHuopanClientName()!=null){
                ohuopan.setHuopanClientName(huopan.getHuopanClientName());
            }
            if(huopan.getHuopantype()!=null){
                ohuopan.setHuopantype(huopan.getHuopantype());
            }

            chHuopanServiceI.updateEntitie(ohuopan);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "删除货盘", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public RespResult delete(@RequestBody JSONObject json){
        try {
            String id = json.getString("id");
            chHuopanServiceI.deleteEntityById(ChHuopanEntity.class,id);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "江湖评价", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "pingjia",method = RequestMethod.POST)
    @ResponseBody
    public RespResult pingjia(@RequestBody JSONObject json){
        try {
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),"暂未开发");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "查看匹配的船期", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "suitShipDate",method = RequestMethod.POST)
    @ResponseBody
    public RespResult suitShipDate(@RequestBody JSONObject json){
        try {
            String huopanId = json.getString("huopanId");
            ChHuopanEntity huopan = chHuopanServiceI.get(ChHuopanEntity.class,huopanId);
            //查看货盘装货港
            String positionId = huopan.getHuopanBegin();
            ChPositionEntity position = chPositionService.get(ChPositionEntity.class,positionId);
            //查看同组地点
            List<ChPositionEntity> positions = chPositionService.findByProperty(ChPositionEntity.class,"positionTypeCode",position.getPositionTypeCode());
            //检索同组地点下所有资源
            StringBuffer sb = new StringBuffer();
            for (ChPositionEntity positionEntity : positions){
                sb.append(positionEntity.getId()).append(",");
            }
            String begins = sb.toString();
            List<ChShipDateEntity> shipDateEntities = chShipDateServiceI.findHql("from ChShipDateEntity where shipFromPort in (?)",begins.substring(0,begins.length()-1));
            for (ChShipDateEntity shipdate : shipDateEntities){
                ChClientEntity client = chClientServiceI.get(ChClientEntity.class,shipdate.getShipClientId());
                shipdate.setClient(client);
                showShipdate(shipdate);
            }
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),shipDateEntities);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "继续找船", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "goonShip",method = RequestMethod.POST)
    @ResponseBody
    public RespResult goonShip(@RequestBody JSONObject json){
        try {
            String huopanId = json.getString("huopanId");
            ChHuopanEntity huopan = chHuopanServiceI.get(ChHuopanEntity.class,huopanId);
            if (huopan.getHuopanContinue().equals("Y")){
                huopan.setHuopanContinue("N");
            }else {
                huopan.setHuopanContinue("Y");
            }
            chHuopanServiceI.updateEntitie(huopan);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }
}
