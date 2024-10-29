package com.tha103.newview.orders.service;

import java.util.List;

import javax.persistence.Tuple;

import com.tha103.newview.orders.model.Orderlist;
import com.tha103.newview.orders.model.Orders;

public interface OrdersService2 {
	
	List<Orders> findByUserID(Integer userID);
	
	List<Tuple> findByOrderListID(Integer orderListID);
	
	boolean saveCom(Orderlist orderlist);
	
	int cancelOrders(Integer orderID);
	
	int cancelReview(Integer orderListID);
	
	
}
