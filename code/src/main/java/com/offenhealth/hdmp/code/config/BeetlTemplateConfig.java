package com.offenhealth.hdmp.code.config;

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

/**
 * beetl模板配置
 * Created by earl on 2017/3/20.
 */
@Configuration
public class BeetlTemplateConfig {

    @Value("${beetl.pagePath}")
    private String pagePath;


    @Value("${beetl.properties}")
    private String properties;


    // 配置 Beetl
    @Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration configuration = new BeetlGroupUtilConfiguration();
        // 获取资源解析器
        ResourcePatternResolver patternResolver = ResourcePatternUtils
                .getResourcePatternResolver(new DefaultResourceLoader());
        try {
            // 获取模板文件所在的根目录
            String root = patternResolver.getResource("classpath:"+pagePath).getFile().getPath();
            WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader(root);
            // 设置资源加载器
            configuration.setResourceLoader(webAppResourceLoader);
            // 设置配置文件
            configuration.setConfigFileResource(patternResolver.getResource(properties));
            return configuration;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver beetlSpringViewResolver(
            @Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        //页面模板后缀为.html格式 （不配置这个会导致项目启动后第一次访问页面空白）
        beetlSpringViewResolver.setSuffix(".html");
        return beetlSpringViewResolver;
    }

}
