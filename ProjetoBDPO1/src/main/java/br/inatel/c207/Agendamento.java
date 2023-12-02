package br.inatel.c207;

public class Agendamento {

    //int idAgendamento;
    private String tipo;
    private String data;
    private  int psicologo_CRP;
    private int aluno_id;

    public Agendamento(String tipo, String data, int psicologo_CRP, int aluno_id) {
        this.tipo = tipo;
        this.data = data;
        this.psicologo_CRP = psicologo_CRP;
        this.aluno_id = aluno_id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getPsicologo_CRP() {
        return psicologo_CRP;
    }

    public void setPsicologo_CRP(int psicologo_CRP) {
        this.psicologo_CRP = psicologo_CRP;
    }

    public int getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(int aluno_id) {
        this.aluno_id = aluno_id;
    }
}
