package com.mycompany.presupuestoferias.views;

import com.mycompany.presupuestoferias.controllers.EgresoIngresoController;
import com.mycompany.presupuestoferias.models.egreso;
import com.mycompany.presupuestoferias.models.egresoDao;
import com.mycompany.presupuestoferias.models.ingreso;
import com.mycompany.presupuestoferias.models.ingresoDao;
import javax.swing.JOptionPane;

public class PresupuestoView extends javax.swing.JFrame {

    egreso egreso_pres = new egreso();
    egresoDao egreso_presDao = new egresoDao();
    ingreso ingreso_pres = new ingreso();
    ingresoDao ingreso_presDao = new ingresoDao();
    EgresoIngresoController egres_account;

    public PresupuestoView() {
        // Pasar las instancias creadas como argumentos al crear EgresoIngresoController
        initComponents();
        setSize(1200, 920);
        setResizable(false);
        setExtendedState(MAXIMIZED_VERT);
        setLocationRelativeTo(null);
        setTitle("Presupuestar");
        egres_account = new EgresoIngresoController(this, egreso_pres, egreso_presDao, ingreso_pres, ingreso_presDao);
        pnlViewsEgreIngresos.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnViewsEgreIngresos = new javax.swing.JButton();
        btnRegisterEgreso = new javax.swing.JButton();
        btnUpdateEgreso = new javax.swing.JButton();
        btnDeleteEgreso = new javax.swing.JButton();
        btnCancelEgreso = new javax.swing.JButton();
        pnlViewsEgreIngresos = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEgresos = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableIngresos = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cmbTipoPresupuesto = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbCategoriaPresupuesto = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbProdServicio = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        txtIdFeria = new javax.swing.JLabel();
        txtNameFeria = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(13, 13, 13));
        jLabel1.setText("ARMA EL PRESUPUESTO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, -1));

        btnViewsEgreIngresos.setBackground(new java.awt.Color(38, 38, 38));
        btnViewsEgreIngresos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnViewsEgreIngresos.setForeground(new java.awt.Color(255, 255, 255));
        btnViewsEgreIngresos.setText("VER EGRESOS E INGRESOS");
        btnViewsEgreIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewsEgreIngresosActionPerformed(evt);
            }
        });
        jPanel1.add(btnViewsEgreIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1170, 43));

        btnRegisterEgreso.setBackground(new java.awt.Color(38, 38, 38));
        btnRegisterEgreso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRegisterEgreso.setForeground(new java.awt.Color(255, 255, 255));
        btnRegisterEgreso.setText("Registrar");
        jPanel1.add(btnRegisterEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 80, 160, 40));

        btnUpdateEgreso.setBackground(new java.awt.Color(38, 38, 38));
        btnUpdateEgreso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdateEgreso.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateEgreso.setText("Modificar");
        jPanel1.add(btnUpdateEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, 160, 40));

        btnDeleteEgreso.setBackground(new java.awt.Color(38, 38, 38));
        btnDeleteEgreso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDeleteEgreso.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteEgreso.setText("Eliminar");
        jPanel1.add(btnDeleteEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 160, 40));

        btnCancelEgreso.setBackground(new java.awt.Color(38, 38, 38));
        btnCancelEgreso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCancelEgreso.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelEgreso.setText("Cancelar");
        jPanel1.add(btnCancelEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 230, 160, 40));

        pnlViewsEgreIngresos.setBackground(new java.awt.Color(38, 38, 38));
        pnlViewsEgreIngresos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("EGRESOS");
        pnlViewsEgreIngresos.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));

        tableEgresos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableEgresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tipo", "Categoria", "Producto/Servicio", "Cantidad (u)", "Precio (S/.)"
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
        if (tableEgresos.getColumnModel().getColumnCount() > 0) {
            tableEgresos.getColumnModel().getColumn(0).setResizable(false);
            tableEgresos.getColumnModel().getColumn(1).setResizable(false);
            tableEgresos.getColumnModel().getColumn(2).setResizable(false);
            tableEgresos.getColumnModel().getColumn(3).setResizable(false);
            tableEgresos.getColumnModel().getColumn(4).setResizable(false);
            tableEgresos.getColumnModel().getColumn(5).setResizable(false);
        }

        pnlViewsEgreIngresos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1140, 212));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("INGRESOS");
        pnlViewsEgreIngresos.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 310, -1, -1));

        tableIngresos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Tipo", "Categoria", "Producto/Servicio", "Cantidad (u)", "Precio (S/.)"
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

        pnlViewsEgreIngresos.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 1140, 212));

        jPanel1.add(pnlViewsEgreIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 1170, 580));

        jPanel7.setBackground(new java.awt.Color(166, 166, 166));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
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
        jPanel7.add(cmbTipoPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

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

        jPanel4.setBackground(new java.awt.Color(89, 89, 89));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Producto / Servicio");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, -1, 30));

        cmbProdServicio.setBackground(new java.awt.Color(217, 217, 217));
        cmbProdServicio.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        cmbProdServicio.setForeground(new java.awt.Color(0, 0, 0));
        cmbProdServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProdServicioActionPerformed(evt);
            }
        });
        jPanel7.add(cmbProdServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 260, 30));

        jPanel5.setBackground(new java.awt.Color(89, 89, 89));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cantidad (u)");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 30, -1, 30));
        jPanel7.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 140, 30));

        jPanel6.setBackground(new java.awt.Color(89, 89, 89));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Precio (S/.)");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, 30));
        jPanel7.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 70, 140, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 960, 190));

        jPanel8.setBackground(new java.awt.Color(38, 38, 38));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(txtIdFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        txtNameFeria.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNameFeria.setForeground(new java.awt.Color(255, 255, 255));
        txtNameFeria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel8.add(txtNameFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 370, 40));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTipoPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoPresupuestoActionPerformed
        String tipo = (String) cmbTipoPresupuesto.getSelectedItem();

        if (tipo.equals("--- SELECCIONE ---")) {
            cmbCategoriaPresupuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
            cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
        } else if (tipo.equals("EGRESO")) {
            cmbCategoriaPresupuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Lugar", "Comida", "Publicidad", "Materiales", "Transporte", "Seguridad", "Evento"}));
            cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));

        } else if (tipo.equals("INGRESO")) {
            cmbCategoriaPresupuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Stans", "Entradas", "Sponsor"}));
            cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
        }
    }//GEN-LAST:event_cmbTipoPresupuestoActionPerformed

    private void cmbCategoriaPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaPresupuestoActionPerformed
        String tipo = (String) cmbTipoPresupuesto.getSelectedItem();
        String categoria = (String) cmbCategoriaPresupuesto.getSelectedItem();

        if (tipo.equals("EGRESO")) {
            if (categoria.equals("--- SELECCIONE ---")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
            } else if (categoria.equals("Lugar")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Alquiler del lugar"}));
            } else if (categoria.equals("Comida")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Desayuno", "Almuerzo", "Cena", "Bebidas"}));
            } else if (categoria.equals("Publicidad")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Publicidad radio", "Publicidad TV", "Publicidad online", "Volantes", "Desarrollo web"}));
            } else if (categoria.equals("Materiales")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Alquiler de equipos", "Alquiler de sillas y mesas", "Decoración", "Señalización"}));
            } else if (categoria.equals("Transporte")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Transporte de equipos", "Transporte de sillas y mesas", "Transporte del personal", "Transporte de invitados"}));
            } else if (categoria.equals("Seguridad")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Personal de seguridad"}));
            } else if (categoria.equals("Evento")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Invitados especiales", "Presentadores", "Asistentes", "Hotel", "Viaje"}));
            }
        } else if (tipo.equals("INGRESO")) {
            if (categoria.equals("--- SELECCIONE ---")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{""}));
            } else if (categoria.equals("Stans")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Puesto pequeño", "Puesto Mediano", "Puesto Grande"}));
            } else if (categoria.equals("Entradas")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Vip", "Platinum", "General", "Free Pass"}));
            } else if (categoria.equals("Sponsor")) {
                cmbProdServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"--- SELECCIONE ---", "Movistar TV", "Adidas", "Samsung", "Red Bull", "Otro"}));
            }
        }
    }//GEN-LAST:event_cmbCategoriaPresupuestoActionPerformed

    /**
     * Método que se ejecuta cuando se selecciona un elemento en el JComboBox
     * cmbProdServicio.
     *
     * @param evt El evento de acción generado
     */
    private void cmbProdServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProdServicioActionPerformed

        String categoria = (String) cmbCategoriaPresupuesto.getSelectedItem();

        // Verificar si la categoría seleccionada es "Comida"
        if (categoria.equals("Comida")) {
            int cantidadSeguridad = egres_account.cantSeguridad();

            // Verificar si hay suficiente cantidad de personal de seguridad
            if (cantidadSeguridad > 0) {
                cmbProdServicio.setEditable(true);
                txtCantidad.setEditable(false);
                txtCantidad.setText(String.valueOf(cantidadSeguridad));
                txtPrecio.setEditable(true);
            } else {
                JOptionPane.showMessageDialog(null, "Personal de seguridad = " + cantidadSeguridad);
                cmbProdServicio.setEditable(false);
                txtCantidad.setEditable(false);
                txtCantidad.setText(String.valueOf(cantidadSeguridad));
                txtPrecio.setEditable(false);
            }
        } // Si la categoría no es "Comida", habilitar la edición de los campos
        else {
            cmbProdServicio.setEditable(true);
            txtCantidad.setEditable(true);
            txtPrecio.setEditable(true);
        }
    }//GEN-LAST:event_cmbProdServicioActionPerformed

    private void btnViewsEgreIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewsEgreIngresosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnViewsEgreIngresosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelEgreso;
    public javax.swing.JButton btnDeleteEgreso;
    public javax.swing.JButton btnRegisterEgreso;
    public javax.swing.JButton btnUpdateEgreso;
    public javax.swing.JButton btnViewsEgreIngresos;
    public javax.swing.JComboBox<String> cmbCategoriaPresupuesto;
    public javax.swing.JComboBox<String> cmbProdServicio;
    public javax.swing.JComboBox<String> cmbTipoPresupuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JPanel pnlViewsEgreIngresos;
    public javax.swing.JTable tableEgresos;
    public javax.swing.JTable tableIngresos;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JLabel txtIdFeria;
    public javax.swing.JLabel txtNameFeria;
    public javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
