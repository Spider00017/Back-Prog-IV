package br.ueg.aula01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {
	
	@GetMapping("/ola-mundo")
			public String getOla() {
			return "Olá mundo!";
			}		

	@GetMapping("/ola-mundos")
	public List<String> getOlaMundos(){
		List<String> lista = new ArrayList<String>();
		lista.add("Olá Mundo!!!");
		lista.add("Hello World!!!");
		lista.add("Hello Welt!!!!");
		lista.add("Qualquer mundo!!!");
		return lista;
	}
	
	@PostMapping("/ola-mundos2")
	public List<String> getOlaPost(@RequestBody List<String> plista) {
		List<String> lista = new ArrayList<String>();
		for(String nome: plista) {
			lista.add("Olá "+ nome + " seja bem vindo!!!");		
		}
		return lista;
	}
}
