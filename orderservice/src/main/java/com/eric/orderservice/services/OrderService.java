package com.eric.orderservice.services;

import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.eric.orderservice.facades.OrderFacade;
import com.eric.orderservice.models.Order;

@Service
public class OrderService {
    private OrderFacade orderFacade;
    public OrderService(OrderFacade orderFacadeObj) {
    	this.orderFacade=orderFacadeObj;
    }

	public boolean publishOrderData(Order order) {
		MessageChannel messageChannel = orderFacade.outboundInventory();
	       return  messageChannel.send(MessageBuilder
	                .withPayload(order)
	                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
	                .build());
	}
}
