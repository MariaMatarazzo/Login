package com.Login.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.Login.entities.Login;
import com.Login.repository.LoginRepository;

@Service

public class LoginService {
	    private final LoginRepository repository;

	    public LoginService(LoginRepository repository) {
	        this.repository = repository;
	    }

	    public List<Login> listar() { return repository.findAll(); }
	    public Login salvar(Login login) { return repository.save(login); }
	    public Login buscarPorId(Long id) { return repository.findById(id).orElse(null); }
	    public void deletar(Long id) { repository.deleteById(id); }
	}


