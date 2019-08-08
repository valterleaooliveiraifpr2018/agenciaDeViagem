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

import com.alphaviagens.alphaviagens.models.LocaisTransportes;
import com.alphaviagens.alphaviagens.repositorys.LocaisTransportesRepository;



@Controller
public class LocaisTransportesController {
	@Autowired
	LocaisTransportesRepository repository;
	@GetMapping("/locaisTransportesForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("locaisTransportes", repository.findAll());
		return mv;
	}
	@RequestMapping("/locaisTransportesAdd")
	public ModelAndView add(LocaisTransportes locais) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("locaisTransportes", locais);
		return mv;
	}
	@RequestMapping("/locaisTransportesEdit/{id}")
	public ModelAndView edit(@PathVariable ("id") Long id) {
		Optional<LocaisTransportes> locais = repository.findById(id);
		LocaisTransportes lo = locais.get();
		return add(lo);
	}
	@RequestMapping("/locaisTransportesRemover/{id}")
	public ModelAndView delete(@PathVariable ("id") Long id) {
		Optional<LocaisTransportes> locais = repository.findById(id);
		LocaisTransportes lo = locais.get();
		repository.delete(lo);
		return findAll();
	}
	@RequestMapping("/locaisTRansportesSalvar/{id}")
	public ModelAndView save( @Valid LocaisTransportes locais, BindingResult result) {
		if(result.hasErrors()) {
			return add(locais);
		}
		repository.saveAndFlush(locais);
		return findAll();
	}
}
