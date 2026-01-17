package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// Annotation que transforma a classe em um Service
@Service
public class NinjaService {

    /*
    * Injetar dependencia Repository para que possamos acessar os métodos do JPA
    * 1- criar atributo do tipo 'repository'
    * 2- inicializar construtor
    * */
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os meus ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Listar todos os meus ninjas por ID
    public NinjaDTO procurarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.map(ninjaMapper::toDTO).orElse(null);
        /*
        * Optinal = o id pode ou não existir na tabela
        * .orElse = seta um retorno padrão caso o id não exista na tabela
        * */
    }

    // Criar um novo ninja
    public NinjaDTO adicionarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninja = ninjaMapper.toModel(ninjaDTO); // traduz o dto para model
        ninja = ninjaRepository.save(ninja); // salvar informações neste model
        return ninjaMapper.toDTO(ninja); // retorna as informações salvas em forma de DTO
    }

    // Deletar um ninja tem que ser void
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninja) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()) {
            NinjaModel ninjaAtualizado = ninjaMapper.toModel(ninja);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.toDTO(ninjaSalvo);
        }
        return null;
    }
}
