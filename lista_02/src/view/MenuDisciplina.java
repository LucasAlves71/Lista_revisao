package view;

import javax.swing.JOptionPane;

import app.Disciplina;
import cadastros.CadastroDisciplina;

public class MenuDisciplina {

	public static Disciplina dadosNovaDisciplina() {
		String nomeDaDisciplina = lerNomeDaDisciplina();
		String codigoDaDisciplina = lerCodigoDaDisciplina();
		String areaDeAtuacao = lerAreaDeAtuacao();
		
		return new Disciplina (codigoDaDisciplina, nomeDaDisciplina, areaDeAtuacao);
	}

	private static String lerAreaDeAtuacao() {
		return JOptionPane.showInputDialog("Informe a area de atuação da disciplina: ");
	}

	private static String lerCodigoDaDisciplina() {
		return JOptionPane.showInputDialog("Informe o código da disciplina: ");
	}

	private static String lerNomeDaDisciplina() {
		return JOptionPane.showInputDialog("Informe o nome da disciplina: ");
	}


	public static void menuDisciplina(CadastroDisciplina cadDisciplina) {
		String txt = "Informe a opção desejada \n"
				+ "1 - Cadastrar disciplina\n"
				+ "2 - Pesquisar disciplina\n"
				+ "3 - Atualizar disciplina\n"
				+ "4 - Remover disciplina\n"
				+ "0 - Voltar para menu anterior";
		
		int opcao=-1;
		do {
			String strOpcao = JOptionPane.showInputDialog(txt);
			opcao = Integer.parseInt(strOpcao);

			switch (opcao) {
			case 1:
				Disciplina novaDisciplina = dadosNovaDisciplina();
				cadDisciplina.cadastrarDisciplina(novaDisciplina);
				break;
				
			case 2: 
				String codigoDisciplina = lerCodigoDaDisciplina();
				Disciplina d = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
				if (d != null) {
					JOptionPane.showMessageDialog(null, d.toString());
				}
				break;
				
			case 3: 
				codigoDisciplina = lerCodigoDaDisciplina(); 
				Disciplina novoCadastro = dadosNovaDisciplina();
				boolean atualizado = cadDisciplina.atualizarDisciplina(codigoDisciplina, novoCadastro);
				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado.");
				}
				break;
				
			case 4: 
				codigoDisciplina = lerCodigoDaDisciplina();
				Disciplina remover = cadDisciplina.pesquisarDisciplina(codigoDisciplina);
				boolean removido = cadDisciplina.removerDisciplina(remover);
				if (removido) {
					JOptionPane.showMessageDialog(null, "Disciplina removida do cadastro");
					System.gc();
				}

			default:
				break;
			}
		} while (opcao != 0);
		return;
	}


}