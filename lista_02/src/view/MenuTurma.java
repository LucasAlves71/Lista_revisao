package view;

import java.util.Date;

import javax.swing.JOptionPane;

import exceptions.*;

import app.*;
import cadastros.*;

public class MenuTurma {

    public static Turma dadosNovaTurma(CadastroProfessores cadProfessor, CadastroDisciplina cadDisciplina) {
        String numDaTurma = lerNumDaTurma();
        Professor professor = selecionarProfessor(cadProfessor);
        Disciplina disciplina = selecionarDisciplina(cadDisciplina);

        try {
            return Turma.criarTurma(numDaTurma, professor, disciplina);
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        } catch (DisciplinaNaoAtribuidaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        } catch (ProfessorNaoAtribuidoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static String lerNumDaTurma() {
        return JOptionPane.showInputDialog("Informe o número da turma: ");
    }

    public static Professor selecionarProfessor(CadastroProfessores cadProfessor) {
        String matProfessor = JOptionPane.showInputDialog("Informe o matrícula do professor: ");
        Professor professor = cadProfessor.pesquisarProfessor(matProfessor);
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado.");
        }
        return professor;
    }

    public static Disciplina selecionarDisciplina(CadastroDisciplina cadDisciplina) {
        String codigoDisciplina = JOptionPane.showInputDialog("Informe o código da disciplina: ");
        Disciplina disciplina = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
        if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
        }
        return disciplina;
    }

    public static void menuTurma(CadastroTurma cadTurma, CadastroAluno cadAluno, CadastroProfessores cadProfessor, CadastroDisciplina cadDisciplina) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Adicionar aluno à turma\n"
                + "6 - Fazer chamada de turma\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(cadProfessor, cadDisciplina);
                    if (novaTurma != null) {
                        cadTurma.cadastrarTurma(novaTurma);
                    }
                    break;

                case 2:
                    String numDaTurma = lerNumDaTurma();
                    Turma turma = cadTurma.pesquisarTurma(numDaTurma);
                    if (turma != null) {
                        JOptionPane.showMessageDialog(null, turma.toString());
                    }
                    break;

                case 3:
                    numDaTurma = lerNumDaTurma();
                    Turma novaTurmaCadastro = dadosNovaTurma(cadProfessor, cadDisciplina);
                    boolean atualizado = cadTurma.atualizarTurma(numDaTurma, novaTurmaCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Turma atualizada.");
                    }
                    break;

                case 4:
                    numDaTurma = lerNumDaTurma();
                    Turma remover = cadTurma.pesquisarTurma(numDaTurma);
                    boolean removido = cadTurma.removerTurma(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
                        System.gc();
                    }
                    break;

                case 5:
                    numDaTurma = lerNumDaTurma();
                    turma = cadTurma.pesquisarTurma(numDaTurma);
                    if (turma != null) {
                        String matriculaAluno = JOptionPane.showInputDialog("Informe a matrícula do aluno para adicionar à turma: ");
                        Aluno aluno = cadAluno.pesquisarAluno(matriculaAluno);
                        if (aluno != null) {
                            turma.adicionarAluno(aluno);
                            JOptionPane.showMessageDialog(null, "Aluno adicionado à turma.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
                        }
                    }
                    break;

                case 6:
                    String numDaTurma1 = lerNumDaTurma();
                    Turma turma1 = cadTurma.pesquisarTurma(numDaTurma1);
                    if (turma1 != null) {
                        Date data = new Date();
                        turma1.chamada(data);
                    } else {
                        JOptionPane.showMessageDialog(null, "Turma não encontrada.");
                    }
                    break;


                default:
                    break;
            }
        } while (opcao != 0);
    }
}