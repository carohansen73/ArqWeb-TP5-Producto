package com.example.demo.model;

import com.example.demo.dto.ProductoDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Producto {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	@Column    
	private String nombre;
	@Column    
	private double precio;
	@Column
	private Integer stock;
	
	public Producto() {
		super();
	}
	
	public Producto(String nombre, double precio, Integer stock) {
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	
	public Producto(ProductoDTO dto) {
		this.id = dto.getId();
		this.nombre = dto.getNombre();
		this.precio = dto.getPrecio();
		this.stock = dto.getStock();
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}
	
	
}
