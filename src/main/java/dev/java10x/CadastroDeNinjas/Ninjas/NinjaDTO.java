package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaDTO {

    private Long id;

    private String nome;

    private String email;

    private int idade;

    private String urlImagem;

    private String rank;

    private MissoesModel missao;

}
