/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.absd.pos.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ranjith-suranga
 */
@Entity
public class OrderDetail {
    
    @EmbeddedId
    private OrderDetail_PK orderDetail_PK;
    private int qty;
    private double unitPrice;
    
    @ManyToOne
    @JoinColumn(name="orderId", referencedColumnName = "id", insertable = false, updatable = false)
    private Orders order;
    
    @ManyToOne
    @JoinColumn(name="itemCode", referencedColumnName = "code", insertable = false, updatable = false)
    private Item item;

    public Orders getOrder() {
        return order;
    }

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String itemCode, int qty, double unitPrice) {
        this.orderDetail_PK = new OrderDetail_PK(orderId, itemCode);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public OrderDetail(OrderDetail_PK orderDetail_PK, int qty, double unitPrice) {
        this.orderDetail_PK = orderDetail_PK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    
    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the orderDetail_PK
     */
    public OrderDetail_PK getOrderDetail_PK() {
        return orderDetail_PK;
    }

    /**
     * @param orderDetail_PK the orderDetail_PK to set
     */
    public void setOrderDetail_PK(OrderDetail_PK orderDetail_PK) {
        this.orderDetail_PK = orderDetail_PK;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "orderDetail_PK=" + orderDetail_PK + ", qty=" + qty + ", unitPrice=" + unitPrice + '}';
    }
    
}
