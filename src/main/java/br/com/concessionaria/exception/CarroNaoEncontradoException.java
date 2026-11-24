package br.com.concessionaria.exception;

/**
 * Lançada quando não existe carro com o ID informado.
 */
public class CarroNaoEncontradoException extends RuntimeException {

    public CarroNaoEncontradoException(Long id) {
        super("Carro com ID " + id + " não encontrado");
    }
}
