package com.bolsaideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bolsaideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	/*
	@GetMapping(value = {"/","/index","/home"})
	public String index(ModelMap model) {
		model.addAttribute("titulo", "hola mundo desde modelMap");
		return "index";
	}
	
	@GetMapping(value = {"/","/index","/home"})
	public String index(Map<String, Object> map) {
		map.put("titulo", "Titulo desde Map<>");
		return "index";
	}
	
	@GetMapping(value = {"/","/index","/home"})
	public ModelAndView index(ModelAndView mv) {
		
		mv.addObject("titulo", "Hola desde ModelAnVieW");
		mv.setViewName("index");
		return mv;
	}
	*/
	@GetMapping(value = {"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "hola desde controlador model");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("javier");
		usuario.setApellido("Apellido");
		usuario.setEmail("javirx@hotmail.com");
		model.addAttribute("titulo", "perfil de usuario: ".concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		model.addAttribute("titulo", "listar");
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("cantidad", usuarios.size());
		return "listar";
	}

}
