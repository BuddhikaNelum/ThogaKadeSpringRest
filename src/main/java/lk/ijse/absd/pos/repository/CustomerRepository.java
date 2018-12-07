package lk.ijse.absd.pos.repository;

import lk.ijse.absd.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,String> {

    List<Customer> findCustomerByNameLike(String name);

}
