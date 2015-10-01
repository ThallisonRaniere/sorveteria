package br.com.sorveteria.views.venda;

import br.com.sorveteria.controllers.CabecalhoVendaController;
import br.com.sorveteria.models.CabecalhoVendaModel;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgVendasAbertas extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Venda", "Data", "ID", "Cliente", "Id", "Usuário", "Observações"});
    CabecalhoVendaController cvc = new CabecalhoVendaController();

    public DlgVendasAbertas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/consultas.png")).getImage());
        formataTabela();
        preencheTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendasAbertas = new javax.swing.JTable();
        btnAvancar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Listagem Vendas Abertas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Selecione uma venda aberta para adicionar itens");

        tblVendasAbertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVendasAbertas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblVendasAbertas);

        btnAvancar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/ok.png"))); // NOI18N
        btnAvancar.setText("Avançar");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(322, 322, 322)
                .addComponent(btnAvancar)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAvancar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //
    }//GEN-LAST:event_formWindowOpened

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed
        if (tblVendasAbertas.getSelectedRowCount() == 1) {
            int linha = tblVendasAbertas.getSelectedRow();
            Integer codVenda = Integer.parseInt(tblVendasAbertas.getValueAt(linha, 0).toString());
            DlgVendaAdicionaItens dlgVendaAdicionaItens = new DlgVendaAdicionaItens(null, rootPaneCheckingEnabled);
            dlgVendaAdicionaItens.numeroVendaSelecionada = codVenda;
            dlgVendaAdicionaItens.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor selecione uma venda em aberto para adicionar itens!");
        }
    }//GEN-LAST:event_btnAvancarActionPerformed

    public final void formataTabela() {
        modelo.setRowCount(0);
        tblVendasAbertas.setModel(modelo);
        tblVendasAbertas.getColumnModel().getColumn(0).setMinWidth(50);
        tblVendasAbertas.getColumnModel().getColumn(0).setMaxWidth(50);
        tblVendasAbertas.getColumnModel().getColumn(1).setMinWidth(90);
        tblVendasAbertas.getColumnModel().getColumn(1).setMaxWidth(90);
        tblVendasAbertas.getColumnModel().getColumn(2).setMinWidth(40);
        tblVendasAbertas.getColumnModel().getColumn(2).setMaxWidth(40);
        tblVendasAbertas.getColumnModel().getColumn(4).setMinWidth(40);
        tblVendasAbertas.getColumnModel().getColumn(4).setMaxWidth(40);
        tblVendasAbertas.setGridColor(Color.BLACK);
        tblVendasAbertas.setShowGrid(true);
        tblVendasAbertas.setSelectionBackground(Color.LIGHT_GRAY);
    }

    public final void preencheTabela() {
        List<CabecalhoVendaModel> vendas = cvc.getVendasAbertas();
        if (vendas.size() > 0) {
            modelo.setRowCount(0);
            vendas.stream().forEach((venda) -> {
                modelo.addRow(new Object[]{venda.getIdVenda(), venda.getDataVenda(), venda.getIdCliente(), venda.getNomeCliente(), venda.getIdUsuario(), venda.getNomeUsuario(), venda.getObservacoesVenda()});
            });
            tblVendasAbertas.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "Não tem vendas em aberto! Por favor efetue o lançamento de uma nova venda para continuar!");
            this.dispose();
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
            DlgVendasAbertas dialog = new DlgVendasAbertas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAvancar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblVendasAbertas;
    // End of variables declaration//GEN-END:variables
}
