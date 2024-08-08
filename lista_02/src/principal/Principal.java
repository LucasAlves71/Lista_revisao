package principal;

import javax.swing.JOptionPane;
import app.*;
import cadastros.*;
import view.*;

public class Principal {

    static CadastroAluno cadAluno;
    static CadastroProfessores cadProfessor;
    static CadastroDisciplina cadDisciplina;
    static CadastroTurma cadTurma;

    public static void main(String[] args) {
        cadAluno = new CadastroAluno();
        cadProfessor = new CadastroProfessores();
        cadDisciplina = new CadastroDisciplina();
        cadTurma = new CadastroTurma();    

        int opcao = 0; 

        do {
            opcao = MenuPrincipal.menuOpcoes(); 
            switch (opcao) {
                case 1: 
                    MenuAluno.menuAluno(cadAluno); 
                    break;
                case 2: 
                    MenuProfessor.menuProfessor(cadProfessor);
                    break;
                case 3: 
                    MenuDisciplina.menuDisciplina(cadDisciplina);
                    break;
                case 4: 
                    Professor professor = selecionarProfessor();
                    Disciplina disciplina = selecionarDisciplina();
                    MenuTurma.menuTurma(cadTurma, cadAluno, professor, disciplina);
                    break;
                case 0: 
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);
    }

    private static Professor selecionarProfessor() {
        String matProfessor = JOptionPane.showInputDialog("Informe a matricula do professor: ");
        Professor professor = cadProfessor.pesquisarProfessor(matProfessor);
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Professor não encontrado.");
        }
        return professor;
    }

    private static Disciplina selecionarDisciplina() {
        String codigoDisciplina = JOptionPane.showInputDialog("Informe o código da disciplina: ");
        Disciplina disciplina = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
        if (disciplina == null) {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
        }
        return disciplina;
    }
}
