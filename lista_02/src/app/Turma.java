package app;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String numDaTurma;
    private Professor professor;
    private Disciplina disciplina;
    private List<Aluno> alunos;

    public Turma(String numDaTurma, Professor professor, Disciplina disciplina) {
        this.numDaTurma = numDaTurma;
        this.professor = professor;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public String getNumDaTurma() {
        return numDaTurma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

  
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Número da Turma: ").append(numDaTurma).append("\n");
        info.append("Professor: ").append(professor.getNome()).append("\n");
        info.append("Disciplina: ").append(disciplina.getNomeDisciplina()).append("\n");
        info.append("Alunos Matriculados: \n");
        for (Aluno aluno : alunos) {
            info.append(aluno.getNome()).append(" - ").append(aluno.getMatricula()).append("\n");
        }
        return info.toString();
    }
}
