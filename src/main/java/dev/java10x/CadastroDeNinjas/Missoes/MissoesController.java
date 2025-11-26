package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    /*
    * CRUD
    *
    * CREATE - PostMapping
    * READ - GetMapping
    * UPDATE - PutMapping
    * DELETE - DeleteMapping
    * */

    // Adicionar missão
    @PostMapping("/adicionar")
    public String adicionarMissao() {
        return "Missao criada";
    }

    // Mostrar todas as missões
    @GetMapping("/lista")
    public String mostrarMissoes() {
        return "Lista de Todas as Missões";
    }

    // Mostrar missão por ID
    @GetMapping("/procurarID")
    public String procurarMissaoPorId() {
        return "ID da missão";
    }

    // Alterar informações da missão
    @PutMapping("/alterarID")
    public String alterarMissaoId() {
        return "Missão alterada";
    }

    // Deletar missao
    @DeleteMapping("/deletarID")
    public String deletarMissaoPorId() {
        return "Missão deletada";
    }

}
