package com.kmu.manager.util;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

public class UploadUtil {

    //生成随机字符串
    public static String randomString(){
        //要求做的随机，重复的概率要求很小，时间戳+随机字符串    从1970年1月1日0点开始，经过的毫秒数
        long time = new Date().getTime();
        String s = UUID.randomUUID().toString().replace("-","");
        return time+s;
    }
    
    //上传文件的方法
    public static boolean upload(String fileName, InputStream inputStream, String bucketName) {
        try{
            // Endpoint以杭州为例，其它Region请按实际情况填写。
            String endpoint = "https://oss-cn-chengdu.aliyuncs.com";
            // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
            String accessKeyId = "LTAI4GGUFTeM9yeJB9oN3AQj";
            String accessKeySecret = "Tpso9BlL4fUe802zAQ2Q97FtmHJ4Dl";
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
