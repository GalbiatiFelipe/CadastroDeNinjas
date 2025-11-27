package dev.java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;

// Annotation que transforma a classe em um Service
@Service
public class MissoesService {

    /*
     * Injetar dependencia Repository para que possamos acessar os métodos do JPA
     * 1- criar atributo do tipo 'repository'
     * 2- inicializar construtor
     * */
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository) {
        this.missoesRepository = missoesRepository;
    }

    // Listar todas as missoes
    public List<MissoesModel> listarMissoes() {
        return missoesRepository.findAll();
    }

}
