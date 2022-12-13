package Estrutura;

import Model.ModelUsuario;
import java.util.Comparator;

/**
 *
 * @author dklug
 */
public class UsuarioComparatorPorInstituicao implements Comparator<ModelUsuario> {
    
    @Override
    public int compare(ModelUsuario p1, ModelUsuario p2) {
        if (p1.getInstituicao().compareTo(p2.getInstituicao()) == 0) {
            return p1.getCodigo() - p2.getCodigo();
        }
        return p1.getInstituicao().compareTo(p2.getInstituicao());
    }
        
}
