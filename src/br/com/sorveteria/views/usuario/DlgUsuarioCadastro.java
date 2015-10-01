package br.com.sorveteria.views.usuario;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.sorveteria.controllers.CidadeController;
import br.com.sorveteria.controllers.UsuarioController;
import br.com.sorveteria.dao.Conexao;
import br.com.sorveteria.models.CidadeModel;
import br.com.sorveteria.models.UsuarioModel;
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
import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Lucas Pereira - Thallison Raniere
 */
public class DlgUsuarioCadastro extends javax.swing.JDialog {

    UsuarioModel usuarioModel = new UsuarioModel();
    UsuarioController usuarioController = new UsuarioController();
    CidadeController cidadeController = new CidadeController();
    CidadeModel cidadeModel = new CidadeModel();

    public DlgUsuarioCadastro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setIconImage(new ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cadastro.png")).getImage());
        initComponents();
        ValidaNome();
        ValidaNumero();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbCidade = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        btnBuscaCep = new javax.swing.JButton();
        txtCep = new javax.swing.JFormattedTextField();
        txtNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        txtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Cadastro de Usuário");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Cadastro de Usuário");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("CPF:");

        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço do Usuário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("CEP:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Rua:");

        txtRua.setEditable(false);
        txtRua.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtBairro.setEditable(false);
        txtBairro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Bairro:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Cidade:");

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
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscaCep)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumero))
                            .addComponent(txtRua, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                            .addComponent(txtBairro))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(0, 66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscaCep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel10)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Login:");

        txtLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setText("Senha:");

        btnSalvar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/gravar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sorveteria/views/icones/cancelar.png"))); // NOI18N
        btnLimpar.setText("Limpar");

        txtCpf.setColumns(11);
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 256, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(btnSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscaCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaCepActionPerformed
        if (VerificaCEP()) {
            try {
                PreencheEndereco();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Sua conexão com a internet está desabilitada!");
            }
        }
    }//GEN-LAST:event_btnBuscaCepActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (VerificaNome()) {
            if (VerificaCpf()) {
                if (VerificaCEP()) {
                    if (VerificaCidade()) {
                        if (VerificaLogin()) {
                            if (VerificaSenha()) {
                                if (VerificaNumero()) {
                                    if (usuarioController.cadastra(usuarioModel)) {
                                        LimpaFormulario();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void cbCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCidadeActionPerformed
        if (cbCidade.getSelectedItem() == null) {

        } else {
            String[] valores = cbCidade.getSelectedItem().toString().split(" - ");
            usuarioModel.setIdCidade(Integer.parseInt(valores[0]));
        }
    }//GEN-LAST:event_cbCidadeActionPerformed

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
            DlgUsuarioCadastro dialog = new DlgUsuarioCadastro(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    public final void LimpaFormulario() {
        txtNome.setText(null);
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
            usuarioModel.setLoginUsuario(txtLogin.getText().replaceAll("'", "").trim());
            return true;
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
            usuarioModel.setNomeUsuario(txtNome.getText().replaceAll("'", "").trim().toUpperCase());
            usuarioModel.setStatus(1);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o Nome!");
            txtNome.grabFocus();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscaCep;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbCidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRua;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
