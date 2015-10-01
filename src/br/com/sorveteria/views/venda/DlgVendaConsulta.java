package br.com.sorveteria.views.venda;

import br.com.sorveteria.controllers.CabecalhoVendaController;
import br.com.sorveteria.controllers.ItensVendaController;
import br.com.sorveteria.models.CabecalhoVendaModel;
import br.com.sorveteria.models.ItemVendaModel;
import java.awt.Color;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgVendaConsulta extends javax.swing.JDialog {

    DefaultTableModel modeloVendas = new DefaultTableModel(null, new String[]{"Venda", "Data", "ID", "Cliente", "ID", "Usuário", "Observações", "Total", "Status"});
    DefaultTableModel modeloItens = new DefaultTableModel(null, new String[]{"ID", "Item", "Venda", "Produto", "Descrição", "Qtd", "Preço", "Total"});

    CabecalhoVendaController cvc = new CabecalhoVendaController();
    ItensVendaController ivc = new ItensVendaController();

    public DlgVendaConsulta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        formataVendas();
        formataItens();
        preencheTabelaVendas();
    }

    public final void formataVendas() {
        modeloVendas.setRowCount(0);
        tblVendas.setModel(modeloVendas);
        tblVendas.getColumnModel().getColumn(0).setMinWidth(50);
        tblVendas.getColumnModel().getColumn(0).setMaxWidth(50);
        tblVendas.getColumnModel().getColumn(1).setMinWidth(90);
        tblVendas.getColumnModel().getColumn(1).setMaxWidth(90);
        tblVendas.getColumnModel().getColumn(2).setMinWidth(40);
        tblVendas.getColumnModel().getColumn(2).setMaxWidth(40);
        tblVendas.getColumnModel().getColumn(4).setMinWidth(40);
        tblVendas.getColumnModel().getColumn(4).setMaxWidth(40);
        tblVendas.getColumnModel().getColumn(7).setMinWidth(80);
        tblVendas.getColumnModel().getColumn(7).setMaxWidth(80);
        tblVendas.getColumnModel().getColumn(8).setMinWidth(50);
        tblVendas.getColumnModel().getColumn(8).setMaxWidth(50);
        tblVendas.setGridColor(Color.BLACK);
        tblVendas.setShowGrid(true);
        tblVendas.setSelectionBackground(Color.LIGHT_GRAY);
    }

    public final void formataItens() {
        modeloItens.setRowCount(0);
        tblItens.setModel(modeloItens);
        tblItens.getColumnModel().getColumn(0).setMinWidth(50);
        tblItens.getColumnModel().getColumn(0).setMaxWidth(50);
        tblItens.getColumnModel().getColumn(1).setMinWidth(40);
        tblItens.getColumnModel().getColumn(1).setMaxWidth(40);
        tblItens.getColumnModel().getColumn(2).setMinWidth(60);
        tblItens.getColumnModel().getColumn(2).setMaxWidth(60);
        tblItens.getColumnModel().getColumn(3).setMinWidth(70);
        tblItens.getColumnModel().getColumn(3).setMaxWidth(70);
        tblItens.getColumnModel().getColumn(4).setMinWidth(250);
        tblItens.getColumnModel().getColumn(5).setMinWidth(90);
        tblItens.getColumnModel().getColumn(5).setMaxWidth(90);
        tblItens.getColumnModel().getColumn(6).setMinWidth(90);
        tblItens.getColumnModel().getColumn(6).setMaxWidth(90);
        tblItens.getColumnModel().getColumn(7).setMinWidth(90);
        tblItens.getColumnModel().getColumn(7).setMaxWidth(90);
        tblItens.setGridColor(Color.BLACK);
        tblItens.setShowGrid(true);
        tblItens.setSelectionBackground(Color.LIGHT_GRAY);
    }

    public final void preencheTabelaVendas() {
        List<CabecalhoVendaModel> vendas = cvc.getAll();
        if (vendas.size() > 0) {
            new Thread() {
                @Override
                public void run() {
                    modeloVendas.setRowCount(0);
                    vendas.stream().forEach((venda) -> {
                        modeloVendas.addRow(new Object[]{venda.getIdVenda(), venda.getDataVenda(), venda.getIdCliente(), venda.getNomeCliente(), venda.getIdUsuario(), venda.getNomeUsuario(), venda.getObservacoesVenda(), NumberFormat.getCurrencyInstance().format(venda.getValorTotal()), venda.getStatus()});
                    });
                    tblVendas.setModel(modeloVendas);
                }
            }.start();

        } else {
            JOptionPane.showMessageDialog(null, "Não tem vendas! Por favor efetue o lançamento de uma nova venda para continuar!");
        }
    }

    public final void preencheTabelaItens(Integer codigo) {
        List<ItemVendaModel> data = ivc.consultaPeloIdVenda(codigo);
        new Thread() {
            @Override
            public void run() {
                modeloItens.setRowCount(0);
                data.stream().forEach((i) -> {
                    //"ID","Item","Venda","Produto","Descrição","Qtd","Preço","Total"
                    modeloItens.addRow(new Object[]{i.getIdItemVenda(), i.getItem(), i.getIdVenda(), i.getIdProduto(), i.getDescricao(), i.getQuantidade(), NumberFormat.getCurrencyInstance().format(i.getPrecoVendaProduto()), NumberFormat.getCurrencyInstance().format(i.getValorTotalItem())});
                });
                tblItens.setModel(modeloItens);
            }
        }.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblVenda = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta Venda");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Consulta Venda Cadastrada");

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblItens.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblItens);

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVendas.getTableHeader().setReorderingAllowed(false);
        tblVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVendasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblVendas);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Itens da Venda");

        lblVenda.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

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
                                .addComponent(lblVenda)))
                        .addGap(0, 553, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblVenda))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(286, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVendasMouseClicked
        int linha = tblVendas.getSelectedRow();
        if (tblVendas.getSelectedRowCount() == 1) {
            int cod = Integer.parseInt(tblVendas.getValueAt(linha, 0).toString());
            lblVenda.setText(": "+tblVendas.getValueAt(linha, 0).toString());
            preencheTabelaItens(cod);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione apenas uma venda!");
        }
    }//GEN-LAST:event_tblVendasMouseClicked

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
            DlgVendaConsulta dialog = new DlgVendaConsulta(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblVenda;
    private javax.swing.JTable tblItens;
    private javax.swing.JTable tblVendas;
    // End of variables declaration//GEN-END:variables
}
