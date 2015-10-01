package br.com.sorveteria.views.cidade;

import br.com.sorveteria.controllers.CidadeController;
import br.com.sorveteria.dao.CidadeDAO;
import br.com.sorveteria.dao.Conexao;
import br.com.sorveteria.models.CidadeModel;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgCidadeConsulta extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Código", "Nome", "Estado", "Status"});
    CidadeModel cidadeModel = new CidadeModel();
    CidadeDAO cidadeDAO = new CidadeDAO();
    CidadeController cidadeController = new CidadeController();

    public DlgCidadeConsulta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/consultas.png")).getImage());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnConsulta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCidades = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form de Consulta de cidades cadastradas");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Consulta de Cidades Cadastradas");

        jLabel2.setText("Nome:");

        btnConsulta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/pesquisar.png"))); // NOI18N
        btnConsulta.setText("Consultar");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        tblCidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCidades.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCidades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btnConsulta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                PreencheTabela();
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_btnConsultaActionPerformed

    public void FormataTabela() {
        tblCidades.setModel(modelo);
        tblCidades.setSelectionBackground(Color.LIGHT_GRAY);
        tblCidades.setShowGrid(true);
    }

    public Boolean VerificaNome() {
        if (!txtNome.getText().isEmpty()) {
            String nome = txtNome.getText().replaceAll("'", "").trim().toUpperCase();
            cidadeModel.setNomeCidade(nome.replaceAll(" ", "%"));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o nome da cidade por favor!");
            txtNome.grabFocus();
            return false;
        }
    }

    public void PreencheTabela() {
        modelo.setRowCount(0);
        FormataTabela();
        if (VerificaNome()) {
            List<CidadeModel> cidades = cidadeController.getCidadesEstado(cidadeModel);
            if (cidades.size() <= 0) {
                JOptionPane.showMessageDialog(null, "A pesquisa não encontrou nenhuma cidade!");
            } else {
                cidades.stream().forEach((cidade) -> {
                    modelo.addRow(new Object[]{cidade.getIdCidade(), cidade.getNomeCidade(), cidade.getSiglaEstado(), cidade.getStatus()});
                });
                tblCidades.setModel(modelo);
            }
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
            DlgCidadeConsulta dialog = new DlgCidadeConsulta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblCidades;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
