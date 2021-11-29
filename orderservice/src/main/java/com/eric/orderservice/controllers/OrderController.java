package com.eric.orderservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eric.orderservice.models.Order;
import com.eric.orderservice.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
	private OrderService orderService;
	@PostMapping({"/v1.0", "/v1.1"})

	public ResponseEntity<?> publishOrder(@RequestBody Order order) {
		
		if(orderService.publishOrderData(order))
			return ResponseEntity.status(HttpStatus.ACCEPTED).
					body("Order Published"+order.getOrderId());
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).
					body("Order Not Published"+order.getOrderId());
	}
}
