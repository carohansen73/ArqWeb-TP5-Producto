package com.example.demo.dto;

import java.io.Serializable;

public class CotizacionDolarDTO implements Serializable{
	private double compra;
	private double venta;
	
	public CotizacionDolarDTO() {
		
	}
	
	public CotizacionDolarDTO(double compra, double venta) {
		super();
		this.compra = compra;
		this.venta = venta;
	}
	public double getCompra() {
		return compra;
	}
	public void setCompra(double compra) {
		this.compra = compra;
	}
	public double getVenta() {
		return venta;
	}
	public void setVenta(double venta) {
		this.venta = venta;
	}
	
	public double getPromedioCompraVenta() {
		return (this.getCompra()+this.getVenta())/2;
	}
	
}
