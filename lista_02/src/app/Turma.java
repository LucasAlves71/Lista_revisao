package app;

public class Turma {
	String disciplinaDaTurma;
	String professor;
	Aluno aluno;
	String numDaTurma;

	public Turma(String disciplinaDaTurma, String numDaTurma, String professor) {
		this.disciplinaDaTurma = disciplinaDaTurma;
		this.numDaTurma = numDaTurma;
		this.professor = professor;
		
	}

	public String getNumDaTurma() {
		return numDaTurma;
	}

	public String getProfessor() {
		return professor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public String toString() {
		String resposta = super.toString() + '\n';
		resposta += "Disciplina da turma: " + disciplinaDaTurma + '\n';
		resposta += "Professor regente na turma: " + professor + '\n';
		resposta += "Número da turma: " + numDaTurma + '\n';
		return resposta;
	}

	
}
