package Controller;

import Model.ModelPessoa;
import Model.ModelViagem;
import Model.ModelViagemPassageiroTipo;
import View.Consulta;
import View.View;
import View.ViewManutencaoViagemPassageiro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author dklug
 */
public class ControllerManutencaoViagemPassageiro {
    private ViewManutencaoViagemPassageiro viewManutencao;
    private View view;
    private Consulta viewConsulta;
    private ArrayList<ModelPessoa> passageiros;
    private ModelViagem viagem;

    public ControllerManutencaoViagemPassageiro(View view, ArrayList<ModelPessoa> passageiros, ModelViagem viagem, Consulta viewConsulta) {
        this.viewManutencao = new ViewManutencaoViagemPassageiro();
        this.view = view;
        this.viewConsulta = viewConsulta;
        this.passageiros = passageiros;
        this.viagem = viagem;
        this.init();
    }
    
    public void init() {
        this.viewManutencao.montaTela(this.getPessoas(), this.viagem, this.getTipoViagem(), this.view, this.passageiros);
        this.iniciaBotoes();
    }
    
    public void iniciaBotoes(){
        this.viewManutencao.adicionaAcaoIncluirPassageiro(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doIncluirPassageiro();
            }
        });
    }
    
    public Set<ModelPessoa> getPessoas() {
        return this.view.getPesoas();
    }
    
    public void exibir() {
        this.viewManutencao.setVisible(true);
    }
    
    public void fecharTela() {
        this.viewManutencao.dispose();
    }
    
    public void doIncluirPassageiro() {
        try {
            ModelPessoa passageiro = this.viewManutencao.getPessoaSelecionada();
            // adicionamos o passageiro na lista da tela de maneutencao;
            this.passageiros.add(passageiro);
            this.viagem.addPassageiro(passageiro, this.getTipoViagem());
            ModelViagemPassageiroTipo viagemPassageiroTipo = new ModelViagemPassageiroTipo(this.viagem, passageiro, this.getTipoViagem());
            this.view.setTipoConfirmacao(viagemPassageiroTipo, TipoConfirma.PENDENTE);
            
            JOptionPane.showMessageDialog(null, "Passageiro selecionado", "Alerta", JOptionPane.WARNING_MESSAGE);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível selecionar o passageiro", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        this.viewConsulta.atualizaConsulta();
        this.fecharTela();
    }
    
    private TipoViagem getTipoViagem() {
        String tipo = this.viewManutencao.getTipoViagemSelecionada();
        if(tipo == "Somente Ida") {
            return TipoViagem.IDA;
        } else if(tipo == "Somente Volta") {
            return TipoViagem.VOLTA;
        } else {
            return TipoViagem.IDA_VOLTA;
        }
    }
    
    
}
