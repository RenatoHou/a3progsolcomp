/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinteface;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author renat
 */
public class ManterFuncionarios extends javax.swing.JFrame {
    private boolean novoCadastro = false;
    
    /**
     * Creates new form ManterClientes
     */
    public ManterFuncionarios() {
        initComponents();
        labelSenha.setVisible(false);
        campoSenha.setVisible(false);
        botaoCancela.setVisible(false);
        carregarClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        campoNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        campoCPF = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        campoIdade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        campoSenha = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        botaoRemover = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        botaoEditar = new javax.swing.JButton();
        botaoNovo = new javax.swing.JButton();
        botaoCancela = new javax.swing.JButton();
        labelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabelaClientes.setBackground(new java.awt.Color(51, 51, 51));
        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Idade", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        campoNome.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Nome");

        campoCPF.setEditable(false);
        campoCPF.setBackground(new java.awt.Color(204, 204, 204));
        try {
            campoCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setText("CPF");

        campoIdade.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setText("Idade");

        campoEmail.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setText("Email");

        labelSenha.setText("Senha");

        campoSenha.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSenha)
                    .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4)
                        .addComponent(campoNome)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(campoCPF)
                        .addComponent(jLabel3)
                        .addComponent(campoIdade)
                        .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(64, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(campoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(campoIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(51, 0, 51));

        botaoRemover.setBackground(new java.awt.Color(204, 0, 0));
        botaoRemover.setText("Remover");
        botaoRemover.setEnabled(false);
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });

        jLabel5.setText("Açoes:");

        botaoEditar.setText("Editar");
        botaoEditar.setEnabled(false);
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoNovo.setBackground(new java.awt.Color(0, 204, 255));
        botaoNovo.setForeground(new java.awt.Color(255, 255, 255));
        botaoNovo.setText("Novo");
        botaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoActionPerformed(evt);
            }
        });

        botaoCancela.setBackground(new java.awt.Color(204, 0, 0));
        botaoCancela.setForeground(new java.awt.Color(255, 255, 255));
        botaoCancela.setText("Cancela");
        botaoCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botaoRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botaoNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoRemover)
                .addGap(39, 39, 39)
                .addComponent(botaoEditar)
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoNovo)
                    .addComponent(botaoCancela))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        labelTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTitle.setText("Editar dados dos funcionários:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitle)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        DefaultTableModel tableModel = (DefaultTableModel)tabelaClientes.getModel();
        int selectedRow = tabelaClientes.getSelectedRow();
        campoNome.setText(tableModel.getValueAt(selectedRow, 0).toString());
        campoCPF.setText(tableModel.getValueAt(selectedRow, 1).toString());
        campoIdade.setText(tableModel.getValueAt(selectedRow, 2).toString());
        campoEmail.setText(tableModel.getValueAt(selectedRow, 3).toString());
        botaoRemover.setEnabled(true);
        botaoEditar.setEnabled(true);
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            if (clienteDAO.deleteCliente(campoCPF.getText())){
                campoNome.setText("");
                campoCPF.setText("");
                campoIdade.setText("");
                campoEmail.setText("");
                botaoRemover.setEnabled(false);
                botaoEditar.setEnabled(false);
                ((DefaultTableModel)tabelaClientes.getModel()).removeRow(tabelaClientes.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Cliente removido.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            if (clienteDAO.updateCliente(new Cliente(campoCPF.getText(),campoNome.getText(), Integer.parseInt(campoIdade.getText()), campoEmail.getText(), null ))){
                carregarClientes();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoActionPerformed
        if (!novoCadastro){
            novoCadastro = !novoCadastro;
            arrumarCadastro();
        }else{
            try {
            
                String nome = campoNome.getText();
                String cpf = campoCPF.getText();
                String email = campoEmail.getText();
                String senha = campoSenha.getText();
                if (nome.isBlank() || cpf.equals("   .   .   -  " ) || email.isBlank() || senha.isBlank())
                    throw new NullPointerException();
                int idade = Integer.parseInt(campoIdade.getText());
                //esse programa só aceita cadastro de pessoas com idades entre 11 e 99 anos.
                if (idade < 10){
                    throw new NumberFormatException();
                }
                int ano = Year.now().getValue() - idade;
                Cliente cliente = new Cliente(cpf, nome, ano, email, senha, true, false);
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.insertFuncionario(cliente);
                clienteDAO.close();
                JOptionPane.showMessageDialog(null, "Cadastro realizado");
                botaoRemover.setEnabled(false);
                botaoEditar.setEnabled(false);
                novoCadastro = !novoCadastro;
                arrumarCadastro();
                carregarClientes();
            } catch (SQLException ex) {
                Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException nf) {
                JOptionPane.showMessageDialog(null, "Ano de nascimento inválido.");
            } catch (NullPointerException np) {
                JOptionPane.showMessageDialog(null, "Dados inválidos.");      
            }
            
            
            
            
        }
    }//GEN-LAST:event_botaoNovoActionPerformed

    private void botaoCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelaActionPerformed
        campoNome.setText("");
        campoCPF.setText("");
        campoIdade.setText("");
        campoEmail.setText("");
        botaoRemover.setEnabled(false);
        botaoEditar.setEnabled(false);
        novoCadastro = !novoCadastro;
        arrumarCadastro();
    }//GEN-LAST:event_botaoCancelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManterFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManterFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManterFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManterFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManterFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancela;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoNovo;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JFormattedTextField campoCPF;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoIdade;
    private javax.swing.JTextField campoNome;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables

    private void carregarClientes() {
        ((DefaultTableModel)tabelaClientes.getModel()).setRowCount(0);
        try {
            ClienteDAO clienteDAO = new ClienteDAO();
            DefaultTableModel tableModel = (DefaultTableModel)tabelaClientes.getModel();
            for (Cliente cliente:clienteDAO.findAllFuncionario()){
                tableModel.addRow(new Object[]{cliente.getNome(), cliente.getCpf(), cliente.getIdade(), cliente.getEmail()});
            }
            clienteDAO.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManterFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void arrumarCadastro(){
        if (novoCadastro){
            campoNome.setText("");
            campoCPF.setText("");
            campoIdade.setText("");
            campoEmail.setText("");
            labelTitle.setText("Novo cadastro de cliente:");
            campoCPF.setEditable(true);
            labelSenha.setVisible(true);
            campoSenha.setVisible(true);
            botaoCancela.setVisible(true);
            botaoEditar.setVisible(false);
            botaoRemover.setVisible(false);
            botaoNovo.setText("Confirma");
        }else{
            labelTitle.setText("Editar dados dos clientes:");
            campoCPF.setEditable(false);
            labelSenha.setVisible(false);
            campoSenha.setVisible(false);
            botaoCancela.setVisible(false);
            botaoEditar.setVisible(true);
            botaoRemover.setVisible(true);
            botaoNovo.setText("Novo");
            campoNome.setText("");
            campoCPF.setText("");
            campoIdade.setText("");
            campoEmail.setText("");
        }
    }
}