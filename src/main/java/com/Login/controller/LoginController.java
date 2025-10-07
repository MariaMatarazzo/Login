package com.Login.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/users")
public class LoginController {

	    private final LoginService service;
	    
	    @PostMapping("/auth")
	    public ResponseEntity<Login> authenticate(@RequestBody Login loginDetails) {
	        Login authenticatedUser = service.authenticate(loginDetails.getUsername(), loginDetails.getPassword());
	    

	    if (authenticatedUser != null) {
	        // Retorna 200 OK com os dados do usuário (sem a senha) se a autenticação for bem-sucedida
	        authenticatedUser.setPassword(null); // Nunca retorne a senha para o front-end
	        return ResponseEntity.ok(authenticatedUser);
	    }
	    // Retorna 401 Unauthorized se as credenciais estiverem incorretas
	    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	    }
	    
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



