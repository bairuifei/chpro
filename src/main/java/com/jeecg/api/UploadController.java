package com.jeecg.api;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecgframework.core.enums.StoreUploadFilePathEnum;
import org.jeecgframework.core.util.ResourceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/upload")
@Api(value = "图片上传接口", description = "图片上传接口", tags = "uploadAPI")
public class UploadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    /**
     * WebUploader
     * 文件上传处理/删除处理
     */

    @ApiOperation(value = "文件上传", httpMethod = "POST")
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RespResult upload(HttpServletRequest request) {
        String ctxPath= ResourceUtil.getConfigByName("webUploadpath");//demo中设置为D://upFiles,实际项目应因事制宜
        String webUploaddbpath=ResourceUtil.getConfigByName("webUploaddbpath");//数据库存储前缀
        try {
            //如果是上传操作
            String fileName = null;
            String bizPath= StoreUploadFilePathEnum.DEFAULT.getPath();
            String nowday=new SimpleDateFormat("yyyyMMdd").format(new Date());
            File file = new File(ctxPath+File.separator+bizPath+File.separator+nowday);
            if (!file.exists()) {
                file.mkdirs();// 创建文件根目录
            }
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile mf=multipartRequest.getFile("file");// 获取上传文件对象
            String orgName = mf.getOriginalFilename();// 获取文件名
            fileName = orgName.substring(0,orgName.lastIndexOf("."))+"_"+System.currentTimeMillis()+orgName.substring(orgName.indexOf("."));
            String savePath = file.getPath() + File.separator + fileName;
            File savefile = new File(savePath);
            FileCopyUtils.copy(mf.getBytes(), savefile);
            String dbpath=webUploaddbpath+File.separator+bizPath+File.separator+nowday+File.separator+fileName;
            return new RespResult(0,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),dbpath);
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(1,RespMsg.SUCCESS.getCode(),RespMsg.SUCCESS.getMsg(),null);
        }
    }
}
