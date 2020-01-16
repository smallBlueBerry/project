package com.statics.nwcoinstatics.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**   
* @Description: 产品类（包含多个团队，对应多个交易所）
* @version: v1.0.0
* @author: linan
* @date: Nov 5, 2019 3:01:14 PM 
*/
@Entity
@Table(name="product")
@Data
public class ProductData implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",length = 11,nullable = false)
	private int id;
	
	/** 产品名称 **/
	@Column(name = "name")
	private String name;
	
	/** 注册时间 **/
	@Column(name = "start_time")
	private Date start_time;
	
	/** 策略类型 **/
	@Column(name = "type")
	private String type;
	
	/** 初始资产 **/
	@Column(name = "begin_assets")
	private String begin_assets;
	
	/** 资产 **/
	@Column(name = "assets")
	private String assets;
	
	/** 登陆名 **/
	@Column(name = "login_name")
	private String login_name;
	
	/** 登陆密码 **/
	@Column(name = "exchange_id")
	private String exchange_id;
	
	/** 交易所ID **/
	@Column(name = "login_password")
	private String login_password;
	
	/** 权限 **/
	@Column(name = "power")
	private String power;
	
	/** 计价ID **/
	@Column(name = "unit_id")
	private int unit_id;
	
	/** 创建时间 **/
	@Column(name = "create_time")
	private Date create_time;
	
	/** 更新时间 **/
	@Column(name = "update_time")
	private Date update_time; 

}
