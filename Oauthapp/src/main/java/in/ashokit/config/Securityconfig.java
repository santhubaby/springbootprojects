package in.ashokit.config;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class Securityconfig {
	
	

	@org.springframework.context.annotation.Configuration
	public class SecurityConfig {

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/","/welcome").permitAll()
	                .anyRequest().authenticated()
	            )
	            .oauth2Login(oauth -> oauth
	                .defaultSuccessUrl("/welcome", true) // redirect after login
	            );

	        return http.build();
	    }
	}

}
