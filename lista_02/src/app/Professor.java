package app;

import exceptions.CampoEmBrancoException;

public class Professor extends PessoaFisica{

    private String areaFormacao;
    private String matriculaFUB;

    public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB) {
        super(nome, cpf, email);
        this.areaFormacao = areaFormacao;
        this.matriculaFUB = matriculaFUB;
    }

    public static Professor criarProfessor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB) throws CampoEmBrancoException {

        if (nome == null || nome.trim().isEmpty() || nome.isBlank()) {
            throw new CampoEmBrancoException(" NOME ");
        }

        if (cpf == null || cpf.trim().isEmpty() || cpf.isBlank()) {
            throw new CampoEmBrancoException(" CPF ");
        }

        if (email == null || email.trim().isEmpty() || email.isBlank()) {
            throw new CampoEmBrancoException(" EMAIL ");
        }

        if (areaFormacao == null || areaFormacao.trim().isEmpty() || areaFormacao.isBlank()) {
            throw new CampoEmBrancoException(" ÁREA DE FORMAÇÃO ");
        }

        if (matriculaFUB == null || matriculaFUB.trim().isEmpty() || matriculaFUB.isBlank()) {
            throw new CampoEmBrancoException(" MATRÍCULA FUB ");
        }

        return new Professor(nome, cpf, email, areaFormacao, matriculaFUB);
    }

    public final String getAreaFormacao() {
        return areaFormacao;
    }

    public final String getMatriculaFUB() {
        return matriculaFUB;
    }
    public String toString() {
        String resposta = super.toString();
        resposta += "MATRICULA: " + matriculaFUB + '\n';
        resposta += "AREA DE FORMAÇÃO: " + areaFormacao + '\n';
        return resposta;
    }

}