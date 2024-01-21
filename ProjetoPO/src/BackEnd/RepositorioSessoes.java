package BackEnd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

public class RepositorioSessoes implements Serializable {

    private Collection<Sessao> sessoes = new HashSet<>();

    public RepositorioSessoes() {
        sessoes = new HashSet<>();
    }

    public void adicionarSessao(Sessao sessao) {
        sessoes.add(sessao);
    }

    public void adicionarRequisicoesAumaSessao(Sessao sessao) {
        for (Sessao s : sessoes) {
            if (s.getCodigo() == sessao.getCodigo()) {
                s.setRequisicoes(sessao.getRequisicoes());
            }
        }

    }

    public boolean verificarExisteSessao(int cod) {

        for (Sessao s : sessoes) {
            if (s.getCodigo() == cod) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarExisteSessaoProdutor(int cod, Produtor produtor) {

        for (Sessao s : sessoes) {
            if (s.getCodigo() == cod && s.getAlbumSerGravado().getProdutor().equals(produtor)) {
                return true;
            }
        }
        return false;
    }

    public Sessao procurarSessao(int cod) {

        for (Sessao s : sessoes) {
            if (s.getCodigo() == cod) {
                return (Sessao) s;
            }
        }
        return null;
    }

    public Sessao procurarSessaoPorMusico(int cod, Musico musico) {

        for (Sessao s : sessoes) {
            if (s.getCodigo() == cod) {
                return (Sessao) s;
            }
        }

        return null;
    }

    public Collection<Sessao> listarSessoesAgendadasPorDia(Produtor produtor, LocalDate data) {
        Collection<Sessao> sessoesAgendadas = new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.getAlbumSerGravado().getProdutor().equals(produtor) && s.isSessaoConcluida() == false && (s.getDiaDeGravacao().equals(data))) {
                sessoesAgendadas.add(s);
                System.out.println(s.toString());
            }
        }
        return sessoesAgendadas;
    }

    public Collection<Sessao> listarSessoesAgendadasPorMusico(Musico musico) {
        Collection<Sessao> sessoesAgendadas = new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida() == false) {
                for (Requisicao r : s.getRequisicoes()) {
                    if (r.getRequisitor().equals(musico)) {
                        sessoesAgendadas.add(s);
                        System.out.println(s.toString());
                    }
                    
                }

            }
        }
        return sessoesAgendadas;
    }

    public Collection<Sessao> listarEstadoSessoesPorMusico(Musico musico) {
        Collection<Sessao> sessoesAgendadas = new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida() == false) {
                Collection<Requisicao> requisicoesSessao = new HashSet<>();
                requisicoesSessao = s.getRequisicoes();
                for (Requisicao r : requisicoesSessao) {
                    if (r.getRequisitor().equals(musico)) {
                        sessoesAgendadas.add(s);
                    }
                    System.out.println(s.toString() + "-Sessão a decorrer.");
                }

            } else if (s.isSessaoConcluida() == true) {
                Collection<Requisicao> requisicoesSessao = new HashSet<>();
                requisicoesSessao = s.getRequisicoes();
                for (Requisicao r : requisicoesSessao) {
                    if (r.getRequisitor().equals(musico)) {
                        sessoesAgendadas.add(s);
                    }
                    System.out.println(s.toString() + "-Sessão concluida.");
                }
            }
        }
        return sessoesAgendadas;
    }

    public Collection<Sessao> listarSessoesAgendadasPorProdutor() {
        Collection<Sessao> sessoesAgendadas = new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida() == false) {
                sessoesAgendadas.add(s);
                System.out.println(s.toString());
            }
        }
        return sessoesAgendadas;
    }

    public Collection<Sessao> listarSessoesConcluidas() {
        Collection<Sessao> sessoesConcluidas = new HashSet<>();
        for (Sessao s : sessoes) {
            if (s.isSessaoConcluida() == true) {
                sessoesConcluidas.add(s);
                System.out.println(s.toString());
            }
        }
        return sessoesConcluidas;
    }

    public void guardarFicheiroObjetos(String nomeFicheiro) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(nomeFicheiro); ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(sessoes);

        }
    }

    public void carregarFicheiroObjetos(String nomeFicheiro) throws Exception {
        FileInputStream file = new FileInputStream(nomeFicheiro);
        ObjectInputStream oin = new ObjectInputStream(file);
        sessoes = (HashSet<Sessao>) oin.readObject();
        oin.close();
        file.close();
    }

    @Override
    public String toString() {
        return "            LISTA INSTRUMENTOS\n" + "-----------------------------\n" + sessoes.toString() + '}';
    }

}
