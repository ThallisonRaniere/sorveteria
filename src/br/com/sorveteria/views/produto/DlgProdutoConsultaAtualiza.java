package br.com.sorveteria.views.produto;

import br.com.sorveteria.controllers.ProdutoController;
import br.com.sorveteria.models.ProdutoModel;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgProdutoConsultaAtualiza extends javax.swing.JDialog {

    ProdutoModel produtoModel = new ProdutoModel();
    ProdutoModel produtoModel2 = new ProdutoModel();

    ProdutoController produtoController = new ProdutoController();

    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Código", "Descrição", "Saldo", "Preço", "Status"});

    public DlgProdutoConsultaAtualiza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/alterar.png")).getImage());
        initComponents();
        formataTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduto = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Consulta e Atualiza Produto");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Consulta Produto");

        tblProduto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblProduto.getTableHeader().setReorderingAllowed(false);
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduto);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/search.png"))); // NOI18N
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Código:");

        txtCodigo.setEditable(false);
        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Descrição:");

        txtDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Preço:");

        txtPreco.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Status:");

        cbStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/alterar.png"))); // NOI18N
        btnSalvar.setText("Atualizar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisa))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbStatus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        limpaFormulario();
        preencheTabela();
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (VerificaCodigo()) {
            if (VerificaDescricao()) {
                if (VerificaPreco()) {
                    produtoModel.setStatus(cbStatus.getSelectedIndex());
                    if (produtoController.atualiza(produtoModel)) {
                        limpaFormulario();
                        preencheTabela();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        new Thread() {
            @Override
            public void run() {
                if (tblProduto.getSelectedRowCount() == 1) {
                    int linha = tblProduto.getSelectedRow();
                    txtCodigo.setText(tblProduto.getValueAt(linha, 0).toString());
                    txtDescricao.setText(tblProduto.getValueAt(linha, 1).toString());
                    Double preco = Double.parseDouble(tblProduto.getValueAt(linha, 3).toString().replace("R$", " ").replace(",", ".").trim());
                    txtPreco.setText(preco.toString());
                    cbStatus.setSelectedIndex(Integer.parseInt(tblProduto.getValueAt(linha, 4).toString()));
                    txtDescricao.grabFocus();
                }
            }
        }.start();
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpaFormulario();
    }//GEN-LAST:event_btnLimparActionPerformed

    public void preencheTabela() {
        if (VerificaNome()) {
            List<ProdutoModel> produtos = produtoController.consultaPeloNome(produtoModel2);
            if (produtos.size() > 0) {
                modelo.setRowCount(0);
                produtos.stream().forEach((produto) -> {
                    modelo.addRow(new Object[]{produto.getIdProduto(), produto.getDescricao(), produto.getSaldoProduto(), NumberFormat.getCurrencyInstance().format(produto.getPrecoVendaProduto()), produto.getStatus()});
                });
                tblProduto.setModel(modelo);
            }else{
                JOptionPane.showMessageDialog(null, "Não tem produtos cadastrados com essa descrição!");
            }
        }
    }

    public Boolean VerificaCodigo() {
        if (!txtCodigo.getText().isEmpty()) {
            produtoModel.setIdProduto(Integer.parseInt(txtCodigo.getText()));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o Produto!");
            txtCodigo.grabFocus();
            return false;
        }
    }

    public Boolean VerificaNome() {
        if (!txtNome.getText().isEmpty()) {
            String nome = txtNome.getText().replaceAll("'", "").trim().toUpperCase();
            produtoModel2.setDescricao(nome.replaceAll(" ", "%"));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe a descrição do produto!");
            txtNome.grabFocus();
            return false;
        }
    }

    public Boolean VerificaDescricao() {
        if (!txtDescricao.getText().isEmpty()) {
            produtoModel.setDescricao(txtDescricao.getText().replaceAll("'", "").trim().toUpperCase());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe a descrição do produto!");
            txtDescricao.grabFocus();
            return false;
        }
    }

    public Boolean VerificaPreco() {
        if (!txtPreco.getText().isEmpty()) {
            try {
                produtoModel.setPrecoVendaProduto(Double.parseDouble(txtPreco.getText().replaceAll(",", ".")));
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Informe um valor válido, separe os centavos com um .");
                txtPreco.grabFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o preço inicial do produto!");
            txtPreco.grabFocus();
            return false;
        }
    }

    public final void limpaFormulario() {
        txtCodigo.setText(null);
        txtDescricao.setText(null);
        txtPreco.setText(null);
        cbStatus.setSelectedIndex(0);
        txtNome.grabFocus();
    }

    public final void formataTabela() {
        modelo.setRowCount(0);
        tblProduto.setModel(modelo);
        tblProduto.getColumnModel().getColumn(0).setMinWidth(50);
        tblProduto.getColumnModel().getColumn(0).setMaxWidth(50);
        tblProduto.getColumnModel().getColumn(2).setMinWidth(100);
        tblProduto.getColumnModel().getColumn(2).setMaxWidth(100);
        tblProduto.getColumnModel().getColumn(3).setMinWidth(100);
        tblProduto.getColumnModel().getColumn(3).setMaxWidth(100);
        tblProduto.getColumnModel().getColumn(4).setMinWidth(50);
        tblProduto.getColumnModel().getColumn(4).setMaxWidth(50);
        tblProduto.setGridColor(Color.BLACK);
        tblProduto.setShowGrid(true);
        tblProduto.setSelectionBackground(Color.LIGHT_GRAY);
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
            DlgProdutoConsultaAtualiza dialog = new DlgProdutoConsultaAtualiza(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
