package lk.ijse.absd.pos.repository;

import lk.ijse.absd.pos.entity.OrderDetail;
import lk.ijse.absd.pos.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, OrderDetail> {
}
