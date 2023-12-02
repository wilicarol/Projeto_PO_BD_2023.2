package br.inatel.c207;

import java.sql.SQLException;

public class WorkDB extends Database{

    PsicoDB atpsi = new PsicoDB();
    public boolean insertWorkshop(Workshop workshop){
        connect();
        String sql="INSERT INTO workshop (tema, data, psicologo_CRP)values(?,?)";
        try{
            pst=connection.prepareStatement(sql);
            pst.setString(1,workshop.getTema());
            pst.setString(2,workshop.getData());
            atpsi.updatePsico(workshop.getPsicologo_CRP(), "Psicologo");
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
    public boolean updateAluno(int idWorkshop, Workshop workshop){
        connect();
        String sql="UPDATE Workshop SET Nome=? WHERE idWorkshop=?";

        try{
            pst=connection.prepareStatement(sql);
            pst.setString(1,workshop.getTema());
            pst.setString(2, workshop.getData());
            pst.setString(3, String.valueOf(idWorkshop));
            pst.execute();
            atpsi.updatePsico(workshop.getPsicologo_CRP(), "true");
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
    public boolean deleteAluno(int idWorkshop){
        connect();
        String sql= "DELETE FROM Workshop WHERE idWorkshop = ?";
        try{
            pst=connection.prepareStatement(sql);
            pst.setInt(1,idWorkshop);
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
    /*public ArrayList<Workshop> selectWorkshop() {
        connect();
        ArrayList<Workshop> workshops = new ArrayList<>();
        String sql="SELECT * FROM Workshop";

        try{
            statement= connection.createStatement();
            result=statement.executeQuery(sql);

            while(result.next()){
                Workshop workTemp=new Workshop(result.getString("Tema"),result.getString("Dia"),result.getString("Hora"));
                System.out.println("Tema: "+workTemp.getTema());
                workshops.add(workTemp);
            }
        }catch(SQLException e){
            System.out.println("Erro 3: "+e.getMessage());
        }finally{
            try{
                connection.close();
                statement.close();
                result.close();
            }catch(SQLException e){
                System.out.println("Erro4"+e.getMessage());
            }
        }
        return workshops;
    }*/
}
