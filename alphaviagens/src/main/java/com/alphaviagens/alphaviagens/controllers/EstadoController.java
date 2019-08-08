package com.alphaviagens.alphaviagens.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alphaviagens.alphaviagens.models.Estado;
import com.alphaviagens.alphaviagens.repositorys.EstadoRepository;


@Controller
public class EstadoController {
	@Autowired
	EstadoRepository repository;
	@GetMapping("/estadoForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("/estadoForm");
		mv.addObject("estados", repository.findAll());
		return mv;
	    }
	@RequestMapping("/estadoAdd")
	public ModelAndView add(Estado estado){
		ModelAndView mv = new ModelAndView();
		mv.addObject("estado",estado);
		return mv;
	    }
	@RequestMapping("/editarEstado/{id}")
	public ModelAndView edit(@PathVariable ("id") Long id) {
		Optional<Estado> estado = repository.findById(id);
		Estado esta = estado.get();
		return add(esta);
		
	    }
	@RequestMapping("/removerEstado/{id}")
	public ModelAndView delete(@PathVariable ("id") Long id) {
		Optional<Estado> estado = repository.findById(id);		
		Estado esta = estado.get();
		repository.delete(esta);
		return findAll();
	    }
	@RequestMapping("/salvarEstado")
	public ModelAndView remove(@Valid Estado estado, BindingResult result) {
		if(result.hasErrors()){
			return add(estado);
		}
		repository.saveAndFlush(estado);
		return findAll();
	   }
	}