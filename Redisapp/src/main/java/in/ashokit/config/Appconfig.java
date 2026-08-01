package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import in.ashokit.model.Student;

@Configuration
public class Appconfig {
	
	
	//Redisconnection
	
	@Bean
	public RedisConnectionFactory cf()
	{
		return new LettuceConnectionFactory();
	}
	
	
	@Bean 
	public StringRedisSerializer  ss() {
		
		return new StringRedisSerializer();
	}
	
	
	
	
   @Bean
   public RedisTemplate<String,Student> rt()
   {
	   RedisTemplate<String, Student> template =new RedisTemplate<>();
	   template.setConnectionFactory(cf());
	   
	// Use String keys
	    template.setKeySerializer(ss());
	    template.setHashKeySerializer(ss());
 // use json for values
	    Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
	    template.setValueSerializer(serializer);
	    template.setHashValueSerializer(serializer);

	    template.afterPropertiesSet();
	   return template;
   }
}
