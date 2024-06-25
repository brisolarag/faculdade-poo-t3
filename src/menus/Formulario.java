package menus;

import models.Cliente;
import models.Clientela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formulario extends JFrame {

    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoNasc;

    public Formulario() {
        initComponents();
    }

    public void initComponents() {
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Formulário de Clientes");
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); 

        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelNome, gbc);
        gbc.gridx = 1;
        panel.add(campoNome, gbc);

        JLabel labelEmail = new JLabel("Email:");
        campoEmail = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelEmail, gbc);
        gbc.gridx = 1;
        panel.add(campoEmail, gbc);

        JLabel labelNasc = new JLabel("Data de Nasc:");
        campoNasc = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelNasc, gbc);
        gbc.gridx = 1;
        panel.add(campoNasc, gbc);

        JButton btnEnviar = new JButton("Enviar");
        btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String email = campoEmail.getText();
                String dataNascString = campoNasc.getText();

                if (nome.isEmpty() || email.isEmpty() || dataNascString.isEmpty()) {
                    JOptionPane.showMessageDialog(Formulario.this, "Preencha todos os campos.");
                    return;
                }

                Date dataNasc = transformaData(dataNascString);
                if (dataNasc == null) {
                    JOptionPane.showMessageDialog(Formulario.this, "Formato de data inválido. Use dd/MM/yyyy.");
                    return;
                }

                Cliente novoCliente = new Cliente(nome, email, dataNascString);
                Clientela.addCliente(novoCliente);

                JOptionPane.showMessageDialog(Formulario.this, "Cliente cadastrado com sucesso!");

                dispose(); 
            }
        });

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose()); 

        JPanel botoesPanel = new JPanel();
        botoesPanel.add(btnEnviar);
        botoesPanel.add(btnCancelar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(botoesPanel, gbc);

        add(panel);

        setVisible(true);
    }

    private Date transformaData(String dataString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return sdf.parse(dataString);
        } catch (ParseException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Formulario::new);
    }
}
