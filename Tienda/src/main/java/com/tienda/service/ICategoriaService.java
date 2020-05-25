package com.tienda.service;

import java.util.List;

import com.tienda.model.Categoria;

public interface ICategoriaService {
	
	void guardar(Categoria categoria);
	
	List<Categoria> buscarTodas();
	
	Categoria buscarPorId(Integer idCategoria);

}
