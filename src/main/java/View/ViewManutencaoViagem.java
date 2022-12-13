package View;

import Estrutura.PreenchimentoException;
import Model.ModelMotorista;
import Model.ModelOnibus;
import Model.ModelPessoa;
import Model.ModelRota;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author dklug
 */
public class ViewManutencaoViagem extends javax.swing.JFrame {
    LocalDate hoje = LocalDate.now();

    /**
     * Creates new form ViewManutencaoViagem
     */
    public ViewManutencaoViagem() {
        initComponents();
    }
    
    /**
     * Inicia o comboBox de rotas
     */
    public void iniciaRotas(List<ModelRota> rotas) {
        for(ModelRota rota : rotas) {
            this.cbRota.addItem(rota);
        }
    }
    
    /**
     * Inicia o comboBox de motoristas disponiveis
     */
    public void iniciaMotorista(List<ModelMotorista> motoristas) {
        for(ModelMotorista motorista : motoristas) {
            if(motorista.isDiponivel()){
                this.cbMotorista.addItem(motorista);
            }
        }
    }
    
    /**
     * Inicia o comboBox de onibus
     */
    public void iniciaOnibus(List<ModelOnibus> onibos) {
        for(ModelOnibus onibus : onibos) {
            if(onibus.isDiponivel()) {
                this.cbOnibus.addItem(onibus);
            }
        }
    }
    
    /**
     * Atualiza a lista de pessoas no textArea.
     */
    public void atualizaPassageiro(ArrayList<ModelPessoa> passageiros){
        this.taPassageiros.selectAll();
        this.taPassageiros.replaceSelection("");
        for(ModelPessoa passageiro : passageiros) {
            this.taPassageiros.append(passageiro.getNome() + "\n");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbRota = new javax.swing.JComboBox<>();
        cbMotorista = new javax.swing.JComboBox<>();
        cbOnibus = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        taPassageiros = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        btPassageiro = new javax.swing.JButton();
        btConfirmar = new javax.swing.JButton();
        dateSelect = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir  Viagem");

        jLabel1.setText("Data:");

        jLabel2.setText("Motorista:");

        jLabel4.setText("Onibus:");

        jLabel5.setText("Rota:");

        taPassageiros.setEditable(false);
        taPassageiros.setColumns(20);
        taPassageiros.setRows(5);
        jScrollPane1.setViewportView(taPassageiros);

        jLabel6.setText("Passageiros:");

        btPassageiro.setText("Incluir Passageiro");

        btConfirmar.setText("Confirmar");

        dateSelect.setDate(Date.from(hoje.atStartOfDay(ZoneId.systemDefault()).toInstant()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btPassageiro))))
                            .addComponent(btConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbRota, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cbMotorista, javax.swing.GroupLayout.Alignment.LEADING, 0, 326, Short.MAX_VALUE)
                                    .addComponent(cbOnibus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbRota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbOnibus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btPassageiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(btConfirmar)
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    public void adicionaAcaoSelecionaPassageiro(ActionListener acao) {
        this.btPassageiro.addActionListener(acao);
    }
    
    public void adicionaAcaoConfirmar(ActionListener acao) {
        this.btConfirmar.addActionListener(acao);
    }
    
    
        
        public void exibeMensagem(String titulo, String mensagem, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }
    /**
     * Retorna a data selecionada na tela
     * @return LocalDate
     */
    public LocalDate getData() throws PreenchimentoException {
        Date data = this.dateSelect.getDate();
        LocalDate localDate = data.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate();
        if(localDate != null) {
            return localDate;
        } else {
            throw new PreenchimentoException("Data não definida");
        }
    }
    
    /**
     * Retorna a rota selecionada na tela
     * @return ModelRota
     */
    public ModelRota getRota() throws PreenchimentoException {
        ModelRota rota = this.cbRota.getItemAt(this.cbRota.getSelectedIndex());
        if(rota != null) {
            return rota;
        } else {
            throw new PreenchimentoException("Rota não foi definida");
        }
    }
    
    /**
     * Retorna o motorista selecionado validando a sua disponibilidade

     */
    public ModelMotorista getCampoMotorista(){
        return this.cbMotorista.getItemAt(this.cbMotorista.getSelectedIndex());
    }
    
    public ModelOnibus getCampoOnibus() {
        return this.cbOnibus.getItemAt(this.cbOnibus.getSelectedIndex());
    }   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmar;
    private javax.swing.JButton btPassageiro;
    private javax.swing.JComboBox<ModelMotorista> cbMotorista;
    private javax.swing.JComboBox<ModelOnibus> cbOnibus;
    private javax.swing.JComboBox<ModelRota> cbRota;
    private org.jdesktop.swingx.JXDatePicker dateSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea taPassageiros;
    // End of variables declaration//GEN-END:variables
}