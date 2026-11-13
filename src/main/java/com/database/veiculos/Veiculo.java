package com.database.veiculos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O modelo é obrigatório")
    @Size(min = 2, max = 60, message = "O modelo deve ter entre 2 e 60 caracteres")
    private String modelo;

    @NotBlank(message = "A placa é obrigatória")
    @Size(min = 7, max = 7, message = "A placa deve ter 7 caracteres")
    private String placa;

    @NotNull(message = "O ano é obrigatório")
    @Min(value = 1950, message = "O ano deve ser maior ou igual a 1950")
    @Max(value = 2030, message = "O ano deve ser menor ou igual a 2030")
    private Integer ano;

    @NotBlank(message = "A cor é obrigatória")
    @Size(max = 30, message = "A cor deve ter no máximo 30 caracteres")
    private String cor;

    public Veiculo() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public Integer getAno() { return ano; }
    public void setAno(Integer ano) { this.ano = ano; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
}