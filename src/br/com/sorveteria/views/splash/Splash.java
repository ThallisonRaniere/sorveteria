package br.com.sorveteria.views.splash;

import br.com.sorveteria.dao.Conexao;
import br.com.sorveteria.views.inicio.FrmLogin;
import com.thehowtotutorial.splashscreen.JSplash;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class Splash {

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Erro");
        }
        try {
            JSplash splash = new JSplash(Splash.class.getResource("splash.png"), true, true, false, "Versão 1.0", new Font("Arial", 1, 14), Color.BLACK, Color.BLACK);
            splash.splashOn();
            splash.setProgress(10, "Por favor aguarde!");
            Thread.sleep(1000);
            splash.setProgress(50, "O sistema está sendo inicializado!");
            Thread.sleep(1000);
            splash.setProgress(60, "Verificando conexão com o banco de dados!");
            Thread.sleep(500);
            if (!Conexao.TestaConexao()) {
                JOptionPane.showMessageDialog(null, "Não foi possível estabelecer conexão com o banco de dados! Entre em contato com o suporte!\n\nA aplicação será finalizada!");
                System.exit(0);
            }
            splash.setProgress(80, "Abrindo o sistema!");
            Thread.sleep(500);
            splash.splashOff();
            FrmLogin frmLogin = new FrmLogin();
            frmLogin.setVisible(true);
        } catch (InterruptedException | ClassNotFoundException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Erro:\n\n" + ex.getMessage());
        }
    }
}
