package ex13_polygonsName;
public class Switch extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Switch.class.getName());


    public Switch() {
        initComponents();
        lblPoligono.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnTestar = new javax.swing.JButton();
        txtLado = new javax.swing.JSpinner();
        lblPoligono = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel1.setText("Descubra o Nome Poligono ");

        btnTestar.setText("Teste!");
        btnTestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestarActionPerformed(evt);
            }
        });

        txtLado.setModel(new javax.swing.SpinnerNumberModel(3, 3, 10, 1));

        lblPoligono.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        lblPoligono.setText("Nome do Poligono");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel3.setText("Lados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(127, 127, 127)
                                                .addComponent(lblPoligono))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabel3)
                                                .addGap(27, 27, 27)
                                                .addComponent(txtLado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(59, 59, 59)
                                                .addComponent(btnTestar)))
                                .addContainerGap(108, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1)
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtLado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(btnTestar))
                                .addGap(55, 55, 55)
                                .addComponent(lblPoligono)
                                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void btnTestarActionPerformed(java.awt.event.ActionEvent evt) {
        int lados = Integer.parseInt(txtLado.getValue().toString());
        String tipo;
        switch (lados) {
            case 3:
                tipo = "Triângulo";
                break;
            case 4:
                tipo = "Quadrilátero";
                break;
            case 5:
                tipo = "Pentágono";
                break;
            case 6:
                tipo = "Hexágono";
                break;
            case 7:
                tipo = "Heptágono";
                break;
            case 8:
                tipo = "Octógono";
                break;
            case 9:
                tipo = "Eneágono";
                break;
            case 10:
                tipo = "Decágono";
                break;
            default:
                tipo = "Não identificado";
                break;
        }

        lblPoligono.setText(tipo);


        lblPoligono.setVisible(true);
    }

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Switch().setVisible(true));
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnTestar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblPoligono;
    private javax.swing.JSpinner txtLado;
    // End of variables declaration
}
