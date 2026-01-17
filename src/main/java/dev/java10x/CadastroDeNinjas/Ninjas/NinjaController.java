package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    /*
    * Injetar NinjaService para que as rotas possam acessar os métodos de lógica
    * 1- criar atributo do tipo 'NinjaService'
    * 2- inicializar o construtor
    * */

    private NinjaService ninjaService;

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
    public NinjaDTO adicionarNinja(@RequestBody NinjaDTO ninja) {
        return ninjaService.adicionarNinja(ninja);
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/lista")
    public List<NinjaDTO> mostrarTodosOsNinjas() {
        return ninjaService.listarNinjas();
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/procurar/{id}")
    public NinjaDTO procurarNinjasPorId(@PathVariable Long id) {
        //PathVariable = permite o usuario passar o id, para compor o URL
        return ninjaService.procurarNinjaPorId(id);
    }

    // Alterar dados dos ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.atualizarNinja(id, ninja);
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id) {
        ninjaService.deletarNinjaPorId(id);
    }


}
