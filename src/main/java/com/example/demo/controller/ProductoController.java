package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Producto;
import com.example.demo.services.ProductoService;


@RestController
public class ProductoController {
	
	@Autowired
	private final ProductoService service;
	
	public ProductoController(ProductoService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public Iterable<Producto> getAll(){
		return service.findAll();
	}

}
