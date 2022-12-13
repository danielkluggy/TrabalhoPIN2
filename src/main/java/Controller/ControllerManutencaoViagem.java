package Controller;

import Estrutura.CampoInvalidoException;
import Estrutura.PreenchimentoException;
import Model.ModelMotorista;
import Model.ModelOnibus;
import Model.ModelPessoa;
import Model.ModelRota;
import Model.ModelViagem;
import View.Consulta;
import View.Disponibilizavel;
import View.View;
import View.ViewManutencaoViagem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author dklug
 */
public class ControllerManutencaoViagem {
    private View view;
    private ViewManutencaoViagem viewManutencao;
    private Controller controller;
    private ArrayList<ModelPessoa> passageiros;
    private ModelViagem modelViagem;
    LocalDate hoje = LocalDate.now();

    public ControllerManutencaoViagem(View view, Controller controller) {
        this.view = view;
        this.viewManutencao = new ViewManutencaoViagem();
        this.controller = controller;
        this.passageiros = new ArrayList<ModelPessoa>();
        this.modelViagem = new ModelViagem();
        this.init();
    }
    
    public void init() {
        this.iniciaCombobox();
        this.iniciaBotoes();
    }
    
    public List<ModelMotorista> getMotorista() {
        return this.view.getMotoristas();
    }
    
    public List<ModelRota> getRotas() {
        return this.view.getRotas();
    }
    
    public List<ModelOnibus> getOnibus() {
        return this.view.getOnibus();
    }
    
     public List<ModelViagem> getViagens() {
        return this.view.getViagens();
    } 
    
    public void adicionaNewViagem(ModelViagem viagem){
        this.view.getViagens().add(viagem);
    }
    
    public void iniciaCombobox() {
        this.viewManutencao.iniciaMotorista(this.getMotorista());
        this.viewManutencao.iniciaOnibus(this.getOnibus());
        this.viewManutencao.iniciaRotas(this.getRotas());
    }
    
    public void iniciaBotoes() {
        this.viewManutencao.adicionaAcaoSelecionaPassageiro(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selecionaPassageiro();
            }
        });
        
        this.viewManutencao.adicionaAcaoConfirmar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doConfirmar();
            }
        });
    }
    
    public void exibir() {
        this.viewManutencao.setVisible(true);
    }
    
    public void fechaTela() {
        this.viewManutencao.setVisible(false);
    }
    
    /**
     * Chama a tela de manutenção para selecionar as pessoas.
     * Utiliza uma classe anônima para atualizar a tela específica.
     * @param evt 
     */
    public void selecionaPassageiro() {
        
        ControllerManutencaoViagemPassageiro controllerViewPassageiro = new ControllerManutencaoViagemPassageiro(this.view, this.passageiros, this.modelViagem, new Consulta(){
            public void atualizaConsulta(){
                 viewManutencao.atualizaPassageiro(passageiros);
            }
        });
        
        controllerViewPassageiro.exibir();
    }
    
    public void doConfirmar(){
      ModelViagem newViagem = this.modelViagem;
        try {
            newViagem.setData(this.viewManutencao.getData());
            newViagem.addMotorista(this.getValorCampoMotorista());
            newViagem.addOnibus(this.getValorCampoOnibus());
            newViagem.addRota(this.viewManutencao.getRota());
            
            this.adicionaNewViagem(newViagem);
            this.limpaCampos();
            this.viewManutencao.exibeMensagem("Alerta", "Dado inserido com Sucesso!", JOptionPane.WARNING_MESSAGE);
        } catch (PreenchimentoException ex) {
            this.viewManutencao.exibeMensagem("Erro", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        } catch (CampoInvalidoException ex) {
            this.viewManutencao.exibeMensagem("Erro", ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
        this.controller.atualizaConsulta();
    }
    
    public ModelMotorista getValorCampoMotorista() throws PreenchimentoException, CampoInvalidoException {
        ModelMotorista motorista = this.viewManutencao.getCampoMotorista();
        if(motorista == null) {
            throw new PreenchimentoException("Motorista não selecionado");
        }
        if(this.isMotoristaDisponivel(motorista)) {
            return motorista;
        } else {
            throw new CampoInvalidoException("Motorista selecionado não disponível");
        }
    }
    
    /**
     * Retorna o onibus selcionado validando a sua disponibilidade
     * @return
     * @throws PreenchimentoException
     * @throws CampoInvalidoException 
     */
    public ModelOnibus getValorCampoOnibus() throws PreenchimentoException, CampoInvalidoException {
        ModelOnibus onibus = this.viewManutencao.getCampoOnibus();
        if(onibus == null ) {
            throw new PreenchimentoException("Onibus não selecionado");
        }
        if(this.isOnibusDisponivel(onibus)) {
            return onibus;
        } else {
            throw new CampoInvalidoException("Ônibus selecionado não disponível");
        }
    }
    
        /**
     * Avalia a disponibilidadde de um motorista de acordo com as outras viagens para aquele determinado dia.
     * É considerado um motorista disponivel aquele que não assumiu uma viagem em um outro dia.
     * @param motorista
     * @return boolean
     * @throws PreenchimentoException 
     */
    private boolean isMotoristaDisponivel(ModelMotorista motorista) throws PreenchimentoException{
        if(!this.disponibilizavel(motorista)) {
            return false;
        }
        for(ModelViagem viagem : this.getViagens()) {
            viagem.getData().getDayOfMonth();
            if(viagem.getData().getDayOfMonth() == this.viewManutencao.getData().getDayOfMonth() && viagem.getData().getMonth() == this.viewManutencao.getData().getMonth() && viagem.getData().getYear() == this.viewManutencao.getData().getYear()) {
                if(viagem.getMotorista() == motorista) {
                    return false;
                }
            }
        }
        return true;
    }
    
        /**
     * Avalia a disponibilidade do onibus estar disponível analisando as outras viagens existentes
     * É considerado um onibus disponivel aquele que não possui nenhuma viagem para aquela determinada data.
     * @param onibus
     * @return
     * @throws PreenchimentoException 
     */
    private boolean isOnibusDisponivel(ModelOnibus onibus) throws PreenchimentoException{
        // valida disponibilidade básica
        if(!disponibilizavel(onibus)) {
            return false;
        }
        
        //valida a disponibilidade pela data
        for(ModelViagem viagem : this.view.getViagens()) {
            if(viagem.getData().getDayOfMonth() == this.viewManutencao.getData().getDayOfMonth() && viagem.getData().getMonth() == this.viewManutencao.getData().getMonth() && viagem.getData().getYear() == this.viewManutencao.getData().getYear()) {
                if(viagem.getOnibus() == onibus) {
                    return false;
                }
            }
        }        
        return true;
    }
    
       /**
     * Retorna a primeira validação de disponibilização através da interface
     * @param objeto Disponibilizavel
     * @return boolena
     */
    private boolean disponibilizavel(Disponibilizavel objeto) {
        return objeto.isDiponivel();
    }
    
    private void limpaCampos(){
        this.passageiros.clear();
        this.viewManutencao.atualizaPassageiro(this.passageiros);
    }
}
