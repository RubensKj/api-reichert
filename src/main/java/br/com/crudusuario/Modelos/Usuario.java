package br.com.crudusuario.Modelos;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.InputMismatchException;

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

    /**
     * Validação de CPF
     *
     * @param cpf
     * @return true or false
     */
    public boolean validaCPF(String cpf) {
        if (cpf.equals("00000000000") ||
                cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999") ||
                (cpf.length() != 11)) {
            return false;
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char) (r + 48);

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig11 = '0';
            else dig11 = (char) (r + 48);

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                return true;
            else return false;
        } catch (InputMismatchException erro) {
            return false;
        }
    }

    public String formataCPF(String cpf) {
        return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
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
