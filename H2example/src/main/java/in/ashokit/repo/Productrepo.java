package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Product;

public interface Productrepo extends JpaRepository<Product, Integer> {

}