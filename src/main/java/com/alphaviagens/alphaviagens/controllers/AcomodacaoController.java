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

import com.alphaviagens.alphaviagens.models.Acomodacao;
import com.alphaviagens.alphaviagens.repositorys.AcomodacaoRepository;

@Controller
public class AcomodacaoController {
	@Autowired
	AcomodacaoRepository repository;
	@GetMapping("administrativo/acomodacaoForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("administrativo/acomodacaoForm");
		mv.addObject("acomodacoes", repository.findAll());
		return mv;
	}
	@RequestMapping("administrativo/acomodacaoAdd")
	public ModelAndView add(Acomodacao acomodacao) {
		ModelAndView mv = new ModelAndView("administrativo/acomodacaoAdd");
		mv.addObject("acomodacao", acomodacao);
		return mv;
	}
	@RequestMapping("administrativo/acomodacaoEditar/{id}")
	public ModelAndView edit(@PathVariable ("id")Long id) {
		Optional<Acomodacao> acomodacao = repository.findById(id);
		Acomodacao acomo = acomodacao.get();
		return add(acomo);
	}
	@RequestMapping("administrativo/acomodacaoRemover/{id}")
	public ModelAndView delete(@PathVariable ("id")Long id) {
		Optional<Acomodacao> acomodacao = repository.findById(id);
		Acomodacao acomo = acomodacao.get();
		repository.delete(acomo);
		return findAll();
	}
	@RequestMapping("administrativo/acomodacaoSalvar/")
	public ModelAndView save(@Valid Acomodacao acomodacao, BindingResult result) {
		if(result.hasErrors()) {
			return add(acomodacao);
		}
		repository.saveAndFlush(acomodacao);
		return findAll();
	}
}
