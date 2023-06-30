package com.mycompany.presupuestoferias.views;

import com.mycompany.presupuestoferias.ejercicios.ColaClientes;
import com.mycompany.presupuestoferias.ejercicios.Pila;



public class Ejercicios extends javax.swing.JFrame {

    Pila pila = new Pila();
    ColaClientes cola = new ColaClientes();

    public Ejercicios() {
        initComponents();
        setResizable(false);
        setSize(642, 507);
        setExtendedState(MAXIMIZED_VERT);
        setLocationRelativeTo(null);
        setTitle("Ejercicios");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaArreglo = new javax.swing.JTextArea();
        btnAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtAllNum = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAgregarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaArregloClientes = new javax.swing.JTextArea();
        btnQuitarCliente = new javax.swing.JButton();
        txtAllClientes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PILAS + ARREGLOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tamaño de pila:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        txtNum.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumActionPerformed(evt);
            }
        });
        jPanel1.add(txtNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 30));

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 90, 30));

        txaArreglo.setColumns(20);
        txaArreglo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txaArreglo.setRows(5);
        jScrollPane1.setViewportView(txaArreglo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 280, 180));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 90, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ingresa un numero:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        txtAllNum.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtAllNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAllNumActionPerformed(evt);
            }
        });
        jPanel1.add(txtAllNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 130, 30));

        jTabbedPane1.addTab("Ejercicio 3", jPanel1);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 180, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ingresa nombre del cliente:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("COLAS + LISTAS ENLAZADAS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, 30));

        btnAgregarCliente.setText("Agregar");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 90, 30));

        txaArregloClientes.setColumns(20);
        txaArregloClientes.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txaArregloClientes.setLineWrap(true);
        txaArregloClientes.setRows(5);
        jScrollPane2.setViewportView(txaArregloClientes);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 280, 180));

        btnQuitarCliente.setText("Quitar");
        btnQuitarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarClienteActionPerformed(evt);
            }
        });
        jPanel2.add(btnQuitarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 90, 30));

        txtAllClientes.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txtAllClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAllClientesActionPerformed(evt);
            }
        });
        jPanel2.add(txtAllClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 130, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tamaño de cola:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, -1, -1));

        jTabbedPane1.addTab("Ejercicio 4", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        int num = Integer.parseInt(txtNum.getText());
        pila.agregar(num);
        txaArreglo.setText(pila.mostrarDatos());
        txtAllNum.setText(String.valueOf(pila.getTamaño())); 
        txtNum.setText("");
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        pila.quitar();
        txaArreglo.setText(pila.mostrarDatos());
        txtAllNum.setText(String.valueOf(pila.getTamaño()));  
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void txtAllNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAllNumActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtAllNumActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        // TODO add your handling code here:
        String nom = txtNombre.getText();
        cola.agregarCliente(nom);
        txaArregloClientes.setText(cola.mostrarClientes());
        txtAllClientes.setText(String.valueOf(cola.getTamaño())); 
        txtNombre.setText("");
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnQuitarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarClienteActionPerformed
        // TODO add your handling code here:
        cola.quitarCliente();
        txaArregloClientes.setText(cola.mostrarClientes());
        txtAllClientes.setText(String.valueOf(cola.getTamaño())); 
    }//GEN-LAST:event_btnQuitarClienteActionPerformed

    private void txtAllClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAllClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAllClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarCliente;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnQuitarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea txaArreglo;
    private javax.swing.JTextArea txaArregloClientes;
    private javax.swing.JTextField txtAllClientes;
    private javax.swing.JTextField txtAllNum;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNum;
    // End of variables declaration//GEN-END:variables
}
