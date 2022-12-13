package DAO;

import Model.ModelUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dklug
 */
public class UsuarioDAO {
       
    private static void createTable() {
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS USUARIO"
                + "   (id           INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   nome          VARCHAR(255),"
                + "   instituicao           VARCHAR(400))";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvar(ModelUsuario usuario){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO USUARIO (id, nome, instituicao) VALUES(?,?,?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(2, usuario.getNome());
            pstmt.setString(3, usuario.getInstituicao());
            pstmt.execute();

            System.out.println("Usuario gravado com sucesso!");

            final ResultSet resultado = pstmt.getGeneratedKeys();
            if (resultado.next()) {
                int id = resultado.getInt(1);
                usuario.setId(id);
            }
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizar(ModelUsuario usuario){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE USUARIO SET nome=?, instituicao=? WHERE id=?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getInstituicao());
            pstmt.setInt(3, usuario.getCodigo());
            pstmt.execute();

            System.out.println("Usuario atualizado com sucesso!");
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<ModelUsuario> getTodos(){
        createTable();
        List<ModelUsuario> usuarios = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM USUARIO";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String instituicao = resultado.getString("instituicao");
                
                ModelUsuario p = new ModelUsuario(id, nome, instituicao);
                usuarios.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return usuarios;
    }
    
    public static boolean excluir(int id){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM USUARIO WHERE id = ?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();
            System.out.println("Usuario apagada com sucesso!");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
    }
    
}
