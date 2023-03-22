package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/emp")
@Slf4j
public class EmpController {
	
	@Value("${app.name}")
	private String value;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/{name}")
	public String getName(@PathVariable("name") String name) {
		log.info("name value::{}",env);
		return "name"+name;
		
	}

}
