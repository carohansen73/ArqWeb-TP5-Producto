package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@Query("SELECT p FROM Producto p WHERE LOWER(p.nombre) = LOWER(:nombre)")
    Optional<Producto> findByNombre(String nombre);

	@Transactional
	@Modifying
	@Query("UPDATE Producto p SET precio=precioEnDolar*:promedioCompraVenta")
	void actualizarPrecios(double promedioCompraVenta);

	
}
