package com.alphaviagens.alphaviagens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alphaviagens.alphaviagens.models.Reclamacao;
import com.alphaviagens.alphaviagens.repositorys.ReclamacaoRepository;

@Controller
public class ReclamacaoController {
	@Autowired
	ReclamacaoRepository rr;
	
	@RequestMapping(value = "/reclamacao", method = RequestMethod.GET)
	public String eventos() {

		return "/contact";
	}

	@RequestMapping(value = "/reclamacao", method = RequestMethod.POST)
	public String form(@Valid Reclamacao reclamacao,BindingResult result,RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!!!");
			return "redirect:/reclamacao";
		}
		rr.saveAndFlush(reclamacao);
		return "eventos/mensagemReclamacao";
	}
	@RequestMapping("/mensagemReclamacao")
	public String mensagemReclamacao() {
		return "redirect:/reclamacao";
	}

}
