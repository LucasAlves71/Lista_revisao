package app;

public class Disciplina {
    String  codigoDisciplina,
            nomeDisciplina,
            areaAtuacao;

    public Disciplina(String codigoDisciplina, String nomeDisciplina, String areaAtuacao) {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.areaAtuacao = areaAtuacao;
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


}