package com.cts.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.model.Accessory;

public interface AccessoryRepository extends JpaRepository<Accessory, Long>{
	@Query(value="select accessory_price from accessories where accessory_id=?1",nativeQuery = true)
	public long getAccessoryPrice(long id);

}
