package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer>{

}
