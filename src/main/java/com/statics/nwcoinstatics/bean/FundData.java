package com.statics.nwcoinstatics.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**   
* @Description: 产品类
* @version: v1.0.0
* @author: linan
* @date: Nov 2, 2019 9:35:56 PM 
*/
@Entity
@Table(name="found")
public class FundData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",length = 11,nullable = false)
	private int id;

	/** 产品ID **/
	@Column(name = "product_id")
	private int product_id;
	
	/** 日期 **/
	@Column(name = "create_time")
	private Date create_time;
	
	/** 当前权益 **/
	@Column(name = "current_interest")
	private String current_interest;
	
	/** 已实现权益 **/
	@Column(name = "realized_interest")
	private String realized_interest;
	
	/** 当日收益 **/
	@Column(name = "profit_day")
	private String profit_day;

	/** 综合年化 **/
	@Column(name = "multiple_profit")
	private String multiple_profit;
	
	/** NAV **/
	@Column(name = "nav")
	private String nav;
	
	/** Daily Return **/
	@Column(name = "daily_return")
	private String daily_return;
	
	/** 计价ID **/
	@Column(name = "unit_id")
	private int unit_id;
	
	public FundData() {
		super();
	}

	public FundData(int product_id, Date create_time, String current_interest, String realized_interest,
			String profit_day, String multiple_profit, String nav, String daily_return, int unit_id) {
		super();
		this.product_id = product_id;
		this.create_time = create_time;
		this.current_interest = current_interest;
		this.realized_interest = realized_interest;
		this.profit_day = profit_day;
		this.multiple_profit = multiple_profit;
		this.nav = nav;
		this.daily_return = daily_return;
		this.unit_id = unit_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getCurrent_interest() {
		return current_interest;
	}

	public void setCurrent_interest(String current_interest) {
		this.current_interest = current_interest;
	}

	public String getRealized_interest() {
		return realized_interest;
	}

	public void setRealized_interest(String realized_interest) {
		this.realized_interest = realized_interest;
	}

	public String getProfit_day() {
		return profit_day;
	}

	public void setProfit_day(String profit_day) {
		this.profit_day = profit_day;
	}

	public String getMultiple_profit() {
		return multiple_profit;
	}

	public void setMultiple_profit(String multiple_profit) {
		this.multiple_profit = multiple_profit;
	}

	public String getNav() {
		return nav;
	}

	public void setNav(String nav) {
		this.nav = nav;
	}

	public String getDaily_return() {
		return daily_return;
	}

	public void setDaily_return(String daily_return) {
		this.daily_return = daily_return;
	}

	public int getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(int unit_id) {
		this.unit_id = unit_id;
	}
	
}
