package com.applet.config;

import com.applet.utils.common.JJFunctions;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


@SpringBootConfiguration
public class RedisConfig {

    @Bean
    public RedisTemplate redisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        StringRedisSerializer srs = new StringRedisSerializer();
        Jackson2JsonRedisSerializer jsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        jsonRedisSerializer.setObjectMapper(JJFunctions.getObjectMapper());
        template.setKeySerializer(srs);
        template.setHashKeySerializer(srs);
        template.setValueSerializer(jsonRedisSerializer);
        template.setHashValueSerializer(jsonRedisSerializer);
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /*<bean id="jedisPool10" class="redis.clients.jedis.JedisPool">
        <constructor-arg index="0" ref="jedisPoolConfig" />
		<constructor-arg index="1" value="${redis.host}" />
		<constructor-arg index="2" value="${redis.port}" type="int" />
		<constructor-arg index="3" value="${redis.timeout}" type="int" />
		<constructor-arg index="4" value="${redis.password}" />
		<constructor-arg index="5" value="${redis.database10}" type="int" />
	</bean>
	<bean id="jedisPool1"  class="redis.clients.jedis.JedisPool">
		<constructor-arg index="0" ref="jedisPoolConfig" />
		<constructor-arg index="1" value="${redis.host}" />
		<constructor-arg index="2" value="${redis.port}" type="int" />
		<constructor-arg index="3" value="${redis.timeout}" type="int" />
		<constructor-arg index="4" value="${redis.password}" />
		<constructor-arg index="5" value="${redis.database1}" type="int" />
	</bean>*/

}
