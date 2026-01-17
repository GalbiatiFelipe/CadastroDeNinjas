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
    public MissoesDTO adicionarMissao(@RequestBody MissoesDTO missao) {
        return missoesService.adicionarMissao(missao);
    }

    // Mostrar todas as missões
    @GetMapping("/lista")
    public List<MissoesDTO> mostrarMissoes() {
        return missoesService.listarMissoes();
    }

    // Mostrar missão por ID
    @GetMapping("/procurar/{id}")
    public MissoesDTO procurarMissaoPorId(@PathVariable Long id) {
        //PathVariable = permite o usuario passar o id, para compor o URL
        return missoesService.procurarPorId(id);
    }

    // Alterar informações da missão
    @PutMapping("/alterar/{id}")
    public MissoesDTO atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        return missoesService.atualizarMissao(id, missao);
    }

    // Deletar missao
    @DeleteMapping("/deletar/{id}")
    public void deletarPorId(@PathVariable Long id) {
        missoesService.deletarMissaoPorId(id);
    }

}
