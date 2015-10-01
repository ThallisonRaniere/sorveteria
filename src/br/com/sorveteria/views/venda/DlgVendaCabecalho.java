package br.com.sorveteria.views.venda;

import br.com.sorveteria.controllers.CabecalhoVendaController;
import br.com.sorveteria.controllers.ClienteController;
import br.com.sorveteria.controllers.UsuarioController;
import br.com.sorveteria.models.CabecalhoVendaModel;
import br.com.sorveteria.views.cliente.DlgClienteConsultaAtualiza;
import br.com.sorveteria.views.usuario.DlgUsuarioConsultaAtualiza;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgVendaCabecalho extends javax.swing.JDialog {

    ClienteController c = new ClienteController();
    UsuarioController u = new UsuarioController();
    CabecalhoVendaModel cvm = new CabecalhoVendaModel();
    CabecalhoVendaController cvc = new CabecalhoVendaController();

    public DlgVendaCabecalho(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png")).getImage());
        lblCli.setVisible(false);
        lblUsu.setVisible(false);
        setaData();
        ExcluiLetrasCliente();
        ExcluiLetrasUsuario();
    }

    public void limpaFormulario() {
        txtCodCliente.setText(null);
        txtNomeCliente.setText(null);
        txtCodUsuario.setText(null);
        txtNomeUsuario.setText(null);
        txtObs.setText(null);
        DlgVendasAbertas dlgVendasAbertas = new DlgVendasAbertas(null, rootPaneCheckingEnabled);
        dlgVendasAbertas.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodCliente = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodUsuario = new javax.swing.JTextField();
        txtNomeUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtObs = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRegistraVenda = new javax.swing.JButton();
        lblCli = new javax.swing.JLabel();
        lblUsu = new javax.swing.JLabel();
        txtDataVenda = new javax.swing.JFormattedTextField();
        btnAddItens = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Lançamento de Venda");
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("DataVenda:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Cód. Cliente:");

        txtCodCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodClienteFocusLost(evt);
            }
        });
        txtCodCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodClienteKeyPressed(evt);
            }
        });

        txtNomeCliente.setEditable(false);
        txtNomeCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Cód. Usuário:");

        txtCodUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodUsuarioFocusLost(evt);
            }
        });
        txtCodUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodUsuarioKeyPressed(evt);
            }
        });

        txtNomeUsuario.setEditable(false);
        txtNomeUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Observações:");

        txtObs.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Formulário de Venda");

        btnRegistraVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnRegistraVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/ok.png"))); // NOI18N
        btnRegistraVenda.setText("Registrar Venda");
        btnRegistraVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistraVendaActionPerformed(evt);
            }
        });

        lblCli.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblCli.setText("F3 - Consulta Cliente");

        lblUsu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsu.setText("F4 - Consulta Usuário");

        txtDataVenda.setEditable(false);
        try {
            txtDataVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnAddItens.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAddItens.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/vendas.png"))); // NOI18N
        btnAddItens.setText("Adicionar Itens");
        btnAddItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeCliente))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeUsuario))
                            .addComponent(txtObs)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(lblCli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUsu)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(btnRegistraVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddItens)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCli)
                        .addComponent(lblUsu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistraVenda)
                    .addComponent(btnAddItens))
                .addGap(29, 29, 29))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public final void setaData() {
        SimpleDateFormat dt = new SimpleDateFormat("dd-MM-yyyy");
        String hoje = dt.format(Date.from(Instant.now()));
        txtDataVenda.setText(hoje);
        cvm.setDataVenda(hoje);
    }


    private void txtCodClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodClienteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (VerificaCodigoCliente()) {
                txtCodUsuario.grabFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F3) {
            DlgClienteConsultaAtualiza d = new DlgClienteConsultaAtualiza(null, rootPaneCheckingEnabled);
            d.setVisible(true);
            if (d.VerificaCodigo()) {
                txtCodCliente.setText(d.retornaCodigo().toString());
                evt.setKeyCode(10);
                txtCodClienteKeyPressed(evt);
            }
        }
    }//GEN-LAST:event_txtCodClienteKeyPressed

    private void txtCodUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (VerificaCodigoUsuario()) {
                txtObs.grabFocus();
            }
        } else if (evt.getKeyCode() == KeyEvent.VK_F4) {
            DlgUsuarioConsultaAtualiza d = new DlgUsuarioConsultaAtualiza(null, rootPaneCheckingEnabled);
            d.setVisible(true);
            if (d.VerificaCodigo()) {
                txtCodUsuario.setText(d.retornaCodigo().toString());
                evt.setKeyCode(10);
                txtCodUsuarioKeyPressed(evt);
            }
        }
    }//GEN-LAST:event_txtCodUsuarioKeyPressed

    private void btnRegistraVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistraVendaActionPerformed
        if (VerificaCodigoCliente()) {
            if (VerificaCodigoUsuario()) {
                cvm.setObservacoesVenda(txtObs.getText().toUpperCase());
                cvm.setStatus(0);
                cvc.cadastra(cvm);
                limpaFormulario();
            }
        }
    }//GEN-LAST:event_btnRegistraVendaActionPerformed

    private void btnAddItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItensActionPerformed
        DlgVendasAbertas dlgVendasAbertas = new DlgVendasAbertas(null, rootPaneCheckingEnabled);
        dlgVendasAbertas.setVisible(true);
    }//GEN-LAST:event_btnAddItensActionPerformed

    private void txtCodClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodClienteFocusGained
        lblCli.setVisible(true);
        lblUsu.setVisible(false);
    }//GEN-LAST:event_txtCodClienteFocusGained

    private void txtCodClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodClienteFocusLost
        lblCli.setVisible(false);
        lblUsu.setVisible(false);
    }//GEN-LAST:event_txtCodClienteFocusLost

    private void txtCodUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodUsuarioFocusGained
        lblCli.setVisible(false);
        lblUsu.setVisible(true);
    }//GEN-LAST:event_txtCodUsuarioFocusGained

    private void txtCodUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodUsuarioFocusLost
        lblCli.setVisible(false);
        lblUsu.setVisible(false);
    }//GEN-LAST:event_txtCodUsuarioFocusLost

    public final void ExcluiLetrasUsuario() {
        txtCodUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodUsuario.setText(txtCodUsuario.getText().replaceAll("[^0-9]", ""));
            }

        });
    }

    public final void ExcluiLetrasCliente() {
        txtCodCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodCliente.setText(txtCodCliente.getText().replaceAll("[^0-9]", ""));
            }

        });
    }

    public Boolean VerificaCodigoCliente() {
        if (!txtCodCliente.getText().isEmpty()) {
            try {
                Integer cod = Integer.parseInt(txtCodCliente.getText().trim());
                String cliente = c.consultaPeloNomeID(cod);
                if (cliente != null) {
                    txtNomeCliente.setText(cliente);
                    cvm.setIdCliente(cod);
                    txtCodCliente.grabFocus();
                } else {
                    txtNomeCliente.setText(null);
                }
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Informe um código válido!\n\n" + e.getMessage());
                txtNomeCliente.setText(null);
                txtCodCliente.grabFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o Código do cliente!");
            txtNomeCliente.setText(null);
            return false;
        }
    }

    public Boolean VerificaCodigoUsuario() {
        if (!txtCodUsuario.getText().isEmpty()) {
            try {
                Integer cod = Integer.parseInt(txtCodUsuario.getText().trim());
                String usuario = u.consultaNomePeloID(cod);
                if (usuario != null) {
                    txtNomeUsuario.setText(usuario);
                    cvm.setIdUsuario(cod);
                    txtObs.grabFocus();
                } else {
                    txtNomeUsuario.setText(null);
                }
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Informe um código válido!\n\n" + e.getMessage());
                txtNomeUsuario.setText(null);
                txtCodUsuario.grabFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o Código do usuario!");
            txtNomeUsuario.setText(null);
            return false;
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Erro!");
        }
        java.awt.EventQueue.invokeLater(() -> {
            DlgVendaCabecalho dialog = new DlgVendaCabecalho(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItens;
    private javax.swing.JButton btnRegistraVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCli;
    private javax.swing.JLabel lblUsu;
    private javax.swing.JTextField txtCodCliente;
    private javax.swing.JTextField txtCodUsuario;
    private javax.swing.JFormattedTextField txtDataVenda;
    private javax.swing.JTextField txtNomeCliente;
    private javax.swing.JTextField txtNomeUsuario;
    private javax.swing.JTextField txtObs;
    // End of variables declaration//GEN-END:variables
}
