package models;

import java.util.ArrayList;

public class Clientela {
    private static ArrayList<Cliente> todos_clientes = new ArrayList<Cliente>() {{
        add(new Cliente("João", "joao@example.com", "01/01/1990"));
        add(new Cliente("Maria", "maria@example.com", "15/05/1985"));
        add(new Cliente("Pedro", "pedro@example.com", "10/10/2000"));
    }};
    public static void addCliente(Cliente c) {
        todos_clientes.add(c);
    }
    public static ArrayList<Cliente> getTodosClientes() {
        return todos_clientes;
    }
}
