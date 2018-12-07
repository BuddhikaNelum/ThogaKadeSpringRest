package lk.ijse.absd.pos.controller;

import lk.ijse.absd.pos.dto.OrdersDTO;
import lk.ijse.absd.pos.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PutMapping("/{id}")
    public void saveOrder(@PathVariable("id") String id, @RequestBody OrdersDTO ordersDTO){
        ordersService.saveOrder(id,ordersDTO);
    }
}
