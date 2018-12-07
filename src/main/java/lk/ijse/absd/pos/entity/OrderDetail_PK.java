/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.absd.pos.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author ranjith-suranga
 */
@Embeddable
public class OrderDetail_PK implements Serializable{
    
    private String orderId;
    private String itemCode;

    public OrderDetail_PK() {
    }

    public OrderDetail_PK(String orderId, String itemCode) {
        this.orderId = orderId;
        this.itemCode = itemCode;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public String toString() {
        return "OrderDetail_PK{" + "orderId=" + orderId + ", itemCode=" + itemCode + '}';
    }

    
    
}
