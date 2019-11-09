package br.com.crudusuario.Payloads;

public class UsuarioPayload {

    private String nomeCompleto;

    private String cpf;

    private String numeroCelular;

    private double quantiaPaga;

    private String status;

    private String tipoIngresso;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public double getQuantiaPaga() {
        return quantiaPaga;
    }

    public String getStatus() {
        return status;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }
}
