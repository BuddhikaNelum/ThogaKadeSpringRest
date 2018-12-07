package lk.ijse.absd.pos.service.impl;

import lk.ijse.absd.pos.dto.CustomerDTO;
import lk.ijse.absd.pos.entity.Customer;
import lk.ijse.absd.pos.repository.CustomerRepository;
import lk.ijse.absd.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveCustomer(String customerId, CustomerDTO customerDTO) {
        if (!customerDTO.getId().equals(customerId)){
            throw new RuntimeException("Customer Id mismatched");
        }
        repository.save(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress()));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        if(!customerDTO.getId().equals(customerId)){
            throw new RuntimeException("Customer Id mismatched");
        }
        if (repository.existsById(customerId)){
            repository.save(new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress()));
        }else {
            throw new RuntimeException("Customer not found");
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }

    @Override
    public CustomerDTO findCustomer(String customerId) {
        Customer customer = repository.findById(customerId).get();
        return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
    }

    @Override
    public List<CustomerDTO> findAllCustomers() {
        List<Customer> allCustomers = repository.findAll();
        List<CustomerDTO> dtos = new ArrayList<>();
        allCustomers.forEach(customer -> dtos.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress())));
        return dtos;
    }

    @Override
    public List<CustomerDTO> findCustomersLike(String name) {
        List<Customer> allCustomers = repository.findCustomerByNameLike(name + "%");
        List<CustomerDTO> dtos = new ArrayList<>();
        allCustomers.forEach(customer -> new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
        return dtos;
    }

    @Override
    public long getCustomerCount() {
        return repository.count();
    }

}
