package com.ingyeo.vuejs.common.vuejs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ingyeo.vuejs.common.vuejs.VuePageComponentResourceLoader;

@RestController
public class InitializeController {
	@Autowired
	private VuePageComponentResourceLoader vuePageComponentResourceLoader;

	@GetMapping(value = { "/vue-initialize" })
	public InitializeResponse initialize() {
		InitializeResponse response = new InitializeResponse();
		response.setVueRouters(vuePageComponentResourceLoader.getVueRouters());

		return response;
	}
}
