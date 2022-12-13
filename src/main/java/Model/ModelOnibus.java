package Model;

import View.Disponibilizavel;

/**
 *
 * @author dklug
 */
public class ModelOnibus implements Disponibilizavel {
    final private String marca;
    final private int assentos;
    private boolean emManutencao;

    public ModelOnibus(String marca, int assentos) {
        this.marca = marca;
        this.assentos = assentos;
        this.emManutencao = false;
    }
    
    public void setEmManutencao(boolean isManutencao) {
        this.emManutencao = isManutencao;
    }

    public String getMarca() {
        return marca;
    }

    public int getAssentos() {
        return assentos;
    }

    public boolean isEmManutencao() {
        return emManutencao;
    }
    
    @Override
    public String toString(){
        return this.marca + " - " + this.assentos + " lugares";
    }

    @Override
    public boolean isDiponivel() {
        if(this.isEmManutencao()) {
            return false;
        }
        return true;
    }
}
