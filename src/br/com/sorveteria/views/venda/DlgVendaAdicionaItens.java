package br.com.sorveteria.views.venda;

import br.com.sorveteria.controllers.CabecalhoVendaController;
import br.com.sorveteria.controllers.ItensVendaController;
import br.com.sorveteria.dao.ProdutoDAO;
import br.com.sorveteria.models.CabecalhoVendaModel;
import br.com.sorveteria.models.ItemVendaModel;
import br.com.sorveteria.models.ProdutoModel;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgVendaAdicionaItens extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"CodProd", "Descricao", "Qtd", "Preco", "VlrTotalItem"});
    ItemVendaModel itemVendaModel = new ItemVendaModel();
    ItensVendaController ivc = new ItensVendaController();
    ProdutoModel produtoModel = new ProdutoModel();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    CabecalhoVendaModel cvm = new CabecalhoVendaModel();
    CabecalhoVendaController cvc = new CabecalhoVendaController();

    Integer cod;
    String descricao;
    Double valor;
    Double quantidade;
    Double valorTotal;
    List<Double> totais = new ArrayList<>();

    public Integer numeroVendaSelecionada;

    public DlgVendaAdicionaItens(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ValidaCodigo();
        formataTabela();
        imprimeTotal();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        lblCodigoVenda = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtValorTotal = new javax.swing.JTextField();
        btnAdiciona = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCarrinho = new javax.swing.JTable();
        btnFinaliza = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Adiciona Itens Venda");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Adicionar itens");

        jLabel2.setText("Código da Venda:");

        lblCodigoVenda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCodigoVenda.setText(".");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Código:");

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Descrição:");

        txtDescricao.setEditable(false);
        txtDescricao.setBackground(new java.awt.Color(255, 255, 85));
        txtDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Saldo:");

        txtSaldo.setEditable(false);
        txtSaldo.setBackground(new java.awt.Color(255, 255, 85));
        txtSaldo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Valor:");

        txtValor.setEditable(false);
        txtValor.setBackground(new java.awt.Color(255, 255, 85));
        txtValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Quantidade:");

        txtQuantidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantidadeKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Valor Total:");

        txtValorTotal.setEditable(false);
        txtValorTotal.setBackground(new java.awt.Color(255, 255, 85));
        txtValorTotal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        btnAdiciona.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdiciona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/vendas.png"))); // NOI18N
        btnAdiciona.setText("Adicionar Item");
        btnAdiciona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionaActionPerformed(evt);
            }
        });

        btnRemove.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/deletar.png"))); // NOI18N
        btnRemove.setText("Remover Item");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel9.setText("Valor Total:");

        lblValorTotal.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblValorTotal.setText(".");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carrinho", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14))); // NOI18N

        tblCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCarrinho.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCarrinho);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnFinaliza.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnFinaliza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/Cifrao.png"))); // NOI18N
        btnFinaliza.setText("Finalizar Venda");
        btnFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Pressione enter!!!!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10))
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnAdiciona)
                                .addGap(4, 4, 4)
                                .addComponent(btnRemove))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCodigoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnFinaliza, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1113, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblCodigoVenda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdiciona)
                            .addComponent(btnRemove))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(lblValorTotal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFinaliza))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public final void formataTabela() {
        modelo.setRowCount(0);
        tblCarrinho.setDragEnabled(false);
        tblCarrinho.setModel(modelo);
        tblCarrinho.getColumnModel().getColumn(0).setMinWidth(70);
        tblCarrinho.getColumnModel().getColumn(0).setMaxWidth(70);
        tblCarrinho.getColumnModel().getColumn(1).setMinWidth(200);
        tblCarrinho.getColumnModel().getColumn(2).setMinWidth(70);
        tblCarrinho.getColumnModel().getColumn(2).setMaxWidth(70);
        tblCarrinho.getColumnModel().getColumn(3).setMinWidth(70);
        tblCarrinho.getColumnModel().getColumn(3).setMaxWidth(70);
        tblCarrinho.getColumnModel().getColumn(4).setMinWidth(90);
        tblCarrinho.getColumnModel().getColumn(4).setMaxWidth(90);
        tblCarrinho.setShowGrid(true);
        tblCarrinho.setGridColor(Color.BLACK);
        tblCarrinho.setSelectionBackground(Color.GRAY);
        txtCodigo.grabFocus();
    }

    public void limpaFormulario() {
        txtDescricao.setText(null);
        txtSaldo.setText(null);
        txtValor.setText(null);
        txtQuantidade.setText(null);
        txtValorTotal.setText(null);
        txtCodigo.grabFocus();
    }

    public void preencheCampos() {
        limpaFormulario();
        if (VerificaCodigo()) {
            List<ProdutoModel> produto = produtoDAO.consultaPeloID(produtoModel);
            if (produto.size() == 1) {
                produto.stream().map((p) -> {
                    txtDescricao.setText(p.getDescricao());
                    return p;
                }).map((p) -> {
                    txtSaldo.setText(p.getSaldoProduto().toString());
                    return p;
                }).map((p) -> {
                    txtValor.setText(p.getPrecoVendaProduto().toString());
                    return p;
                }).forEach((_item) -> {
                    txtQuantidade.grabFocus();
                });
            } else {
                JOptionPane.showMessageDialog(null, "Não tem esse produto cadastrado!");
                txtCodigo.setText(null);
                txtCodigo.grabFocus();
            }
        }
    }

    List<ItemVendaModel> itens = new ArrayList<>();

    public List<ItemVendaModel> preparaItensVenda() {
        itens.clear();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            //"CodProd", "Descricao", "Qtd", "Preco", "VlrTotalItem"
            ItemVendaModel item = new ItemVendaModel();
            item.setItem(i + 1);
            item.setIdVenda(numeroVendaSelecionada);
            item.setIdProduto(Integer.parseInt(modelo.getValueAt(i, 0).toString()));
            item.setQuantidade(Double.parseDouble(modelo.getValueAt(i, 2).toString().replaceAll(",", ".")));
            item.setPrecoVendaProduto(Double.parseDouble(modelo.getValueAt(i, 3).toString().replaceAll(",", ".")));
            item.setValorTotalItem(Double.parseDouble(modelo.getValueAt(i, 4).toString().replaceAll(",", ".")));
            itens.add(item);
        }
        return itens;
    }

    public void imprime() {
        for (ItemVendaModel i : itens) {
            System.out.println(i.getItem() + " " + i.getIdVenda() + " " + i.getIdProduto() + " " + i.getQuantidade() + " " + i.getPrecoVendaProduto() + " " + i.getValorTotalItem());
        }
        System.out.println("Valor Total: " + imprimeTotal());
    }


    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblCodigoVenda.setText(numeroVendaSelecionada.toString());
    }//GEN-LAST:event_formWindowOpened

    private void btnFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaActionPerformed
        List<ItemVendaModel> data = preparaItensVenda();
        if (data.size() > 0) {
            ivc.cadastraItensVenda(data);
            cvm.setIdVenda(numeroVendaSelecionada);
            cvm.setValorTotal(imprimeTotal());
            cvc.finalizaVenda(cvm);
            this.dispose();
        }
    }//GEN-LAST:event_btnFinalizaActionPerformed

    private void txtCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            preencheCampos();
        }
    }//GEN-LAST:event_txtCodigoKeyPressed

    private void txtQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantidadeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (VerificaQuantidade()) {
                Double valorRec = Double.parseDouble(txtValor.getText());
                valorTotal = valorRec * quantidade;
                txtValorTotal.setText(String.format("%.2f", valorTotal));
            }
        }
    }//GEN-LAST:event_txtQuantidadeKeyPressed

    public final Double imprimeTotal() {
        Double Total = 0.0;
        for (Double total : totais) {
            Total += total;
        }
        lblValorTotal.setText(NumberFormat.getCurrencyInstance().format(Total));
        return Total;
    }


    private void btnAdicionaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionaActionPerformed
        if (VerificaCodigo()) {
            if (VerificaQuantidade()) {
                if (VerificaValorTotal()) {
                    modelo.addRow(new Object[]{produtoModel.getIdProduto(), txtDescricao.getText(), quantidade, txtValor.getText(), String.format("%.2f", valorTotal)});
                    totais.add(valorTotal);
                    imprimeTotal();
                    limpaFormulario();
                    txtCodigo.setText(null);
                    txtCodigo.grabFocus();
                }
            }
        }
    }//GEN-LAST:event_btnAdicionaActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        if (tblCarrinho.getSelectedRowCount() == 1) {
            int linha = tblCarrinho.getSelectedRow();
            Double valSelec = Double.parseDouble(tblCarrinho.getValueAt(linha, 4).toString().replaceAll(",", "."));
            totais.add(valSelec * -1);
            modelo.removeRow(linha);
            imprimeTotal();
            System.out.println(totais);
        } else {
            JOptionPane.showMessageDialog(null, "Para excluir um produto deverá selecionar o produto na tabela!");
            tblCarrinho.grabFocus();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Erro nimbus!");
        }
        java.awt.EventQueue.invokeLater(() -> {
            DlgVendaAdicionaItens dialog = new DlgVendaAdicionaItens(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAdiciona;
    private javax.swing.JButton btnFinaliza;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCodigoVenda;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JTable tblCarrinho;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValorTotal;
    // End of variables declaration//GEN-END:variables

    public Boolean VerificaCodigo() {
        if (!txtCodigo.getText().isEmpty()) {
            produtoModel.setIdProduto(Integer.parseInt(txtCodigo.getText().trim()));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o código!");
            txtCodigo.grabFocus();
            return false;
        }
    }

    public final void ValidaCodigo() {
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigo.setText(txtCodigo.getText().replaceAll("[^0-9]", ""));
            }

        });
    }

    public Boolean VerificaQuantidade() {
        if (!txtQuantidade.getText().isEmpty()) {
            try {
                Double qtd = Double.parseDouble(txtQuantidade.getText().replaceAll(",", ".").trim());
                if (qtd > 0) {
                    quantidade = qtd;
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Informe uma quantidade válida!");
                    return false;
                }
            } catch (NumberFormatException | HeadlessException e) {
                JOptionPane.showMessageDialog(null, "Informe uma quantidade válida!\n\n" + e.getMessage());
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe uma quantidade válida!");
            txtQuantidade.grabFocus();
            return false;
        }
    }

    public Boolean VerificaValorTotal() {
        if (!txtValorTotal.getText().isEmpty()) {

            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe a quantidade e pressione enter!");
            txtQuantidade.grabFocus();
            return false;
        }
    }

}
