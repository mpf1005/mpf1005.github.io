package com.offenhealth.hdmp.code;

import com.offenhealth.hdmp.code.config.PathYml;
import com.offenhealth.hdmp.eshop.common.util.DefaultProfileUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties({PathYml.class})  //加载配置文件属性到这些类中
@MapperScan("com.offenhealth.hdmp.code.dao")
public class CodeApplication  {

    private static final Logger log = LoggerFactory.getLogger(CodeApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(CodeApplication.class);
        DefaultProfileUtils.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        //是否使用ssl
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        //访问路径
        String contextPath = env.getProperty("server.context-path");
        if (contextPath == null){
            contextPath = "";
        }
        //把contextPath保存起来
        PathYml.setContextPath(contextPath);
        //拼接项目的访问路径，并打印出来
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "接口文档地址: \t\t{}://localhost:{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port")+contextPath,
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port")+contextPath,
                protocol,env.getProperty("server.port")+contextPath+"/swagger-ui.html",
                env.getActiveProfiles());
    }

}
