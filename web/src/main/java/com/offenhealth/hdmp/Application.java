package com.offenhealth.hdmp;
import com.offenhealth.hdmp.eshop.common.util.DefaultProfileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 启动主程序
 */
@SpringBootApplication
@ComponentScan()
public class Application {


    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }


    private static final Logger log = LoggerFactory.getLogger(Application.class);

    //启动方法
    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        DefaultProfileUtils.addDefaultProfile(app);
        ApplicationContext ctx = app.run(args);
        Environment env = ctx.getEnvironment();
        //是否使用ssl
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String contextPath = env.getProperty("server.context-path");

        String[] beanNames =  ctx.getBeanDefinitionNames();
        System.out.println("所以beanNames个数："+beanNames.length);
        for(String bn:beanNames){
            System.out.println(bn);
        }


        String[] serviceBeanNames =  ctx.getBeanNamesForAnnotation(Service.class);
        System.out.println("Service注解beanNames个数："+serviceBeanNames.length);
        for(String bn:serviceBeanNames){
            System.out.println(bn);
        }

        String[] repositoryBeanNames =  ctx.getBeanNamesForAnnotation(Repository.class);
        System.out.println("Repository注解beanNames个数："+repositoryBeanNames.length);
        for(String bn:repositoryBeanNames){
            System.out.println(bn);
        }


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
