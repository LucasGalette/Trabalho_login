package view;


import model.Login;
import uteis.BdLogin;
import uteis.BdCadastro;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FormLogin extends JFrame {

    JButton btnEntrar, btnCadastrar;

    public FormLogin(){
        JFrame frame = new JFrame("Login");
        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panelLogin = new JPanel(new GridLayout(2,2));
        TitledBorder tituloDadosCliente = new TitledBorder("Login");
        panelLogin.setBorder(tituloDadosCliente);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblLogin = new JLabel("Login:");
        JLabel lblSenha = new JLabel("Senha:");

        JTextField txtLogin = new JTextField();
        JTextField txtSenha = new JTextField();

        panelLogin.add(lblLogin);
        panelLogin.add(txtLogin);
        panelLogin.add(lblSenha);
        panelLogin.add(txtSenha);

        JPanel panelBotoes = new JPanel(new GridLayout(2,1));
        TitledBorder botoes = new TitledBorder("");
        panelBotoes.setBorder(botoes);

        btnEntrar = new JButton("ENTRAR");
        btnCadastrar = new JButton("CADASTRAR NOVO USUÁRIO");
        panelBotoes.add(btnEntrar);
        panelBotoes.add(btnCadastrar);

        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Login login = new Login();
                    login.setLogin(txtLogin.getText());
                    login.setSenha(txtSenha.getText());

                    BdLogin c = new BdLogin();
                    c.verificarLogin(login);

                    JOptionPane.showMessageDialog(null,"Logado com sucesso!");
                }
                catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"Erro ao fazer login!");
                }
            }
        });

        btnCadastrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                FormCadastro Cadastro = new FormCadastro();
                frame.dispose();
            }

        });


        frame.add(panelLogin, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
