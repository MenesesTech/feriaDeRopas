package com.mycompany.presupuestoferias.views;

import com.mycompany.presupuestoferias.controllers.feriasController;
import com.mycompany.presupuestoferias.controllers.settingsController;
import com.mycompany.presupuestoferias.models.feria;
import com.mycompany.presupuestoferias.models.feriaDao;

public class SystemView extends javax.swing.JFrame {

    feria feria_ropa = new feria();
    feriaDao feriaRopaDao = new feriaDao();

    public SystemView() {
        initComponents();
        setSize(1200, 700);
        setResizable(false);
        setExtendedState(MAXIMIZED_VERT);
        setLocationRelativeTo(null);
        setTitle("Sistema de Presupuetos");
        settingsController setting = new settingsController(this);
        feriasController feria_account = new feriasController(feria_ropa, feriaRopaDao, this);
        feria_account.listAllFerias();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cubiertaPestañas = new javax.swing.JLayeredPane();
        pnlPrincipal = new javax.swing.JPanel();
        pnlInicio = new javax.swing.JPanel();
        lblInicio = new javax.swing.JLabel();
        pnlRegistroFerias = new javax.swing.JPanel();
        lblRegistroFerias = new javax.swing.JLabel();
        pnlListaFerias = new javax.swing.JPanel();
        lblListaFerias = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnRegistroFerias = new javax.swing.JButton();
        btnListaFerias = new javax.swing.JButton();
        btnEmployees = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblUbicacion = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        lblFechaInicio = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        lblFechaFin = new javax.swing.JLabel();
        txtFechaFin = new javax.swing.JTextField();
        btnCancelFeria = new javax.swing.JButton();
        btnRegisterFeria = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lblOrganizador = new javax.swing.JLabel();
        txtOrganizador = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFerias = new javax.swing.JTable();
        btnOrdenarBurbuja = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableListaFerias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlSecundario = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout cubiertaPestañasLayout = new javax.swing.GroupLayout(cubiertaPestañas);
        cubiertaPestañas.setLayout(cubiertaPestañasLayout);
        cubiertaPestañasLayout.setHorizontalGroup(
            cubiertaPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        cubiertaPestañasLayout.setVerticalGroup(
            cubiertaPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(cubiertaPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 1000, 40));

        pnlPrincipal.setBackground(new java.awt.Color(15, 15, 15));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInicio.setBackground(new java.awt.Color(15, 15, 15));
        pnlInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-de-inicio.png"))); // NOI18N
        lblInicio.setText("  Inicio");
        pnlInicio.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        pnlPrincipal.add(pnlInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        pnlRegistroFerias.setBackground(new java.awt.Color(15, 15, 15));
        pnlRegistroFerias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegistroFerias.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRegistroFerias.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistroFerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/feria.png"))); // NOI18N
        lblRegistroFerias.setText("Registro de Ferias");
        pnlRegistroFerias.add(lblRegistroFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        pnlPrincipal.add(pnlRegistroFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 50));

        pnlListaFerias.setBackground(new java.awt.Color(15, 15, 15));
        pnlListaFerias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblListaFerias.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblListaFerias.setForeground(new java.awt.Color(255, 255, 255));
        lblListaFerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista-de-ferias.png"))); // NOI18N
        lblListaFerias.setText("Lista de Ferias");
        pnlListaFerias.add(lblListaFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        pnlPrincipal.add(pnlListaFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 50));

        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 600));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(252, 220, 31));

        btnRegistroFerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/feria_btn.png"))); // NOI18N
        btnRegistroFerias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Ferias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        btnRegistroFerias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroFeriasActionPerformed(evt);
            }
        });

        btnListaFerias.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haisenberg\\Pictures\\RECURSOS PARA SOFTWARES\\caja.png")); // NOI18N
        btnListaFerias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Lista de Ferias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        btnEmployees.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haisenberg\\Pictures\\RECURSOS PARA SOFTWARES\\empleado.png")); // NOI18N
        btnEmployees.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        btnSettings.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haisenberg\\Pictures\\RECURSOS PARA SOFTWARES\\configuraciones.png")); // NOI18N
        btnSettings.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Configuración", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        btnLogout.setIcon(new javax.swing.ImageIcon("C:\\Users\\Haisenberg\\Pictures\\RECURSOS PARA SOFTWARES\\boton-de-encendido-apagado.png")); // NOI18N
        btnLogout.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Cerrar Sesión", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmployees, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistroFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListaFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistroFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListaFerias, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmployees, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        jTabbedPane1.addTab("Inicio", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(205, 205, 205));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(52, 52, 52));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Ferias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblUbicacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUbicacion.setForeground(new java.awt.Color(255, 255, 255));
        lblUbicacion.setText("Ubicación:");

        txtUbicacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFechaInicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicio.setText("Fecha de Inicio:");

        txtFechaInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblFechaFin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaFin.setText("Fecha de Fin:");

        txtFechaFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnCancelFeria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelFeria.setText("Cancelar");

        btnRegisterFeria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegisterFeria.setText("Agregar");

        lblCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- SELECCIONE ---", "ROPA FEMENINA", "ROPA MASCULINA", "ROPA INFANTIL", "ROPA DEPORTIVA", "ROPA USADA" }));

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- SELECCIONE ---", "PLANIFICADA", "EN CURSO", "FINALIZADA" }));

        lblOrganizador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOrganizador.setForeground(new java.awt.Color(255, 255, 255));
        lblOrganizador.setText("Organizador:");

        txtOrganizador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Teléfono:");

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo:");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblUbicacion)
                    .addComponent(lblNombre)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(txtNombre)
                            .addComponent(txtUbicacion)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
                        .addGap(1, 1, 1)))
                .addGap(33, 33, 33)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                            .addComponent(lblCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(lblEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addComponent(lblOrganizador)
                            .addGap(18, 18, 18)
                            .addComponent(txtOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(lblTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegisterFeria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelFeria, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(btnRegisterFeria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnCancelFeria, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56))
                                .addGroup(jPanel13Layout.createSequentialGroup()
                                    .addComponent(lblNombre)
                                    .addGap(31, 31, 31)
                                    .addComponent(lblUbicacion)
                                    .addGap(75, 75, 75)))
                            .addGap(6, 6, 6)
                            .addComponent(lblFechaFin))
                        .addGroup(jPanel13Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblEstado)
                                .addComponent(cmbEstado))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblOrganizador)
                                .addComponent(txtOrganizador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTelefono)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCorreo)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblFechaInicio))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCategoria)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 930, 260));

        tableFerias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Ubicación", "Categoria", "Estado", "Fecha de Inicio", "Fecha de Fin"
            }
        ));
        jScrollPane1.setViewportView(tableFerias);
        if (tableFerias.getColumnModel().getColumnCount() > 0) {
            tableFerias.getColumnModel().getColumn(2).setHeaderValue("Categoria");
            tableFerias.getColumnModel().getColumn(3).setHeaderValue("Estado");
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 930, 180));

        btnOrdenarBurbuja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnOrdenarBurbuja.setText("Ordenar por Categorias");
        btnOrdenarBurbuja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarBurbujaActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrdenarBurbuja, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 490, 240, 40));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        jTabbedPane1.addTab("Registro de Ferias", jPanel3);

        jPanel5.setBackground(new java.awt.Color(205, 205, 205));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableListaFerias.setBackground(new java.awt.Color(52, 52, 52));
        tableListaFerias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Ubicación", "Fecha de Inicio", "Fecha de Fin", "Organizador", "Telefono", "Correo"
            }
        ));
        jScrollPane3.setViewportView(tableListaFerias);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 930, 320));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 15, 15));
        jLabel1.setText("LISTA DE FERIAS");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lista de Ferias", jPanel4);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 1000, 600));

        pnlLogo.setBackground(new java.awt.Color(15, 15, 15));

        lblLogo.setBackground(new java.awt.Color(15, 15, 15));
        lblLogo.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 0));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tienda.png"))); // NOI18N
        lblLogo.setText("<html>   <style>     h1 {       font-size: 18px;       margin-bottom: 0;     }     h6 {       font-size: 8px;       margin-top: 0;      }   </style>   <h1>FASHION</h1>   <h6>FERIA DE ROPA</h6> </html> ");

        javax.swing.GroupLayout pnlLogoLayout = new javax.swing.GroupLayout(pnlLogo);
        pnlLogo.setLayout(pnlLogoLayout);
        pnlLogoLayout.setHorizontalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLogoLayout.setVerticalGroup(
            pnlLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLogoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 100));

        pnlSecundario.setBackground(new java.awt.Color(15, 15, 15));
        pnlSecundario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(205, 205, 205));
        lblTitle.setText("SISTEMA DE PRESUPUESTO DE FERIAS");
        pnlSecundario.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 480, -1));

        getContentPane().add(pnlSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1000, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroFeriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroFeriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroFeriasActionPerformed

    private void btnOrdenarBurbujaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarBurbujaActionPerformed
        // TODO add your handling code here:
        feriasController ferController = new feriasController(feria_ropa, feriaRopaDao, this);
        ferController.listBurbujaFerias();
    }//GEN-LAST:event_btnOrdenarBurbujaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCancelFeria;
    private javax.swing.JButton btnEmployees;
    private javax.swing.JButton btnListaFerias;
    private javax.swing.JButton btnLogout;
    public javax.swing.JButton btnOrdenarBurbuja;
    public javax.swing.JButton btnRegisterFeria;
    private javax.swing.JButton btnRegistroFerias;
    private javax.swing.JButton btnSettings;
    public javax.swing.JComboBox<String> cmbCategoria;
    public javax.swing.JComboBox<String> cmbEstado;
    public javax.swing.JLayeredPane cubiertaPestañas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    public javax.swing.JLabel lblInicio;
    public javax.swing.JLabel lblListaFerias;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblOrganizador;
    public javax.swing.JLabel lblRegistroFerias;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUbicacion;
    public javax.swing.JPanel pnlInicio;
    public javax.swing.JPanel pnlListaFerias;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlPrincipal;
    public javax.swing.JPanel pnlRegistroFerias;
    private javax.swing.JPanel pnlSecundario;
    public javax.swing.JTable tableFerias;
    private javax.swing.JTable tableListaFerias;
    public javax.swing.JTextField txtCorreo;
    public javax.swing.JTextField txtFechaFin;
    public javax.swing.JTextField txtFechaInicio;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtOrganizador;
    public javax.swing.JTextField txtTelefono;
    public javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}
