package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente {
    private static int _id = 0;
    private int id;
    public int getId() {return this.id;}
    private void setId() {
        this.id = _id;
        _id++;
    }

    private String nome;
    public void setNome(String newNome) {
        this.nome = newNome;
    }
    public String getNome() {return this.nome;}

    private String email;
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    public String getEmail() {return this.email;}

    private Date data_nasc;
    public Date getDataNasc() {return this.data_nasc;}


    public Cliente(String nome, String email, String data_nasc) {
        setId();
        this.nome = nome;
        this.email = email;
        this.data_nasc = transformaData(data_nasc);
    }



    private Date transformaData(String dataString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFormatada = null;
        try {
            dataFormatada = sdf.parse(dataString);
        } catch (Exception e) {
            return null;
        }
        return dataFormatada;
    }

}
