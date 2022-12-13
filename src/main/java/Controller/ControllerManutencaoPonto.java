package Controller;

import Model.ModelPonto;
import View.View;
import View.ViewManutencaoPonto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author dklug
 */
public class ControllerManutencaoPonto {
    private ViewManutencaoPonto viewManutencao;
    private View view;
    private Controller controllerConsulta;

    public ControllerManutencaoPonto(View view, Controller controllerConsulta) {
        this.view = view;
        this.viewManutencao = new ViewManutencaoPonto();
        this.controllerConsulta = controllerConsulta;
        this.iniciaBotoes();
    }
    
    public void exibir(){
        this.viewManutencao.setVisible(true);
    }
    
    public void iniciaBotoes() {
        this.viewManutencao.adicionaAcaoIncluir(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionaPonto();
            }
        });
    }
    
    public void adicionaPonto() {
         try{
            int latitude      = this.viewManutencao.getLatitude();
            int longitude     = this.viewManutencao.getLongitude();
            String referencia = this.viewManutencao.getReferencia();

            ModelPonto ponto = new ModelPonto(referencia);
            ponto.setLatitudeLongitude(latitude, longitude);

            this.view.getPontos().add(ponto);
            this.viewManutencao.exibeMensagem("Alerta", "Dado inserido com Sucesso!", JOptionPane.WARNING_MESSAGE);
            this.controllerConsulta.atualizaConsulta();
        } catch(Exception e) {
            this.viewManutencao.exibeMensagem("Erro", "Não foi possível salvar os dados", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
