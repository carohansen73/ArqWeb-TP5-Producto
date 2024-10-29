package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.services.ApiService;

@RestController
@RequestMapping("rest_template")
public class RestTemplateController {
	
	@Autowired
	private ApiService api_service;
	
	@GetMapping
	public ResponseEntity<String> get(){
		return this.api_service.get();
	}
	
	@PostMapping
	public ResponseEntity<Producto> post(@RequestBody Producto producto){
		return this.api_service.post(producto);
	}
	
	@DeleteMapping("/{id")
	public void delete(@PathVariable Integer id) {
		this.api_service.delete(id);
	}
	
    @PutMapping("/{id}")
    public void put(@PathVariable Integer id, @RequestBody Producto producto) {
        this.api_service.update(id, producto);
    }
}
