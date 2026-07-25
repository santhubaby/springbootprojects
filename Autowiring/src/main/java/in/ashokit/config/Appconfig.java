package in.ashokit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "in.ashokit")
public class Appconfig {
		
		public Appconfig() {
			System.out.println("AppConfig::Constructor");
		}

	}

