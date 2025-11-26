package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Annotation que transforma a classe em um Service
@Service
public class NinjaService {

    /*
    * Injetar dependencia Repository para que possamos acessar os métodos do JPA
    * 1- criar atributo do tipo 'repository'
    * 2- inicializar construtor
    * */
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os meus ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }
}
