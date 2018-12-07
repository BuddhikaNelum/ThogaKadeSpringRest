package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.CustomerDTO;
import lk.ijse.absd.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PutMapping("/{id}")
    public void saveCustomer(@PathVariable("id") String customerId, @RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerId,customerDTO);
    }

    @PostMapping("/{id}")
    public void updateCustomer(@PathVariable("id") String customerId, @RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerId,customerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") String customerId){
        customerService.deleteCustomer(customerId);
    }

    @GetMapping("/{id}")
    public CustomerDTO findCustomer(@PathVariable("id") String customerId){
        return customerService.findCustomer(customerId);
    }

    @GetMapping
    public Object findAllCustomers(@RequestParam(value = "action",required = false)String action,
                                   @RequestParam(value = "name",required = false)String name){
        if (action != null){
            switch (action){
                case "count":
                    return customerService.getCustomerCount();
                case "like":
                    return customerService.findCustomersLike(name);
                default:
                    return customerService.findAllCustomers();
            }
        }else {
            return customerService.findAllCustomers();
        }
    }

}
