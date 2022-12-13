package Model;

import Controller.TipoConfirma;
import Controller.TipoViagem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dklug
 */
public class ModelViagem{
    private LocalDate data;
    private boolean isViagemAberta;
    private ModelOnibus onibus;
    private ModelMotorista motorista;
    private ArrayList<ModelRota> rotas;
    private ArrayList<ModelPessoa> passageiros;
    private Map<ModelPessoa, TipoViagem> pessoaTipoViagem;
    private Map<ModelPessoa, TipoConfirma> pessoaTipoConfirma;

    public ModelViagem() {
        this.isViagemAberta   = true;
        this.rotas            = new ArrayList<ModelRota>();
        this.passageiros      = new ArrayList<ModelPessoa>();
        this.pessoaTipoViagem = new HashMap<ModelPessoa, TipoViagem>();
        this.pessoaTipoConfirma = new HashMap<ModelPessoa, TipoConfirma>();
    }
    
    public void addRota(ModelRota rota) {
        this.rotas.add(rota);
    }
    
    public ArrayList<ModelRota> getRotas() {
        return this.rotas;
    }
    

    public LocalDate getData() {
        return data;
    }
    
    public void setData(LocalDate data) {
        this.data = data;
    }
    /**
     * Retorna a data ja formatado para ser exibido em telas de consulta padrão Brasileiro
     * 23/08/2021
     * @return String
     */
    public String getDataFormatada(){
        return this.data.getDayOfMonth() + "/" + this.data.getMonthValue() + "/"+ this.data.getYear();
    }
    
    public Map<ModelPessoa, TipoViagem> getMapTipoViagem() {
        return this.pessoaTipoViagem;
    }
    
    /**
     * Retorna a descrição a partir do Enum tipo de viagem. Ideal para Jtable.
     * @param tipoViagem
     * @return 
     */
    public String getTipoViagemDescricao(TipoViagem tipoViagem) {
        switch (tipoViagem){
            case IDA_VOLTA: 
                return "Ida e Volta";
            case IDA: 
                return "Somente Ida";
            case VOLTA: 
                return "Somente Volta";
            default: 
                return "Não especificado";
        }
    }
    
        public Map<ModelPessoa, TipoConfirma> getMapTipoConfirma() {
        return this.pessoaTipoConfirma;
    }
    
    /**
     * Retorna a descrição a partir do Enum tipo de viagem. Ideal para Jtable.
     * @param tipoConfirma
     * @return 
     */
    public String getTipoConfirmaDescricao(TipoConfirma tipoConfirma) {
        switch (tipoConfirma){
            case PENDENTE:
                return "Pendente";
            case IDA_VOLTA: 
                return "Confirmado";
            case IDA: 
                return "Confirmado";
            case VOLTA: 
                return "Confirmado";
            default: 
                return "Não especificado";
        }
    }
    
    public boolean getIsViagemAberta(){
        return this.isViagemAberta;
    }
    
    public void fechaViagem(){
        this.isViagemAberta = false;
    }
    
    /**
     * Permite reabrir uma viagem ja fechada.
     * Só permitirá abrir viagens cuja data data for superior ou igual a data do dia.
     * @return boolean
     */
    public boolean abreViagem(){
        LocalDate hoje = LocalDate.now();
        if(this.data.isAfter(hoje) || this.data.isEqual(hoje)) {
            this.isViagemAberta = true;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Responsável por definir uma nova data para a viagem
     * @param LocalDate - nova data a ser setada
     * @return boolean
     */
    public boolean updataDataViagem(LocalDate novaData) {
        LocalDate dataAtual = LocalDate.now();
        if(dataAtual.isBefore(novaData) || dataAtual.isEqual(novaData)) {
            this.data = novaData;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Adiciona um modelo de onibus na lista de onibus.
     * @param onibus 
     */
    public void addOnibus(ModelOnibus onibus) {
        if(this.onibus == null) {
            // verifica se o onibus é valido a partir do metodo dispsto da interfase para isso.
            this.onibus = onibus;
        }
    }
    
    public void addMotorista(ModelMotorista motorista) {
        if(this.motorista == null) {
            // Verificar se o motoista esta disponível e é valido.
            this.motorista = motorista;
        }
    }
    
    /**
     * Adiciona um novo passageiro a viagem. 
     * Seta a pessoa na lista de passageiros bem como seta no map o tipo de viagem para aquela pessoa.
     * @param pessoa
     * @param tipoViagem 
     */
    public void addPassageiro(ModelPessoa pessoa, TipoViagem tipoViagem) {
        this.passageiros.add(pessoa);
        this.pessoaTipoViagem.put(pessoa, tipoViagem);
        this.pessoaTipoConfirma.put(pessoa, TipoConfirma.PENDENTE);
    }
    
    /**
     * Retorna o enum de tipo de pessoa para a viagem a partir de uma pessoa informada.
     * @param pessoa
     * @return 
     */
    public TipoViagem getTipoViagemPorPessoa(ModelPessoa pessoa){
        return this.pessoaTipoViagem.get(pessoa);
    }
    
    public TipoConfirma getTipoConfirmaPorPessoa(ModelPessoa pessoa){
        return this.pessoaTipoConfirma.get(pessoa);
    }
    
    /**
     * Atualiza o tipo de viagem para uma pessoa específica
     * @param pessoa
     * @param tipoViagem 
     */
    public void atualizaTipoViagem(ModelPessoa pessoa , TipoViagem tipoViagem) {
        this.pessoaTipoViagem.put(pessoa, tipoViagem);
    }
    
    public void atualizaTipoConfirma(ModelPessoa pessoa , TipoConfirma tipoConfirma) {
        this.pessoaTipoConfirma.put(pessoa, tipoConfirma);
    }
    
    /**
     * Retorna uma lista de objetos do tipo ModelViagemPassageiroTipo iterando o map de pessoa com o tipo de viagem.
     * Dessa forma é possível obter uma lista onde se tem os dados da viagem, dados do passageiro, e dados do tipo de viagem para aquele passageiro.
     * @return 
     */
    public ArrayList<ModelViagemPassageiroTipo> getListaPassageiroTipoViagem(){
        ArrayList<ModelViagemPassageiroTipo> lista = new ArrayList<ModelViagemPassageiroTipo>();
        
        for(ModelPessoa pessoa :this.pessoaTipoViagem.keySet()) {
            ModelViagemPassageiroTipo newModel = new ModelViagemPassageiroTipo(
                                                        this, 
                                                        pessoa, 
                                                        this.getTipoViagemPorPessoa(pessoa)
                                                     );
            lista.add(newModel);
        }
        return lista;
    }
    
    /**
     * Retorna o número de passageiros inscritos na viagem.
     * @return 
     */
    public int getNumeroPassageiros() {
        return this.passageiros.size();
    }
    
    public ModelMotorista getMotorista() {
        return this.motorista;
    }
    
    public ArrayList<ModelPessoa> getPassageiros() {
        return this.passageiros;
    }
    
    public ModelOnibus getOnibus() {
        return this.onibus;
    }
    
    @Override
    public String toString() {
       return "Rota: " + this.getRotas().get(0).toString();        
    }
    
}
