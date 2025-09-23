package com.Login.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Login.entities.Produtos;
import com.Login.service.ProdutosService;


@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    private final ProdutosService service;

    public ProdutosController(ProdutosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produtos> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Produtos buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Produtos salvar(@RequestBody Produtos produtos) {
        return service.salvar(produtos);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
