package br.inatel.c207;

public class Workshop {

    //public int idWorkshop;
    private String tema;
    private String data;
    private int psicologo_CRP;

    public Workshop(String tema, String data, int psicologo_CRP) {
        this.tema = tema;
        this.data = data;
        this.psicologo_CRP = psicologo_CRP;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
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

    public void setPsicoloco_CRP(int psicoloco_CRP) {
        this.psicologo_CRP = psicoloco_CRP;
    }
}
