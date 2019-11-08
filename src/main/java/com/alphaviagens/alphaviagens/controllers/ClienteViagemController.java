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
import com.alphaviagens.alphaviagens.models.ClienteViagem;
import com.alphaviagens.alphaviagens.models.Viagem;
import com.alphaviagens.alphaviagens.repositorys.ClienteRepository;
import com.alphaviagens.alphaviagens.repositorys.ClienteViagemRepository;
import com.alphaviagens.alphaviagens.repositorys.ViagemRepository;



@Controller
public class ClienteViagemController {
	@Autowired
	ClienteViagemRepository repository;
	@Autowired
	ClienteRepository cli;
	@Autowired
	ViagemRepository viagem;
	@GetMapping("administrativo/clienteViagemForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("administrativo/clienteViagemForm");
		mv.addObject("clienteViagens", repository.findAll());
		return mv;
	}
	@RequestMapping("administrativo/clienteViagemAdd")
	public ModelAndView add(ClienteViagem clienteViagem) {
		ModelAndView mv = new ModelAndView("administrativo/clienteViagemAdd");
		mv.addObject("clienteViagem", clienteViagem);
		List<Cliente> cliente = cli.findAll();
		mv.addObject("clientes", cliente);
		List<Viagem> via = viagem.findAll();
		mv.addObject("viagens", via);
		return mv;
	}
	@RequestMapping("administrativo/clienteViagemEditar/{id}")
	public ModelAndView edit(@PathVariable ("id") Long id) {
		Optional<ClienteViagem> clienteViagem = repository.findById(id);
		ClienteViagem clivi = clienteViagem.get();
		return add(clivi);
	}
	@RequestMapping("administrativo/clienteViagemRemover/{id}")
	public ModelAndView delete(@PathVariable ("id") Long id) {
		Optional<ClienteViagem> clienteViagem = repository.findById(id);
		ClienteViagem clivi = clienteViagem.get();
		repository.delete(clivi);
		return findAll();
	}
	@RequestMapping("administrativo/clienteViagemSalvar")
	public ModelAndView save(@Valid ClienteViagem clienteViagem, BindingResult result) {
		if(result.hasErrors()) {
			return add(clienteViagem);
		}
		repository.saveAndFlush(clienteViagem);
		return findAll();
	}
}
