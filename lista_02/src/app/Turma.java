package app;

public class Turma extends Disciplina{
	Professor professor;
	Aluno aluno;

	public Turma(String codigoDisciplina, String nomeDisciplina, String areaAtuacao, Professor professor, Aluno aluno) {
		super(codigoDisciplina, nomeDisciplina, areaAtuacao);
		this.aluno = aluno;
		this.professor = professor;
		
	}
	
}
