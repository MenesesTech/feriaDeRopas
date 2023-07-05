package com.mycompany.presupuestoferias.views;

import com.mycompany.presupuestoferias.controllers.EgresoIngresoStatusController;
import com.mycompany.presupuestoferias.models.egreso;
import com.mycompany.presupuestoferias.models.egresoDao;
import com.mycompany.presupuestoferias.models.ingreso;
import com.mycompany.presupuestoferias.models.ingresoDao;

/**
 *
 * @author Haisenberg
 */
public class PresupuestoStatusView extends javax.swing.JFrame {

    egreso egreso_pres = new egreso();
    egresoDao egreso_presDao = new egresoDao();
    ingreso ingreso_pres = new ingreso();
    ingresoDao ingreso_presDao = new ingresoDao();

    public PresupuestoStatusView() {
        initComponents();
        setSize(1190, 920);
        setResizable(false);
        setExtendedState(MAXIMIZED_VERT);
        setLocationRelativeTo(null);
        setTitle("Estados de Egresos e Ingresos");
        EgresoIngresoStatusController egresoController = new EgresoIngresoStatusController(this, egreso_pres, egreso_presDao, ingreso_pres, ingreso_presDao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoPresupuesto = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbCategoriaPresupuesto = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JButton();
        btnMostrarTodo = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        txtIdFeriaStatus = new javax.swing.JLabel();
        txtNameFeriaStatus = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEgresos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableIngresos = new javax.swing.JTable();
        txtTotalPrecioIngreso = new javax.swing.JTextField();
        txtTotalPrecioEgreso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMontoFeria = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(13, 13, 13));
        jLabel1.setText("ESTADO DE EGRESOS E INGRESOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, -1));

        jPanel7.setBackground(new java.awt.Color(166, 166, 166));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(125, 139, 140));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(89, 89, 89));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tipo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        cmbTipoPresupuesto.setBackground(new java.awt.Color(217, 217, 217));
        cmbTipoPresupuesto.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        cmbTipoPresupuesto.setForeground(new java.awt.Color(0, 0, 0));
        cmbTipoPresupuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- SELECCIONE ---", "EGRESO", "INGRESO" }));
        cmbTipoPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoPresupuestoActionPerformed(evt);
            }
        });
        jPanel7.add(cmbTipoPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 30));

        jPanel3.setBackground(new java.awt.Color(89, 89, 89));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Categoria");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 30));

        cmbCategoriaPresupuesto.setBackground(new java.awt.Color(217, 217, 217));
        cmbCategoriaPresupuesto.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        cmbCategoriaPresupuesto.setForeground(new java.awt.Color(0, 0, 0));
        cmbCategoriaPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaPresupuestoActionPerformed(evt);
            }
        });
        jPanel7.add(cmbCategoriaPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 140, 30));

        btnSearch.setBackground(new java.awt.Color(38, 38, 38));
        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setText("Buscar");
        jPanel7.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 160, 40));

        btnMostrarTodo.setBackground(new java.awt.Color(38, 38, 38));
        btnMostrarTodo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMostrarTodo.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarTodo.setText("Mostrar todo");
        jPanel7.add(btnMostrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 160, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 730, 130));

        jPanel8.setBackground(new java.awt.Color(38, 38, 38));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(txtIdFeriaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        txtNameFeriaStatus.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNameFeriaStatus.setForeground(new java.awt.Color(255, 255, 255));
        txtNameFeriaStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel8.add(txtNameFeriaStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 370, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));

        tableEgresos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableEgresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto/Servicio", "Cantidad", "Precio (S/.)", "Precio total (S/.)", "Porcentaje (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableEgresos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 1140, 210));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("INGRESOS");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 550, -1, -1));

        tableIngresos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto/Servicio", "Cantidad", "Precio (S/.)", "Precio total (S/.)", "Porcentaje (%)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableIngresos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 1140, 210));

        txtTotalPrecioIngreso.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jPanel1.add(txtTotalPrecioIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 810, 170, 60));

        txtTotalPrecioEgreso.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jPanel1.add(txtTotalPrecioEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 500, 170, 60));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("TOTAL (S/.)");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 830, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TOTAL (S/.)");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 520, -1, -1));

        txtMontoFeria.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jPanel1.add(txtMontoFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, 170, 60));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("EGRESOS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("MONTO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPresupuestoActionPerformed
        String tipo = (String) cmbTipoPresupuesto.getSelectedItem();

        if (tipo.equals("--- SELECCIONE ---")) {
            cmbCategoriaPresupuesto.removeAllItems();
            cmbCategoriaPresupuesto.addItem("");
        } else if (tipo.equals("EGRESO")) {
            cmbCategoriaPresupuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Lugar", "Comida", "Publicidad", "Materiales", "Transporte", "Seguridad", "Evento"}));
        } else if (tipo.equals("INGRESO")) {
            cmbCategoriaPresupuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Stans", "Entradas", "Sponsor"}));
        }
    }//GEN-LAST:event_cmbTipoPresupuestoActionPerformed

    private void cmbCategoriaPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaPresupuestoActionPerformed


    }//GEN-LAST:event_cmbCategoriaPresupuestoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnMostrarTodo;
    public javax.swing.JButton btnSearch;
    public javax.swing.JComboBox<String> cmbCategoriaPresupuesto;
    public javax.swing.JComboBox<String> cmbTipoPresupuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tableEgresos;
    public javax.swing.JTable tableIngresos;
    public javax.swing.JLabel txtIdFeriaStatus;
    public javax.swing.JTextField txtMontoFeria;
    public javax.swing.JLabel txtNameFeriaStatus;
    public javax.swing.JTextField txtTotalPrecioEgreso;
    public javax.swing.JTextField txtTotalPrecioIngreso;
    // End of variables declaration//GEN-END:variables
}
