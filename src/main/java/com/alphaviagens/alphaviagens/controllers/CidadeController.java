package com.alphaviagens.alphaviagens.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alphaviagens.alphaviagens.models.Cidade;
import com.alphaviagens.alphaviagens.models.Estado;
import com.alphaviagens.alphaviagens.models.LocaisTransportes;
import com.alphaviagens.alphaviagens.repositorys.CidadeRepository;
import com.alphaviagens.alphaviagens.repositorys.EstadoRepository;
import com.alphaviagens.alphaviagens.repositorys.LocaisTransportesRepository;


@Controller
public class CidadeController {
	@Autowired
	CidadeRepository repository;
	@Autowired
	EstadoRepository repositoryEstado;
	@Autowired
	LocaisTransportesRepository repositoryLocaisTrans;
	
	@GetMapping("administrativo/cidadeForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("administrativo/cidadeForm");
		mv.addObject("estado", repository.findAll());
		return mv;
	}
	@RequestMapping("administrativo/cidadeAdd")
	public ModelAndView add(Cidade cidade) {
		ModelAndView mv = new ModelAndView("administrativo/cidadeAdd");
		mv.addObject("cidade",cidade);
		
		List<Estado> listEstado = repositoryEstado.findAll();
		mv.addObject("estados", listEstado);
		
		List<LocaisTransportes> locaisTransporte = repositoryLocaisTrans.findAll();
		mv.addObject("locaisTransportes", locaisTransporte);
		return mv;
	}
	@RequestMapping("administrativo/cidadeEditar/{id}")
	public ModelAndView edit(@PathVariable ("id") Long id) {
		Optional<Cidade> cidade = repository.findById(id);
		Cidade cid = cidade.get();
		return add(cid);
	}
	@RequestMapping("administrativo/cidadeRemover/{id}")
	public ModelAndView delete(@PathVariable ("id")Long id) {
		Optional<Cidade> cidade = repository.findById(id);
		Cidade ci = cidade.get();
		repository.delete(ci);
		return findAll();
	}
	@RequestMapping("administrativo/cidadeSalvar")
	public ModelAndView save( @Valid Cidade cidade, BindingResult result) {
		if(result.hasErrors()) {
			return add(cidade);
		}
		repository.saveAndFlush(cidade);
		return findAll();
	}
}
