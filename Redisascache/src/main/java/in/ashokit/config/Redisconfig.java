package in.ashokit.config;

import java.time.Duration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;



@Configuration
@EnableCaching
public class Redisconfig {
	
	@Bean
	public GenericJackson2JsonRedisSerializer gj() {
	    ObjectMapper mapper = new ObjectMapper();
	    mapper.activateDefaultTyping(
	        BasicPolymorphicTypeValidator.builder()
	            .allowIfSubType(Object.class)
	            .build(),
	        ObjectMapper.DefaultTyping.NON_FINAL
	    );
	    return new GenericJackson2JsonRedisSerializer(mapper);
	}


    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofMinutes(6)) // TTL of 1 minute
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(gj())
            );

        return RedisCacheManager.builder(connectionFactory)
            .cacheDefaults(config)
            .build();
    }
}
