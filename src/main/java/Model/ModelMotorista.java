package Model;

import View.Disponibilizavel;

/**
 *
 * @author dklug
 */
public class ModelMotorista extends ModelPessoa implements Disponibilizavel {
    private int anoContratacao;
    private int situacao;
    

    public ModelMotorista(int codigo, String nome, int anoContratacao) {
        super(codigo, nome);
        this.anoContratacao = anoContratacao;
        this.situacao = 1;
    }
    
    public ModelMotorista(String nome, int anoContratacao) {
        super(nome);
        this.anoContratacao = anoContratacao;
        this.situacao = 1;
    }
    
     public static final int INATIVO = 0;
     public static final int ATIVO   = 1;

    public int getAnoContratacao() {
        return anoContratacao;
    }
    
    /**
     * Retorna a situação
     * 0 - inativo
     * 1 - Ativo
     * @return 
     */
    public int getSituacao() {
        return situacao;
    }
    
    /**
     * Inativo = 0
     * Ativo igual a 1
     * @param situacao 
     */
    public void setSituacao(int situacao) {
        if(situacao == ModelMotorista.INATIVO || situacao == ModelMotorista.ATIVO) {
            this.situacao = situacao;
        }
    }

    @Override
    public boolean isDiponivel() {
        if(situacao == ModelMotorista.ATIVO) {
            return true;
        }
        return false;
    }
    
}