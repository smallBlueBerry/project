package com.statics.nwcoinstatics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.statics.nwcoinstatics.bean.UnitData;

@Component
public interface UnitRepository extends JpaRepository<UnitData, Integer> {
	
	UnitData findById(int id);

}
