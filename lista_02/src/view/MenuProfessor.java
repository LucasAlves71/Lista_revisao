package view;

import javax.swing.JOptionPane;

import exceptions.CampoEmBrancoException;
import app.Professor;
import cadastros.CadastroProfessores;

public class MenuProfessor {

    public static Professor dadosNovoProfessor() {
        String nome = lerNome();
        String cpf = lerCPF();
        String email = lerEmail();
        String areaFormacao = lerAreaFormacao();
        String matriculaFUB = lerMatriculaFUB();

        try {
            return Professor.criarProfessor(nome, cpf, email, areaFormacao, matriculaFUB);
        } catch (CampoEmBrancoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static String lerAreaFormacao() {
        return JOptionPane.showInputDialog("Informe o area de formação do profesor: ");
    }

    public static String lerEmail() {
        return JOptionPane.showInputDialog("Informe o email do professor: ");
    }

    public static String lerCPF() {
        return JOptionPane.showInputDialog("Informe o CPF do professor: ");
    }

    public static String lerNome() {
        return JOptionPane.showInputDialog("Informe o nome do professor: ");
    }

    public static String lerMatriculaFUB() {
        return JOptionPane.showInputDialog("Informe a matricula do professor: ");
    }

    public static void menuProfessor(CadastroProfessores cadProfessor) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar professor\n"
                + "2 - Pesquisar professor\n"
                + "3 - Atualizar professor\n"
                + "4 - Remover professor\n"
                + "0 - Voltar para menu anterior";

        int opcao=-1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Professor novoProfessor = dadosNovoProfessor();
                    cadProfessor.cadastrarProfessor(novoProfessor);
                    break;

                case 2:
                    String matriculaFUB = lerMatriculaFUB();
                    Professor p = cadProfessor.pesquisarProfessor(matriculaFUB);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p.toString());
                    }
                    break;

                case 3:
                    matriculaFUB = lerMatriculaFUB();
                    Professor novoCadastro = dadosNovoProfessor();
                    boolean atualizado = cadProfessor.atualizarProfessor(matriculaFUB, novoCadastro);
                    if (atualizado) {
                        JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
                    }
                    break;

                case 4:
                    matriculaFUB = lerMatriculaFUB();
                    Professor remover = cadProfessor.pesquisarProfessor(matriculaFUB);
                    boolean removido = cadProfessor.removerProfessor(remover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Professor removido do cadastro");
                        System.gc();
                    }

                default:
                    break;
            }
        } while (opcao != 0);
        return;
    }


}