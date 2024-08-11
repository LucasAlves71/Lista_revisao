package app;

import exceptions.CampoEmBrancoException;

public class Disciplina {
    private String  codigoDisciplina;
    private String  nomeDisciplina;
    private String  areaAtuacao;

    public Disciplina(String codigoDisciplina, String nomeDisciplina, String areaAtuacao) {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.areaAtuacao = areaAtuacao;
    }

    public static Disciplina criarDisciplina(String codigoDisciplina, String nomeDisciplina, String areaAtuacao) throws CampoEmBrancoException {
        if (codigoDisciplina == null || codigoDisciplina.trim().isEmpty() || codigoDisciplina.isBlank()) {
            throw new CampoEmBrancoException(" CÓDIGO DA DISCIPLINA ");
        }

        if (nomeDisciplina == null || nomeDisciplina.trim().isEmpty() || nomeDisciplina.isBlank()) {
            throw new CampoEmBrancoException(" NOME DA DISCIPLINA ");
        }

        if (areaAtuacao == null || areaAtuacao.trim().isEmpty() || areaAtuacao.isBlank()) {
            throw new CampoEmBrancoException(" ÁREA DE ATUAÇÃO ");
        }

        return new Disciplina(codigoDisciplina, nomeDisciplina, areaAtuacao);
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public String toString() {
        String resposta = super.toString() + '\n';
        resposta += "NOME DA DISCIPLINA: " + nomeDisciplina + '\n';
        resposta += "CODIGO DA DISCIPLINA: " + codigoDisciplina + '\n';
        resposta += "AREA DE ATUAÇÃO: " + areaAtuacao + '\n';
        return resposta;
    }


    public CharSequence trim() {
        return null;
    }

    public boolean isBlank() {
        return true;
    }
}