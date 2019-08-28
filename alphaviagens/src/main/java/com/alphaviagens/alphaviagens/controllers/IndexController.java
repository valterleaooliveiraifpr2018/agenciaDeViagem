package com.alphaviagens.alphaviagens.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/about")
	public String about() {
		return "about";
	}

	@RequestMapping("/hotels")
	public String hotel() {
		return "hotels";
	}

	@RequestMapping("/contact")
	public String contato() {
		return "contact";
	}

	@RequestMapping("/hotel-room")
	public String quarto() {
		return "hotel-room";
	}

	@RequestMapping("/blog")
	public String blog() {
		return "blog";
	}

	@RequestMapping("/services")
	public String servico() {
		return "services";
	}

	@RequestMapping("/tours")
	public String tour() {
		return "tours";
	}

	@RequestMapping("/tour-place")
	public String lugar() {
		return "tour-place";
	}

}