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

@Entity
@Table(name = "brands", schema="kardbank_vehicle_schema")
@Data
public class Brand {

	private static final long serialVersionUID = -2096127641665459704L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "brand_id", updatable = false, unique = true, nullable = false)
	private int id;

	@Column(name="description", length=250, nullable=false, unique=false)
	private String description;

	@Column(name="registrationDate", length=12, nullable=false, unique=false)
	private String registrationDate;
}