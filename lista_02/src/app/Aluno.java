package app;

import exceptions.CampoEmBrancoException;

public class Aluno extends PessoaFisica{

    private String matricula;
    private String curso;

    public Aluno(String nome, String cpf, String email, String matricula, String curso) {
        super(nome, cpf, email);
        this.matricula = matricula;
        this.curso = curso;
    }
    public static Aluno criarAluno(String nome, String cpf, String email, String matricula, String curso) throws CampoEmBrancoException {

        if (nome == null || nome.trim().isEmpty() || nome.isBlank()) {
            throw new CampoEmBrancoException(" NOME ");
        }

        if (cpf == null || cpf.trim().isEmpty() || cpf.isBlank()) {
            throw new CampoEmBrancoException(" CPF ");
        }

        if (email == null || email.trim().isEmpty() || email.isBlank()) {
            throw new CampoEmBrancoException(" EMAIL ");
        }

        if (matricula == null || matricula.trim().isEmpty() || matricula.isBlank()) {
            throw new CampoEmBrancoException(" MATRICULA ");
        }

        if (curso == null || curso.trim().isEmpty() || curso.isBlank()) {
            throw new CampoEmBrancoException(" CURSO ");
        }

        return new Aluno(nome, cpf, email, matricula, curso);
    }

    public final String getMatricula() {
        return matricula;
    }

    public final String getCurso() {
        return curso;
    }
    
    protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}


    public String toString() {
        String resposta = super.toString();
        resposta += "MATRICULA: " + matricula + '\n';
        resposta += "CURSO: " + curso + '\n';
        return resposta;
    }

}