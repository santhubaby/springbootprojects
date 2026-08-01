package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class RedisascacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisascacheApplication.class, args);
	}

}
