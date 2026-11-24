package br.com.concessionaria.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * Entidade (Model) que representa um veículo da concessionária,
 * mapeada para a tabela "carros".
 */
@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) // o ID é gerado pelo banco; ignorado se vier no JSON
    private Long id;

    @NotBlank(message = "A marca é obrigatória")
    @Size(max = 50, message = "A marca deve ter no máximo 50 caracteres")
    @Column(name = "marca", nullable = false, length = 50)
    private String marca;

    @NotBlank(message = "O modelo é obrigatório")
    @Size(max = 100, message = "O modelo deve ter no máximo 100 caracteres")
    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;

    @NotNull(message = "O ano de fabricação é obrigatório")
    @Positive(message = "O ano de fabricação deve ser positivo")
    @Column(name = "ano_fabricacao", nullable = false)
    private Integer anoFabricacao;

    @NotNull(message = "O ano do modelo é obrigatório")
    @Positive(message = "O ano do modelo deve ser positivo")
    @Column(name = "ano_modelo", nullable = false)
    private Integer anoModelo;

    @NotBlank(message = "A motorização é obrigatória")
    @Size(max = 50, message = "A motorização deve ter no máximo 50 caracteres")
    @Column(name = "motorizacao", nullable = false, length = 50)
    private String motorizacao;

    public Carro() {
    }

    public Carro(String marca, String modelo, Integer anoFabricacao, Integer anoModelo, String motorizacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.motorizacao = motorizacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }
}
