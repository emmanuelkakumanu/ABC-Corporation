package com.cts.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.OrderService.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{
	@Query(value="select * from order_details where user_id=1",nativeQuery = true)
	OrderDetails getAllOrders();

}
