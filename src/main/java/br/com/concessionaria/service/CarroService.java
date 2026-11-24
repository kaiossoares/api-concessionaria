package br.com.concessionaria.service;

import br.com.concessionaria.exception.CarroNaoEncontradoException;
import br.com.concessionaria.model.Carro;
import br.com.concessionaria.repository.CarroRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Regras de negócio do cadastro de carros.
 */
@Service
public class CarroService {

    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Carro> listarTodos() {
        return repository.findAll(Sort.by("id"));
    }

    @Transactional(readOnly = true)
    public Carro buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CarroNaoEncontradoException(id));
    }

    @Transactional
    public Carro cadastrar(Carro carro) {
        return repository.save(carro);
    }

    @Transactional
    public Carro atualizar(Long id, Carro dados) {
        Carro carro = buscarPorId(id);
        carro.setMarca(dados.getMarca());
        carro.setModelo(dados.getModelo());
        carro.setAnoFabricacao(dados.getAnoFabricacao());
        carro.setAnoModelo(dados.getAnoModelo());
        carro.setMotorizacao(dados.getMotorizacao());
        return repository.save(carro);
    }

    @Transactional
    public void excluir(Long id) {
        Carro carro = buscarPorId(id);
        repository.delete(carro);
    }
}
