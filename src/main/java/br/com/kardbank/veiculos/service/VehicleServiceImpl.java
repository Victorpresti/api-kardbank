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
import br.com.kardbank.veiculos.repository.IVehicleRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Log4j2
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private IVehicleRepository iVehicleRepository;

	@Override
	public Vehicle create (Vehicle vehicle) throws Exception {
		log.info("Creating a new Company.");
		try {
			return iVehicleRepository.save(vehicle);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<Vehicle> read (String id) throws Exception {
		log.info("Reading company by identification.");
		try {
			return iVehicleRepository.findById(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Vehicle update (String id, Vehicle detail) throws Exception {
		
		log.info("Updating company by identification and user details.");
		
		try {
			Optional<Vehicle> company = iVehicleRepository.findById(id);
			if (company.isPresent()) {
				//return iCompanyRepository.save(new Vehicle(id, detail.getReasonSocial(), detail.getFantasyName(), detail.getCadastralSituation(), detail.getCadastralSituationDate()));
			}
			return null;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean delete (String id) throws Exception {
		
		log.info("Deleting company by identification.");
		
		try {
			Optional<Vehicle> user = iVehicleRepository.findById(id);
			
			if (user.isPresent()) {				
				iVehicleRepository.deleteById(id);
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
