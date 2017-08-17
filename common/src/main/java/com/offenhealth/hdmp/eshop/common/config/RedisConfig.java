package com.offenhealth.hdmp.eshop.common.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 * Created by earl on 2017/4/1.
 */
@Configuration
@EnableCaching    //开启缓存支持
public class RedisConfig extends CachingConfigurerSupport {

    @Bean
    public KeyGenerator wiselyKeyGenerator(){
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };
    }

    @Bean
    public CacheManager cacheManager( RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate( RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate< Object, Object> template = new RedisTemplate< >();
        template. setConnectionFactory( redisConnectionFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer( Object. class);
        ObjectMapper om = new ObjectMapper();
        om. setVisibility( PropertyAccessor. ALL, JsonAutoDetect. Visibility. ANY);
        om. enableDefaultTyping( ObjectMapper. DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer. setObjectMapper( om);
        //设置值的序列化采用	jackson2JsonRedisSerializer
        template. setValueSerializer( jackson2JsonRedisSerializer);
        //设置键的序列化采用StringRedisSerializer
        template. setKeySerializer( new StringRedisSerializer());
        template. afterPropertiesSet();
        return template;
    }

}
