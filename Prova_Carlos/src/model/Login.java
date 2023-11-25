package model;

public class Login {
    private String Login, Senha;

    public Login(){

    }

    public Login(String login, String senha) {
        Login = login;
        Senha = senha;
    }

    public String getLogin() {return Login; }

    public void setLogin(String login) {
        Login = login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }
}
