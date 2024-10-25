package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.model.Producto;
import com.example.demo.services.ProductoService;



@RestController
@RequestMapping("/productos")
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

	@GetMapping("/{id}")
	public Optional<Producto> getByID(@PathVariable Integer id){
		return service.getById(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<Producto> save(@RequestBody ProductoDTO producto){
		Producto nuevo = service.save(producto);
		return ResponseEntity.ok(nuevo);
	}
	
	
	@PutMapping("/{id")
	public ResponseEntity<Producto> update (@PathVariable Integer id, @RequestBody ProductoDTO producto){
		Producto actualizado = service.update(id, producto);
		return ResponseEntity.ok(actualizado);
	}

	
	
}
