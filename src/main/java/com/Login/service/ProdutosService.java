package com.Login.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Login.entities.Produtos;
import com.Login.repository.produtosRepository;

@Service
public class ProdutosService {
	    private final produtosRepository repository;

	    public ProdutosService(produtosRepository repository) {
	        this.repository = repository;
	    }

	    public List<Produtos> listar() { return repository.findAll(); }
	    public Produtos salvar(Produtos produtos) { return repository.save(produtos); }
	    public Produtos buscarPorId(Long id) { return repository.findById(id).orElse(null); }
	    public void deletar(Long id) { repository.deleteById(id); }
	
}
