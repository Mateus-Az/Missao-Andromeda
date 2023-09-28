package br.mission.andromeda.M.A.Todo.List.exceptions;

import br.mission.andromeda.M.A.Todo.List.dtos.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice(basePackages = "br.mission.andromeda.M.A.Todo.List.controller")
public class ExceptionHandling {


    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(TarefaNaoEncontradaException.class)
    public ErrorDTO tarefaNaoEncontrada(TarefaNaoEncontradaException tarefaNaoEncontradaException){
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(),"Tarefa não encontrada.",LocalDateTime.now());
        return errorDTO;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ListaVaziaException.class)
    public ErrorDTO naoExistemTarefasCriadas(ListaVaziaException listaVaziaException){
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.NOT_FOUND.value(), "Não existem tarefas criadas", LocalDateTime.now());
        return errorDTO;
    }
    @ResponseBody
    @ResponseStatus(HttpStatus.ALREADY_REPORTED)
    @ExceptionHandler(TarefaJaConcluidaException.class)
    public ErrorDTO tarefaJaConcluida(TarefaJaConcluidaException tarefaJaConcluidaException){
        ErrorDTO errorDTO = new ErrorDTO(HttpStatus.ALREADY_REPORTED.value(), "Essa tarefa já foi concluida", LocalDateTime.now());
        return errorDTO;
    }
}
