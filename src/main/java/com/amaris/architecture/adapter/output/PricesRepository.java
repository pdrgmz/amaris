package com.amaris.architecture.adapter.output;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PricesRepository extends JpaRepository<TblPrice, Integer> {

	
	@Query("select "
				+ "p "
				+ "from TblPrice p "
			+ "where "
			+ "p.productId=?1 "
			+ "and p.brandId=?2 "
			+ "and p.startDate<= ?3 and p.endDate>=?3 ")
	List<TblPrice> findPrice(Integer productId, Integer brandId, LocalDateTime date);
	
	
	
	
}
