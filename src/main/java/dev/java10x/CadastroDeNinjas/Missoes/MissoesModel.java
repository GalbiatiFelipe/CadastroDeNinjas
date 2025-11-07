package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private RankMissoes rankMissoes;

    // annotation que significa: muitos ninjas vão ter uma unica missao
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

    public MissoesModel() {
    }

    public MissoesModel(String nome, RankMissoes rankMissoes) {
        this.nome = nome;
        this.rankMissoes = rankMissoes;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RankMissoes getRankMissoes() {
        return rankMissoes;
    }

    public void setRankMissoes(RankMissoes rankMissoes) {
        this.rankMissoes = rankMissoes;
    }

}
