package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.tienda.model.Categoria;
import com.tienda.service.ICategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriaService serviceCategoria;

	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = serviceCategoria.buscarTodas();
		model.addAttribute("categorias",lista);
		return "categorias/listaCategorias"+lista;
	}
	
	@PostMapping("/create")
	public String crear() {
		return "categorias/formCategoria";
	}
	
	@PostMapping("/save")
	public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio el error: "+error.getDefaultMessage());
			}
			return "categorias/formCategorias";
		}
		serviceCategoria.guardar(categoria);
		attributes.addFlashAttribute("msg","Registro Guardado");
		System.out.println("Categoria: "+categoria);
		return "redirect:/categorias/index";
	}
}
