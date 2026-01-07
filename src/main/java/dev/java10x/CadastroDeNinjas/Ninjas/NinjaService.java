package dev.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar todos os meus ninjas por ID
    public NinjaModel procurarNinjaPorId(Long id) {
        Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
        return ninjaPorId.orElse(null);
        /*
        * Optinal = o id pode ou não existir na tabela
        * .orElse = seta um retorno padrão caso o id não exista na tabela
        * */
    }

    // Criar um novo ninja
    public NinjaModel adicionarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Deletar um ninja tem que ser void
    public void deletarNinjaPorId(Long id) {
        ninjaRepository.deleteById(id);
    }

    // Atualizar Ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninja) {
        if (ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }
        return null;
    }
}
