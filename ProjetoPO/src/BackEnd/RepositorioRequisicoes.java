package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class RepositorioRequisicoes implements Serializable {

    private Collection<Requisicao> requisicoes = new HashSet<>();

    public RepositorioRequisicoes() {
        requisicoes = new HashSet<>();
    }

    public void adicionarRequisicao(Requisicao requisicao) {
        requisicoes.add(requisicao);
    }

    public boolean verificarExisteRequisicao(int cod) {

        for (Requisicao r : requisicoes) {
            if (r.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }

    public void aceitarRequisicao(int codRequisicao) {
        for (Requisicao r : requisicoes) {
            if (r.getCodigo() == codRequisicao && r.getEstadoRequisicao().equals("Pendente")) {
                r.setEstadoRequisicao("Atribuido");
            }
        }

    }

    public void recusarRequisicao(int codRequisicao) {
        for (Requisicao r : requisicoes) {
            if (r.getCodigo() == codRequisicao && r.getEstadoRequisicao().equals("Pendente")) {
                r.setEstadoRequisicao("Recusado");
            }
        }

    }

    public Collection<Requisicao> listarRequisicoes(String Estado) { // Estado "Pendente", "Atribuido", "Recusado"
        Collection<Requisicao> requisicoesO = new HashSet<>();
        for (Requisicao r : requisicoes) {
            if (r.getEstadoRequisicao().equals(Estado)) {
                requisicoesO.add(r);
                System.out.println(r.toString());
            }
        }
        return requisicoesO;
    }

    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileOutputStream fos = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(requisicoes);

        oos.close();
        fos.close();
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        requisicoes = (HashSet<Requisicao>) oin.readObject();
        oin.close();
        file.close();
    }

    @Override
    public String toString() {
        return "            LISTA REQUISIÇÕES\n" + "-----------------------------\n" + requisicoes;
    }

}
