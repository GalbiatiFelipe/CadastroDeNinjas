package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    @GetMapping("boasvindas")
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota";
    }

    /*
     * CRUD
     *
     * CREATE - PostMapping
     * READ - GetMapping
     * UPDATE - PutMapping
     * DELETE - DeleteMapping
     * */

    // Adicionar ninja (CREATE)
    @PostMapping("/adicionar")
    public String adicionarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/lista")
    public String mostrarTodosOsNinjas() {
        return "Lista de Ninjas Completa";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/procurarID")
    public String procurarNinjasPorId() {
        return "ID do ninja";
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinjasPorId() {
        return "Ninja Alterado";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId() {
        return "Ninja deletado";
    }


}
