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
* @Description: 计价单位
* @version: v1.0.0
* @author: linan
* @date: Nov 8, 2019 5:20:44 PM 
*/
@Entity
@Table(name="unit")
@Data
public class UnitData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id",length = 11,nullable = false)
	private int id;
	
	@Column(name = "name")
	private String name;

}
