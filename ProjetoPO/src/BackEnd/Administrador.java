package BackEnd;

import java.io.Serializable;
import java.time.LocalDate;



public class Administrador extends Utilizador implements Serializable{

    public Administrador(String username, String password, String nome) {
        super(username, password, nome);
    }

    public Administrador(String username, String password, String nome, int bi, String morada, LocalDate dataNasc) {
        super(username, password, nome, bi, morada, dataNasc);
    }
    

    
}
