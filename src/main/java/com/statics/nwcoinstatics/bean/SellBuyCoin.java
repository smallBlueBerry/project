package com.statics.nwcoinstatics.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="sell_buy_coin")
@Data
public class SellBuyCoin implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",length = 11,nullable = false)
	private int id;

	/** 购买数量 **/
	@Column(name = "buy_num")
	private String buy_num;
	
	/** 卖出数量 **/
	@Column(name = "sell_num")
	private String sell_num;
	
	/** 买卖差量 **/
	@Column(name = "dis_num")
	private String dis_num;
	
	/** 日期 **/
	@Column(name = "create_time")
	private String create_time;

	public SellBuyCoin(String buy_num, String sell_num, String dis_num, String create_time) {
		super();
		this.buy_num = buy_num;
		this.sell_num = sell_num;
		this.dis_num = dis_num;
		this.create_time = create_time;
	}
	
}
