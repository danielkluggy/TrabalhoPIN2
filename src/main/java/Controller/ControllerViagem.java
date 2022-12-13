package Controller;

import Estrutura.SelecionavelException;
import Model.ModelPessoa;
import Model.ModelViagem;
import View.Consulta;
import View.View;
import View.ViewViagem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dklug
 */
public class ControllerViagem implements Controller{
   private ViewViagem viewViagem;
   private View view;

    public ControllerViagem(View view) {
        ViewViagem viewViagem = new ViewViagem();
        this.viewViagem = viewViagem;
        this.view = view;
        this.init();
    }
    
    public void init(){
        this.montaConsulta();
        this.iniciaBotoes();
    }
    
    public void montaConsulta() {
        this.viewViagem.loadTable(this.getViagens());
    }
    
    public void exibir() {
        this.viewViagem.setVisible(true);
    }
    
    public void fecharTela() {
        this.viewViagem.setVisible(false);
    }
    
    List<ModelViagem> getViagens() {
        return this.view.getViagens();
    }
    
    public void iniciaBotoes() {
        this.viewViagem.adicionaAcaoIncluirViagem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               incluirViagem();
            }
        });
        
        this.viewViagem.adicionaAcaoExcluirViagem(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               excluirViagem();
            }
        });
        
        this.viewViagem.adicionaAcaoVisualizarRota(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visualizarRota();
            }
        });
        
        this.viewViagem.adicionaAcaoIncluirPassageiro(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incluirPassageiro();
            }
        });
    }
    
    public void incluirViagem() {
        ControllerManutencaoViagem controller = new ControllerManutencaoViagem(this.view, this);
        controller.exibir();
    }
    
    public void excluirViagem(){
        try {
            int confirmacao = JOptionPane.YES_NO_OPTION;
            int excluir = this.viewViagem.exibeMensagemCofirmacao("Warning", "Deseja excluir esse registro?", confirmacao);            
            if(excluir == JOptionPane.YES_OPTION) {
                this.getViagens().remove(this.viewViagem.getIndiceLinhaTabela());
                this.viewViagem.exibeMensagem("Alerta", "Dado excluido com Sucesso!", excluir);
                this.montaConsulta();
            }
        } catch (Exception e) {
            this.viewViagem.exibeMensagem("Erro", "Nenhum registro Selcionado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void visualizarRota() {
        try {
            this.abreRelatorio();
        } catch (SelecionavelException ex) {
            this.viewViagem.exibeMensagem("Erro", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void incluirPassageiro() {
         try {
            this.abreInclusaoPassageiro();
        } catch (SelecionavelException ex) {
            this.viewViagem.exibeMensagem("Erro", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void abreInclusaoPassageiro() throws SelecionavelException {        
        if(this.viewViagem.getIndiceLinhaTabela() == -1) {
            throw new SelecionavelException("Viagem não selecionada");
        }
        
        ArrayList<ModelPessoa> pessoas = new ArrayList<ModelPessoa>();
        ModelViagem viagem = this.view.getViagens().get(this.viewViagem.getIndiceLinhaTabela());
        
        ControllerManutencaoViagemPassageiro controllerViewPassageiro = new ControllerManutencaoViagemPassageiro(this.view, pessoas, viagem, new Consulta(){
            public void atualizaConsulta(){
                 montaConsulta();
            }
        });
        
        controllerViewPassageiro.exibir();
    } 
    
    private void abreRelatorio() throws SelecionavelException {
        if(this.viewViagem.getIndiceLinhaTabela() == -1) {
            throw new SelecionavelException("Viagem não selecionada");
        }
        ControllerVisualizarViagem controllerRlatorio = new ControllerVisualizarViagem(this.getViagens().get(this.viewViagem.getIndiceLinhaTabela()));
        controllerRlatorio.exibir();;
    }

    @Override
    public void atualizaConsulta() {
        this.montaConsulta();
    }    
    
}
