package br.inatel.c207;

import java.sql.SQLException;

public class AgendaDB extends Database {

    PsicoDB atpsi = new PsicoDB();
    public boolean insertAgenda(Agendamento agendamento){
        connect();
        String sql= "INSERT INTO agendamento(tipo, data, psicologo_id, aluno_id )values(?,?,?,?)";

        try{
            pst=connection.prepareStatement(sql);
            pst.setString(1,agendamento.getTipo());
            pst.setString(2,agendamento.getData());
            pst.setInt(3,agendamento.getPsicologo_CRP());
            pst.setInt(4,agendamento.getAluno_id());
            atpsi.updatePsico(agendamento.getPsicologo_CRP(), "Psicologo");
            check=true;
        }catch(SQLException e){
            System.out.println("Erro10: "+e.getMessage());
            check=false;
        }
        finally{
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro"+e.getMessage());

            }

        }
        return check;
    }
    public boolean updateAgendamento(int id, Agendamento agendamento){
        connect();
        String sql="UPDATE Agendamento SET Tipo=? WHERE idAgendamento=?";

        try{
            pst=connection.prepareStatement(sql);
            pst.setString(1,agendamento.getTipo());
            pst.setInt(2,agendamento.getPsicologo_CRP());
            pst.setString(3,agendamento.getData());
            pst.setInt(4,agendamento.getAluno_id());
            pst.setInt(5, id);
            pst.execute();
            atpsi.updatePsico(id, "Psicologo");
            check=true;
        }catch(SQLException e){
            System.out.println("Erro5: "+e.getMessage());
            check=false;

        } finally{
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro6"+e.getMessage());
            }
        }
        return check;
    }
    public boolean deleteAgendamento(int idAgendamento){
        connect();
        String sql= "DELETE FROM Agendamento WHERE idAgendamento = ?";
        try{
            pst=connection.prepareStatement(sql);
            pst.setInt(1,idAgendamento);
            pst.execute();
            check=true;
        }catch(SQLException e){
            System.out.println("Erro 7" +e.getMessage());
            check=false;
        }finally{
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro 9: "+e.getMessage());
            }
        }
        return check;
    }
}
