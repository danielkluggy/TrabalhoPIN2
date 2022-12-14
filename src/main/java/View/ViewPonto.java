package View;

import Model.ModelPonto;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dklug
 */
public class ViewPonto extends javax.swing.JFrame{

    /**
     * Creates new form ViewPonto
     */
    public ViewPonto() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbRota = new javax.swing.JScrollPane();
        tbPontos = new javax.swing.JTable();
        btAtualizar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btIncluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbPontos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Latitude", "Longitude", "Ponto de ReferĂȘncia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRota.setViewportView(tbPontos);

        btAtualizar.setText("Atualizar");

        btExcluir.setText("Excluir");

        btIncluir.setText("Incluir ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbRota, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbRota, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIncluir)
                    .addComponent(btExcluir)
                    .addComponent(btAtualizar))
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    public void loadTable(List<ModelPonto> pontos) {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Latitude", "Longitude", "Ponto de ReferĂȘncia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        for (int i = 0; i < pontos.size(); i++) {
            Object linha[] = new Object[] { pontos.get(i).getLatitude(),
                                            pontos.get(i).getLongitude(),
                                            pontos.get(i).getPontoDeReferencia()};
            modelo.addRow(linha);
        }
        tbPontos.setModel(modelo);
    }
    
    public void adicionaAcaoAtualizar(ActionListener acao){
        this.btAtualizar.addActionListener(acao);
    }
    
    public void adicionaAcaoIncluir(ActionListener acao) {
        this.btIncluir.addActionListener(acao);
    }
    
    public void adicionaAcaoExcluir(ActionListener acao) {
        this.btExcluir.addActionListener(acao);
    }
    
    public void exibeMensagem(String titulo, String mensagem, int tipo) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, tipo);
    }
    
    public int getIndiceLinhaSelecionada() {
        return this.tbPontos.getSelectedRow();
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btIncluir;
    private javax.swing.JTable tbPontos;
    private javax.swing.JScrollPane tbRota;
    // End of variables declaration//GEN-END:variables

}
