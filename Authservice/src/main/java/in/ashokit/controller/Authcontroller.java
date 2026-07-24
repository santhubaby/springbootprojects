package in.ashokit.controller;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.dto.Authdto;
import in.ashokit.dto.Authdto.AuthRequest;
import in.ashokit.dto.Authdto.AuthResponse;
import in.ashokit.entity.User;
import in.ashokit.jwtutility.Jwtutil;
import in.ashokit.repo.Userrepo;
import in.ashokit.service.Userservice;

@RestController
@RequestMapping("/auth")
public class Authcontroller {

    @Autowired 
    private AuthenticationManager authManager;
    @Autowired 
    private Jwtutil jwtUtil;
    @Autowired 
    private Userservice uservice;
    @Autowired 
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        // Always encode password before saving
        uservice.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        UsernamePasswordAuthenticationToken authToken =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
        try {
            Authentication authentication = authManager.authenticate(authToken);

            if (authentication.isAuthenticated()) {
                // ✅ Use authenticated principal’s authorities, not request.getRole()
            	System.out.println("autheticationauthorities:"+authentication.getAuthorities());
            	Collection<? extends GrantedAuthority> filteredAuthorities =
            		    authentication.getAuthorities().stream()
            		        .filter(auth -> {
            		            String role = auth.getAuthority();
            		            return !role.equals("FACTOR_PASSWORD") && !role.equals("ROLE_FACTOR_PASSWORD");
            		        })
            		        .toList();

            		String token = jwtUtil.generateToken(
            		    authentication.getName(),
            		    filteredAuthorities
            		);


            		System.out.println("controllerfilteredAuthorities: " +filteredAuthorities);

                return ResponseEntity.ok(new AuthResponse(token));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new AuthResponse("invalid credentials"), HttpStatus.BAD_REQUEST);
    }
}

	        

	        
	        
/***
	         * es, exactly — you’re creating an AuthResponse object just to wrap the token and send it back in the HTTP response body.

The AuthResponse class is a simple DTO (Data Transfer Object) with a field like token.

When you return ResponseEntity.ok(new AuthResponse(token)), Spring automatically serializes that object into JSON.

The client then sees a clean JSON response like:

json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
So the purpose of AuthResponse is simply to display the token in a structured way instead of returning a raw string. It makes your API response cleaner and easier to consume.
	         */
	    
	 //In short: yes, you’re creating the AuthResponse object just to display (return) the token in a structured way.   
	    
	



