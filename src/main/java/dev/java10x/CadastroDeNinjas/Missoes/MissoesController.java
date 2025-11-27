package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

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
    public List<MissoesModel> mostrarMissoes() {
        return missoesService.listarMissoes();
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
