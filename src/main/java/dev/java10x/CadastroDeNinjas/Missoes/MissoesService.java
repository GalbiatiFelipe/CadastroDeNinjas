package dev.java10x.CadastroDeNinjas.Missoes;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    // Listar Missoes por ID
    public MissoesModel procurarPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.orElse(null);
        /*
         * Optinal = o id pode ou não existir na tabela
         * .orElse = seta um retorno padrão caso o id não exista na tabela
         * */
    }

    // adiconar uma missão
    public MissoesModel adicionarMissao(MissoesModel missao) {
        return missoesRepository.save(missao);
    }

    // deletar uma missao: metodo deve ser void
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

}
