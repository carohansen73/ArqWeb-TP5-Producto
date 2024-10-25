package com.example.demo.dto;

import java.io.Serializable;

import jakarta.persistence.Column;

public class ProductoDTO implements Serializable{
	
	private Integer id;
	private String nombre; 
	private double precio;
	private Integer stock;
	
	public ProductoDTO(Integer id, String nombre, double precio, Integer stock) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
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
	
	
}
