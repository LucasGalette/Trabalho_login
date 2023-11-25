package uteis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarConexao {
    public static Connection getConexao() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conectado com banco de dados");
            return DriverManager.getConnection("jdbc:mysql://localhost/prova", "root", "");
        }catch (ClassNotFoundException e){
            throw new SQLException(e.getMessage());
        }
    }
}
