package in.ashokit.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import in.ashokit.entity.User;
import in.ashokit.repo.Userrepo;
import in.ashokit.service.Userservice;


@Configuration
@EnableWebSecurity
public class Securityconfig {

    @Autowired
    private Userrepo userRepo;
    
    @Autowired
    Userservice uservice;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Define UserDetailsService bean
    //In plain words: this bean says “When someone logs in, fetch the user from the DB, and give Spring Security a User object with username, password, and role.”
   
    // AuthenticationManager bean
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    
    //performs actual authentication
    //User- class that implements userdetails interface
    //Cachedetailsmanager-class that implements userdetailsservice
    //userdetailservice has a method loaduserbyusername
    //daoauthenticationprovider extends parent class(abstract....some name)
    
    //authmanager is a functional interface having method authenticate
    //daoauthentionprovider extends parent that parent has authenticate method
    //auth manager .authenticate return Authentication interface object
   /***
    *  AuthenticationManager → interface.
    

    ProviderManager → default implementation of AuthenticationManager.

    ProviderManager delegates authentication to one or more AuthenticationProviders (like DaoAuthenticationProvider).

    DaoAuthenticationProvider uses your UserDetailsService + PasswordEncoder to check credentials against the database.
    //--------------------------------------------------
    //--------------------------------------------------
    How delegation works step by step
You call:

java
authenticationManager.authenticate(
    new UsernamePasswordAuthenticationToken(username, password)
);
Since your authenticationManager is actually a ProviderManager, it loops through its configured AuthenticationProviders.

It finds a DaoAuthenticationProvider that supports UsernamePasswordAuthenticationToken.

DaoAuthenticationProvider calls your UserDetailsService.loadUserByUsername(username) to fetch user details.

It then compares the provided password with the stored one using your PasswordEncoder.

If valid, it returns an authenticated Authentication object (with roles/authorities).
If invalid, it throws BadCredentialsException.

👉 So the relationship is:

AuthenticationManager = interface.

ProviderManager = default implementation of that interface.

DaoAuthenticationProvider = plugged into ProviderManager as one of its delegates.

ProviderManager delegates authentication requests to DaoAuthenticationProvider (or other providers) until one succeeds.
    
    
 AuthenticationManager → interface with the method authenticate(Authentication authentication).

ProviderManager → the default implementation of AuthenticationManager.

It doesn’t authenticate directly.

Instead, it maintains a list of AuthenticationProviders.

When you call authenticate(), it loops through that list and delegates the request.

AuthenticationProvider → interface that defines how to perform authentication for a specific type of Authentication (e.g., username/password, LDAP, OAuth2).

DaoAuthenticationProvider → a concrete implementation of AuthenticationProvider that uses UserDetailsService + PasswordEncoder to check credentials against a database.

//Authmanager is a functional interface holding authenticate method

//Authmanager functionalinterface implemented by providermanager class

//providermanager is  a class containing interfaces such as Authenticationproviders

//Authenticationprovider is an interface here in the case username and password it is implemented by daoathenticationprovider class
//this daothenticationprovider extends parent class that parent class has authenticate method
///
///
///UsernamePasswordAuthenticationToken, JwtAuthenticationToken, etc. implement Authentication interface
///
///Authentication authentication -means authtoken which is usernamepasswordauthenticationtoken class object
*/
    
    @Bean
	public AuthenticationProvider authProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(uservice);
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;

	}
    
   

    // Security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/register","/auth/login").permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}




