package org.smartapplication.services.Implementations;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.smartapplication.dtos.request.Order.CreateOrderRequest;
import org.smartapplication.dtos.response.Order.CreateOrderResponse;
import org.smartapplication.exceptions.CustomerNotFoundException;
import org.smartapplication.exceptions.ProductNotFoundException;
import org.smartapplication.model.Order;
import org.smartapplication.model.Store;
import org.smartapplication.repositories.CustomerOrderRepository;
import org.smartapplication.services.OrderServiceInterface;
import org.smartapplication.services.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderServiceInterface {
    private final ModelMapper modelMapper = new ModelMapper();
    private final StoreService storeService;
    private final UserService userService;
    private final CustomerOrderRepository customerOrderRepository;
    @Override
    public CreateOrderResponse createOrder(CreateOrderRequest request) throws ProductNotFoundException, CustomerNotFoundException {
        Order order = modelMapper.map(request, Order.class);
        Store store = storeService.getProductBy(request.getCartId());
        order=customerOrderRepository.save(order);

        return null;
    }

    @Override
    public Order findBy(Long id) {
        return null;
    }


}
