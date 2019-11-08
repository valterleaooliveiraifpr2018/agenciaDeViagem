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

import com.alphaviagens.alphaviagens.models.Cliente;
import com.alphaviagens.alphaviagens.models.FormaPagamento;
import com.alphaviagens.alphaviagens.repositorys.ClienteRepository;
import com.alphaviagens.alphaviagens.repositorys.FormaPagamentoRepository;



@Controller
public class FormaPagamentoController {
	@Autowired
	FormaPagamentoRepository repository;
	@Autowired
	ClienteRepository repositoryCli;
	@GetMapping("administrativo/formaPagamentoForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("administrativo/formaPagamentoForm");
		mv.addObject("formaPagamentos", repository.findAll());
		return mv;
	}
	@RequestMapping("administrativo/formaPagamentoAdd")
	public ModelAndView add(FormaPagamento formaPagamento) {
		ModelAndView mv = new ModelAndView("administrativo/formaPagamentoAdd");
		mv.addObject("formaPagamento", formaPagamento);
		
		List<Cliente> listCliente = repositoryCli.findAll();
		mv.addObject("clientes", listCliente);
		return mv;
	}
	@RequestMapping("administrativo/formaPagamentoEditar/{id}")
	public ModelAndView edit(@PathVariable ("id")Long id) {
		Optional<FormaPagamento> formaPagamento = repository.findById(id);
		FormaPagamento forma = formaPagamento.get();
		return add(forma);
	}
	@RequestMapping("administrativo/formaPagamentoRemover/{id}")
	public ModelAndView delete(@PathVariable ("id")Long id) {
		Optional<FormaPagamento> formaPagamento = repository.findById(id);
		FormaPagamento forma = formaPagamento.get();
		repository.delete(forma);
		return findAll();
	}
	@RequestMapping("administrativo/formaPagamentoSalvar")
	public ModelAndView save(@Valid FormaPagamento formaPagamento, BindingResult result) {
		if(result.hasErrors()) {
			return add(formaPagamento);
		}
		repository.delete(formaPagamento);
		return findAll();
 }
}