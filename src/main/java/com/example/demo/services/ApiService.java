package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Producto;

@Service
public class ApiService {
	
	
	@Value("${base_url}")
	private String base_url;
	
	@Autowired
	private RestTemplate rest_template;

	public ResponseEntity<String> get(){
		try {
			return this.rest_template.getForEntity(this.base_url, String.class);
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			return ResponseEntity.status(ex.getStatusCode()).body(ex.getResponseBodyAsString());
		}
	}
	
	public ResponseEntity<Producto> post(Producto producto){
		try {
			ResponseEntity<Producto> respuesta = this.rest_template.postForEntity(this.base_url, producto, Producto.class);
			return new ResponseEntity<>(respuesta.getBody(), HttpStatus.CREATED);
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			return ResponseEntity.status(ex.getStatusCode()).body(null);
		}
		
	}
	
	public ResponseEntity<Void> delete(Integer id){
		try {
			this.rest_template.delete(this.base_url + "/" + id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
            return ResponseEntity.status(ex.getStatusCode()).build();
        }
	}
	
	 public ResponseEntity<Void> update(Integer id, Producto producto) {
	        try {
	            this.rest_template.put(this.base_url + "/" + id, producto);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (HttpClientErrorException | HttpServerErrorException ex) {
	            return ResponseEntity.status(ex.getStatusCode()).build();
	        }
	    }
	    
}
