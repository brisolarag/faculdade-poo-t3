package menus;
import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

    public Principal() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Menu Principal");
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new java.awt.FlowLayout());

        JButton btnFormCliente = new JButton("Cadastrar novo cliente");
        btnFormCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Formulario formCliente = new Formulario();
                formCliente.setVisible(true);
            }
        });
        add(btnFormCliente);

        JButton btnVerClientes = new JButton("Ver todos clientes");
        btnVerClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VisualizadorClientes visualizador = new VisualizadorClientes();
                visualizador.setVisible(true);
            }
        });
        add(btnVerClientes);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Principal();
            }
        });
    }
}