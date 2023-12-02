package br.inatel.c207;

public class Psicologo {
    private int CRP;
    private String Nome;

    private String atendimento;

    public Psicologo(int CRP, String nome, String atendimento) {
        this.CRP = CRP;
        Nome = nome;
        this.atendimento = atendimento;
    }

    public Psicologo() {

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getCRP() {
        return CRP;
    }

    public void setCRP(int CRP) {
        this.CRP = CRP;
    }

    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }
}
