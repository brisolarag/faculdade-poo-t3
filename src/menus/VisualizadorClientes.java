package menus;

import models.Cliente;
import models.Clientela;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class VisualizadorClientes extends JFrame {

    private JList<String> listaClientes;

    public VisualizadorClientes() {
        initComponents();
    }

    private void initComponents() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Lista de Clientes");

        JPanel panel = new JPanel(new BorderLayout());

        ArrayList<Cliente> clientes = Clientela.getTodosClientes();
        DefaultListModel<String> listModel = new DefaultListModel<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (Cliente cliente : clientes) {
            String infoCliente = cliente.getNome() + " - " +
                    cliente.getEmail() + " - " +
                    sdf.format(cliente.getDataNasc());
            listModel.addElement(infoCliente);
        }

        listaClientes = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(listaClientes);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Botão para fechar a janela
        JButton btnFechar = new JButton("Fechar");
        btnFechar.addActionListener(e -> dispose()); 
        panel.add(btnFechar, BorderLayout.SOUTH);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(VisualizadorClientes::new);
    }
}
