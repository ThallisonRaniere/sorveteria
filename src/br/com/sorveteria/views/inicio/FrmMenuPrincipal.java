package br.com.sorveteria.views.inicio;

import br.com.sorveteria.dao.Conexao;
import br.com.sorveteria.views.cidade.DlgCidadeAtualiza;
import br.com.sorveteria.views.cidade.DlgCidadeCadastro;
import br.com.sorveteria.views.cidade.DlgCidadeConsulta;
import br.com.sorveteria.views.cliente.DlgClienteCadastro;
import br.com.sorveteria.views.cliente.DlgClienteConsultaAtualiza;
import br.com.sorveteria.views.estado.DlgEstadoAtualiza;
import br.com.sorveteria.views.estado.DlgEstadoCadastro;
import br.com.sorveteria.views.estado.DlgEstadoConsulta;
import br.com.sorveteria.views.produto.DlgProdutoCadastro;
import br.com.sorveteria.views.produto.DlgProdutoConsultaAtualiza;
import br.com.sorveteria.views.produto.DlgProdutoEntrada;
import br.com.sorveteria.views.usuario.DlgUsuarioCadastro;
import br.com.sorveteria.views.usuario.DlgUsuarioConsultaAtualiza;
import br.com.sorveteria.views.venda.DlgVendaConsulta;
import br.com.sorveteria.views.venda.DlgVendaCabecalho;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    public FrmMenuPrincipal() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/aplicacao.png")).getImage());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Principal do Sistema");

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png"))); // NOI18N
        jMenu1.setText("Cadastros");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/estado.png"))); // NOI18N
        jMenu6.setText("Estado");
        jMenu6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png"))); // NOI18N
        jMenuItem1.setText("Cadastra");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/alterar.png"))); // NOI18N
        jMenuItem3.setText("Atualiza");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem3);

        jMenu1.add(jMenu6);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cidade.png"))); // NOI18N
        jMenu8.setText("Cidade");
        jMenu8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png"))); // NOI18N
        jMenuItem5.setText("Cadastra");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/alterar.png"))); // NOI18N
        jMenuItem6.setText("Atualiza");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem6);

        jMenu1.add(jMenu8);

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/Usuario.png"))); // NOI18N
        jMenu9.setText("Usuário");
        jMenu9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png"))); // NOI18N
        jMenuItem8.setText("Cadastro");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem8);

        jMenuItem10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/alterar.png"))); // NOI18N
        jMenuItem10.setText("Atualiza");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem10);

        jMenu1.add(jMenu9);

        jMenu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cliente.png"))); // NOI18N
        jMenu10.setText("Cliente");
        jMenu10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png"))); // NOI18N
        jMenuItem11.setText("Cadastro");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem11);

        jMenu1.add(jMenu10);

        jMenu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/produto.png"))); // NOI18N
        jMenu11.setText("Produto");
        jMenu11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png"))); // NOI18N
        jMenuItem13.setText("Cadastro");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem13);

        jMenuItem16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png"))); // NOI18N
        jMenuItem16.setText("Entrada");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem16);

        jMenu1.add(jMenu11);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/consultas.png"))); // NOI18N
        jMenu2.setText("Consultas");
        jMenu2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/estado.png"))); // NOI18N
        jMenuItem4.setText("Estados");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cidade.png"))); // NOI18N
        jMenuItem7.setText("Cidades");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/Usuario.png"))); // NOI18N
        jMenuItem9.setText("Usuários");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cliente.png"))); // NOI18N
        jMenuItem12.setText("Clientes");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/produto.png"))); // NOI18N
        jMenuItem14.setText("Produtos");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/vendas.png"))); // NOI18N
        jMenu3.setText("Vendas");
        jMenu3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png"))); // NOI18N
        jMenuItem15.setText("Lançamento");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem15);

        jMenuItem18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/consultas.png"))); // NOI18N
        jMenuItem18.setText("Consulta");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem18);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/iconesistema.png"))); // NOI18N
        jMenu4.setText("Sistema");
        jMenu4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenuItem17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/backup.png"))); // NOI18N
        jMenuItem17.setText("Backup Base de dados");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        jMenuBar1.add(jMenu4);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/sair.png"))); // NOI18N
        jMenu7.setText("Sair");
        jMenu7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenu7MousePressed(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgEstadoCadastro dlgEstadoCadastro = new DlgEstadoCadastro(this, rootPaneCheckingEnabled);
                dlgEstadoCadastro.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgEstadoAtualiza dlgEstadoAtualiza = new DlgEstadoAtualiza(this, rootPaneCheckingEnabled);
                dlgEstadoAtualiza.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MousePressed
        int res = JOptionPane.showConfirmDialog(null, "Deseja realmente sair do sistema", "Sair do sistema", JOptionPane.YES_NO_CANCEL_OPTION);
        if (res == 0) {
            System.exit(0);
        } else {

        }
    }//GEN-LAST:event_jMenu7MousePressed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgEstadoConsulta dlgEstadoConsulta = new DlgEstadoConsulta(this, rootPaneCheckingEnabled);
                dlgEstadoConsulta.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgCidadeCadastro dlgCidadeCadastro = new DlgCidadeCadastro(this, rootPaneCheckingEnabled);
                dlgCidadeCadastro.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgCidadeAtualiza dlgCidadeAtualiza = new DlgCidadeAtualiza(this, rootPaneCheckingEnabled);
                dlgCidadeAtualiza.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgCidadeConsulta dlgCidadeConsulta = new DlgCidadeConsulta(this, rootPaneCheckingEnabled);
                dlgCidadeConsulta.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgUsuarioCadastro dlgCadastroUsuario = new DlgUsuarioCadastro(this, rootPaneCheckingEnabled);
                dlgCadastroUsuario.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgUsuarioConsultaAtualiza dlgConsultaAtualizaUsuario = new DlgUsuarioConsultaAtualiza(this, rootPaneCheckingEnabled);
                dlgConsultaAtualizaUsuario.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgUsuarioConsultaAtualiza dlgConsultaAtualizaUsuario = new DlgUsuarioConsultaAtualiza(this, rootPaneCheckingEnabled);
                dlgConsultaAtualizaUsuario.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgClienteCadastro dlgClienteCadastro = new DlgClienteCadastro(this, rootPaneCheckingEnabled);
                dlgClienteCadastro.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgClienteConsultaAtualiza dlgClienteConsultaAtualiza = new DlgClienteConsultaAtualiza(this, rootPaneCheckingEnabled);
                dlgClienteConsultaAtualiza.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgProdutoCadastro dlgProdutoCadastro = new DlgProdutoCadastro(this, rootPaneCheckingEnabled);
                dlgProdutoCadastro.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgProdutoConsultaAtualiza dlgProdutoConsultaAtualiza = new DlgProdutoConsultaAtualiza(this, rootPaneCheckingEnabled);
                dlgProdutoConsultaAtualiza.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgVendaCabecalho dlgVendaCabecalho = new DlgVendaCabecalho(this, rootPaneCheckingEnabled);
                dlgVendaCabecalho.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgProdutoEntrada dlgProdutoEntrada = new DlgProdutoEntrada(this, rootPaneCheckingEnabled);
                dlgProdutoEntrada.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                if (Conexao.backup()) {
                    JOptionPane.showMessageDialog(null, "Backup gerado com sucesso!");
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        try {
            if (Conexao.TestaConexao()) {
                DlgVendaConsulta dlgConsultaVenda = new DlgVendaConsulta(this, rootPaneCheckingEnabled);
                dlgConsultaVenda.setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            System.out.println("Erro nimbus");
        }
        java.awt.EventQueue.invokeLater(() -> {
            new FrmMenuPrincipal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
