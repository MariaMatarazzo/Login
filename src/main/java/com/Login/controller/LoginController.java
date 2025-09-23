package com.Login.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Login.entities.Login;
import com.Login.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {

	    private final LoginService service;
	    public LoginController(LoginService service) {
	        this.service = service;
	    }

	    @GetMapping
	    public List<Login> listar() {
	        return service.listar();
	    }

	    @GetMapping("/{id}")
	    public Login buscar(@PathVariable Long id) {
	        return service.buscarPorId(id);
	    }

	    @PostMapping
	    public Login salvar(@RequestBody Login login) {
	        return service.salvar(login);
	    }

	    @DeleteMapping("/{id}")
	    public void deletar(@PathVariable Long id) {
	        service.deletar(id);
	    }
	}



