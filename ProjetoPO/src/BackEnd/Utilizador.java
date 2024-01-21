package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Utilizador implements Serializable {
    
    private String username;
    private String password;
    private String nome;
    private int bi;
    private String morada;
    private LocalDate dataNasc;
    

    public Utilizador(String username, String password, String nome, int bi, String morada, LocalDate dataNasc) {
        this.username = username;
        this.password = password;
        this.nome = nome;
        this.bi = bi;
        this.morada = morada;
        this.dataNasc = dataNasc;
    }

    //Construtor de editar dados
    public Utilizador(String nome, int bi, String morada, LocalDate dataNasc) {
        this.nome = nome;
        this.bi = bi;
        this.morada = morada;
        this.dataNasc = dataNasc;
    }

    public Utilizador(String username, String password, String nome) {
        this.username = username;
        this.password = password;
        this.nome = nome;
    }
    
    


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getBi() {
        return bi;
    }

    public void setBi(int bi) {
        this.bi = bi;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + "\n" +
               "Bi:" + bi + "\n" +
               "Morada:" + morada + "\n" +
               "Data Nascimento:" + dataNasc;
    }
    
    
}
