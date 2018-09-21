package com.jeecg.api;

import com.jeecg.client.entity.ChClientEntity;
import com.jeecg.client.service.ChClientServiceI;
import com.jeecg.util.YzCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.jeecgframework.core.common.service.impl.RedisService;
import org.jeecgframework.core.util.JSONHelper;
import org.jeecgframework.core.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/client")
@Api(value = "客户接口", description = "客户接口", tags = "clientAPI")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Resource
    private RedisService redisService;

    @Autowired
    private ChClientServiceI chClientService;

    /**
     * 验证码集合
     */
    private static final List<String> yzCodes = new ArrayList<>();
    private static final long telCodeOverTime = 60l;

    @ApiOperation(value = "获取验证码", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "yzCode",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public void yzCode(HttpServletResponse response) throws Exception {
        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // response.setContentType("image/png");

        //获取随机码和随机码图片
        Map map = YzCodeUtils.buildYzCode();
        yzCodes.add(((String)map.get("code")).toUpperCase());
        logger.info("yzCodes============>\n"+ JSONHelper.collection2json(yzCodes));
        // 输出图象到页面
        ImageIO.write((BufferedImage)map.get("image"), "JPEG", response.getOutputStream());
    }

    @ApiOperation(value = "验证验证码", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "judgeYzCode",method = RequestMethod.POST)
    @ResponseBody
    public RespResult judgeYzCode(@RequestBody JSONObject json){
        String yzCode = json.getString("yzCode");
        if (StringUtil.isEmpty(yzCode)){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        if (yzCodes.contains(yzCode.toUpperCase())){
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        }else {
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "删除验证码", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "delYzCode",method = RequestMethod.POST)
    @ResponseBody
    public RespResult delYzCode(@RequestBody JSONObject json){
        String yzCode = json.getString("yzCode");
        if (StringUtil.isEmpty(yzCode)){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        if (yzCodes.contains(yzCode.toUpperCase())){
            yzCodes.remove(yzCode.toUpperCase());
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        }else {
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "发送短信验证码", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "telCode",method = RequestMethod.POST)
    @ResponseBody
    public RespResult telCode(@RequestBody JSONObject json){
        String tel = json.getString("tel");
        String yzCode = json.getString("yzCode");
        if (StringUtil.isEmpty(tel) || StringUtil.isEmpty(yzCode)){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        if (yzCodes.contains(yzCode.toUpperCase())){
            // TODO: 2018/8/18/018 发送验证码
            String telCode = new Double(Math.random()*10000).intValue()+"";
            logger.info("发送验证码成功=========>"+telCode);
            redisService.setSeconds(tel,telCode,telCodeOverTime);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),telCode);
        }else {
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "验证短信验证码", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "yzTelCode",method = RequestMethod.POST)
    @ResponseBody
    public RespResult yzTelCode(@RequestBody JSONObject json){
        String tel = json.getString("tel");
        String telCode = json.getString("telCode");
        if (StringUtil.isEmpty(tel) || StringUtil.isEmpty(telCode)){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        String cachTelCode = redisService.get(tel);
        if (StringUtil.isNotEmpty(cachTelCode)){
            if (cachTelCode.equals(telCode)){
                redisService.delete(tel);
                return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
            }else {
                return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
            }
        }else {
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "注册", httpMethod = "POST")
    @RequestMapping(value = "register",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public RespResult register(@RequestBody ChClientEntity client){
        try {
            client.setNewShipDate("Y");
            chClientService.save(client);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "登录", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public RespResult login(@RequestBody JSONObject json){
        String tel = json.getString("tel");
        String pwd = json.getString("pwd");
        if (StringUtil.isEmpty(tel) || StringUtil.isEmpty(pwd)){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        List<ChClientEntity> clients = chClientService.findHql("from ChClientEntity where clientMobile = ? and clientPwd = ?",tel,pwd);
        if (clients!=null && clients.size()>0){
            clients.get(0).setClientPwd("*");
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),clients.get(0));
        }else {
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "忘记密码/更新密码", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "forgetPwd",method = RequestMethod.POST)
    @ResponseBody
    public RespResult forgetPwd(@RequestBody JSONObject json){
        String tel = json.getString("tel");
        String pwd = json.getString("pwd");
        if (StringUtil.isEmpty(tel) || StringUtil.isEmpty(pwd)){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        ChClientEntity client = chClientService.findUniqueByProperty(ChClientEntity.class,"clientMobile",tel);
        if (client!=null){
            client.setClientPwd(pwd);
            chClientService.updateEntitie(client);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        }else {
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "更新我的资料/更新手机/实名认证", httpMethod = "POST")
    @RequestMapping(value = "updateInfo",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public RespResult updateInfo(@RequestBody ChClientEntity client){
        ChClientEntity oclient= chClientService.get(ChClientEntity.class,client.getId());
        if (oclient==null){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        try {
            if(client.getClientHeadimg()!=null){
                oclient.setClientHeadimg(client.getClientHeadimg());
            }
            if(client.getClientName()!=null){
                oclient.setClientName(client.getClientName());
            }
            if(client.getClientSex()!=null){
                oclient.setClientSex(client.getClientSex());
            }
            if(client.getClientOpenid()!=null){
                oclient.setClientOpenid(client.getClientOpenid());
            }
            if(client.getClientGzwx()!=null){
                oclient.setClientGzwx(client.getClientGzwx());
            }
            if(client.getClientMobile()!=null){
                oclient.setClientMobile(client.getClientMobile());
            }
            if(client.getClientRealname()!=null){
                oclient.setClientRealname(client.getClientRealname());
            }
            if(client.getClientCreditid()!=null){
                oclient.setClientCreditid(client.getClientCreditid());
            }
            chClientService.updateEntitie(oclient);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "标记货主", httpMethod = "POST")
    @RequestMapping(value = "tagInfo",method = RequestMethod.POST,consumes = "application/json")
    @ResponseBody
    public RespResult tagInfo(@RequestBody JSONObject json){
        String clientId = json.getString("clientId");
        String type = json.getString("type");
        ChClientEntity oclient= chClientService.get(ChClientEntity.class,clientId);
        if (oclient==null){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        if (type.equals("huozhu")){
            int count = oclient.getCountHuozhu();
            oclient.setCountHuozhu(count+1);
        }else if(type.equals("huodai")){
            int count = oclient.getCountHuodai();
            oclient.setCountHuodai(count+1);
        }else if(type.equals("zhongjie")){
            int count = oclient.getCountZhongjie();
            oclient.setCountZhongjie(count+1);
        }else if(type.equals("pianzi")){
            int count = oclient.getCountPianzi();
            oclient.setCountPianzi(count+1);
        }
        try {
            chClientService.updateEntitie(oclient);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "设置新船期通知", httpMethod = "POST",produces="application/json")
    @RequestMapping(value = "newShipDate",method = RequestMethod.POST)
    @ResponseBody
    public RespResult newShipDate(@RequestBody JSONObject json){
        String clientId = json.getString("clientId");
        String yOrN = json.getString("yOrN");
        ChClientEntity client = chClientService.get(ChClientEntity.class,clientId);
        if (client!=null){
            client.setNewShipDate(yOrN);
            chClientService.updateEntitie(client);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        }else {
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }
}
