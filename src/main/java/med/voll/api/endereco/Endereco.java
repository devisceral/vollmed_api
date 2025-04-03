package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Optional;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private  String numero;
    private String complemento;

    public Endereco(DadosEndereco dados) {

        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.numero = dados.numero();
        this.complemento =  dados.complemento();
    }

    public void atualizarInformacoes(DadosEndereco dados) {

        Optional.ofNullable(dados.logradouro()).ifPresent(logradouro -> this.logradouro = logradouro);
        Optional.ofNullable(dados.bairro()).ifPresent(bairro -> this.bairro = bairro);
        Optional.ofNullable(dados.cep()).ifPresent(cep -> this.cep = cep);
        Optional.ofNullable(dados.cidade()).ifPresent(cidade -> this.cidade = cidade);
        Optional.ofNullable(dados.uf()).ifPresent(uf -> this.uf = uf);
        Optional.ofNullable(dados.numero()).ifPresent(numero -> this.numero = numero);
        Optional.ofNullable(dados.complemento()).ifPresent(complemento -> this.complemento = complemento);
    }
}
