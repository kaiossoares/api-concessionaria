package br.com.concessionaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Converte as exceções da aplicação em respostas JSON com o status HTTP adequado.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /** 404 - ID inexistente. */
    @ExceptionHandler(CarroNaoEncontradoException.class)
    public ProblemDetail tratarNaoEncontrado(CarroNaoEncontradoException ex) {
        ProblemDetail problema = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problema.setTitle("Carro não encontrado");
        return problema;
    }

    /** 400 - corpo da requisição com campos inválidos (ex.: marca em branco). */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail tratarValidacao(MethodArgumentNotValidException ex) {
        Map<String, String> campos = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(erro -> campos.putIfAbsent(erro.getField(), erro.getDefaultMessage()));

        ProblemDetail problema = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, "Um ou mais campos estão inválidos");
        problema.setTitle("Dados inválidos");
        problema.setProperty("campos", campos);
        return problema;
    }
}
