package br.com.sorveteria.views.cliente;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.sorveteria.controllers.CidadeController;
import br.com.sorveteria.controllers.ClienteController;
import br.com.sorveteria.dao.Conexao;
import br.com.sorveteria.models.CidadeModel;
import br.com.sorveteria.models.ClienteModel;
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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgClienteConsultaAtualiza extends javax.swing.JDialog {

    DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Código", "CPF", "CNPJ", "Nome", "Contato", "Email", "CEP", "Numero", "Codigo", "Cidade", "UF", "Status"});
    ClienteModel clienteModel = new ClienteModel();
    ClienteModel clienteModel2 = new ClienteModel();
    ClienteController clienteController = new ClienteController();
    CidadeModel cidadeModel = new CidadeModel();
    CidadeController cidadeController = new CidadeController();

    public DlgClienteConsultaAtualiza(java.awt.Frame parent, boolean modal) {
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
        tblCliente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        btnAtualiza = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        btnBuscaCep = new javax.swing.JButton();
        txtCep = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JTextField();
        txtNomeSelecionado = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtContato = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
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

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Atualizar Cliente Selecionado", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço do Cliente", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("CEP:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Rua:");

        txtRua.setEditable(false);
        txtRua.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtBairro.setEditable(false);
        txtBairro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Bairro:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Cidade:");

        cbCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCidadeActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Número:");

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscaCep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtBairro)
                    .addComponent(cbCidade, 0, 474, Short.MAX_VALUE)
                    .addComponent(txtRua))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscaCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel14)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtNomeSelecionado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Contato:");

        txtContato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Email:");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel15.setText("CPF:");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("CNPJ:");

        try {
            txtCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCnpj.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Nome:");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Status:");

        cbStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1" }));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setText("Código:");

        txtCodigo.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNomeSelecionado, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                            .addComponent(txtContato)
                            .addComponent(txtEmail)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNomeSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnLimpa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLimpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cancelar.png"))); // NOI18N
        btnLimpa.setText("Limpar");
        btnLimpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaActionPerformed(evt);
            }
        });

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
                .addGap(0, 494, Short.MAX_VALUE)
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

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        if (VerificaNome()) {
            PreencheTabela();
        }
    }//GEN-LAST:event_btnPesquisaActionPerformed

    public Boolean VerificaContato() {
        if (!txtContato.getText().isEmpty()) {
            clienteModel.setContatoCliente(txtContato.getText().replaceAll("'", "").trim().toUpperCase());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o contato!");
            txtContato.grabFocus();
            return false;
        }
    }

    public Boolean VerificaEmail() {
        if (!txtEmail.getText().isEmpty()) {
            if (txtEmail.getText().contains("@")) {
                clienteModel.setEmailCliente(txtEmail.getText().replaceAll("'", "").trim());
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Informe um email válido!");
                txtEmail.grabFocus();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Informe o email!");
            txtEmail.grabFocus();
            return false;
        }
    }
    private void btnAtualizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaActionPerformed
        if (VerificaCodigo()) {
            if (VerificaNomeSelecionado()) {
                if (VerificaContato()) {
                    if (VerificaEmail()) {
                        if (VerificaCEP()) {
                            if (VerificaNumero()) {
                                if (VerificaCidade()) {
                                    if (txtCpf.isEnabled()) {
                                        if (ValidaCpf()) {
                                            if (clienteController.atualiza(clienteModel)) {
                                                LimpaFormulario();
                                            }
                                        }
                                    } else if (txtCnpj.isEnabled()) {
                                        if (ValidaCnpj()) {
                                            if (clienteController.atualiza(clienteModel)) {
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
        txtContato.setText(null);
        txtEmail.setText(null);
        txtNome.grabFocus();
    }

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        new Thread() {
            @Override
            public void run() {
                if (tblCliente.getSelectedRowCount() == 1) {
                    int linha = tblCliente.getSelectedRow();
                    txtCpf.setEnabled(true);
                    txtCnpj.setEnabled(true);
                    txtCodigo.setText(tblCliente.getValueAt(linha, 0).toString());
                    if (tblCliente.getValueAt(linha, 1) == null) {
                        txtCpf.setEnabled(false);
                        txtCnpj.setText(tblCliente.getValueAt(linha, 2).toString());
                    } else if (tblCliente.getValueAt(linha, 2) == null) {
                        txtCnpj.setEnabled(false);
                        txtCpf.setText(tblCliente.getValueAt(linha, 1).toString());
                    }
                    txtNomeSelecionado.setText(tblCliente.getValueAt(linha, 3).toString());
                    txtContato.setText(tblCliente.getValueAt(linha, 4).toString());
                    txtEmail.setText(tblCliente.getValueAt(linha, 5).toString());
                    txtCep.setText(tblCliente.getValueAt(linha, 6).toString());
                    btnBuscaCepActionPerformed(null);
                    txtNumero.setText(tblCliente.getValueAt(linha, 7).toString());
                    cbStatus.setSelectedIndex(Integer.parseInt(tblCliente.getValueAt(linha, 11).toString()));
                }
            }
        }.start();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void cbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCidadeActionPerformed
        if (cbCidade.getSelectedItem() == null) {

        } else {
            String[] valores = cbCidade.getSelectedItem().toString().split(" - ");
            clienteModel.setIdCidade(Integer.parseInt(valores[0]));
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

    private void btnLimpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaActionPerformed
        LimpaFormulario();
    }//GEN-LAST:event_btnLimpaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (tblCliente.getSelectedRowCount() == 1) {
            retornaCodigo();
        }
    }//GEN-LAST:event_formWindowClosed

    public Integer retornaCodigo() {
        int linha = tblCliente.getSelectedRow();
        int cod = Integer.parseInt(tblCliente.getValueAt(linha, 0).toString());
        return cod;
    }

    public final void FormataTabela() {
        tblCliente.setModel(modelo);
        modelo.setRowCount(0);
        tblCliente.getColumnModel().getColumn(0).setMinWidth(50);
        tblCliente.getColumnModel().getColumn(0).setMaxWidth(50);
        tblCliente.getColumnModel().getColumn(1).setMinWidth(90);
        tblCliente.getColumnModel().getColumn(1).setMaxWidth(90);
        tblCliente.getColumnModel().getColumn(2).setMinWidth(110);
        tblCliente.getColumnModel().getColumn(2).setMaxWidth(110);
        tblCliente.getColumnModel().getColumn(3).setMinWidth(200);
        tblCliente.getColumnModel().getColumn(3).setMaxWidth(200);
        tblCliente.getColumnModel().getColumn(4).setMinWidth(100);
        tblCliente.getColumnModel().getColumn(4).setMaxWidth(100);
        tblCliente.getColumnModel().getColumn(5).setMinWidth(180);
        tblCliente.getColumnModel().getColumn(5).setMaxWidth(180);
        tblCliente.getColumnModel().getColumn(6).setMinWidth(70);
        tblCliente.getColumnModel().getColumn(6).setMaxWidth(70);
        tblCliente.getColumnModel().getColumn(7).setMinWidth(55);
        tblCliente.getColumnModel().getColumn(7).setMaxWidth(55);
        tblCliente.getColumnModel().getColumn(8).setMinWidth(55);
        tblCliente.getColumnModel().getColumn(8).setMaxWidth(55);
        tblCliente.getColumnModel().getColumn(9).setMinWidth(150);
        tblCliente.getColumnModel().getColumn(9).setMaxWidth(150);
        tblCliente.getColumnModel().getColumn(10).setMinWidth(30);
        tblCliente.getColumnModel().getColumn(10).setMaxWidth(30);
        tblCliente.getColumnModel().getColumn(11).setMinWidth(50);
        tblCliente.getColumnModel().getColumn(11).setMaxWidth(50);
        tblCliente.setSelectionBackground(Color.LIGHT_GRAY);
        tblCliente.setShowGrid(true);
        tblCliente.setGridColor(Color.BLACK);
    }

    public final void PreencheTabela() {
        modelo.setRowCount(0);
        tblCliente.setModel(modelo);
        List<ClienteModel> clientes = clienteController.consultaPeloNome(clienteModel2);
        if (clientes.size() > 0) {
            clientes.stream().forEach((cliente) -> {
                //"Código", "CPF", "CNPJ", "Nome", "Contato", "Email", "CEP", "Numero", "Codigo", "Cidade", "UF", "Status"
                modelo.addRow(new Object[]{cliente.getIdCliente(), cliente.getCpfCliente(), cliente.getCnpjCliente(), cliente.getNomeCliente(), cliente.getContatoCliente(), cliente.getEmailCliente(), cliente.getCepCliente(), cliente.getNumeroLogradouroCliente(), cliente.getIdCidade(), cliente.getNomeCidade(), cliente.getSiglaEstado(), cliente.getStatus()});
            });
            tblCliente.setModel(modelo);
        } else {
            JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum cliente com esse nome!");
        }
    }

    public Boolean VerificaCodigo() {
        if (!txtCodigo.getText().isEmpty()) {
            clienteModel.setIdCliente(Integer.parseInt(txtCodigo.getText()));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o cliente!");
            txtCodigo.grabFocus();
            return false;
        }
    }

    public Boolean VerificaNumero() {
        if (!txtNumero.getText().isEmpty()) {
            clienteModel.setNumeroLogradouroCliente(Integer.parseInt(txtNumero.getText()));
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o numero do endereço!");
            txtNumero.grabFocus();
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
            clienteModel2.setNomeCliente(nome.replaceAll("'", "").trim().toUpperCase());
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
            clienteModel.setNomeCliente(nome.replaceAll("'", "").trim().toUpperCase());
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o nome!");
            txtNomeSelecionado.grabFocus();
            return false;
        }
    }

    public Boolean ValidaCpf() {
        if (!txtCpf.getText().isEmpty()) {
            try {
                CPFValidator validador = new CPFValidator();
                validador.assertValid(txtCpf.getText());
                clienteModel.setCpfCliente(txtCpf.getText().trim());
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar validar o cpf!\n\n" + ex.getMessage());
                txtCpf.grabFocus();
            }
        } else {
            clienteModel.setCpfCliente(null);
            return true;
        }
        return false;
    }

    public Boolean ValidaCnpj() {
        if (!txtCnpj.getText().isEmpty()) {
            try {
                CNPJValidator validador = new CNPJValidator();
                validador.assertValid(txtCnpj.getText());
                clienteModel.setCnpjCliente(txtCnpj.getText().trim());
                return true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao tentar validar o cnpj!\n\n" + ex.getMessage());
                txtCnpj.grabFocus();
            }
        } else {
            clienteModel.setCnpjCliente(null);
            return true;
        }
        return false;
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
            clienteModel.setCepCliente(txtCep.getText());
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
                    jsonObject = (JSONObject) jSONParser.parse(ConsultaCep(clienteModel.getCepCliente()));
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
//    //---------------------------------------------------------------------

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
            DlgClienteConsultaAtualiza dialog = new DlgClienteConsultaAtualiza(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCnpj;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtContato;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeSelecionado;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables
}
