package com.statics.nwcoinstatics.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**   
* @Description: 产品绑定的交易所信息（账户密码）
* @version: v1.0.0
* @author: linan
* @date: Nov 5, 2019 3:03:20 PM 
*/
@Entity
@Table(name="exchange")
@Data
public class ExchangeData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",length = 11,nullable = false)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "api_key")
	private String api_key;
	
	@Column(name = "secret_key")
	private String secret_key;
	
	@Column(name = "pass_phrase")
	private String pass_phrase;
	
	@Column(name = "url")
	private String url;

}
