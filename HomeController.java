package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class HomeController {
	
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/signin")
	public String signin() {
		
		return "signin";
	}
	
	@PostMapping("/dashboard")
	public String dashboard(HttpServletRequest request, Model model) {
		String usuario = request.getParameter("Usuario");
		String senha = request.getParameter("Senha");
		
		System.out.println("Usuario: " + usuario);
		System.out.println("Senha: " + senha);
		
		if (senha.equals ("12345678") ) {
		model.addAttribute ("nome", usuario);
		model.addAttribute ("descricao", "Passear");
		     return "dashboard";
		}
		else {
		model.addAttribute ("mensagem", "Senha Invalida");
		return "erro";
		}
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@GetMapping ("/quemsou")
	public String quemsou() {
		return "quemsou";
	}
	
	@GetMapping ("/cadastrado")
	public String cadastrado() {
		return "cadastrado";
	}
	
}
