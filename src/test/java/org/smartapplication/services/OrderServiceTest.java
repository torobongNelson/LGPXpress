package org.smartapplication.services;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smartapplication.dtos.request.Order.CreateOrderRequest;
import org.smartapplication.dtos.request.Order.ItemRequest;
import org.smartapplication.dtos.response.Order.CreateOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.smartapplication.Utils.Constants.SUCCESSFUL_ORDER_MESSAGE;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    private final Logger logger = LoggerFactory.getLogger(OrderServiceTest.class);
    @Autowired
    private Properties properties;

    @BeforeEach
    @SneakyThrows
    public void beginEachTestWith(){

    }

    @Test
    @SneakyThrows
    public void placeOrderTest(){
        CreateOrderResponse orderResponse = orderService.createOrder(buildOrderRequest());
        assertThat(orderResponse.getMessage()).isNotNull();
        assertThat(orderResponse.getMessage()).isEqualTo(SUCCESSFUL_ORDER_MESSAGE);
    }

    private CreateOrderRequest buildOrderRequest() {

        return CreateOrderRequest.builder()
                .items(List.of(ItemRequest.builder()
                        .amountInKg(12.5)
                        .itemName("Gas")
                        .numberOfItems(2)
                        .build())
                )
                .deliveryAddress("10, herbert Macaulay Way, Sabo, Yaba, Lagos")
                .phoneNumber("07036174617")
                .storeUniqueId(properties.getProperty("store id"))
                .userEmail("alaabdulmalik03@gmail.com")
                .build();
    }

    @Test
    public void placeOrderWithIncompleteDetailsExceptionIsThrown__OrderProcessAborts(){

    }

}
