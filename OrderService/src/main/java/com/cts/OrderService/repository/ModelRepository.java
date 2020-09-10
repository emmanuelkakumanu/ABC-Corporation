package com.cts.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.model.CarModels;

public interface ModelRepository extends JpaRepository<CarModels, Long>{
	@Query(value="select model_price from models where model_id=?1",nativeQuery = true)
	public long getModelPrice(long id);
}
