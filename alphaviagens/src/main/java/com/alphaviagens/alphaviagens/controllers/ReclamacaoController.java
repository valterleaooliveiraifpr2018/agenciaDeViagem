package com.alphaviagens.alphaviagens.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alphaviagens.alphaviagens.models.Reclamacao;
import com.alphaviagens.alphaviagens.repositorys.ReclamacaoRepository;

@Controller
public class ReclamacaoController {
	@Autowired
	ReclamacaoRepository rr;
	

//	@RequestMapping("/mensagemReclamacao")
//	public String mensagemReclamacao() {
//		return "redirect:/reclamacao";
//	}
	@GetMapping("/mensagemReclamacao")
	public ModelAndView mensagemReclamacao() {
		
		ModelAndView mv = new ModelAndView("/contact");
		
		
		return mv;
	}
	@GetMapping("/adicionarReclamacao")
	public ModelAndView add(Reclamacao reclamacao) {
		
		ModelAndView mv = new ModelAndView("/contact");
		mv.addObject("reclamacao", reclamacao);
		
		return mv;
	}
	@PostMapping("/salvarReclamacao")
	public ModelAndView save(@Valid Reclamacao reclamacao, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(reclamacao);
		}
		
		rr.saveAndFlush(reclamacao);
		
		return mensagemReclamacao();
	}
	
	
	
//	@RequestMapping(value = "/reclamacao", method = RequestMethod.GET)
//	public String eventos() {
//
//		return "/contact";
//	}
//
//	@RequestMapping(value = "/reclamacao", method = RequestMethod.POST)
//	public String form(@Valid Reclamacao reclamacao,BindingResult result,RedirectAttributes attributes) {
//		if (result.hasErrors()) {
//			attributes.addFlashAttribute("mensagem", "Verifique os campos!!!");
//			return "redirect:/reclamacao";
//		}
//		rr.saveAndFlush(reclamacao);
//		return "eventos/mensagemReclamacao";
//		
//	}
//		if (result.hasErrors()) {
//			attributes.addFlashAttribute("mensagem", "Verifique os campos!!!");
//			return "redirect:/reclamacao";
//			
//		}
//		rr.save(reclamacao);
//		attributes.addFlashAttribute("mensagem", "Verifique os campos!!!");
//		return "eventos/mensagemReclamacao";
//
//		
//	}
	

}
