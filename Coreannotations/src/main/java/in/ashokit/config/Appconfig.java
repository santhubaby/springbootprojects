package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import in.ashokit.beans.Appsecurity;

@Configuration
@ComponentScan(basePackages="in.ashokit")
public class Appconfig {
	
	

		public Appconfig() {
			System.out.println("AppConfig :: Constructor");
		}

		@Bean
		public Appsecurity getSecurityContextObj() {
			Appsecurity security = new Appsecurity("SHA-256");
			// security logic
			return security;
		}
	}


