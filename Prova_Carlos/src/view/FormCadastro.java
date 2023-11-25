package view;

import model.Cadastro;
import uteis.BdCadastro;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FormCadastro extends JFrame {

    JLabel lblNome, lblLogin, lblSenha, lblEmail;
    JTextField txtNome, txtLogin, txtSenha, txtEmail;
    JButton btnSalvar;

    public FormCadastro(){
        JFrame frame = new JFrame("Cadastrar Novo Usuario");
        frame.setSize(200,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panelCadastro = new JPanel(new GridLayout(4,2));
        TitledBorder tituloDadosCliente = new TitledBorder("Cadastro");
        panelCadastro.setBorder(tituloDadosCliente);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        lblNome = new JLabel("Nome:");
        lblLogin = new JLabel("Login:");
        lblSenha = new JLabel("Senha:");
        lblEmail = new JLabel("Email:");

        txtNome = new JTextField();
        txtLogin = new JTextField();
        txtSenha = new JTextField();
        txtEmail = new JTextField();

        panelCadastro.add(lblNome);
        panelCadastro.add(txtNome);
        panelCadastro.add(lblLogin);
        panelCadastro.add(txtLogin);
        panelCadastro.add(lblSenha);
        panelCadastro.add(txtSenha);
        panelCadastro.add(lblEmail);
        panelCadastro.add(txtEmail);

        JPanel panelBotoes = new JPanel(new GridLayout(1,1));
        TitledBorder botoes = new TitledBorder("");
        panelBotoes.setBorder(botoes);

        btnSalvar = new JButton("SALVAR");
        panelBotoes.add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Cadastro cadastro = new Cadastro();
                    cadastro.setNome(txtNome.getText());
                    cadastro.setLogin(txtLogin.getText());
                    cadastro.setSenha(txtSenha.getText());
                    cadastro.setEmail(txtEmail.getText());

                    BdCadastro c = new BdCadastro();
                    c.adicionarCadastro(cadastro);

                    JOptionPane.showMessageDialog(null,"Cadastrado com sucesso!");
                }
                catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"Erro ao cadastrar dados!");
                }
            }
        });

        frame.add(panelCadastro, BorderLayout.NORTH);
        frame.add(panelBotoes, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
