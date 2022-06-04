/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package userinteface;

import com.mycompany.projetoa3.Session;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.Produto;
import model.Venda_Produto;


public class HomeV2 extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public HomeV2() {
        initComponents();
        carregaProdutos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        painelHome = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        painelMasculino = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painelMasculinoCenter = new javax.swing.JPanel();
        painelFeminino = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelFemininoCenter = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        labelTotalFinal = new javax.swing.JLabel();
        botaoFecharPedido = new javax.swing.JButton();
        painelCarrinho = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setExtendedState(6);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        painelHome.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelHomeLayout = new javax.swing.GroupLayout(painelHome);
        painelHome.setLayout(painelHomeLayout);
        painelHomeLayout.setHorizontalGroup(
            painelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelHomeLayout.setVerticalGroup(
            painelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Home", painelHome);

        painelMasculino.setBackground(new java.awt.Color(0, 102, 102));
        painelMasculino.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Os melhores");
        jLabel1.setToolTipText("");
        painelMasculino.add(jLabel1, java.awt.BorderLayout.NORTH);

        painelMasculinoCenter.setOpaque(false);
        painelMasculinoCenter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 12));
        painelMasculino.add(painelMasculinoCenter, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Masculino", painelMasculino);

        painelFeminino.setBackground(new java.awt.Color(0, 102, 102));
        painelFeminino.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Os melhores");
        jLabel2.setToolTipText("");
        painelFeminino.add(jLabel2, java.awt.BorderLayout.NORTH);

        painelFemininoCenter.setOpaque(false);
        painelFemininoCenter.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 12));
        painelFeminino.add(painelFemininoCenter, java.awt.BorderLayout.CENTER);

        jTabbedPane2.addTab("Feminino", painelFeminino);

        getContentPane().add(jTabbedPane2, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new java.awt.GridLayout(2, 1, 2, 2));

        labelTotalFinal.setBackground(new java.awt.Color(0, 153, 153));
        labelTotalFinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTotalFinal.setForeground(new java.awt.Color(255, 255, 255));
        labelTotalFinal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalFinal.setText("R$0,00");
        labelTotalFinal.setOpaque(true);
        jPanel3.add(labelTotalFinal);

        botaoFecharPedido.setText("Fechar pedido");
        botaoFecharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharPedidoActionPerformed(evt);
            }
        });
        jPanel3.add(botaoFecharPedido);

        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        painelCarrinho.setBackground(new java.awt.Color(0, 153, 153));
        painelCarrinho.setPreferredSize(new java.awt.Dimension(180, 510));
        painelCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                painelCarrinhoMousePressed(evt);
            }
        });
        jPanel1.add(painelCarrinho, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        setSize(new java.awt.Dimension(849, 518));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Session.newSession();
    }//GEN-LAST:event_formWindowClosing

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        this.repaint(60);
    }//GEN-LAST:event_formFocusGained

    private void painelCarrinhoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelCarrinhoMousePressed
        painelCarrinho.repaint();
        System.out.println("repaint painel carrinho");
    }//GEN-LAST:event_painelCarrinhoMousePressed

    private void botaoFecharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharPedidoActionPerformed
        Session.fecharPedido();
        Session.newSession();
        this.dispose();
    }//GEN-LAST:event_botaoFecharPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(HomeV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeV2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeV2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFecharPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel labelTotalFinal;
    private javax.swing.JPanel painelCarrinho;
    private javax.swing.JPanel painelFeminino;
    private javax.swing.JPanel painelFemininoCenter;
    private javax.swing.JPanel painelHome;
    private javax.swing.JPanel painelMasculino;
    private javax.swing.JPanel painelMasculinoCenter;
    // End of variables declaration//GEN-END:variables


    private void carregaProdutos(){
        try {
            ProdutoDAO produtoDao = new ProdutoDAO();
            for (Produto produto: produtoDao.findAllProduto()){
                addProduto(produto);
            }
            produtoDao.Close();
        } catch (SQLException ex) {
            Logger.getLogger(HomeV2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addProduto(Produto produto){
        java.awt.GridBagConstraints gridBagConstraints;
        JPanel painelProtudo = new JPanel();
        painelProtudo.setBackground(java.awt.Color.gray);
        painelProtudo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 51), 3, true));
        painelProtudo.setForeground(java.awt.Color.white);
        painelProtudo.setMaximumSize(getPreferredSize());
        painelProtudo.setMinimumSize(getPreferredSize());
        painelProtudo.setPreferredSize(new java.awt.Dimension(250, 375));
        painelProtudo.setLayout(new java.awt.GridBagLayout());

        JPanel painelImagemProduto = new JPanel();
        painelImagemProduto.setBackground(new java.awt.Color(204, 255, 204));
        painelImagemProduto.setMaximumSize(new java.awt.Dimension(200, 300));
        painelImagemProduto.setMinimumSize(new java.awt.Dimension(200, 300));
        painelImagemProduto.setName(""); // NOI18N
        painelImagemProduto.setPreferredSize(new java.awt.Dimension(200, 300));

        javax.swing.GroupLayout painelImagemProdutoLayout = new javax.swing.GroupLayout(painelImagemProduto);
        painelImagemProduto.setLayout(painelImagemProdutoLayout);
        painelImagemProdutoLayout.setHorizontalGroup(
            painelImagemProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        painelImagemProdutoLayout.setVerticalGroup(
            painelImagemProdutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        painelProtudo.add(painelImagemProduto, new java.awt.GridBagConstraints());

        JLabel labelNomeProduto = new JLabel();
        labelNomeProduto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelNomeProduto.setForeground(new java.awt.Color(255, 255, 255));
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        labelNomeProduto.setText(produto.getDescricao() + " R$" + df.format(produto.getPreco()));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        painelProtudo.add(labelNomeProduto, gridBagConstraints);

        JButton botaoComprarProduto = new JButton();
        botaoComprarProduto.setBackground(new java.awt.Color(255, 255, 255));
        botaoComprarProduto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botaoComprarProduto.setForeground(new java.awt.Color(0, 0, 0));
        botaoComprarProduto.setText("Comprar");
        botaoComprarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarAoCarrinho(produto);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        painelProtudo.add(botaoComprarProduto, gridBagConstraints);
        
        if (produto.getCategoria().equals("masculino"))
            painelMasculinoCenter.add(painelProtudo);
        else if (produto.getCategoria().equals("feminino"))
            painelFemininoCenter.add(painelProtudo);
        else
            System.out.println("Produto sem categoria");
        
        

    }
    
    private void adicionarAoCarrinho(Produto produto){
        DetalhesProduto window = new DetalhesProduto(produto, this);
        window.setVisible(true);
    }
    
    public void atualizaCarrinho(){
        painelCarrinho.removeAll();
        double totalFinal = 0.0;
        for(Venda_Produto produtoCarrinho: Session.getCarrinho()){
            System.out.println("Adicionar no painel carrinho:" + produtoCarrinho.getProduto().getDescricao() + "/ qtd = " + produtoCarrinho.getQuantidade());
            System.out.println("-----------------------------");
            JPanel painelItemCarrinho = new JPanel();
            painelItemCarrinho.setPreferredSize(new java.awt.Dimension(170, 120));
            painelItemCarrinho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adicionarAoCarrinho(produtoCarrinho.getProduto());
            }
            });
            
            JLabel labelNome = new JLabel();
            labelNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            labelNome.setText(produtoCarrinho.getProduto().getDescricao());

            JLabel labelValorItem = new JLabel();
            labelValorItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            labelValorItem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            DecimalFormat df = new DecimalFormat("#,##0.00");
            labelValorItem.setText("R$"+df.format(produtoCarrinho.getPreco_venda()));
            
            JLabel jLabel5 = new JLabel();
            jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            jLabel5.setText("Total:");

            JLabel labelTotal = new JLabel();
            labelTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            labelTotal.setText("R$"+df.format(produtoCarrinho.getTotal()));

            JLabel jLabel7 = new JLabel();
            jLabel7.setText("Quantidade");

            JLabel labelQuantidade = new JLabel();
            labelQuantidade.setText("( " + produtoCarrinho.getQuantidade() + " )");

            javax.swing.GroupLayout painelItemCarrinhoLayout = new javax.swing.GroupLayout(painelItemCarrinho);
            painelItemCarrinho.setLayout(painelItemCarrinhoLayout);
            painelItemCarrinhoLayout.setHorizontalGroup(
                painelItemCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelItemCarrinhoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painelItemCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelItemCarrinhoLayout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(labelValorItem))
                        .addGroup(painelItemCarrinhoLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                            .addComponent(labelTotal))
                        .addGroup(painelItemCarrinhoLayout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelQuantidade)))
                    .addContainerGap())
            );
            painelItemCarrinhoLayout.setVerticalGroup(
                painelItemCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelItemCarrinhoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labelNome)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(labelValorItem)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelItemCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(labelQuantidade))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(painelItemCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(labelTotal))
                    .addContainerGap())
            );
            totalFinal += produtoCarrinho.getTotal();
            painelCarrinho.add(painelItemCarrinho);
        }
        labelTotalFinal.setText("R$" + new DecimalFormat("#,##0.00").format(totalFinal));
        painelCarrinho.repaint();
    }
    
}
