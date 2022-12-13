package Controller;

import Model.ModelPessoa;
import View.View;
import View.ViewSelect;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dklug
 */
public class ControllerSelect {
    private View view;
    private ViewSelect viewSelect;

    public ControllerSelect(View view) {
        ViewSelect viewSelect = new ViewSelect();
        this.viewSelect = viewSelect;
        this.view = view;
        this.inicializaBotoes();
    }
    
    public void inicializaBotoes() {
        this.viewSelect.adicionarAcaoBotaoMotorista(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abreLoginMotorista();
            }
        });
        
        this.viewSelect.adicionarAcaoBotaoAdministrador(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               abreLoginAdministrador(); 
            }
        });
    }
    
    public void abreLoginMotorista() {
        ControllerLogin controllerLogin = new ControllerLogin(this.view, this.viewSelect, ModelPessoa.DRIVER);
        controllerLogin.exibir();
    }
    
    public void abreLoginAdministrador() {
        ControllerLogin controllerLogin = new ControllerLogin(this.view, this.viewSelect, ModelPessoa.ADMIN);
        controllerLogin.exibir();
    }
    
    /**
     * Exibe  tela
     */
    public void exibir() {
        this.viewSelect.setVisible(true);
    }
    
}
