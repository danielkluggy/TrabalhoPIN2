package Model.Table;

import Model.ModelViagem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dklug
 */
public class TableModelViagem extends AbstractTableModel {
    
    private List<ModelViagem> viagens = new ArrayList<>();
    private final String[] nomeColunas = { "Data", "Motorista", "Ônibus", "Número de Passageiros"};
    private final int COLUNA_DATA = 0;
    private final int COLUNA_MOTORISTA = 1;
    private final int COLUNA_ONIBUS = 2;
    private final int COLUNA_PASSAGEIROS = 3;
    
    
    public TableModelViagem (List<ModelViagem> viagens) {
        this.viagens = viagens;
    }

    @Override
    public int getRowCount() {
        if (viagens != null) {
            return viagens.size();
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
                case COLUNA_DATA:
                    return viagens.get(rowIndex).getDataFormatada();
                case COLUNA_MOTORISTA:
                    return viagens.get(rowIndex).getMotorista().getNome();
                case COLUNA_ONIBUS:
                    return viagens.get(rowIndex).getOnibus().getMarca();
                case COLUNA_PASSAGEIROS:
                    return viagens.get(rowIndex).getNumeroPassageiros();
        }         
        return null;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
    }

}
