package app;

import exceptions.*;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

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

    public static Turma criarTurma(String numDaTurma, Professor professor, Disciplina disciplina) throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {

        if (numDaTurma == null || numDaTurma.trim().isEmpty() || numDaTurma.isBlank()) {
            throw new CampoEmBrancoException(" NÚMERO DA TURMA ");
        }

        if (professor == null) {
            throw new ProfessorNaoAtribuidoException();
        }

        if (disciplina == null) {
            throw new DisciplinaNaoAtribuidaException();
        }

        return new Turma(numDaTurma, professor, disciplina);
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
    public void chamada(Date data) {
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Disciplina: ").append(disciplina.getNomeDisciplina()).append("\n");
        mensagem.append("Turma: ").append(getNumDaTurma()).append("\n");
        mensagem.append("Professor: ").append(professor.getNome()).append("\n");
        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatoBrasileiro.format(data);
        mensagem.append("Data: ").append(dataFormatada).append("\n");
        mensagem.append("Lista de Alunos:\n");

        List<Aluno> alunosOrdenados = new ArrayList<>(alunos);
        Collections.sort(alunosOrdenados, (a1, a2) -> a1.getNome().compareToIgnoreCase(a2.getNome()));

        for (Aluno aluno : alunosOrdenados) {
            mensagem.append(aluno.getMatricula()).append(" - ").append(aluno.getNome()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensagem.toString(), "Chamada da Turma", JOptionPane.INFORMATION_MESSAGE);
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