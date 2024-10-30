package com.example.demo.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dto.ProductoDTO;
import com.example.demo.model.Producto;
import com.example.demo.repositories.ProductoRepository;





@Configuration
class LoadDatabase {

	    @Bean
	    CommandLineRunner initDatabase(ProductoRepository repo) {
	        return args -> {
	        	  try {
	        		  
	        		  ProductoDTO prodDto1 = new ProductoDTO(1, "Fideos", 1000, 5, 1);
	        		  ProductoDTO prodDto2 = new ProductoDTO(2, "Cafe", 2500, 3,2.1);
	        		  ProductoDTO prodDto3 = new ProductoDTO(3, "Galletitas", 1200, 5,1.1);
	        		  ProductoDTO prodDto4 = new ProductoDTO(4, "Azucar", 900, 5,0.85);
	        		  
	        		  Producto p1 = new Producto(prodDto1);
	        		  Producto p2 = new Producto(prodDto2);
	        		  Producto p3 = new Producto(prodDto3);
	        		  Producto p4 = new Producto(prodDto4);
	        		  
	        		  repo.save(p1);
	        		  repo.save(p2);
	        		  repo.save(p3);
	        		  repo.save(p4);
	        		  
	        		  
	        	  } catch(Exception e) {
	        		  System.out.println("Los datos ya estan cargados");
	        	  }
	        };
    }
}

