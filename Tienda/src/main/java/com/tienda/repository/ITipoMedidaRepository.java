package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.model.TipoMedida;

@Repository
public interface ITipoMedidaRepository extends JpaRepository<TipoMedida, Integer>{
	

}
