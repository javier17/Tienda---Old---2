package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tienda.DTO.Mensaje;
import com.tienda.model.Categoria;
import com.tienda.repository.ICategoriaRepository;
import com.tienda.service.ICategoriaService;


@CrossOrigin(origins = "*")//http://localhost:4200
@RestController
@RequestMapping(value = "/categorias")
public class CategoriasController {
	
	@Autowired
	private ICategoriaService serviceCategoria;

	@Autowired
	private ICategoriaRepository repo;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Categoria> lista = serviceCategoria.buscarTodas();
		model.addAttribute("categorias",lista);
		return "categorias/listaCategorias"+lista;
	}
	@GetMapping
	public List<Categoria> mostrar(Model model) {
		//List<Categoria> lista = serviceCategoria.buscarTodas();
	//	model.addAttribute("categorias",lista);
		return serviceCategoria.buscarTodas();
	}
	
	
	@PostMapping("/create")
	public String crear() {
		return "categorias/formCategoria";
	}
	
	@PostMapping
	public ResponseEntity crear(@RequestBody Categoria categoria) {
		System.err.println(categoria);
		serviceCategoria.guardar(categoria);
		
		return new ResponseEntity(new Mensaje("Categoria guardada"), HttpStatus.CREATED);
	}
	
	
	
	
	@PutMapping
	public ResponseEntity modificar(@RequestBody Categoria categoria) {
		System.err.println(categoria);
		Categoria categoria2= serviceCategoria.buscarPorId(categoria.getIdCategoria());
		categoria2.setDescripcion(categoria.getDescripcion());
		serviceCategoria.guardar(categoria2);
		return new ResponseEntity("Categoria modificada", HttpStatus.CREATED);
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
