package lk.ijse.absd.pos.service;

import lk.ijse.absd.pos.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {

    void saveCustomer(String customerId, CustomerDTO customerDTO);

    void updateCustomer(String customerId, CustomerDTO customerDTO);

    void deleteCustomer(String customerId);

    CustomerDTO findCustomer(String customerId);

    List<CustomerDTO> findAllCustomers();

    List<CustomerDTO> findCustomersLike(String name);

    long getCustomerCount();
}
