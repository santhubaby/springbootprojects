package in.ashokit.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import in.ashokit.entity.Consumerorder;
import in.ashokit.repo.Consumerrepo;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class Orderconsumercontroller {

    private final Consumerrepo consumerOrderRepository;

    public Orderconsumercontroller(Consumerrepo consumerOrderRepository) {
        this.consumerOrderRepository = consumerOrderRepository;
    }

    @GetMapping("/orders")
    @PreAuthorize("hasRole('USER')")
    public List<Consumerorder> getAllOrders() {
        return consumerOrderRepository.findAll();
    }

    @GetMapping("/admin/orders")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Consumerorder> getAdminOrders() {
        return consumerOrderRepository.findAll();
    }
}

