package br.com.sorveteria.views.cidade;

import br.com.sorveteria.controllers.CidadeController;
import br.com.sorveteria.controllers.EstadoController;
import br.com.sorveteria.dao.Conexao;
import br.com.sorveteria.dao.EstadoDAO;
import br.com.sorveteria.models.CidadeModel;
import br.com.sorveteria.models.EstadoModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgCidadeAtualiza extends javax.swing.JDialog {

    CidadeModel cidadeModel = new CidadeModel();
    CidadeController cidadeController = new CidadeController();
    EstadoDAO estadoDAO = new EstadoDAO();
    EstadoController estadoController = new EstadoController();

    public DlgCidadeAtualiza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        PreencheCbEstado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbCidades = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        btnAtualiza = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Atualiza cadastro de cidade");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Atualizar cadastro de cidade");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Selecione o estado:");

        cbEstado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Selecione a cidade:");

        cbCidades.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCidadesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Status:");

        cbStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        btnAtualiza.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAtualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/alterar.png"))); // NOI18N
        btnAtualiza.setText("Atualizar");
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cancelar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Código:");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbCidades, 0, 348, Short.MAX_VALUE)
                            .addComponent(cbEstado, 0, 348, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualiza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualiza)
                    .addComponent(btnLimpar))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public final void PreencheCbEstado() {
        try {
            if (Conexao.TestaConexao()) {
                List<EstadoModel> estados = new ArrayList<>();
                estados.clear();
                cbEstado.removeAllItems();
                cbEstado.addItem(null);
                estados = estadoController.getAll();
                for (EstadoModel estado : estados) {
                    cbEstado.addItem(estado.getIdEstado() + " - " + estado.getSiglaEstado());
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }

    public final void PreencheCbCidades(Integer cod) {
        try {
            if (Conexao.TestaConexao()) {
                List<CidadeModel> cidades = new ArrayList<>();
                cidades.clear();
                cbCidades.removeAllItems();
                cbCidades.addItem(null);
                cidades = cidadeController.consultaPeloIDEstado(cod);
                for (CidadeModel cidade : cidades) {
                    cbCidades.addItem(cidade.getIdCidade() + " - " + cidade.getNomeCidade() + " - " + cidade.getStatus());
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }


    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.getSelectedItem() == null) {

        } else {
            String[] valores = cbEstado.getSelectedItem().toString().split(" - ");
            cidadeModel.setIdEstado(Integer.valueOf(valores[0]));
            Integer Codigo = Integer.valueOf(valores[0]);
            PreencheCbCidades(Codigo);
        }
    }//GEN-LAST:event_cbEstadoActionPerformed


    private void cbCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCidadesActionPerformed
        if (cbCidades.getSelectedItem() == null) {

        } else {
            String[] valores = cbCidades.getSelectedItem().toString().split(" - ");
            cidadeModel.setIdCidade(Integer.parseInt(valores[0]));
            txtCodigo.setText(valores[0]);
            txtNome.setText(valores[1]);
            cbStatus.setSelectedIndex(Integer.parseInt(valores[2]));
        }
    }//GEN-LAST:event_cbCidadesActionPerformed

    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                if (VerificaEstado()) {
                    if (VerificaCidade()) {
                        if (VerificaNome()) {
                            if (cidadeController.atualiza(cidadeModel)) {
                                txtCodigo.setText(null);
                                txtNome.setText(null);
                                cbCidades.removeAllItems();
                                cbStatus.setSelectedIndex(0);
                                cbEstado.setSelectedIndex(0);
                                PreencheCbEstado();
                                cbEstado.grabFocus();
                            }
                        }
                    }
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_btnAtualizaActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtCodigo.setText(null);
        txtNome.setText(null);
        cbCidades.removeAllItems();
        cbStatus.setSelectedIndex(0);
        cbEstado.setSelectedIndex(0);
        PreencheCbEstado();
        cbEstado.grabFocus();
    }//GEN-LAST:event_btnLimparActionPerformed

    public Boolean VerificaNome() {
        if (!txtNome.getText().isEmpty()) {
            cidadeModel.setNomeCidade(txtNome.getText().replaceAll("'", "").trim().toUpperCase());
            cidadeModel.setStatus(Integer.parseInt(cbStatus.getSelectedItem().toString()));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o nome da cidade!");
            txtNome.grabFocus();
            return false;
        }
    }

    public Boolean VerificaEstado() {
        if (cbEstado.getSelectedIndex() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe um estado válido por favor!");
            cbEstado.grabFocus();
            return false;
        }
    }

    public Boolean VerificaCidade() {
        if (cbCidades.getSelectedIndex() > 0) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe uma cidade válida por favor!");
            cbCidades.grabFocus();
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
            System.out.println("Erro");
        }
        java.awt.EventQueue.invokeLater(() -> {
            DlgCidadeAtualiza dialog = new DlgCidadeAtualiza(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAtualiza;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JComboBox cbCidades;
    private javax.swing.JComboBox cbEstado;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
