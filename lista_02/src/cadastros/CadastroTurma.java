package cadastros;

import java.util.ArrayList;
import java.util.List;

import app.Turma;

public class CadastroTurma {
    private List<Turma> turmas;

    public CadastroTurma() {
        turmas = new ArrayList<>();
    }

    public boolean cadastrarTurma(Turma turma) {
        return turmas.add(turma);
    }

    public Turma pesquisarTurma(String numDaTurma) {
        for (Turma t : turmas) {
            if (t.getNumDaTurma().equalsIgnoreCase(numDaTurma)) {
                return t;
            }
        }
        return null;
    }

    public boolean removerTurma(Turma turma) {
        return turmas.remove(turma);
    }

    public boolean atualizarTurma(String codigo, Turma novaTurma) {
        Turma turma = pesquisarTurma(codigo);
        if (turma != null) {
            turmas.remove(turma);
            return turmas.add(novaTurma);
        }
        return false;
    }
}
