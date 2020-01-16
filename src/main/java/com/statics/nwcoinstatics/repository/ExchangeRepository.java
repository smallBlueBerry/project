package com.statics.nwcoinstatics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.statics.nwcoinstatics.bean.ExchangeData;

@Component
public interface ExchangeRepository extends JpaRepository<ExchangeData, Integer> {
	
	
	ExchangeData findById(int id);

}
