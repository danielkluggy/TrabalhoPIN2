package Controller;

import Model.ModelRota;
import View.View;
import View.ViewRota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dklug
 */
public class ControllerRota  implements Controller{
    private ViewRota viewRota;
    private View view;

    public ControllerRota( View view) {
        this.viewRota = new ViewRota();
        this.view = view;
        this.init();
    }
    
    public void init() {
        this.montaConsulta();
        this.iniciaBotoes();
    }
    
    public void montaConsulta(){
        this.viewRota.loadTable(this.getRotas());
    }
    
    List<ModelRota> getRotas() {
        return this.view.getRotas();
    }
    
    public void exibir(){
        this.viewRota.setVisible(true);
    }
    
    public void fechaTela() {
        this.viewRota.dispose();
    }
    
    public void iniciaBotoes() {
        this.viewRota.adicionaAcaoIncluir(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               incluirRota();
            }
        });
        
        this.viewRota.adicionarAcaoAtualizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizaTela();
            }
        });
        
        this.viewRota.adicionarAcaoExcluir(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluirRota();
            }
        });
    }
    
    public void excluirRota(){        
        try {
            int confirmacao = JOptionPane.YES_NO_OPTION;
            int excluir = JOptionPane.showConfirmDialog (null, "Deseja excluir esse registro?","Warning",confirmacao);
            if(excluir == JOptionPane.YES_OPTION) {
                this.view.getRotas().remove(this.viewRota.getIndiceLinhaSelecionada());
                this.viewRota.exibeMensagem("Alerta", "Dado excluido com Sucesso!", JOptionPane.WARNING_MESSAGE);
                this.atualizaTela();
            }
        } catch (Exception e) {
            this.viewRota.exibeMensagem("Erro", "Não foi possível excluir o registro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void incluirRota() {
        ControllerManutencaoRota controller = new ControllerManutencaoRota(this, this.view);
        controller.exibir();
    }
    
    public void atualizaTela() {
        this.montaConsulta();
    }

    @Override
    public void atualizaConsulta() {
        this.atualizaTela();
    }
    
}
