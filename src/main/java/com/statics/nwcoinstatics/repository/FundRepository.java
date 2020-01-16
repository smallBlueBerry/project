package com.statics.nwcoinstatics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.statics.nwcoinstatics.bean.FundData;

@Component
public interface FundRepository extends JpaRepository<FundData, Integer> {
	
	@Query(nativeQuery = true, value = "select * from found where product_id=?1 and create_time=?2")
	FundData findByDateAndProduct(int product_id, String date);
	
	@Query(nativeQuery = true, value = "SELECT p.name as product_name,f.current_interest,f.realized_interest,f.profit_day,f.multiple_profit,f.nav,"
			+ "f.daily_return,u.name as unit_name,f.create_time FROM found f, product p,unit u WHERE f.product_id=p.id and f.unit_id=u.id "
			+ "and if(?5 != '',p.name like CONCAT('%',?5,'%'),1=1) "
			+ "and if(?3 !='' and ?4 !='',f.create_time between ?3 and ?4,1=1) "
			+ "LIMIT ?1,?2")
	List<Object[]> findUserCoinList(int start, int end, String startTime, String endTime, String productName);
	
	@Query(nativeQuery = true, value = "select count(f.id) from found f, product p,unit u WHERE f.product_id=p.id and f.unit_id=u.id "
			+ "and if(?3 != '',p.name like CONCAT('%',?3,'%'),1=1) "
			+ "and if(?1 !='' and ?2 !='',f.create_time between ?1 and ?2,1=1)")
	int findUserCoinCount(String startTime, String endTime, String productName);

}
