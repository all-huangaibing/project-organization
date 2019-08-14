package com.matteo.gitinfo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * 功能：
 *
 * @author huangaibing
 * @date  2019/8/14 10:34
 */
@Controller
public class ProjectVersionController {
    /** logger */
    private final static Logger logger = LoggerFactory.getLogger(ProjectVersionController.class);

    @Value("${spring.application.name}")
    private String projectName;

    private StringBuilder versionInfo;


    @RequestMapping(value = "/version", method = GET)
    @ResponseBody
    public StringBuilder versionInformation() {
        return versionInfo;
    }

    public ProjectVersionController(){
        try{
            InputStream inputStream = ProjectVersionController.class.getClassLoader().getResourceAsStream("git.properties");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder gitPropertiesBuilder = new StringBuilder();
            String line ;
            while ((line = bufferedReader.readLine()) != null) {
                gitPropertiesBuilder.append(line);
            }
            Map<String, String> gitProperties = JSON.parseObject(gitPropertiesBuilder.toString(),
                    new TypeReference<Map<String, String>>() {});
            versionInfo = new StringBuilder();
            versionInfo.append("git.build.version = ").append(gitProperties.get("git.build.version")).append("<br/>")
                    .append("git.branch = ").append(gitProperties.get("git.branch")).append("<br/>")
                    .append("git.build.time = ").append(gitProperties.get("git.build.time")).append("<br/>")
                    .append("git.commit.id = ").append(gitProperties.get("git.commit.id")).append("<br/>")
                    .append("git.commit.time = ").append(gitProperties.get("git.commit.time")).append("<br/>");
            System.out.println("versionInfoBuilder = " + versionInfo);
        }catch (Exception e){
            logger.error("HealthCheckController error",e);
            versionInfo = new StringBuilder("Version information could not be retrieved");
        }

    }

    /*
        {
        "git.tags":"",
        "git.build.version":"0.0.2-SNAPSHOT",
        "git.closest.tag.commit.count":"",
        "git.commit.user.name":"huangaibing",
        "git.commit.id.abbrev":"c636592",
        "git.branch":"dev",
        "git.build.host":"DESKTOP-MQ7J9EE",
        "git.commit.id.describe-short":"c636592-dirty",
        "git.commit.id.describe":"c636592-dirty",
        "git.build.user.email":"huangaibing@pcuu.com",
        "git.commit.id":"c6365925b58043a4f5a66c5b6f01bd6a2a11ad06",
        "git.commit.message.short":"Merge remote-tracking branch 'origin/dev' into dev",
        "git.commit.user.email":"huangaibing@pcuu.com",
        "git.closest.tag.name":"",
        "git.build.time":"2019-08-14 152821",
        "git.commit.time":"2019-08-14 145956",
        "git.build.user.name":"huangaibing",
        "git.dirty":"true",
        "git.commit.message.full":"Merge remote-tracking branch 'origin/dev' into dev",
        "git.remote.origin.url":"git@git.zmcms.cn:basicservices/crm-center.git"
        }
    */
    public static void main(String[] args) {
        String a = "aaaa";
        System.out.println("a = " + a);
        System.out.println("JSON.toJSONString(a) = " + JSON.toJSONString(a));
        StringBuilder b = new StringBuilder("bbbb");
        System.out.println("b = " + b);
        System.out.println("JSON.toJSONString(a) = " + JSON.toJSONString(b));
    }
}
