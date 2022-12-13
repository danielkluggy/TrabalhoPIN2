package Controller;

import Model.ModelPonto;
import View.View;
import View.ViewPonto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dklug
 */
public class ControllerPonto implements Controller{
    private ViewPonto viewPonto;
    private View view;

    public ControllerPonto(View view) {
        this.view = view;
        this.viewPonto = new ViewPonto();
        this.init();
    }
    
    public void exibir(){
        this.viewPonto.setVisible(true);
    }
    
    public void init() {
        this.montaConsulta();
        this.iniciaBotoes();
    } 
    
    public void montaConsulta(){
        this.viewPonto.loadTable(this.getPontos());
    }
    
    public List<ModelPonto> getPontos() {
        return this.view.getPontos();
    }
    
    public void iniciaBotoes(){
        this.viewPonto.adicionaAcaoAtualizar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               iniciaConsulta();
            }
        });
        
        this.viewPonto.adicionaAcaoIncluir(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluirPonto();
            }
        });
        
        this.viewPonto.adicionaAcaoExcluir(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               excluirPonto();
            }
        });
    }
    
    public void iniciaConsulta(){
        this.montaConsulta();
    }
    
    public void incluirPonto() {
        ControllerManutencaoPonto controller = new ControllerManutencaoPonto(this.view, this);
        controller.exibir();
    }
    
    public void excluirPonto() {
         try {
            int confirmacao = JOptionPane.YES_NO_OPTION;
            int excluir = JOptionPane.showConfirmDialog (null, "Deseja excluir esse registro?","Warning",confirmacao);
            if(excluir == JOptionPane.YES_OPTION) {
                this.view.getPontos().remove(this.viewPonto.getIndiceLinhaSelecionada());
                this.viewPonto.exibeMensagem("Alerta", "Dado excluido com Sucesso!", JOptionPane.WARNING_MESSAGE);
                this.atualizaConsulta();
            }
        } catch (Exception e) {
            this.viewPonto.exibeMensagem("Erro", "Não foi possível excluir o registro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void atualizaConsulta() {
        this.iniciaConsulta();
    }
    
    
}
