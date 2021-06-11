package com.contass.lista_tarefas.controllers;

import com.contass.lista_tarefas.model.ListaTarefas;
import com.contass.lista_tarefas.repository.ListaTarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


/**
 * criacao do controlador para a lista de tarefas
 * */
@Controller
public class ListaTarefaController {

    /**
     * injeção automática de dependências do repository
     * */
    @Autowired
    private ListaTarefaRepository listaTarefaRepository;

    /**
     * Mapeamento para o cadastro de tarefas
     * direciona para a classe de cadastro
     * */
    @RequestMapping(value = "/cadastrarTarefa", method = RequestMethod.GET)
    public String form() {
        return "view/formListaTarefa";
    }

    /**
     * Mapeamento cadastro de tarefas
     * salva a tarefa no banco de dados
     * direciona para a classe de cadastro
     * */
    @RequestMapping(value = "/cadastrarTarefa", method = RequestMethod.POST)
    public String form(@Valid ListaTarefas listaTarefas, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarTarefa";
        }

        listaTarefaRepository.save(listaTarefas);
        attributes.addFlashAttribute("mensagem", "Tarefa inserida com sucesso!");
        return "redirect:/cadastrarTarefa";
    }

    /**
     * Mapeamento para registros
     * recupera os registros das tarefas
     * retornar um modelAndView dos registros
     * */
    @RequestMapping("/registros")
    public ModelAndView listaTarefas() {
        ModelAndView mv = new ModelAndView("view/lista");
        Iterable<ListaTarefas> tarefas = listaTarefaRepository.findAll();
        mv.addObject("tarefas", tarefas);
        return mv;
    }

    /**
     * Mapeamento para uma unica tarefa a partir do seu codigo
     * recupera o registro da tarefa
     * retornar um modelAndView dessa tarefa
     * */
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesTarefa(@PathVariable("codigo") long codigo) {
        ListaTarefas detalhe = listaTarefaRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("view/detalheTarefa");
        mv.addObject("detalhe", detalhe);
        return mv;
    }

    /**
     * Mapeamento para atualizar uma tarefa
     * atualiza o registro
     * retornar para o cadastro
     * */
    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public String detalhesTarefaPost(@Valid ListaTarefas listaTarefas, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/cadastrarTarefa";
        }
        listaTarefaRepository.save(listaTarefas);
        attributes.addFlashAttribute("mensagem", "Tarefa atualizada com sucesso!");
        return "redirect:/cadastrarTarefa";
    }

    /**
     * Mapeamento para excluir uma tarefa pelo codigo
     * exclui a tarefa
     * retornar para os registros
     * */
    @RequestMapping("/deletar")
    public String deletarTarefa(long codigo){
        ListaTarefas listaTarefas = listaTarefaRepository.findByCodigo(codigo);
        listaTarefaRepository.delete(listaTarefas);
        return "redirect:/registros";
    }
}
