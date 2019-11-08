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

import com.alphaviagens.alphaviagens.models.Acomodacao;
import com.alphaviagens.alphaviagens.models.Cidade;
import com.alphaviagens.alphaviagens.models.FormaPagamento;
import com.alphaviagens.alphaviagens.models.LocaisTransportes;
import com.alphaviagens.alphaviagens.models.Viagem;
import com.alphaviagens.alphaviagens.repositorys.AcomodacaoRepository;
import com.alphaviagens.alphaviagens.repositorys.CidadeRepository;
import com.alphaviagens.alphaviagens.repositorys.FormaPagamentoRepository;
import com.alphaviagens.alphaviagens.repositorys.LocaisTransportesRepository;
import com.alphaviagens.alphaviagens.repositorys.ViagemRepository;

@Controller
public class ViagemController {
	@Autowired
	ViagemRepository repository;
	@Autowired
	CidadeRepository cid;
	@Autowired
	AcomodacaoRepository acomo;
	@Autowired
	LocaisTransportesRepository locais;
	@Autowired
	FormaPagamentoRepository forma;

	@GetMapping("administrativo/viagemForm")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("administrativo/viagemForm");
		mv.addObject("viagens", repository.findAll());
		return mv;
	}

	@RequestMapping("administrativo/viagemAdd")
	public ModelAndView add(Viagem viagem) {
		ModelAndView mv = new ModelAndView("administrativo/viagemAdd");
		mv.addObject("viagem", viagem);
		List<Cidade> cidade = cid.findAll();
		mv.addObject("cidades", cidade);
		List<Acomodacao> acomodacao = acomo.findAll();
		mv.addObject("acomodacoes", acomodacao);
		List<LocaisTransportes> LocaisTransportes = locais.findAll();
		mv.addObject("locais", LocaisTransportes);
		List<FormaPagamento> paga = forma.findAll();
		return mv;

	}

	@RequestMapping("administrativo/viagemEditar/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		Optional<Viagem> viagem = repository.findById(id);
		Viagem vi = viagem.get();
		return add(vi);
	}

	@RequestMapping("administrativo/viagemRemover/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		Optional<Viagem> viagem = repository.findById(id);
		Viagem vi = viagem.get();
		repository.delete(vi);
		return findAll();
	}

	@RequestMapping("administrativo/viagemSalvar")
	public ModelAndView save(@Valid Viagem viagem, BindingResult result) {
		if (result.hasErrors()) {
			return add(viagem);
		}
		repository.saveAndFlush(viagem);
		return findAll();
	}
}
