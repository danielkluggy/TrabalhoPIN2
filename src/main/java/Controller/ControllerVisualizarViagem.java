package Controller;

import Model.ModelViagem;
import View.ViewVisualizarViagem;

/**
 *
 * @author dklug
 */
public class ControllerVisualizarViagem {
    private ViewVisualizarViagem viewVisualizar;
    private ModelViagem viagem;

    public ControllerVisualizarViagem(ModelViagem viagem) {
        this.viagem = viagem;
        this.viewVisualizar = new ViewVisualizarViagem();
        this.init();
    }
    
    public void exibir() {
        this.viewVisualizar.setVisible(true);
    }
    
    public void init(){
        this.viewVisualizar.iniciaConsulta(this.viagem);
    }   
    
}
