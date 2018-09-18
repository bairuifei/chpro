package com.jeecg.api;

import com.jeecg.huopan.entity.ChHuopanEntity;
import com.jeecg.huopan.service.ChHuopanServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecgframework.core.common.service.impl.RedisService;
import org.jeecgframework.core.util.StringUtil;
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

    @ApiOperation(value = "查看历史货盘", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "list",method = RequestMethod.GET)
    @ResponseBody
    public RespResult list(@RequestParam String clientId){
        try {
            List<ChHuopanEntity> huopans = chHuopanServiceI.findByProperty(ChHuopanEntity.class,"huopanClientId",clientId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopans);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "获取货盘信息", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "find",method = RequestMethod.GET)
    @ResponseBody
    public RespResult find(@RequestParam String huopanId){
        try {
            ChHuopanEntity huopan = chHuopanServiceI.get(ChHuopanEntity.class,huopanId);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopan);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }


    @ApiOperation(value = "搜索货盘模块", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "search",method = RequestMethod.GET)
    @ResponseBody
    public RespResult search(@RequestParam String huopanBegin,@RequestParam String huopanEnd,@RequestParam Integer zaiZhong){
        try {
            StringBuffer hql = new StringBuffer("from ChHuopanEntity where 1=1");
            if (StringUtil.isNotEmpty(huopanBegin)){
                hql.append(" and huopanBegin = ").append(huopanBegin);
            }
            if (StringUtil.isNotEmpty(huopanEnd)){
                hql.append(" and huopanEnd = ").append(huopanEnd);
            }
            if (zaiZhong!=null){
                hql.append(" and huopanShipZaizhongMin <= ").append(zaiZhong).append(" and huopanShipZaizhongMax >= ").append(zaiZhong);
            }
            List<ChHuopanEntity> huopans = chHuopanServiceI.findByQueryString(hql.toString());
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopans);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "获取官方货盘", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "office",method = RequestMethod.GET)
    @ResponseBody
    public RespResult office(){
        try {
            List<ChHuopanEntity> huopans = chHuopanServiceI.findByProperty(ChHuopanEntity.class,"huopantype","office");
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),huopans);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "发布货盘", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public RespResult save(@RequestBody ChHuopanEntity huopan){
        try {
            chHuopanServiceI.save(huopan);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "删除货盘", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    @ResponseBody
    public RespResult delete(@RequestParam String id){
        try {
            chHuopanServiceI.deleteEntityById(ChHuopanEntity.class,id);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "江湖评价", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "pingjia",method = RequestMethod.GET)
    @ResponseBody
    public RespResult pingjia(){
        try {
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),"暂未开发");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "查看匹配的船期", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "suitShipDate",method = RequestMethod.GET)
    @ResponseBody
    public RespResult suitShipDate(){
        try {
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),"暂未开发");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "继续找船", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "goonShip",method = RequestMethod.GET)
    @ResponseBody
    public RespResult goonShip(){
        try {
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),"暂未开发");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }
}
