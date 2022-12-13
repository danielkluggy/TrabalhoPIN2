package Estrutura;

import Model.ModelPessoa;
import java.util.Comparator;

/**
 *
 * @author dklug
 */
public class PessoaComparatorPorNome implements Comparator<ModelPessoa> {
    
    @Override
    public int compare(ModelPessoa p1, ModelPessoa p2) {    
        if (p1.getNome().compareTo(p2.getNome()) == 0) {
            return p1.getCodigo() - p2.getCodigo();
        }
        return p1.getNome().compareTo(p2.getNome());
    }
        
}
