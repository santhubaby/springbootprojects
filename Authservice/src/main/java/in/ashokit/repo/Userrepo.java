package in.ashokit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.User;

public interface Userrepo extends JpaRepository<User, Long> {
	    User findByUsername(String username);
	}


