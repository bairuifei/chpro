package com.jeecg.api;

import com.jeecg.client.entity.ChClientEntity;
import com.jeecg.client.service.ChClientServiceI;
import com.jeecg.util.YzCodeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import java.util.HashMap;
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
    private static final Map<String,String> yzCodes = new HashMap<>();
    private static final long telCodeOverTime = 60l;

    @ApiOperation(value = "获取验证码", httpMethod = "GET")
    @RequestMapping(value = "yzCode",method = RequestMethod.GET)
    public void yzCode(String tel, HttpServletResponse response) throws Exception {
        // 设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        // response.setContentType("image/png");

        //获取随机码和随机码图片
        Map map = YzCodeUtils.buildYzCode();
        yzCodes.put(tel,((String)map.get("code")).toUpperCase());
        logger.info("yzCodes============>\n"+ JSONHelper.map2json(yzCodes));
        // 输出图象到页面
        ImageIO.write((BufferedImage)map.get("image"), "JPEG", response.getOutputStream());
    }

    @ApiOperation(value = "发送短信验证码", httpMethod = "GET")
    @RequestMapping(value = "telCode",method = RequestMethod.GET)
    @ResponseBody
    public RespResult telCode(@RequestParam String tel, @RequestParam String yzCode){
        if (StringUtil.isEmpty(tel) || StringUtil.isEmpty(yzCode)){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        if (yzCodes.containsKey(tel)){
            if ((yzCodes.get(tel)).equals(yzCode.toUpperCase())){
                // TODO: 2018/8/18/018 发送验证码
                String telCode = new Double(Math.random()*10000).intValue()+"";
                logger.info("发送验证码成功=========>"+telCode);
                redisService.setSeconds(tel,telCode,telCodeOverTime);
                return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),telCode);
            }else {
                return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
            }
        }else {
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }

    @ApiOperation(value = "验证短信验证码", httpMethod = "GET")
    @RequestMapping(value = "yzTelCode",method = RequestMethod.GET)
    @ResponseBody
    public RespResult yzTelCode(@RequestParam String tel, @RequestParam String telCode){
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

    @ApiOperation(value = "登录", httpMethod = "GET")
    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ResponseBody
    public RespResult login(@RequestParam String tel, @RequestParam String pwd){
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

    @ApiOperation(value = "忘记密码/更新密码", httpMethod = "GET")
    @RequestMapping(value = "forgetPwd",method = RequestMethod.GET)
    @ResponseBody
    public RespResult forgetPwd(@RequestParam String tel, @RequestParam String pwd){
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

    @ApiOperation(value = "更新我的资料", httpMethod = "GET",produces="application/json")
    @RequestMapping(value = "updateInfo",method = RequestMethod.GET)
    @ResponseBody
    public RespResult updateInfo(@RequestBody ChClientEntity client){
        ChClientEntity oclient= chClientService.get(ChClientEntity.class,client.getId());
        if (oclient==null){
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
        try {
            oclient.setClientHeadimg(client.getClientHeadimg());
            oclient.setClientName(client.getClientName());
            oclient.setClientSex(client.getClientSex());
            oclient.setClientOpenid(client.getClientOpenid());
            oclient.setClientGzwx(client.getClientGzwx());
            chClientService.updateEntitie(oclient);
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.FAIL.getCode(),RespMsg.FAIL.getMsg(),null);
        }
    }
}
