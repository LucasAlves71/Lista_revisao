package cadastros;

import java.util.ArrayList;
import java.util.List;

import app.Turma;

public class CadastroTurma {
	int numTurmas; 
	private List<Turma> turmas;
	
	public CadastroTurma() {
		numTurmas = 0;
		turmas = new ArrayList<Turma>();
	}
	
	public int cadastrarTurma(Turma t) {
		boolean cadastrou = turmas.add(t);
		if (cadastrou) {
			numTurmas = turmas.size();
		}
		return numTurmas;
	}
	
	public Turma pesquisarTurma(String numDaTurma) {
		for (Turma t : turmas) {
			if (t.getNumDaTurma().equalsIgnoreCase(numDaTurma)) {
				return t;
			}
		}
		return null;
	}
	
	public boolean removerTurma(Turma t) {
		boolean removeu = false; 
		if (turmas.contains(t)) {
			removeu = turmas.remove(t);
		}
		return removeu;
	}
	
	public boolean atualizarTurma(String numDaTurma, Turma t) {
		boolean resposta = false;
		Turma remover = pesquisarTurma(numDaTurma);
		if (remover != null) {
			turmas.remove(remover);
			resposta = turmas.add(t);
		}
		return resposta;
	}
}