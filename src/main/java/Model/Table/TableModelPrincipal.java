package Model.Table;

import Controller.TipoConfirma;
import Controller.TipoViagem;
import Model.ModelViagem;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dklug
 */
public class TableModelPrincipal extends AbstractTableModel {
    
    private ModelViagem viagem;
    private final String[] nomeColunas = { "Passageiro", "Tipo", "Ida", "Volta"};
    private final int COLUNA_PASSAGEIRO = 0;
    private final int COLUNA_TIPO = 1;
    private final int COLUNA_IDA = 2;
    private final int COLUNA_VOLTA = 3;
    
    
    public TableModelPrincipal (ModelViagem viagem) {
        this.viagem = viagem;
    }

    @Override
    public int getRowCount() {
        if (viagem != null) {
            return viagem.getNumeroPassageiros();
        }
            return 0;
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case COLUNA_PASSAGEIRO:
                    return viagem.getPassageiros().get(rowIndex).getNome();
                case COLUNA_TIPO:
                    return viagem.getTipoViagemDescricao(viagem.getTipoViagemPorPessoa(viagem.getPassageiros().get(rowIndex)));
                case COLUNA_IDA:
                    return getIda(viagem.getTipoConfirmaPorPessoa(viagem.getPassageiros().get(rowIndex)), rowIndex);
                case COLUNA_VOLTA:
                    return getVolta(viagem.getTipoConfirmaPorPessoa(viagem.getPassageiros().get(rowIndex)), rowIndex);
        }
        return null;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
    }
    
    private String getIda(TipoConfirma confirma, int i) {
        if(viagem.getTipoViagemPorPessoa(viagem.getPassageiros().get(i)) == TipoViagem.VOLTA) {
            return "---";
        } else if (confirma == TipoConfirma.IDA || confirma == TipoConfirma.IDA_VOLTA) {
            return "Confirmado";
        } else
            return "Pendente";
    }
    
    private String getVolta(TipoConfirma confirma, int i) {
        if(viagem.getTipoViagemPorPessoa(viagem.getPassageiros().get(i)) == TipoViagem.IDA) {
            return "---";
        } else if (confirma == TipoConfirma.VOLTA || confirma == TipoConfirma.IDA_VOLTA) {
                return "Confirmado";
        } else
            return "Pendente";
    }

}
