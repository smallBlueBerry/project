package com.statics.nwcoinstatics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.statics.nwcoinstatics.bean.ProductData;

@Component
public interface ProductRepository extends JpaRepository<ProductData, Integer> {

}
