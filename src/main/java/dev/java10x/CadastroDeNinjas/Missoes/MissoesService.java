package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaMapper;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Annotation que transforma a classe em um Service
@Service
public class MissoesService {

    /*
     * Injetar dependencia Repository para que possamos acessar os métodos do JPA
     * 1- criar atributo do tipo 'repository'
     * 2- inicializar construtor
     * */
    private final MissoesRepository missoesRepository;
    private final MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper) {
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    // Listar todas as missoes
    public List<MissoesDTO> listarMissoes() {
        List<MissoesModel> missoes = missoesRepository.findAll();
        return missoes.stream()
                .map(missoesMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Listar Missoes por ID
    public MissoesDTO procurarPorId(Long id) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        return missaoPorId.map(missoesMapper::toDTO).orElse(null);
        /*
         * Optinal = o id pode ou não existir na tabela
         * .orElse = seta um retorno padrão caso o id não exista na tabela
         * */
    }

    // adiconar uma missão
    public MissoesDTO adicionarMissao(MissoesDTO missao) {
        MissoesModel missoesModel = missoesMapper.toModel(missao);
        missoesRepository.save(missoesModel);
        return missoesMapper.toDTO(missoesModel);
    }

    // deletar uma missao: metodo deve ser void
    public void deletarMissaoPorId(Long id) {
        missoesRepository.deleteById(id);
    }

    // atualizar uma missao
    public MissoesDTO atualizarMissao(Long id, MissoesDTO missao) {
        Optional<MissoesModel> missaoPorId = missoesRepository.findById(id);
        if (missaoPorId.isPresent()) {
            MissoesModel missaoAtualizada = missoesMapper.toModel(missao);
            missoesRepository.save(missaoAtualizada);
            return missoesMapper.toDTO(missaoAtualizada);
        }
        return null;
    }

}
