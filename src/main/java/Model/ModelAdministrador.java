package Model;

/**
 *
 * @author dklug
 */
public class ModelAdministrador extends ModelPessoa {
    private String cargo;

    public ModelAdministrador(int codigo, String nome, String cargo) {
        super(codigo, nome);
        this.cargo = cargo;
    }
    
    public ModelAdministrador(String nome, String cargo) {
        super(nome);
        this.cargo = cargo;
    }


    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}