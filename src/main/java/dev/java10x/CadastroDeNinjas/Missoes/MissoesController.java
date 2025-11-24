package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissoesController {

    /*
    * CRUD das missões
    * */

    // Adicionar missão
    @PostMapping("/adiconarmissao")
    public String adicionarMissao() {
        return "Missao criada";
    }

    // Mostrar todas as missões
    @GetMapping("/mostrarmissoes")
    public String mostrarMissoes() {
        return "Lista de Todas as Missões";
    }

    // Mostrar missão por ID
    @GetMapping("/missaoID")
    public String mostrarMissaoPorId() {
        return "ID da missão";
    }

    // Alterar informações da missão
    @PutMapping("/alterarmissaoID")
    public String alterarMissaoId() {
        return "Missão alterada";
    }

    // Deletar missao
    @DeleteMapping("/deletarmissaoID")
    public String deletarMissaoPorId() {
        return "Missão deletada";
    }

}
