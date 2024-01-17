package com.devcaotics.sysRifa.controllers;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.devcaotics.sysRifa.model.entities.Rifa;
import com.devcaotics.sysRifa.model.repositories.RepositoryService;

@RestController
@RequestMapping("/rifa")
public class RifaController {

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Rifa r){
		
		try {
			RepositoryService.getCurrentInstance().create(r);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Rifa> read(@PathVariable("codigo") int codigo){
		
		try {
			Rifa r = RepositoryService.getCurrentInstance().readRifa(codigo);
			
			return new ResponseEntity<Rifa>(r, HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.OK);
		}
		
		
		
	}
}
