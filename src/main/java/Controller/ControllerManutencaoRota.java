package Controller;

import Model.ModelPonto;
import Model.ModelRota;
import View.View;
import View.ViewManutencaoRota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author dklug
 */
public class ControllerManutencaoRota {
    private ViewManutencaoRota viewManutencao;
    private Controller controllerView;
    private View view;

    public ControllerManutencaoRota(Controller controllerView, View view) {
        this.controllerView = controllerView;
        this.view = view;
        this.viewManutencao = new ViewManutencaoRota();
        this.init();
    }
    
    public void exibir() {
        this.viewManutencao.setVisible(true);
    }
    
    public void fechaTela() {
        this.viewManutencao.dispose();
    }
    
    public void init(){
        this.viewManutencao.populaPonto(this.view.getPontos());
        this.iniciaBotoes();
    }
    
    public void iniciaBotoes() {
        this.viewManutencao.adicionaAcaoSalvar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarRota();
            }
        });
    }
    
    public void salvarRota() {
        try{
            Random random    = new Random();
            int codigo       = random. nextInt(1000);
            String origem    = this.viewManutencao.getTextOrigem();
            String destino   = this.viewManutencao.getTextDestino();
            ModelPonto ponto = this.viewManutencao.getPonto();

            ModelRota rota = new ModelRota(codigo, origem, destino);
            rota.addPonto(ponto);
            this.view.getRotas().add(rota);
            this.controllerView.atualizaConsulta();
            this.viewManutencao.exibeMensagem("Alerta", "Dado inserido com Sucesso!", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e) {
            this.viewManutencao.exibeMensagem("Erro", "Não foi possível salvar os dados", JOptionPane.ERROR_MESSAGE);
        }
    }

    
}
