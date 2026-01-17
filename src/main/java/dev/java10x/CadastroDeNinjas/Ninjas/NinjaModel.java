package dev.java10x.CadastroDeNinjas.Ninjas;

//JPA = Java Persistence API
import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// annotation que transforma uma classe em uma entidade do banco de dados
@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor // cria um construtor sem argumentos
@AllArgsConstructor // cria um construtor com todos os argumentos que sempre se atualiza
@Data // cria todos os getters e setters
public class NinjaModel {

    // annotations que juntas definem que o atributo logo abaixo possa gerar numeros sequencias automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true) //annotation que deixa faz com que o atributo só aceito valores unicos
    private String email;

    private int idade;

    @Column(name = "imagem_url")
    private String urlImagem;

    private String rank;

    // annotation que significa: um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missao_id") // Foreina Key = Chave Estrangeira
    private MissoesModel missao;

}
