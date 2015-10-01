package br.com.sorveteria.views.usuario;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.sorveteria.controllers.CidadeController;
import br.com.sorveteria.controllers.UsuarioController;
import br.com.sorveteria.dao.Conexao;
import br.com.sorveteria.models.CidadeModel;
import br.com.sorveteria.models.UsuarioModel;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgUsuarioConsultaAtualiza extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Código", "Nome", "CPF", "CEP", "Número", "Código", "Cidade", "Estado", "Login", "Status"});
    UsuarioModel usuarioModel = new UsuarioModel();
    UsuarioModel usuarioModel2 = new UsuarioModel();
    UsuarioController usuarioController = new UsuarioController();
    CidadeModel cidadeModel = new CidadeModel();
    CidadeController cidadeController = new CidadeController();

    public DlgUsuarioConsultaAtualiza(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/alterar.png")).getImage());
        initComponents();
        ValidaNome();
        ValidaNomeSelecionado();
        ValidaNumero();
        FormataTabela();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNomeSelecionado = new javax.swing.JTextField();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        btnBuscaCep = new javax.swing.JButton();
        txtCep = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        btnLimpa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta e Atualiza cadastro");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Consulta Usuário");

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNome.setText(" ");

        btnPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/search.png"))); // NOI18N
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        btnAtualiza.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAtualiza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/alterar.png"))); // NOI18N
        btnAtualiza.setText("Atualizar");
        btnAtualiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atualizar Usuário Selecionado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        txtCodigo.setEditable(false);

        txtLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("CPF:");

        txtSenha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setText("Nome:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Login:");

        txtCpf.setColumns(11);
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Senha:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço do Usuário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("CEP:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Rua:");

        txtRua.setEditable(false);
        txtRua.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtBairro.setEditable(false);
        txtBairro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Bairro:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Cidade:");

        cbCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCidadeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Número:");

        btnBuscaCep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/search.png"))); // NOI18N
        btnBuscaCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaCepActionPerformed(evt);
            }
        });

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscaCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addComponent(txtBairro)
                    .addComponent(cbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtRua)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscaCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel10)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setText("Código:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Status:");

        cbStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNomeSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNomeSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btnLimpa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLimpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cancelar.png"))); // NOI18N
        btnLimpa.setText("Limpar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisa)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAtualiza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpa)
                .addGap(438, 438, 438))
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
                    .addComponent(jLabel2)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualiza)
                    .addComponent(btnLimpa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCidadeActionPerformed
        if (cbCidade.getSelectedItem() == null) {

        } else {
            String[] valores = cbCidade.getSelectedItem().toString().split(" - ");
            usuarioModel.setIdCidade(Integer.parseInt(valores[0]));
        }
    }//GEN-LAST:event_cbCidadeActionPerformed

    private void btnBuscaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCepActionPerformed
        if (VerificaCEP()) {
            try {
                PreencheEndereco();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Sua conexão com a internet está desabilitada!");
            }
        }
    }//GEN-LAST:event_btnBuscaCepActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        if (VerificaNome()) {
            PreencheTabela();
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
        if (VerificaCodigo()) {
            if (VerificaNomeSelecionado()) {
                if (VerificaCpf()) {
                    if (VerificaCEP()) {
                        if (VerificaNumero()) {
                            if (VerificaCidade()) {
                                if (VerificaLogin()) {
                                    if (VerificaSenha()) {
                                        usuarioModel.setStatus(Integer.parseInt(cbStatus.getSelectedItem().toString()));
                                        if (usuarioController.atualiza(usuarioModel)) {
                                            LimpaFormulario();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAtualizaActionPerformed

    public final void LimpaFormulario() {
        FormataTabela();
        txtNome.setText(null);
        txtNomeSelecionado.setText(null);
        txtCodigo.setText(null);
        txtCpf.setText(null);
        txtCep.setText(null);
        txtNumero.setText(null);
        txtRua.setText(null);
        txtBairro.setText(null);
        cbCidade.removeAllItems();
        txtLogin.setText(null);
        txtSenha.setText(null);
        txtNome.grabFocus();

    }

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        if (tblUsuarios.getSelectedRowCount() == 1) {
            //{"Código", "Nome", "CPF", "CEP", "Número", "Código", "Cidade", "Estado", "Login", "Status"});
            new Thread() {
                @Override
                public void run() {
                    int linha = tblUsuarios.getSelectedRow();
                    txtCodigo.setText(tblUsuarios.getValueAt(linha, 0).toString());
                    txtNomeSelecionado.setText(tblUsuarios.getValueAt(linha, 1).toString());
                    txtCpf.setText(tblUsuarios.getValueAt(linha, 2).toString());
                    txtCep.setText(tblUsuarios.getValueAt(linha, 3).toString());
                    btnBuscaCepActionPerformed(null);
                    txtNumero.setText(tblUsuarios.getValueAt(linha, 4).toString());
                    txtLogin.setText(tblUsuarios.getValueAt(linha, 8).toString());
                    cbStatus.setSelectedIndex(Integer.parseInt(tblUsuarios.getValueAt(linha, 9).toString()));
                }
            }.start();
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (tblUsuarios.getSelectedRowCount() == 1) {
            retornaCodigo();
        }
    }//GEN-LAST:event_formWindowClosed

    public Integer retornaCodigo() {
        int linha = tblUsuarios.getSelectedRow();
        int cod = Integer.parseInt(tblUsuarios.getValueAt(linha, 0).toString());
        return cod;
    }

    public final void FormataTabela() {
        tblUsuarios.setModel(modelo);
        modelo.setRowCount(0);
        tblUsuarios.getColumnModel().getColumn(0).setMaxWidth(50);
        tblUsuarios.getColumnModel().getColumn(1).setMinWidth(300);
        tblUsuarios.getColumnModel().getColumn(2).setMinWidth(70);
        tblUsuarios.getColumnModel().getColumn(3).setMaxWidth(70);
        tblUsuarios.getColumnModel().getColumn(4).setMaxWidth(55);
        tblUsuarios.getColumnModel().getColumn(5).setMaxWidth(50);
        tblUsuarios.getColumnModel().getColumn(6).setMinWidth(150);
        tblUsuarios.getColumnModel().getColumn(7).setMaxWidth(50);
        tblUsuarios.getColumnModel().getColumn(8).setMinWidth(120);
        tblUsuarios.getColumnModel().getColumn(9).setMaxWidth(50);
        tblUsuarios.setSelectionBackground(Color.LIGHT_GRAY);
        tblUsuarios.setShowGrid(true);
        tblUsuarios.setGridColor(Color.BLACK);
    }

    public final void PreencheTabela() {
        modelo.setRowCount(0);
        tblUsuarios.setModel(modelo);
        List<UsuarioModel> usuarios = usuarioController.consultaPeloNome(usuarioModel2);
        if (usuarios.size() > 0) {
            usuarios.stream().forEach((usuario) -> {
                modelo.addRow(new Object[]{usuario.getIdUsuario(), usuario.getNomeUsuario(), usuario.getCpfUsuario(), usuario.getCepUsuario(), usuario.getNumeroLogradouroUsuario(), usuario.getIdCidade(), usuario.getNomeCidade(), usuario.getSiglaEstado(), usuario.getLoginUsuario(), usuario.getStatus()});
            });
            tblUsuarios.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum usuário com esse nome!");
        }
    }

    public Boolean VerificaCodigo() {
        if (!txtCodigo.getText().isEmpty()) {
            usuarioModel.setIdUsuario(Integer.parseInt(txtCodigo.getText()));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o usuário!");
            txtCodigo.grabFocus();
            return false;
        }
    }

    public Boolean VerificaNumero() {
        if (!txtNumero.getText().isEmpty()) {
            usuarioModel.setNumeroLogradouroUsuario(Integer.parseInt(txtNumero.getText()));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o numero do endereço!");
            txtNumero.grabFocus();
            return false;
        }
    }

    public Boolean VerificaLogin() {
        if (!txtLogin.getText().isEmpty()) {
            if (!usuarioController.verificaLogin(txtLogin.getText(), usuarioModel.getIdUsuario())) {
                usuarioModel.setLoginUsuario(txtLogin.getText().replaceAll("'", "").trim());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Esse login já está sendo usado! Informe um login válido por favor!");
                txtLogin.grabFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o Login por favor!");
            txtLogin.grabFocus();
            return false;
        }
    }

    public Boolean VerificaSenha() {
        if (!txtSenha.getText().isEmpty()) {
            usuarioModel.setSenhaUsuario(DigestUtils.md5Hex(txtSenha.getText()));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe a senha por favor!");
            txtSenha.grabFocus();
            return false;
        }
    }

    public Boolean VerificaCidade() {
        if (cbCidade.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Por favor selecione uma cidade válida!");
            cbCidade.grabFocus();
            return false;
        } else {

            return true;
        }
    }

    public Boolean VerificaNome() {
        if (!txtNome.getText().isEmpty()) {
            String nome = txtNome.getText().replaceAll(" ", "%");
            usuarioModel2.setNomeUsuario(nome.replaceAll("'", "").trim().toUpperCase());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o Nome!");
            txtNome.grabFocus();
            return false;
        }
    }

    public Boolean VerificaNomeSelecionado() {
        if (!txtNomeSelecionado.getText().isEmpty()) {
            String nome = txtNomeSelecionado.getText();
            usuarioModel.setNomeUsuario(nome.replaceAll("'", "").trim().toUpperCase());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o nome!");
            txtNomeSelecionado.grabFocus();
            return false;
        }
    }

    public Boolean VerificaCpf() {
        if (!txtCpf.getText().isEmpty()) {
            try {
                CPFValidator validador = new CPFValidator();
                validador.assertValid(txtCpf.getText());
                usuarioModel.setCpfUsuario(txtCpf.getText().trim());
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar validar o cpf!\n\n" + ex.getMessage());
                txtCpf.grabFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o cpf!");
            txtCpf.grabFocus();
            return false;
        }
    }

    public final void ValidaNome() {
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNome.setText(txtNome.getText().replaceAll("[^a-zA-Z\\u00C0-\\u00FF ]", ""));
            }

        });
    }

    public final void ValidaNomeSelecionado() {
        txtNomeSelecionado.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeSelecionado.setText(txtNomeSelecionado.getText().replaceAll("[^a-zA-Z\\u00C0-\\u00FF ]", ""));
            }

        });
    }

    public final void ValidaNumero() {
        txtNumero.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumero.setText(txtNumero.getText().replaceAll("[^0-9]", ""));
            }

        });
    }

    public Boolean VerificaCEP() {
        if (!txtCep.getText().isEmpty() && !txtCep.getText().contains(" ")) {
            usuarioModel.setCepUsuario(txtCep.getText());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o CEP!");
            txtCep.grabFocus();
            return false;
        }
    }

    //---------------------Consulta CEP -----------------------------------
    public String ConsultaCep(String CEP) {
        try {
            URL url = new URL("http://viacep.com.br/ws/" + CEP + "/json/");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String retorno;
            StringBuilder builder = new StringBuilder();
            while ((retorno = bufferedReader.readLine()) != null) {
                builder.append(retorno);
            }
            bufferedReader.close();
            return builder.toString();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar consultar o cep informado! Obs> Verifique a conexão com a internet, é obrigatório!!!!\n\n" + ex.getMessage());
        }
        return null;
    }

    public void PreencheEndereco() throws IOException {
        JSONObject jsonObject;
        JSONParser jSONParser = new JSONParser();
        try {
            URL url = new URL("http://www.google.com");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.connect();
            int cod = http.getResponseCode();
            if (cod == 200) {
                try {
                    jsonObject = (JSONObject) jSONParser.parse(ConsultaCep(usuarioModel.getCepUsuario()));
                    String rua = String.valueOf(jsonObject.get("logradouro"));
                    String bairro = String.valueOf(jsonObject.get("bairro"));
                    String cidade = String.valueOf(jsonObject.get("localidade"));
                    if (rua == null) {
                        JOptionPane.showMessageDialog(null, "A rua não foi encontrada!");
                    } else {
                        txtRua.setText(rua);
                    }
                    if (bairro == null) {
                        JOptionPane.showMessageDialog(null, "O bairro não foi encontrado!");
                    } else {
                        txtBairro.setText(bairro);
                    }
                    if (cidade == null) {
                        JOptionPane.showMessageDialog(null, "A cidade não foi encontrada!");
                    } else {
                        cidadeModel.setNomeCidade(cidade);
                        PreencheCbCidades();
                    }
                } catch (ParseException | HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, "Erro!\n\n" + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique sua internet!");
            }
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Sua conexão com a internet está desabilitada!");
        }
    }

    //---------------------------------------------------------------------
    //---------------------Preencher Cidade-------------------
    public final void PreencheCbCidades() {
        try {
            if (Conexao.TestaConexao()) {
                List<CidadeModel> cidades = new ArrayList<>();
                cidades.clear();
                cbCidade.removeAllItems();
                cbCidade.addItem(null);
                cidades = cidadeController.getCidadesEstado(cidadeModel);
                for (CidadeModel cidade : cidades) {
                    cbCidade.addItem(cidade.getIdCidade() + " - " + cidade.getNomeCidade() + " - " + cidade.getSiglaEstado() + " - " + cidade.getStatus());
                }
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro");
        }
    }
    //---------------------------------------------------------------------

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
            DlgUsuarioConsultaAtualiza dialog = new DlgUsuarioConsultaAtualiza(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnBuscaCep;
    private javax.swing.JButton btnLimpa;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JComboBox cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeSelecionado;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
