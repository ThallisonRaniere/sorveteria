package br.com.sorveteria.dao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/sorveteria";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection Conecta() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar conectar com a base de dados!\n\n" + ex.getMessage());
            throw new SQLException();
        }
    }

    public static boolean TestaConexao() throws ClassNotFoundException {
        Connection conexao;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorveteria?user=root&password=");
            return true;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "O programa não conseguiu se conectar com a base de dados!\nEntre em contato com o suporte\nO programa será finalizado!\n" + erro + "", "Erro de conexão com o banco de dados!", JOptionPane.OK_OPTION);
            System.exit(0);
            return false;
        }
    }

    public static Boolean backup() throws ClassNotFoundException {
        Date data = new Date();
        SimpleDateFormat formata = new SimpleDateFormat("dd-MM-YYYY");
        File diretorio = new File("c:\\sorveteria\\backups");
        if (diretorio.exists()) {
            try {
                if (TestaConexao()) {
                    String nomeBackup = "c:\\sorveteria\\backups\\backup" + formata.format(data) + ".sql";
                    String comando = "cmd /c mysqldump -h localhost -u root sorveteria > " + nomeBackup;
                    Runtime.getRuntime().exec(comando);
                    return true;
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro!\n\n" + e.getMessage());
                return false;
            }
        } else {
            diretorio.mkdirs();
            try {
                if (TestaConexao()) {
                    String nomeBackup = "c:\\sorveteria\\backups\\backup" + formata.format(data) + ".sql";
                    String comando = "cmd /c mysqldump -h localhost -u root sorveteria > " + nomeBackup;
                    Runtime.getRuntime().exec(comando);
                    return true;
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erro!\n\n" + e.getMessage());
                return false;
            }
        }
        return null;
    }
}
