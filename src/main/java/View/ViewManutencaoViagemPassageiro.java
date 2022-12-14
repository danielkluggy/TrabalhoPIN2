package View;

import Model.ModelPessoa;
import Model.ModelViagem;
import Model.ModelViagemPassageiroTipo;
import Controller.TipoConfirma;
import Controller.TipoViagem;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author dklug
 */
public class ViewManutencaoViagemPassageiro extends javax.swing.JFrame {

    /**
     * Creates new form ViewManutencaoViagemPessoa
     */
    public ViewManutencaoViagemPassageiro() {
        initComponents();       

    }
    
    private boolean jaListada(ModelPessoa pessoa, ArrayList<ModelPessoa> passageiros) {
        if(passageiros.size() <= 0) {
            return false;
        }
        
        for(ModelPessoa pLista : passageiros) {
            if(pLista.equals(pessoa)) {
                return true;
            }
        }
        return false;
    }
    
    public void montaTela(Set<ModelPessoa> pessoas, ModelViagem viagem, TipoViagem tipo, View view, ArrayList<ModelPessoa> passageiroJainclusos) {
         for(ModelPessoa umaPessoa : pessoas) {
            if(!this.jaListada(umaPessoa, passageiroJainclusos)){
                this.cbPessoas.addItem(umaPessoa);
                ModelViagemPassageiroTipo viagemPassageiroTipo = new ModelViagemPassageiroTipo(viagem, umaPessoa, tipo);
                view.setTipoConfirmacao(viagemPassageiroTipo, TipoConfirma.PENDENTE);
            }
        }
    }
    
    public void adicionaAcaoIncluirPassageiro(ActionListener acao) {
        this.btIncluirPassageiro.addActionListener(acao);
    }
    
    public ModelPessoa getPessoaSelecionada() {
        return this.cbPessoas.getItemAt(this.cbPessoas.getSelectedIndex());
    }
    
    public String getTipoViagemSelecionada() {
        return this.cbTipoViagem.getItemAt(this.cbTipoViagem.getSelectedIndex());
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
        cbPessoas = new javax.swing.JComboBox<>();
        btIncluirPassageiro = new javax.swing.JButton();
        cbTipoViagem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incluir Passageiro");

        jLabel1.setText("Selecione uma pessoa:");

        btIncluirPassageiro.setText("Incluir");

        cbTipoViagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ida e Volta", "Somente Ida", "Somente Volta" }));

        jLabel2.setText("Tipo de viagem:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbTipoViagem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btIncluirPassageiro, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbPessoas, 0, 340, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTipoViagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btIncluirPassageiro)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIncluirPassageiro;
    private javax.swing.JComboBox<ModelPessoa> cbPessoas;
    private javax.swing.JComboBox<String> cbTipoViagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
