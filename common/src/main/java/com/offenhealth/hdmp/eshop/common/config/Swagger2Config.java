package com.offenhealth.hdmp.eshop.common.config;

import com.google.common.base.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//参考：http://blog.csdn.net/catoop/article/details/50668896
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.offenhealth"))
                .paths(PathSelectors.any())
                .build();
    }

//    @Bean
//    public Docket createRestApi() {
//        //排除某些注解的类
//        Predicate<RequestHandler> predicate = input -> {
//            Class<?> declaringClass = input.declaringClass();
//            if (declaringClass == BasicErrorController.class)// 排除
//                return false;
//            if(declaringClass.isAnnotationPresent(Api.class)) // 被注解的类
//                return true;
//            if(input.isAnnotatedWith(ApiOperation.class)) // 被注解的方法
//                return true;
//            return false;
//        };
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(predicate)
//                .build();
//    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("--------------------")
                .termsOfServiceUrl("hdmp")
                .contact("hdmp")
                .version("1.0")
                .build();
    }

}