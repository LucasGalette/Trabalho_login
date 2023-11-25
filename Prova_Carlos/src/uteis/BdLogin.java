package uteis;

import model.Cadastro;
import model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BdLogin {
    private Connection conexao;
    public BdLogin() throws SQLException {
        this.conexao = CriarConexao.getConexao();
    }

    public void verificarLogin(Login l) throws SQLException{
        String sql = "SELECT id, nome, login, senha , email from usuario where login = ? and senha = ?";
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(sql);

        stmt.setString(2,l.getLogin());
        stmt.setString(3,String.valueOf(l.getSenha()));

        stmt.execute();
        stmt.close();
    }
}
