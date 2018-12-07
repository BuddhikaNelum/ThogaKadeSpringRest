package lk.ijse.absd.pos.service.impl;

import lk.ijse.absd.pos.dto.OrderDetailsDTO;
import lk.ijse.absd.pos.dto.OrdersDTO;
import lk.ijse.absd.pos.entity.Customer;
import lk.ijse.absd.pos.entity.OrderDetail;
import lk.ijse.absd.pos.entity.OrderDetail_PK;
import lk.ijse.absd.pos.entity.Orders;
import lk.ijse.absd.pos.repository.OrdersRepository;
import lk.ijse.absd.pos.service.OrdersService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class OrdersServiceImpl implements OrdersService {

    private OrdersRepository repository;

    @Override
    public void saveOrder(String id, OrdersDTO ordersDTO) {

        Orders orders = new Orders();
        Customer customer = new Customer(ordersDTO.getCustomerId(),null,null);

        List<OrderDetailsDTO> orderDetailsDTOS = ordersDTO.getOrderDetails();
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (OrderDetailsDTO dto: orderDetailsDTOS) {
            orderDetails.add(new OrderDetail(new OrderDetail_PK(ordersDTO.getId(),dto.getItemCode()),dto.getQty(),dto.getUnitPrice()));
        }

        orders.setId(ordersDTO.getId());
        orders.setDate(ordersDTO.getDate());
        orders.setCustomer(customer);
        orders.setOrderDetails(orderDetails);

        repository.save(orders);

    }
}
