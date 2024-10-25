package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Optional<Producto> findById(Integer id){
		return productoRepository.findById(id);
	}
	
	/*
	public Optional<ProductoDTO> findById(Integer id){
		return productoRepository.findByIdCustom(id);
	}
	*/
	
	
	/*Lo hacemos con DTO?*/
	/*
	 public Producto save(ProductoDTO productoDTO) {
	 
		Optional<Producto> productoExistente = productoRepository.findByNombre(productoDTO.getNombre());

        if (productoExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un producto con el nombre: " + productoDTO.getNombre());
        }

        // Si no existe, lo crea
        return productoRepository.save(new Producto(productoDTO));
	}
	 */
	

}
