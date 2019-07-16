package main.java.BL.Contract.Logic;

import main.java.BL.Contract.Order;
import main.java.BL.Contract.OrderStatus;
import main.java.BL.Contract.Product;
import main.java.common.exceptions.RestaurantManagerException;
import main.java.dataAccess.IRestaurantRepository;
import main.java.database.OrderRepository;
import main.java.database.RestaurantRepository;

import java.util.HashMap;
import java.util.Vector;


public class OrderController implements IOrderManager {

    public OrderController() {
    }


    @Override
    public int AddOrder(Order order) {
        double currentBudget = RestaurantRepository.getRestaurant().getBudget();
        if (currentBudget < order.getTotalAmount()) {
            // Not enogth mbudget to order;
            return -1;
        }
        int orderId = OrderRepository.addOrder(order);

        return orderId;
    }

    @Override
    public Order GetOrder(int orderId) {
        return OrderRepository.getOrderById(orderId);
    }

    @Override
    public void EditOrder(int orderId, Order order) {

        Order existingOrder = OrderRepository.getOrderById(orderId);
        if (order == null)
            throw new RestaurantManagerException("User already exist.");
        OrderRepository.editOrder(orderId, order);

    }

    @Override
    public void CompletedOrder(int orderId) {
        Order order = OrderRepository.getOrderById(orderId);
        order.setOrderStatus(OrderStatus.Completed);
        OrderRepository.editOrder(orderId, order);
    }

    @Override
    public void AddRatingPerOrder(int rating, int orderId) {
        Order order = OrderRepository.getOrderById(orderId);
        order.setRating(rating);
        OrderRepository.editOrder(orderId, order);

    }

    @Override
    public Vector<Product> getListOfOrderedProductsByOrder(String orderId) {
        return OrderRepository.getListOfOrderedProductsByOrder(orderId);
    }

    @Override
    public Vector<Order> getListOfOrders(HashMap hashMap) {
        return OrderRepository.getListOfOrders(hashMap);
    }
}
;