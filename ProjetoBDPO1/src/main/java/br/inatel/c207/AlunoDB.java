package br.inatel.c207;

import java.sql.SQLException;
import java.util.ArrayList;

public class AlunoDB extends Database{

    boolean check = false;
    public boolean insertAluno(Aluno aluno){
        connect();
        String sql="INSERT INTO Aluno(nome, curso, matricula)values(?,?,?)";
        try{
            pst=connection.prepareStatement(sql);
            pst.setString(1,aluno.getNome());
            pst.setInt(2,aluno.getMatricula());
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


    public boolean updateAluno(int matricula,  Aluno aluno){
        connect();
        String sql="UPDATE Aluno SET nome=?, curso=?, WHERE matricula=?";

        try{
            pst=connection.prepareStatement(sql);
            pst.setString(1, aluno.getNome());
            pst.setString(2, aluno.getCurso());
            pst.setInt(3, aluno.getMatricula());
            pst.setInt(4, matricula);
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
    public boolean deleteAluno(int matricula){
        connect();
        String sql= "DELETE FROM Aluno WHERE matricula = ?";
        try{
            pst=connection.prepareStatement(sql);
            pst.setInt(1,matricula);
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
    public ArrayList<Aluno> selectAluno() {

        ArrayList<Aluno> alunos = new ArrayList<>();
        connect();
        String sql="SELECT * FROM Aluno";

        try{
            statement= connection.createStatement();
            result=statement.executeQuery(sql);

            while(result.next()){
                Aluno alunoTemp = new Aluno();
                alunoTemp.setNome(result.getString("nome"));
                alunoTemp.setCurso(result.getString("curso"));
                alunoTemp.setMatricula(result.getInt("matricula"));
                System.out.println("Nome: "+alunoTemp.getNome());
                System.out.println("curso: "+alunoTemp.getCurso());
                System.out.println("Matricula = "+alunoTemp.getMatricula());
                alunos.add(alunoTemp);
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
        return alunos;
    }
}
