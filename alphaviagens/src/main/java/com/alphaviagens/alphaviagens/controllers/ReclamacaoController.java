package com.alphaviagens.alphaviagens.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alphaviagens.alphaviagens.models.ClienteViagem;
import com.alphaviagens.alphaviagens.models.Reclamacao;
import com.alphaviagens.alphaviagens.repositorys.ContatoAdministradorRepository;
import com.alphaviagens.alphaviagens.repositorys.ReclamacaoRepository;

@Controller
public class ReclamacaoController {
	@Autowired
	private ReclamacaoRepository rr;
	@Autowired
	private ContatoAdministradorRepository car;
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
	
	@RequestMapping(value = "/reclamacaoadmin", method = RequestMethod.GET)
	public String eventosAdmin() {

		return "eventos/contatoAdministrador";
	}
	
	@RequestMapping(value = "/Administrador")
	public ModelAndView contatoAdmin() {
		ModelAndView mv = new ModelAndView("eventos/contatoAdministrador");
		List<Reclamacao> rec = car.findAll();
		mv.addObject("contato", rec);
		
		
		return mv;
		
	}


	
	
	@RequestMapping("/mensagemReclamacao")
	public String mensagemReclamacao() {
		return "redirect:/reclamacao";
	}
	

	@RequestMapping("/contatoAdmin/{id}")
	public String delete(@PathVariable ("id") Long id) {
		Optional<Reclamacao> rec = car.findById(id);
		Reclamacao clivi = rec.get();
		car.delete(clivi);
		return "redirect:/Administrador";
	}

	

}
