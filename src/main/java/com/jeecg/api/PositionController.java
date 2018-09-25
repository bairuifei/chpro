package com.jeecg.api;

import com.jeecg.position.entity.ChPositionEntity;
import com.jeecg.position.service.ChPositionServiceI;
import com.jeecg.province.entity.ChProvinceEntity;
import com.jeecg.province.service.ChProvinceServiceI;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/position")
@Api(value = "位置接口", description = "位置接口", tags = "positionAPI")
public class PositionController {
    private static final Logger logger = LoggerFactory.getLogger(PositionController.class);

    @Resource
    private ChProvinceServiceI chProvinceServiceI;

    @Resource
    private ChPositionServiceI chPositionServiceI;

    @ApiOperation(value = "省份列表", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "provinceList",method = RequestMethod.POST)
    @ResponseBody
    public RespResult provinceList(@RequestBody JSONObject json){
        try {
            String pname = null;
            List<ChProvinceEntity> provinceEntitys = null;
            if (json.has("pname")){
                pname = json.getString("pname");
                provinceEntitys = chProvinceServiceI.findHql("from ChProvinceEntity where provinceName like ?","%"+pname+"%");
            }else {
                provinceEntitys = chProvinceServiceI.findHql("from ChProvinceEntity");
            }
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),provinceEntitys);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "港口列表", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "positionList",method = RequestMethod.POST)
    @ResponseBody
    public RespResult positionList(@RequestBody JSONObject json){
        try {
            String portname = null;
            String pid = json.getString("pid");
            List<ChPositionEntity> positionEntitys = null;
            if (json.has("portname")){
                portname = json.getString("portname");
                positionEntitys = chPositionServiceI.findHql("from ChPositionEntity where positionName = ? and provinceId = ?",portname,pid);
            }else {
                positionEntitys = chPositionServiceI.findHql("from ChPositionEntity where provinceId = ?",pid);
            }
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),positionEntitys);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }
}
