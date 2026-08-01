package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Order;

public interface Orderrepo extends JpaRepository<Order,Integer>{

}
