package Model;

import java.util.Objects;

/**
 *
 * @author dklug
 */
public class ModelPessoa implements Comparable<ModelPessoa> {
    
    public static final String ADMIN = "Admin";
    public static final String DRIVER = "Driver";
    
    private int codigo;
    private String nome;
    private String email;
    private String telefone;

    public ModelPessoa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public ModelPessoa(String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public void setId(int id) {
        this.codigo = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int compareTo(ModelPessoa o) {
        return this.codigo - o.codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.codigo;
        hash = 79 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final ModelPessoa other = (ModelPessoa) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    
    @Override
    public  String toString() {
        return  this.getNome();
    }
}
