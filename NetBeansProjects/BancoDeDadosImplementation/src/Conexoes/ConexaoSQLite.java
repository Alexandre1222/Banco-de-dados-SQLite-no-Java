/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 55859
 */
public class ConexaoSQLite {
    
    private Connection conexao;
    
    //Criei o método Conectar, para que na classe principal chame ele
    public boolean conectar(){
        
        //Ele vai tentar criar uma conexão com o banco de dados, se nao der certo irá alertar um erro.
        //O SQLite sempre irá criar um novo banco de dados caso não exista um banco com o nome que vc colocou
    try{
        //Caminho do banco de dados.
        String url = "jdbc:sqlite:banco_de_dados/banco_teste.db";
        //Conexão com o mesmo
        this.conexao = DriverManager.getConnection(url);
        
                Statement statement = conexao.createStatement();
                
                //Inseri os dados dentro do meu banco de dados
                statement.execute("INSERT INTO alunos(Id, nome, turma) VALUES (NULL, 'Alexandre', '3B'), (NULL, 'Well', '2A')");
                
                //Lendo Registros
                PreparedStatement stmt = conexao.prepareStatement("SELECT * FROM Alunos");
                ResultSet resultSet = stmt.executeQuery();
                
                
                System.out.println("id ---------- Nome ---------- Turma");
                while(resultSet.next()){
                int id = resultSet.getInt("Id");
                String Nome = resultSet.getString("nome");
                String Turma = resultSet.getString("turma");
                    
                    System.out.println(id + " ---------- " + Nome + " ---------- " + Turma);
                }
    }catch(SQLException e){
        //Mensagem de erro caso a conexão falhe
        e.printStackTrace();
        
        return false;
    }
        System.out.println("Conexão com o banco de dados feita com sucesso");
    return true;
    
    }
    
}
