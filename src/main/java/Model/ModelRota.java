package Model;

import java.util.ArrayList;

/**
 *
 * @author dklug
 */
public class ModelRota {
    final private int id;
    private String origem;
    private String destino;
    private ArrayList<ModelPonto> pontos;

    public ModelRota(int id, String origem, String destino) {
        this.pontos = new ArrayList<ModelPonto>();
        this.id = id;
        this.origem = origem;
        this.destino = destino;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getId() {
        return id;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }
    
    public void addPonto(ModelPonto ponto) {
        this.pontos.add(ponto);
    }
    
    public ArrayList<ModelPonto> getPontos(){
        return this.pontos;
    }
    
    @Override
    public String toString(){
        return this.origem + " - " + this.destino;
    }
    
}
