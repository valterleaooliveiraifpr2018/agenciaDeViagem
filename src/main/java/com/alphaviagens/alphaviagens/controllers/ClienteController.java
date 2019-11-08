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

import com.alphaviagens.alphaviagens.models.Cliente;
import com.alphaviagens.alphaviagens.repositorys.ClienteRepository;



@Controller
public class ClienteController {
	@Autowired
	ClienteRepository repository;
	@GetMapping("administrativo/clienteForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("administrativo/clienteForm");
		mv.addObject("clientes", repository.findAll());
		return mv;
	}
	@RequestMapping("administrativo/clienteAdd")
	public ModelAndView add(Cliente cliente){
		ModelAndView mv = new ModelAndView("administrativo/clienteAdd");
		mv.addObject("cliente", cliente);
		return mv;
	
    }
	@RequestMapping("administrativo/editarClinte/{id}")
	public ModelAndView edit(@PathVariable ("id")Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		Cliente cli = cliente.get();
		return add(cli);
	}
	@RequestMapping("administrativo/removerClinte/{id}")
	public ModelAndView delete(@PathVariable ("id")Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		Cliente cli = cliente.get();
		repository.delete(cli);
		return findAll();
	}
	@RequestMapping("administrativo/salvarCliente")
	public ModelAndView save(@Valid Cliente cliente, BindingResult result) {
		if(result.hasErrors()) {
			return add(cliente);
		}
		repository.saveAndFlush(cliente);
		return findAll();
	}
}
