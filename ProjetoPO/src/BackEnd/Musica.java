package BackEnd;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

public class Musica implements Serializable {

    private String titulo;
    private int duracao;
    private Collection<Musico> musicos;

    public Musica() {
        musicos = new HashSet<>();
    }

    public Musica(String titulo, int duracao, Collection<Musico> musicos) {
        this.titulo = titulo;
        this.duracao = duracao;
        this.musicos = musicos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Collection<Musico> getMusicos() {
        return musicos;
    }

    public void setMusicos(Collection<Musico> musicos) {
        this.musicos = musicos;
    }

    public void adicionarMusico(Musico musico) {
        musicos.add(musico);
    }

    public void removerMusico(int bi) {
        for (Musico m : musicos) {
            if (m.getBi() == bi) {
                musicos.remove(m);
            }
        }
    }

    @Override
    public String toString() {
        return "MUSICA\n"+ "\nTitulo:" + titulo + "\nDuração:" + duracao + "Artistas ->" + musicos;
    }

}
