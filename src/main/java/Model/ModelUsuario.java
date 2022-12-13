package Model;

/**
 *
 * @author dklug
 */
public class ModelUsuario extends ModelPessoa {
    private String instituicao;

    public ModelUsuario(int codigo, String nome, String instituicao) {
        super(codigo, nome);
        this.instituicao = instituicao;
    }
    
    public ModelUsuario(String nome, String instituicao) {
        super(nome);
        this.instituicao = instituicao;
    }
    
    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
      
}