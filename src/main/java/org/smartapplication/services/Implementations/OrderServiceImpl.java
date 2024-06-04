package org.smartapplication.services.Implementations;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.smartapplication.dtos.response.Order.CancelOrderResponse;
import org.smartapplication.exceptions.OrderNotFoundException;
import org.smartapplication.exceptions.UnpaidOrderAlreadyExists;
import org.smartapplication.model.Customer;
import org.smartapplication.model.Order;
import org.smartapplication.model.OrderItems;
import org.smartapplication.model.Product;
import org.smartapplication.repositories.*;
import org.smartapplication.services.OrderService;
import org.smartapplication.services.StoreService;
import org.smartapplication.services.UserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemsRepository;
    private  final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderItemRepository orderItemRepository, OrderItemRepository orderItemsRepository, CustomerRepository customerRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderItemsRepository = orderItemsRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }


    @Override
    public Order findBy(Long id) {
        return null;
    }

    @Override
    public Order placeOrder(Order order) {
        boolean unpaidOrderExists = orderRepository.existsByCustomerIdAndDeliveryAddressAndPhoneNumberAndIsPaidFalse(
                order.getCustomer().getId(), order.getDeliveryAddress(), order.getPhoneNumber());

        if (unpaidOrderExists) {
            throw new UnpaidOrderAlreadyExists("Order already exists for this customer at the given delivery address");
        }

        Customer customer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        order.setCustomer(customer);

        BigDecimal total = BigDecimal.ZERO;
        for (OrderItems item : order.getProducts()) {
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            item.setProduct(product);
            item.setOrder(order);

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
            //TODO: Don't forget to subtract the product from the vendors product in the product table after it has been paid for.
            total = total.add(itemTotal);

            orderItemsRepository.save(item);
        }

        order.setTotal(total);


        return orderRepository.save(order);
    }

    @Override
    public Order updateorder(Long orderId, Order updateOrder) throws OrderNotFoundException {
        return null;
    }

    @Override
    public CancelOrderResponse cancelOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            orderItemsRepository.deleteAllByOrder(order);
            orderRepository.delete(order);
        } else {
            throw new RuntimeException("Order not found");
        }
        var response = new CancelOrderResponse();
        response.setMessage("Order Cancelled successfully.");
        return response;
    }

    @Override
    public Order makePayment(Long orderId, BigDecimal amount) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            // Business logic for making payment using PayStack or FlutterWave
            order.setIsPaid(true);
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    @Override
    public Order trackOrder(Long orderId) {
        Optional<Order> orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isPresent()) {
            return orderOptional.get();
        } else {
            throw new RuntimeException("Order not found");
        }
    }
}
