package uteis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Cadastro;

public class BdCadastro {
    private Connection conexao;
    public BdCadastro() throws SQLException {
        this.conexao = CriarConexao.getConexao();
    }

    public void adicionarCadastro(Cadastro C) throws SQLException{
        String sql = "INSERT INTO usuario(nome, login, senha, email)" + "values(?,?,?,?)";
        PreparedStatement stmt;

        stmt = this.conexao.prepareStatement(sql);

        stmt.setString(1,C.getNome());
        stmt.setString(2,C.getLogin());
        stmt.setString(3,String.valueOf(C.getSenha()));
        stmt.setString(4,C.getEmail());

        stmt.execute();
        stmt.close();
    }
}
