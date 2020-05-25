package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.model.Categoria;
import com.tienda.service.ICategoriaService;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriaService serviceCategoria;

	public String mostrarIndex(Model model) {
		List<Categoria> lista = serviceCategoria.buscarTodas();
		model.addAttribute("categorias",lista);
		return "categorias/listaCategorias";
	}
	
}
