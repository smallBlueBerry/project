package com.statics.nwcoinstatics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.statics.nwcoinstatics.bean.SellBuyCoin;

@Component
public interface SellBuyCoinRepository extends JpaRepository<SellBuyCoin, Integer>  {

}
