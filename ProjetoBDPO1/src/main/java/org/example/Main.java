package org.example;

import br.inatel.c207.AlunoDB;
import br.inatel.c207.PsicoDB;
import br.inatel.c207.Aluno;
import br.inatel.c207.Psicologo;
import br.inatel.c207.Workshop;
import br.inatel.c207.WorkDB;
import br.inatel.c207.Agendamento;
import br.inatel.c207.AgendaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ArrayList<Psicologo> listaPsicologos = new ArrayList<>();
        ArrayList<Aluno> listaAlunos = new ArrayList<>();
        PsicoDB psicoDB = new PsicoDB();
        AlunoDB alunoDB = new AlunoDB();
        AgendaDB agendaDB = new AgendaDB();
        int id;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        int op; //para escolher qual ação quer realizar

        while (flag) {
            System.out.println("Bem vindo ao nosso site do Mind++ Lab!");
            System.out.println("Escolha uma opção: ");
            System.out.println("1 -  Inserir novo Psicologo;");
            System.out.println("2 -  Inserir novo Aluno;");
            System.out.println("3 -  Agendar um horário (Orientação Educacional(OE) ou Atendimento Individual(AI);");
            System.out.println("4 -  Mostrar Psicólogos disponíveis;");
            System.out.println("5 -  Buscar Psicólogo por nome;");
            System.out.println("6 -  Cancelar agendamento;");
            System.out.println("7 -  Mostrar os alunos atendidos;");
            //System.out.println("3 -  Ministrar Workshop;");
            System.out.println("8 -  Sair do sistema.");
            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Entre com o nome do Psicologo: ");
                    String nome = sc.nextLine();
                    System.out.println("Entre com o CRP: ");
                    int CRP = sc.nextInt();
                    System.out.println("Disponibilidade de atendimento: ");
                    String agendamento = sc.nextLine();
                    sc.nextLine();
                    Psicologo novopsi = new Psicologo(CRP, nome, agendamento);
                    psicoDB.insertPsico(novopsi);
                    System.out.println("Cadastro realizado!");
                    //mandar p BD
                    break;
                case 2: //agendamento
                    System.out.println("Entre com o nome do Aluno: ");
                    String nomeAluno = sc.nextLine();
                    System.out.println("Entre com o curso do Aluno: ");
                    String curso = sc.nextLine();
                    System.out.println("Entre com a matrícula do Aluno: ");
                    int matricula = sc.nextInt();
                    sc.nextLine();
                    Aluno novoaluno = new Aluno(nomeAluno, curso, matricula);
                    System.out.println("Cadastro realizado!");
                    break;
                case 3: //agendar com psi
                    boolean flag2 = true;
                    System.out.println("Digite a data do agendamento: ");
                    String data_agenda = sc.nextLine();
                    System.out.println("Digite o tipo de agendamento: ");
                    String tipo = sc.nextLine();
                    System.out.println("Digite a matricula do Aluno: ");
                    int aluno_id = sc.nextInt();
                    System.out.println("Digite o CRP do Psicologo: ");
                    int psicologo_CRP = sc.nextInt();
                    listaPsicologos = psicoDB.buscaPsicologo(3);
                    for(int i = 0; i<listaPsicologos.size();i++)
                        if(listaPsicologos.get(i).getCRP() == psicologo_CRP) {
                            System.out.println("Este horário não está disponível!");
                            flag2 = false;
                        }
                    if (flag2 == true) {
                        Agendamento agendamento1 = new Agendamento(tipo, data_agenda, psicologo_CRP, aluno_id);
                        agendaDB.insertAgenda(agendamento1);
                        System.out.println("Agendamento realizado!");
                    }
                    break;
                //Mostra psicologos disponiveis
                case 4:
                    listaPsicologos = psicoDB.buscaPsicologo(1);
                    for(int i = 0; i < listaPsicologos.size();i++){
                        System.out.println(" ");
                        System.out.println("Psicólogo" + i);
                        System.out.println("Nome do Psicólogo: ");
                        System.out.println(listaPsicologos.get(i).getNome());
                        System.out.println("CRP do Psicólogo:");
                        System.out.println(listaPsicologos.get(i).getCRP());
                        System.out.println("Disponibilidade de atendimento:");
                        System.out.println(listaPsicologos.get(i).getAtendimento());
                    }
                    break;
                case 5:
                    System.out.println(" ");
                    Psicologo buscapsi = new Psicologo();
                    nome = sc.nextLine();
                    buscapsi = psicoDB.buscarPsiPorNome(nome);
                    System.out.println("Nome do Psicólogo:");
                    System.out.println(buscapsi.getNome());
                    System.out.println("CRP do Psicólogo: ");
                    System.out.println(buscapsi.getCRP());
                    System.out.println("Horarios agendados: ");
                    System.out.println(buscapsi.getAtendimento());
                    break;
                case 6:
                    System.out.println("Entre com o id do agendamento que deseja cancelar: ");
                    id = sc.nextInt();
                    agendaDB.deleteAgendamento(id);
                    break;
                case 7:
                    listaAlunos = alunoDB.selectAluno();
                    for(int i = 0; i < listaAlunos.size();i++){
                        System.out.println(" ");
                        System.out.println("Aluno " + i);
                        System.out.println("Nome do aluno: ");
                        System.out.println(listaAlunos.get(i).getNome());
                        System.out.println("Curso do aluno: ");
                        System.out.println(listaAlunos.get(i).getCurso());
                        System.out.println("Matricula do aluno:");
                        System.out.println(listaAlunos.get(i).getMatricula());
                    }
                    break;
                case 8:
                    flag = false;
                    break;
            }
        }

    }
}
