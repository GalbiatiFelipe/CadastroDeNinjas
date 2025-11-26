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
    public String adicionarNinja() {
        return "Ninja Criado";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/lista")
    public List<NinjaModel> mostrarTodosOsNinjas() {
        return ninjaService.listarNinjas();
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
