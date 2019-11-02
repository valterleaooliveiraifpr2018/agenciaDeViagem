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
	@RequestMapping("administrativo/index")
	public String admin() {
		return "administrativo/index";
	}
	@RequestMapping("administrativo/login")
	public String adminLogin() {
		return "administrativo/login";
	}
	@RequestMapping("administrativo/charts")
	public String adminCharts() {
		return "administrativo/charts";
	}
	@RequestMapping("administrativo/tables")
	public String adminTables() {
		return "administrativo/tables";
	}
	@RequestMapping("administrativo/forgot-password")
	public String adminEsqueceu() {
		return "administrativo/forgot-password";
	}
	@RequestMapping("administrativo/404")
	public String admin404() {
		return "administrativo/404";
	}
	@RequestMapping("administrativo/blank")
	public String adminBlank() {
		return "administrativo/blank";
	}
	@RequestMapping("administrativo/register")
	public String adminRegister() {
		return "administrativo/register";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
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