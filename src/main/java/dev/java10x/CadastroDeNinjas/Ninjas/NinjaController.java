package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    /*
    * Injetar NinjaService para que as rotas possam acessar os métodos de lógica
    * 1- criar atributo do tipo 'NinjaService'
    * 2- inicializar o construtor
    * */

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    public ResponseEntity<String> adicionarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.adicionarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED) // Envia a mensagem para o servidor referente ao status http
                .body("Ninja adicionado com sucesso: " + novoNinja.getNome()); // Mensagem personalizada
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/lista")
    public List<NinjaDTO> mostrarTodosOsNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/procurar/{id}")
    public ResponseEntity<?> procurarNinjasPorId(@PathVariable Long id) {
        //PathVariable = permite o usuario passar o id, para compor o URL
        NinjaDTO ninjaProcurado = ninjaService.procurarNinjaPorId(id);
        if (ninjaProcurado != null) {
            return ResponseEntity.ok(ninjaProcurado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O ninja não existe nos registros");
        }
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        NinjaDTO ninjaAtualizado = ninjaService.atualizarNinja(id, ninja);
        if (ninjaAtualizado != null) {
            return ResponseEntity.ok(ninjaAtualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Este ninja não existe nos registros");
        }
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id) {
        if (ninjaService.procurarNinjaPorId(id) != null) {
            ninjaService.deletarNinjaPorId(id);
            return  ResponseEntity.ok("Ninja de ID " + id + " removido com sucesso"); // .ok: um status simples que só confirma a ação
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND) // Status que não foi encontrado
                    .body("O ID " + id + " não existe");
        }
    }


}
