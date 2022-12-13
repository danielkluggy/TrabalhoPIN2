package Model;

import Controller.TipoViagem;

/**
 *
 * @author dklug
 */
public class ModelViagemPassageiroTipo {
    private ModelViagem viagem;
    private ModelPessoa pasageiro;
    private TipoViagem tipoViagem;

    public ModelViagemPassageiroTipo(ModelViagem viagem, ModelPessoa pasageiro, TipoViagem tipoViagem) {
        this.viagem = viagem;
        this.pasageiro = pasageiro;
        this.tipoViagem = tipoViagem;
    }

    public ModelViagem getViagem() {
        return viagem;
    }

    public ModelPessoa getPasageiro() {
        return pasageiro;
    }

    public TipoViagem getTipoViagem() {
        return tipoViagem;
    }

    public void setViagem(ModelViagem viagem) {
        this.viagem = viagem;
    }

    public void setPasageiro(ModelPessoa pasageiro) {
        this.pasageiro = pasageiro;
    }

    public void setTipoViagem(TipoViagem tipoViagem) {
        this.tipoViagem = tipoViagem;
    }
    
    @Override
    public String toString(){
        String msg = "Data: " + this.viagem.getDataFormatada();
        msg += ", Rota: " + this.viagem.getRotas().toString();
        msg += ".\nMotorista: " + this.viagem.getMotorista();
        msg += ", Ônibus: " + this.viagem.getOnibus();
        msg += ".\nPassageiro: " + this.pasageiro.toString();
        msg += ", Tipo da viagem: " + this.viagem.getTipoViagemDescricao(this.tipoViagem);
        return msg;
    }
}
