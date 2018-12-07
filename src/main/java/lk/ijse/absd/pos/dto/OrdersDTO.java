package lk.ijse.absd.pos.dto;

import java.util.Date;
import java.util.List;

public class OrdersDTO {

    private String id;
    private Date date;
    private String customerId;
    private List<OrderDetailsDTO> orderDetails;

    public List<OrderDetailsDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailsDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrdersDTO(String id, Date date, String customerId, List<OrderDetailsDTO> orderDetails) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.orderDetails = orderDetails;
    }

    public OrdersDTO() {
    }

    public OrdersDTO(String id, Date date, String customerId) {
        this.setId(id);
        this.setDate(date);
        this.setCustomerId(customerId);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
