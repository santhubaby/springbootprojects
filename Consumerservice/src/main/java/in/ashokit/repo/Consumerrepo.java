package in.ashokit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Consumerorder;

import java.util.Optional;

public interface Consumerrepo extends JpaRepository<Consumerorder, Long> {
    Optional<Consumerorder> findByOrderitem(String orderitem);
}
