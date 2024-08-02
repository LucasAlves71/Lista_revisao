package view;

import javax.swing.JOptionPane;


import app.Turma;

import cadastros.CadastroTurma;

public class MenuTurma {

	public static Turma dadosNovaTurma() {
		String disciplina = lerDisciplina();
		String numTurma = lerNumTurma();
		String professor = lerProfessor();
		return new Turma(disciplina, numTurma, professor);
	}

	private static String lerDisciplina() {
		return JOptionPane.showInputDialog("Informe a disciplina da turma: ");
		
	}

	private static String lerProfessor() {
		return JOptionPane.showInputDialog("Informe o professor da turma: ");
	}

	private static String lerNumTurma() {
		return JOptionPane.showInputDialog("Informa o número da turma: ");
	}

	

	public static void menuTurma(CadastroTurma cadTurma) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar turma\n"
				+ "2 - Pesquisar turma\n"
				+ "3 - Atualizar turma\n"
				+ "4 - Remover turma\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Turma novaTurma = dadosNovaTurma();
				cadTurma.cadastrarTurma(novaTurma);
				break;
				
			case 2: 
				String numTurma = lerNumTurma();
				Turma t = cadTurma.pesquisarTurma(numTurma);
				if (t != null) {
					JOptionPane.showMessageDialog(null, t.toString());
				}
				break;
				
			case 3: 
				numTurma = lerNumTurma(); 
				Turma novoCadastro = dadosNovaTurma();
				boolean atualizado = cadTurma.atualizarTurma(numTurma, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				numTurma = lerNumTurma();
				Turma remover = cadTurma.pesquisarTurma(numTurma);
				boolean removido = cadTurma.removerTurma(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Turma removida do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}


}