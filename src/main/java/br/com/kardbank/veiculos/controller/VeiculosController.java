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
package br.com.kardbank.veiculos.controller;

import br.com.kardbank.veiculos.entity.Vehicle;
import br.com.kardbank.veiculos.published.APIGenericResponse;
import br.com.kardbank.veiculos.published.StatusResponse;
import br.com.kardbank.veiculos.service.VehicleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@Log4j2
public class VeiculosController {

	@Autowired
	private VehicleService vehicleService;

	@PostMapping(value = "/public/create/vehicle", consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> create (@RequestBody Vehicle vehicle) {
		try {
			return ResponseEntity.ok(new APIGenericResponse(vehicleService.create(vehicle), new StatusResponse("Request API is successful", HttpStatus.CREATED)));
		} catch (Exception e) {
			log.error("Erro {}, {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(false, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@GetMapping(value = "/public/read/vehicle/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> read (@PathVariable(value = "id") String id) {
		
		try {
			Optional<Vehicle> company = vehicleService.read(id);
			if (company.isPresent()) {
				return ResponseEntity.ok(new APIGenericResponse(company.get(), new StatusResponse("Request API is successful", HttpStatus.OK)));
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(null, new StatusResponse("Company not found.", HttpStatus.NOT_FOUND)));
			}
		} catch (Exception e) {
			log.error("Erro {}, {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@PutMapping(value = "/public/update/vehicle/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> update (@PathVariable(value = "id") String id,  @Valid @RequestBody Vehicle detail) {
		
		try {
			Vehicle vehicle = vehicleService.update(id, detail);
			if (vehicle == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(vehicle, new StatusResponse("Company not found.", HttpStatus.NOT_FOUND)));
			}
			return ResponseEntity.ok(new APIGenericResponse(vehicle, new StatusResponse("Request API is successful", HttpStatus.OK)));
		} catch (Exception e) {
			log.error("Erro {}, {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
	
	@DeleteMapping(value = "/public/delete/vehicle/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<?> delete (@PathVariable(value = "id") String id) {

		try {
			if (vehicleService.delete(id)) {
				return ResponseEntity.ok(new APIGenericResponse(Boolean.TRUE, new StatusResponse("Request API is successful", HttpStatus.OK)));
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIGenericResponse(Boolean.FALSE, new StatusResponse("Company not found.", HttpStatus.NOT_FOUND)));
		} catch (Exception e) {
			log.error("Erro {}, {}", e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new APIGenericResponse(null, new StatusResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR)));
		}		
	}
}
