package DAO;

import Model.ModelMotorista;
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
public class MotoristaDAO {
       
    private static void createTable() {
        Connection connection = Conexao.getConnection();
        String sqlCreate = "CREATE TABLE IF NOT EXISTS MOTORISTA"
                + "   (id           INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "   nome          VARCHAR(255),"
                + "   anoContratacao           INTEGER,"
                + "   situacao          INTEGER)";

        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.execute(sqlCreate);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvar(ModelMotorista motorista){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO MOTORISTA (id, nome, anoContratacao, situacao) VALUES(?,?,?,?)";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(2, motorista.getNome());
            pstmt.setInt(3, motorista.getAnoContratacao());
            pstmt.setInt(4, motorista.getSituacao());
            pstmt.execute();

            System.out.println("Usuario gravado com sucesso!");

            final ResultSet resultado = pstmt.getGeneratedKeys();
            if (resultado.next()) {
                int id = resultado.getInt(1);
                motorista.setId(id);
            }
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizar(ModelMotorista motorista){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE MOTORISTA SET nome=?, anoContratacao=? WHERE id=?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, motorista.getNome());
            pstmt.setInt(2, motorista.getAnoContratacao());
            pstmt.setInt(3, motorista.getCodigo());
            pstmt.execute();

            System.out.println("Usuario atualizado com sucesso!");
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean disponibilidade(ModelMotorista motorista){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE MOTORISTA SET situacao=?, WHERE id=?";
        PreparedStatement pstmt;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, motorista.getSituacao());
            pstmt.setInt(2, motorista.getCodigo());
            pstmt.execute();

            System.out.println("Usuario atualizado com sucesso!");
            return true;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<ModelMotorista> getTodos(){
        createTable();
        List<ModelMotorista> motoristas = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM MOTORISTA";
        Statement stmt;

        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int anoContratacao = resultado.getInt("anoContratacao");
                int situacao = resultado.getInt("situacao");
                
                ModelMotorista p = new ModelMotorista(id, nome, anoContratacao);
                p.setSituacao(situacao);
                motoristas.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return motoristas;
    }
    
    public static boolean excluir(int id){
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM MOTORISTA WHERE id = ?";
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
