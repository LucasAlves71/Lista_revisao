package view;

import javax.swing.JOptionPane;

import app.*;
import cadastros.*;

public class MenuTurma {

    public static Turma dadosNovaTurma(Professor professor, Disciplina disciplina) {
        String numDaTurma = lerNumDaTurma();
        return new Turma(numDaTurma, professor, disciplina);
    }

    private static String lerNumDaTurma() {
        return JOptionPane.showInputDialog("Informe o número da turma: ");
    }

    public static void menuTurma(CadastroTurma cadTurma, CadastroAluno cadAluno, Professor professor, Disciplina disciplina) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar turma\n"
                + "2 - Pesquisar turma\n"
                + "3 - Atualizar turma\n"
                + "4 - Remover turma\n"
                + "5 - Adicionar aluno à turma\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Turma novaTurma = dadosNovaTurma(professor, disciplina);
                    cadTurma.cadastrarTurma(novaTurma);
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
                    Turma novaTurmaCadastro = dadosNovaTurma(professor, disciplina);
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

                default:
                    break;
            }
        } while (opcao != 0);
    }
}
