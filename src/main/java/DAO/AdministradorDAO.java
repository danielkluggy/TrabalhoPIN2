package DAO;

import Model.ModelAdministrador;
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
public class AdministradorDAO {
       
    private static void createTable() {
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS ADMINISTRADOR"
                + "   (id           INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   nome          VARCHAR(255),"
                + "   cargo           VARCHAR(255))";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvar(ModelAdministrador administrador){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO ADMINISTRADOR (id, nome, cargo) VALUES(?,?,?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(2, administrador.getNome());
            pstmt.setString(3, administrador.getCargo());
            pstmt.execute();

            System.out.println("Usuario gravado com sucesso!");

            final ResultSet resultado = pstmt.getGeneratedKeys();
            if (resultado.next()) {
                int id = resultado.getInt(1);
                administrador.setId(id);
            }
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizar(ModelAdministrador administrador){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE ADMINISTRADOR SET nome=?, cargo=? WHERE id=?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, administrador.getNome());
            pstmt.setString(2, administrador.getCargo());
            pstmt.setInt(3, administrador.getCodigo());
            pstmt.execute();

            System.out.println("Usuario atualizado com sucesso!");
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<ModelAdministrador> getTodos(){
        createTable();
        List<ModelAdministrador> administradores = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM ADMINISTRADOR";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cargo = resultado.getString("cargo");
                
                ModelAdministrador p = new ModelAdministrador(id, nome, cargo);
                administradores.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return administradores;
    }
    
    public static boolean excluir(int id){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM ADMINISTRADOR WHERE id = ?";
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
