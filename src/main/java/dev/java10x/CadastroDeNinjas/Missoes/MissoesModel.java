package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private RankMissoes rankMissoes;

    private NinjaModel ninja;

    public MissoesModel() {
    }

    public MissoesModel(String nome, RankMissoes rankMissoes) {
        this.nome = nome;
        this.rankMissoes = rankMissoes;
    }

    public MissoesModel(String nome, RankMissoes rankMissoes, NinjaModel ninja) {
        this(nome, rankMissoes);
        this.ninja = ninja;
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

    public NinjaModel getNinja() {
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }
}
