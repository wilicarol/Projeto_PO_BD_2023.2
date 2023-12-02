package br.inatel.c207;

import java.sql.SQLException;
import java.util.ArrayList;

public class PsicoDB extends Database{
    public boolean insertPsico(Psicologo psicologo){
        connect();
        String sql = "INSERT INTO Psicologo(nome, CRP) values(?,?)";
        try{
            pst=connection.prepareStatement(sql);
            pst.setString(1,psicologo.getNome());
            pst.setInt(2,psicologo.getCRP());
            pst.setString(3,psicologo.getAtendimento());
            pst.execute();
            check=true;
        }catch(SQLException e){
            System.out.println("Erro2: "+e.getMessage());
            check=false;
        }
        finally{
            try{
                connection.close();
                pst.close();
            }catch(SQLException e){
                System.out.println("Erro ao fechar a conexao"+e.getMessage());
            }
        }
        return check;
    }

    public boolean updatePsico(int CRP,String atend){
        connect();
        String sql="UPDATE Psicologo SET atendimento=? WHERE CRP=?";

        try{
            pst=connection.prepareStatement(sql);
            pst.setString(1,atend);
            pst.setInt(2,CRP);
            pst.execute();
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

    public boolean deletePsico(int CRP){
        connect();
        String sql= "DELETE FROM Psicologo WHERE CRP = ?";
        try{
            pst=connection.prepareStatement(sql);
            pst.setInt(1,CRP);
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
    public ArrayList<Psicologo> buscaPsicologo(int fun) {
        ArrayList<Psicologo> listaDepsicologos = new ArrayList<>();

        connect();

        String sql = "SELECT * FROM Psicologo";

        try {

            statement= connection.createStatement();
            result=statement.executeQuery(sql);

            while (result.next()) {
                Psicologo psiAux = new Psicologo();
                psiAux.setCRP(result.getInt("CRP"));
                psiAux.setNome(result.getString("nome"));
               psiAux.setAtendimento(result.getString("atendimento"));

                if (fun == 1)
                    listaDepsicologos.add(psiAux);
                else if (fun == 2 && psiAux.getAtendimento() == null)
                    listaDepsicologos.add(psiAux);
                else if (fun == 3 && psiAux.getAtendimento() == null)
                    listaDepsicologos.add(psiAux);
            }
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro10: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return listaDepsicologos;
    }
    public ArrayList<Psicologo> selectPsico(int fun) {
        connect();
        ArrayList<Psicologo> psicologos = new ArrayList<>();
        String sql="SELECT * FROM Psicologo";

        try{
            statement= connection.createStatement();
            result=statement.executeQuery(sql);

            while(result.next()){
                Psicologo psicoTemp=new Psicologo();
                psicoTemp.setCRP(result.getInt("CRP"));
                psicoTemp.setNome(result.getString("nome"));
               psicoTemp.setAtendimento(result.getString("atendimento"));
                System.out.println("CRP = "+psicoTemp.getCRP());
                System.out.println("Nome: "+psicoTemp.getNome());
                psicologos.add(psicoTemp);
                if (fun == 1)
                    psicologos.add(psicoTemp);
                else if (fun == 2 && psicoTemp.getAtendimento() == null)
                    psicologos.add(psicoTemp);
                else if (fun == 3 && psicoTemp.getAtendimento() == null)
                    psicologos.add(psicoTemp);

            }
            check =  true;
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
        return psicologos;
    }
    public Psicologo buscarPsiPorNome(String nome) {

        connect();
        Psicologo psiAux = null;
        String sql = "SELECT * FROM Psicologo WHERE nome=?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, nome);
            result = pst.executeQuery();
            while (result.next()) {
                String aux = result.getString("nome");
                if (aux.isEmpty()) {
                    check = false;
                } else {
                    psiAux = new Psicologo();
                    psiAux.setNome(result.getString("nome"));
                   psiAux.setAtendimento(result.getString("atendimento"));
                }
            }
            check = true;
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            check = false;
        } finally {
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return psiAux; //mostra que achou o psicologo
    }
}
