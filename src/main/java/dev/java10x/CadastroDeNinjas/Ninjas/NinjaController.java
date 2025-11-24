package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    // CRUD
    // Adicionar ninja (CREATE)
    @PostMapping("/criarninja")
    public String criarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/todosninja")
    public String mostrarTodosOsNinjas() {
        return "Lista de Ninjas Completa";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/ninjaID")
    public String mostrarNinjasPorId() {
        return "ID do ninja";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarninjaID")
    public String alterarNinjasPorId() {
        return "Ninja Alterado";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarninjaID")
    public String deletarNinjaPorId() {
        return "Ninja deletado";
    }


}
