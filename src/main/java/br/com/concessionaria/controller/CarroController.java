package br.com.concessionaria.controller;

import br.com.concessionaria.model.Carro;
import br.com.concessionaria.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controller REST: recebe as requisições HTTP em /carros e devolve JSON.
 */
@RestController
@RequestMapping("/carros")
public class CarroController {

    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    /** POST /carros */
    @PostMapping
    public ResponseEntity<Carro> cadastrar(@RequestBody @Valid Carro carro, UriComponentsBuilder uriBuilder) {
        Carro salvo = service.cadastrar(carro);
        URI location = uriBuilder.path("/carros/{id}").buildAndExpand(salvo.getId()).toUri();
        return ResponseEntity.created(location).body(salvo);
    }

    /** GET /carros */
    @GetMapping
    public ResponseEntity<List<Carro>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    /** GET /carros/{id} */
    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    /** PUT /carros/{id} */
    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable Long id, @RequestBody @Valid Carro carro) {
        return ResponseEntity.ok(service.atualizar(id, carro));
    }

    /** DELETE /carros/{id} */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
