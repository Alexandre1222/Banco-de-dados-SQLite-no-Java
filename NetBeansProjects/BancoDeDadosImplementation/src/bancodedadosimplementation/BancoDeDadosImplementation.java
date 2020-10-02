/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancodedadosimplementation;

/**
 *
 * @author 55859
 */
import Conexoes.ConexaoSQLite;
import java.sql.*;
public class BancoDeDadosImplementation {

    
    public static void main(String[] args) {
        ConexaoSQLite conexaoComBanco = new ConexaoSQLite();
        conexaoComBanco.conectar();
                
                
    }
    
}
