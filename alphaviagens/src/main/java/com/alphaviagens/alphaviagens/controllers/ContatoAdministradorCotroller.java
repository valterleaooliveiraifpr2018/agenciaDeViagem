package com.alphaviagens.alphaviagens.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alphaviagens.alphaviagens.models.Reclamacao;
import com.alphaviagens.alphaviagens.repositorys.ContatoAdministradorRepository;



@Controller
public class ContatoAdministradorCotroller {
	@Autowired
	private ContatoAdministradorRepository car;
	
	@GetMapping("/contatoAdministrador")
	public ModelAndView buscarTodos() {
		
		ModelAndView mv = new ModelAndView("eventos/contatoAdministrador");
		mv.addObject("contatoAdministrador", car.findAll());
		return mv;
	}
	@GetMapping("/adicionarContato")
	public ModelAndView add(Reclamacao rec) {
		
		ModelAndView mv = new ModelAndView("/contatoAdministrador");
		mv.addObject("contato", rec);
		
		List<Reclamacao> listaContato = car.findAll();
		mv.addObject("contato",listaContato);
		
		return mv;
	}
	
	
	
	@GetMapping("/editarContato/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		Optional<Reclamacao> rec = car.findById(id);
		Reclamacao e = rec.get();	
		
		return add(e);
	}
	
	@GetMapping("/removerContato/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		Optional<Reclamacao> rec = car.findById(id);
		Reclamacao e = rec.get();
		car.delete(e);	
		
		return buscarTodos();
	}

	@PostMapping("/salvarContato")
	public ModelAndView save(@Valid Reclamacao rec, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(rec);
		}
		
		car.saveAndFlush(rec);
		
		return buscarTodos();
	}
	
	
}
