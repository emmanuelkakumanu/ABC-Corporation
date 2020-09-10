package com.cts.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cts.model.Color;

public interface ColorRepository extends JpaRepository<Color, Long>{
	@Query(value="select color_price from colors where color_id=?1",nativeQuery=true)
	public long getColorPrice(long id);

}
