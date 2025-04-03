package med.voll.api.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.voll.api.endereco.Endereco;

import java.util.Optional;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    @Embedded
    private Endereco endereco;

    public Paciente(DadosCadastroPaciente dados) {
        this.email = dados.email();
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoPaciente dados) {
        Optional.ofNullable(dados.nome()).ifPresent(nome -> this.nome = nome);
        Optional.ofNullable(dados.telefone()).ifPresent(telefone -> this.telefone = email);
        Optional.ofNullable(dados.endereco()).ifPresent(this.endereco::atualizarInformacoes);
    }
}
