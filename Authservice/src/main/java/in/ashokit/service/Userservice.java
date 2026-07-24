package in.ashokit.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.ashokit.entity.User;
import in.ashokit.repo.Userrepo;


@Service
public class Userservice implements UserDetailsService {

    @Autowired
    private Userrepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user by username/email
        User appuser= userRepo.findByUsername(username);
        if (appuser == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (!"FACTOR_PASSWORD".equals(appuser.getRole())) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + appuser.getRole()));
        }

		System.out.println("UserserviceAuthorities: " +authorities);

        // Return Spring Security User object
        return new org.springframework.security.core.userdetails.User(appuser.getUsername(), appuser.getPassword(), authorities);
    }

    public User saveUser(User appUser) {
        // Encode password before saving
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));


        return userRepo.save(appUser);
    }
}

