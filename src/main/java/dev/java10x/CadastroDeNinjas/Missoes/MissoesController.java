package dev.java10x.CadastroDeNinjas.Missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> adicionarMissao(@RequestBody MissoesDTO missao) {
        MissoesDTO novaMissao = missoesService.adicionarMissao(missao);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missao " + novaMissao.getNome() + " adicionada com sucesso!");
    }

    // Mostrar todas as missões
    @GetMapping("/lista")
    public List<MissoesDTO> mostrarMissoes() {
        return missoesService.listarMissoes();
    }

    // Mostrar missão por ID
    @GetMapping("/procurar/{id}")
    public ResponseEntity<?> procurarMissaoPorId(@PathVariable Long id) {
        //PathVariable = permite o usuario passar o id, para compor o URL
        MissoesDTO missaoProcurada = missoesService.procurarPorId(id);
        if (missaoProcurada != null) {
            return ResponseEntity.ok(missaoProcurada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta missão não existe nos registros!");
        }
    }

    // Alterar informações da missão
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarMissao(@PathVariable Long id, @RequestBody MissoesDTO missao) {
        MissoesDTO missaoAtualizda = missoesService.atualizarMissao(id, missao);
        if (missaoAtualizda != null) {
            return ResponseEntity.ok(missaoAtualizda);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Esta Missão não existe nos registros!");
        }
    }

    // Deletar missao
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        if (missoesService.procurarPorId(id) != null) {
            missoesService.deletarMissaoPorId(id);
            return ResponseEntity.ok("Missão deletada com sucesso!");
        } else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Está Missão não existe nos registros!");
        }
    }

}
