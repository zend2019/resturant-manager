package main.java.BL.Contract;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Order {
    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }
    public HashMap<String, Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(HashMap<String, Integer> productIds) {
        this.productIds = productIds;
    }

    private Date deliveryDate;
    private int orderId;
    private HashMap<String,Integer> productIds;
    private Double totalAmount;
    private int rating;
    private Date OrderDate;
    private OrderStatus orderStatus;
}
