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
package br.com.kardbank.veiculos.service;

import br.com.kardbank.veiculos.entity.Vehicle;

import java.util.Optional;

public interface VehicleService {

	Vehicle create (Vehicle vehicle) throws Exception;

	Optional<Vehicle> read (String id) throws Exception;

	Vehicle update (String id, Vehicle detail) throws Exception;

	boolean delete (String id) throws Exception;
}

