package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Address;

public interface Addressrepo extends JpaRepository<Address, Integer>{

}