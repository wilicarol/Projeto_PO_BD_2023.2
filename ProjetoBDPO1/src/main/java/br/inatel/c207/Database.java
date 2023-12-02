package br.inatel.c207;

import java.sql.*;

public abstract class Database {
    Connection connection;
    Statement statement;
    ResultSet result;
    PreparedStatement pst;

    static final String user = "root";
    static final String password="Fioravante1!";
    static final String database="ProjetoPsi";

    static final String url="jdbc:mysql://localhost:3306/"+database+"?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    public boolean check=false;

    public void connect(){
        try{
            connection= DriverManager.getConnection(url,user,password);
            System.out.println("Conexão ok"+connection);
        }catch(SQLException e){
            System.out.println("Erro:"+e.getMessage());

        }
    }
}
