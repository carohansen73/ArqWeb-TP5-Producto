package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.model.Producto;
import com.example.demo.repositories.ProductoRepository;


@Service
public class ProductoService {
	
	@Autowired
	private final ProductoRepository productoRepository;
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	public Iterable<Producto> findAll(){
		return productoRepository.findAll();
	}

	public Optional<Producto> getById(Integer id){
		return productoRepository.findById(id);
	}
	
	
	 public Producto save(ProductoDTO productoDTO) {
		Optional<Producto> productoExistente = productoRepository.findByNombre(productoDTO.getNombre());

        if (productoExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un producto con el nombre: " + productoDTO.getNombre());
        }
        // Si no existe, lo crea
        return productoRepository.save(new Producto(productoDTO));
	}
	 
	 
	 public Producto update(Integer id, ProductoDTO productoActualizado){
		 Optional <Producto> productoOpcional = productoRepository.findById(id);
		 
		 if(productoOpcional.isPresent()) {
			 Producto productoExistente = productoOpcional.get();
			 
			 // Actualizar los campos con los nuevos valores
			 productoExistente.setNombre(productoActualizado.getNombre());
			 productoExistente.setPrecio(productoActualizado.getPrecio());
			 productoExistente.setStock(productoActualizado.getStock());
			 
			 // Guardar el prod actualizado
			 return productoRepository.save(productoExistente);
	          
		 } else {
	            throw new IllegalArgumentException("Producto con id " + id + " no encontrado.");
	        } 
	 }
	 
	 
	

}
