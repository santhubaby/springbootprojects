package in.ashokit.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Securityconfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for stateless services
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/consumer/admin/**").hasRole("ADMIN") // only ADMIN can access admin endpoints
                .requestMatchers("/consumer/**").hasRole("USER")        // USER role can access consumer endpoints
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
