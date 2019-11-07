package com.alphaviagens.alphaviagens.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alphaviagens.alphaviagens.models.Cidade;
import com.alphaviagens.alphaviagens.models.Funcionario;
import com.alphaviagens.alphaviagens.repositorys.CidadeRepository;
import com.alphaviagens.alphaviagens.repositorys.FuncionarioRepository;

public class funcionarioController {
	@Autowired
	FuncionarioRepository repository;
	@Autowired
	CidadeRepository repositoryCida;
	@GetMapping("administrativo/funcionarioForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("administrativo/funcionarioForm");
		mv.addObject("funcionarios", repository.findAll());
		return mv;
	}
	@RequestMapping("administrativo/funcionarioAdd")
	public ModelAndView add(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("administrativo/funcionarioAdd");
		mv.addObject("funcionario", funcionario);
		List<Cidade> cidade = repositoryCida.findAll();
		mv.addObject("cidade", cidade);
		return mv;
	}
	@RequestMapping("administrativo/funcionarioEditar/{id}")
	public ModelAndView edit(@PathVariable ("id")Long id) {
		Optional<Funcionario> funcionario = repository.findById(id);
		Funcionario func = funcionario.get();
		return add(func);
	}
	@RequestMapping("administrativo/funcionarioRemover/{id}")
	public ModelAndView delete(@PathVariable ("id")Long id) {
		Optional<Funcionario> funcionario = repository.findById(id);
		Funcionario func = funcionario.get();
		repository.delete(func);
		return findAll();
	}
	@RequestMapping("administrativo/funcionarioSalvar/")
	public ModelAndView save(@Valid Funcionario funcionario, BindingResult result) {
		if(result.hasErrors()) {
			return add(funcionario);
		}
		repository.saveAndFlush(funcionario);
		return findAll();
	}
}



