package model;

public class Cadastro {
    private String Nome, Login, Email, Senha;
    private int Id;

    public Cadastro(){

    }

    public Cadastro(String nome, String login, String email, int id, String senha) {
        Nome = nome;
        Login = login;
        Email = email;
        Id = id;
        Senha = senha;
    }


    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
