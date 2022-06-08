/*
--+
    | Project ACCOUNT SERVICE API - Java Class File : 1.0.0 Data: 10/06/2018
    | Copyright(c) by ProfitCode IT Solutions
    |
    | All rights reserved.
    |
    | This software is confidential and proprietary information of
    | ProfitCode IT Solutions ("Confidential Information").
    | You shall not disclose such Confidential Information and shall 
    | use it only in accordance with the terms of the license agreement
    | you entered with ProfitCode IT Solutions.
 +--
 */
package br.com.kardbank.veiculos.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehicles", schema="kardbank_vehicle_schema")
@Data
public class Vehicle implements Serializable {

	private static final long serialVersionUID = -2096127641665459704L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id", updatable = false, unique = true, nullable = false)
	private int id;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "brand_id",nullable=false)
	private Brand brand;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "owner_id",nullable=false)
	private Owner owner;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "model_id",nullable=false)
	private Model model;

	@Column(name="licensePlate", length=8, nullable=false, unique=false)
	private String licensePlate;

	@Column(name="manufacturingYear", length=4, nullable=false, unique=false)
	private Integer manufacturingYear ;

	@Column(name="modelYear", length=4, nullable=false, unique=false)
	private Integer modelYear;

	@Column(name="chasi", length=17, nullable=false, unique=false)
	private String chasi;


}