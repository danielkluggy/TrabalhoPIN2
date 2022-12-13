package Controller;

import Estrutura.Autenticador;
import java.util.ArrayList;

/**
 *
 * @author dklug
 */
public class SenhaRepository extends Autenticador{
    private ArrayList<String> senhas;

    public SenhaRepository() {
        this.senhas = new ArrayList<String>();
    }
    
    private ArrayList<String> getSenhas() {
        this.senhas.add("123456");
        this.senhas.add("654321");
        this.senhas.add("udesc123");
        return this.senhas;
    }

    @Override
    public boolean autentica(String senha) {
        for(String senhaSalva : this.getSenhas()) {
            if(senha.equals(senhaSalva)){
                return true;
            }
        }
        return false;
    }
}
