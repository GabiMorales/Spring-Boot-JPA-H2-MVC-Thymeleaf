package com.gamorales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gamorales.entity.Usuario;
import com.gamorales.repository.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository repositorio;
	
	@GetMapping
	public String index(Model modelo, Usuario usuario) {
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", repositorio.findAll());
		return "index";
	}
	
	@PostMapping("/crearUsuario")
	public String crearUsuario(Model modelo, Usuario usuario) {
		repositorio.save(usuario);
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", repositorio.findAll());
		return "index";
	}
	
	@GetMapping("/editarUsuario/{id}")
	public String editarUsuarioForm(Model modelo, @PathVariable(name="id") Long id) {
		Usuario usuarioParaEditar = repositorio.findById(id).get();
		modelo.addAttribute("usuario", usuarioParaEditar);
		modelo.addAttribute("usuarios", repositorio.findAll());
		return "index";
	}
	
	
	@GetMapping("/eliminarUsuario/{id}")
	public String eliminar(Model modelo, @PathVariable(name="id") Long id) {
		Usuario usuarioParaEliminar = repositorio.findById(id).get();
		repositorio.delete(usuarioParaEliminar);
		modelo.addAttribute("usuario", new Usuario());
		modelo.addAttribute("usuarios", repositorio.findAll());
		
		return "index";
	}
}
