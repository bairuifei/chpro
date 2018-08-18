package com.jeecg.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/testController")
@Api(value = "测试接口", description = "测试接口", tags = "testAPI")
public class TestController {

    @ApiOperation(value = "test", produces = "application/json", httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "hello api";
    }
}
