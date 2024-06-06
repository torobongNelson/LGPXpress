package org.smartapplication.services.Implementations;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.smartapplication.dtos.response.Order.CancelOrderResponse;
import org.smartapplication.exceptions.OrderNotFoundException;
import org.smartapplication.exceptions.UnpaidOrderAlreadyExists;
// import org.smartapplication.model.Order;
// import org.smartapplication.model.OrderItems;
// import org.smartapplication.repositories.OrderItemRepository;
// import org.smartapplication.repositories.OrderRepository;
import org.smartapplication.services.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

// @Service
// @AllArgsConstructor
// public class OrderServiceImpl implements OrderService {

//     private OrderRepository orderRepository;
//     private OrderItemRepository orderItemRepository;
//     private CustomerRepository customerRepository;
//     private ProductRepository productRepository;


//     @Override
//     public Order findBy(Long id) {
//         return null;
//     }

//     @Override
//     @Transactional
//     public Order placeOrder(Order order) throws UnpaidOrderAlreadyExists{
//         boolean unpaidOrderExists = orderRepository.existsByCustomerIdAndDeliveryAddressAndPhoneNumberAndIsPaidFalse(
//                 order.getCustomer().getId(), order.getDeliveryAddress(), order.getPhoneNumber());

//         if (unpaidOrderExists) {
//             throw new UnpaidOrderAlreadyExists("Order already exists for this customer at the given delivery address");
//         }

//         Customer customer = customerRepository.findById(order.getCustomer().getId())
//                 .orElseThrow(()-> new RuntimeException("Customer not found"));

//         order.setCustomer(customer);
//         BigDecimal total = BigDecimal.ZERO;
//         for (OrderItems item: order.getProducts()) {
//             Product product = productRepository.findById(item.getProduct().getId())
//                     .orElseThrow(()-> new RuntimeException("Product not found"));
//             item.setProduct(product);
//             item.setOrder(order);

//             BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));

//             total = total.add(itemTotal);

//             orderItemRepository.save(item);
//         }

//         order.setTotal(total);

//         return orderRepository.save(order);
//     }

//     @Override
//     public Order updateOrder(Long orderId, Order updateOrder) throws OrderNotFoundException {
//         return null;
//     }

//     @Override
//     @Transactional
//     public CancelOrderResponse cancelOrder(Long orderId) {
//         Optional<Order> orderOptional = orderRepository.findById(orderId);
//         if (orderOptional.isPresent()) {
//           Order order = orderOptional.get();
//           orderItemRepository.deleteAllByOrder(order);
//           orderRepository.delete(order);
//         }else {
//             throw new RuntimeException("Order not found");
//         }
//         var response = new CancelOrderResponse();
//         response.setMessage("Order cancelled successfully");
//         return response;
//     }

//     @Override
//     @Transactional
//     public Order makePayment(Long orderId, BigDecimal amount) {
//         Optional<Order> orderOptional = orderRepository.findById(orderId);
//         if (orderOptional.isPresent()) {
//             Order order = orderOptional.get();
//             order.setIsPaid(true);
//             return orderRepository.save(order);
//         }else {
//             throw new RuntimeException("Order not found");
//         }
//     }

//     @Override
//     @Transactional(readOnly = true)
//     public Order trackOrder(Long orderId) {
//         Optional<Order> orderOptional = orderRepository.findById(orderId);
//         if (orderOptional.isPresent()) {
//             return orderOptional.get();
//         } else {
//             throw new RuntimeException("Order not found");
//         }

//     }
// }
