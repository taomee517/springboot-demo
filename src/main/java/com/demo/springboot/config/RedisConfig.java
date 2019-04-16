package com.demo.springboot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author LuoTao
 * @email taomee517@qq.com
 * @date 2019/4/11
 * @time 18:15
 */
@Configuration
public class RedisConfig{

    @Bean
    public KeyGenerator wiselyKeyGenerator(){
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                if(obj != null) {
                    sb.append(obj.toString());
                }
            }
            return sb.toString();
        };
    }

    @Bean
    /**RedisAutoConfiguration类已经自动注入了redisTemplate对象*/
    public StringRedisTemplate redisTemplate(RedisConnectionFactory factory) {
        final StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setDefaultSerializer(jackson2JsonRedisSerializer);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
