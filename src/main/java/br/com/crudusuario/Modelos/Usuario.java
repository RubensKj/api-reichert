package br.com.crudusuario.Modelos;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@DynamicUpdate
@DynamicInsert
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String nomeCompleto;

    @Column(columnDefinition = "varchar(14)")
    private String cpf;

    @Column(columnDefinition = "varchar(15)")
    private String numeroCelular;

    private double quantiaPaga;

    private TipoIngresso tipoIngresso;

    private Status status;

    public Usuario() {
    }

    public Usuario(String nomeCompleto, String cpf, String numeroCelular, double quantiaPaga, TipoIngresso tipoIngresso, Status status) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.numeroCelular = numeroCelular;
        this.quantiaPaga = quantiaPaga;
        this.tipoIngresso = tipoIngresso;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public double getQuantiaPaga() {
        return quantiaPaga;
    }

    public void setQuantiaPaga(double quantiaPaga) {
        this.quantiaPaga = quantiaPaga;
    }

    public TipoIngresso getTipoIngresso() {
        return tipoIngresso;
    }

    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
