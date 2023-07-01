package com.mycompany.presupuestoferias.views;

import com.mycompany.presupuestoferias.controllers.feriaController;
import com.mycompany.presupuestoferias.controllers.settingsController;
import com.mycompany.presupuestoferias.controllers.usuarioController;
import com.mycompany.presupuestoferias.models.feria;
import com.mycompany.presupuestoferias.models.feriaDao;
import com.mycompany.presupuestoferias.models.empleado;
import com.mycompany.presupuestoferias.models.empleadoDao;
import static com.mycompany.presupuestoferias.models.empleadoDao.rol_user;
import static com.mycompany.presupuestoferias.models.empleadoDao.username_user;

public class SystemView extends javax.swing.JFrame {

    feria feria_ropa = new feria();
    feriaDao feriaRopaDao = new feriaDao();
    empleado user_employee = new empleado();
    empleadoDao userDao = new empleadoDao();

    public SystemView() {
        initComponents();
        setSize(1200, 700);
        setResizable(false);
        setExtendedState(MAXIMIZED_VERT);
        setLocationRelativeTo(null);
        setTitle("Sistema de Presupuetos");
        settingsController setting = new settingsController(this);
        feriaController ferController = new feriaController(feria_ropa, feriaRopaDao, this);
        ferController.listAllFerias();
        ferController.listAllFeriasPrincipal();
        usuarioController userController = new usuarioController(user_employee, userDao, this);
        userController.listAllEmployees();
        userController.EmployeeProfile();
        PresupuestoView preView = new PresupuestoView();
        titleInterface();
    }
    
    public String titleInterface() {
        label_name_user.setText(username_user);
        label_name_rol.setText(rol_user);
        return rol_user.trim();
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
        pnlEmployees = new javax.swing.JPanel();
        lblEmployees = new javax.swing.JLabel();
        pnlSettings = new javax.swing.JPanel();
        lblSettings = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        btnEmployees = new javax.swing.JButton();
        btnRegistroFerias = new javax.swing.JButton();
        btnListaFerias = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnEjercicios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombreFeria = new javax.swing.JTextField();
        lblUbicacion = new javax.swing.JLabel();
        txtDistritoFeria = new javax.swing.JTextField();
        lblFechaInicio = new javax.swing.JLabel();
        lblFechaFin = new javax.swing.JLabel();
        btnCancelFeria = new javax.swing.JButton();
        btnDeleteFeria = new javax.swing.JButton();
        lblCategoria = new javax.swing.JLabel();
        cmbCategoriaFeria = new javax.swing.JComboBox<>();
        lblEstado = new javax.swing.JLabel();
        cmbEstadoFeria = new javax.swing.JComboBox<>();
        jDateInicio = new com.toedter.calendar.JDateChooser();
        jDateFin = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtAforoFeria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMontoFeria = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoFeria = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnRegisterFeria = new javax.swing.JButton();
        btnUpdateFeria = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFerias = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnBurbuja = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnListaOriginal = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnPresupuestar = new javax.swing.JButton();
        btnEstadoPresupuesto = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableListaFerias = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txt_employee_name = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txt_employee_username = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_employee_district = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_employee_email = new javax.swing.JTextField();
        txt_employee_password = new javax.swing.JPasswordField();
        cmb_rol = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_employee_id = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txt_employee_lastname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txt_employee_dni = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txt_employee_telephone = new javax.swing.JTextField();
        btn_register_employee = new javax.swing.JButton();
        btn_update_employee = new javax.swing.JButton();
        btn_delete_employee = new javax.swing.JButton();
        btn_cancel_employee = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        employee_table = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_id_profile = new javax.swing.JTextField();
        txt_name_profile = new javax.swing.JTextField();
        txt_district_profile = new javax.swing.JTextField();
        txt_phone_profile = new javax.swing.JTextField();
        txt_email_profile = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        btn_modify_data = new javax.swing.JButton();
        txt_password_modify = new javax.swing.JPasswordField();
        txt_password_modify_confirm = new javax.swing.JPasswordField();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pnlSecundario = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        label_name_user = new javax.swing.JLabel();
        label_name_rol = new javax.swing.JLabel();
        btn_photo = new javax.swing.JButton();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout cubiertaPestañasLayout = new javax.swing.GroupLayout(cubiertaPestañas);
        cubiertaPestañas.setLayout(cubiertaPestañasLayout);
        cubiertaPestañasLayout.setHorizontalGroup(
            cubiertaPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        cubiertaPestañasLayout.setVerticalGroup(
            cubiertaPestañasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(cubiertaPestañas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 490, 40));

        pnlPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInicio.setBackground(new java.awt.Color(0, 0, 0));
        pnlInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInicio.setFont(new java.awt.Font("Roboto Condensed Light", 1, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boton-de-inicio.png"))); // NOI18N
        lblInicio.setText("          Inicio");
        pnlInicio.add(lblInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        pnlPrincipal.add(pnlInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 200, 50));

        pnlRegistroFerias.setBackground(new java.awt.Color(0, 0, 0));
        pnlRegistroFerias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegistroFerias.setFont(new java.awt.Font("Roboto Condensed Light", 1, 18)); // NOI18N
        lblRegistroFerias.setForeground(new java.awt.Color(255, 255, 255));
        lblRegistroFerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/feria.png"))); // NOI18N
        lblRegistroFerias.setText("   Registro de Ferias");
        pnlRegistroFerias.add(lblRegistroFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        pnlPrincipal.add(pnlRegistroFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 200, 50));

        pnlListaFerias.setBackground(new java.awt.Color(0, 0, 0));
        pnlListaFerias.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblListaFerias.setFont(new java.awt.Font("Roboto Condensed Light", 1, 18)); // NOI18N
        lblListaFerias.setForeground(new java.awt.Color(255, 255, 255));
        lblListaFerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista-de-ferias.png"))); // NOI18N
        lblListaFerias.setText("      Lista de Ferias");
        pnlListaFerias.add(lblListaFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 50));

        pnlPrincipal.add(pnlListaFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, 50));

        pnlEmployees.setBackground(new java.awt.Color(0, 0, 0));

        lblEmployees.setFont(new java.awt.Font("Roboto Condensed Light", 1, 18)); // NOI18N
        lblEmployees.setForeground(new java.awt.Color(255, 255, 255));
        lblEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee.png"))); // NOI18N
        lblEmployees.setText("      Empleados");

        javax.swing.GroupLayout pnlEmployeesLayout = new javax.swing.GroupLayout(pnlEmployees);
        pnlEmployees.setLayout(pnlEmployeesLayout);
        pnlEmployeesLayout.setHorizontalGroup(
            pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        pnlEmployeesLayout.setVerticalGroup(
            pnlEmployeesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblEmployees, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        pnlPrincipal.add(pnlEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, 50));

        pnlSettings.setBackground(new java.awt.Color(0, 0, 0));

        lblSettings.setFont(new java.awt.Font("Roboto Condensed Light", 1, 18)); // NOI18N
        lblSettings.setForeground(new java.awt.Color(255, 255, 255));
        lblSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        lblSettings.setText("      Configuración");

        javax.swing.GroupLayout pnlSettingsLayout = new javax.swing.GroupLayout(pnlSettings);
        pnlSettings.setLayout(pnlSettingsLayout);
        pnlSettingsLayout.setHorizontalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlSettingsLayout.setVerticalGroup(
            pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSettingsLayout.createSequentialGroup()
                .addComponent(lblSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlPrincipal.add(pnlSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 200, 50));

        getContentPane().add(pnlPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, 600));

        jTabbedPane1.setBackground(new java.awt.Color(205, 205, 205));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(242, 239, 235));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEmployees.setBackground(new java.awt.Color(242, 239, 235));
        btnEmployees.setForeground(new java.awt.Color(249, 246, 241));
        btnEmployees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empleado.png"))); // NOI18N
        btnEmployees.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null), "Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel10.add(btnEmployees, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 60, 240, 120));

        btnRegistroFerias.setBackground(new java.awt.Color(242, 239, 235));
        btnRegistroFerias.setForeground(new java.awt.Color(249, 246, 241));
        btnRegistroFerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/feriaBtnn.png"))); // NOI18N
        btnRegistroFerias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null), "Registro de Ferias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        btnRegistroFerias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroFeriasActionPerformed(evt);
            }
        });
        jPanel10.add(btnRegistroFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 56, 240, 120));

        btnListaFerias.setBackground(new java.awt.Color(242, 239, 235));
        btnListaFerias.setForeground(new java.awt.Color(249, 246, 241));
        btnListaFerias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/caja.png"))); // NOI18N
        btnListaFerias.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null), "Lista de Ferias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel10.add(btnListaFerias, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 56, 240, 120));

        btnSettings.setBackground(new java.awt.Color(242, 239, 235));
        btnSettings.setForeground(new java.awt.Color(249, 246, 241));
        btnSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configuraciones.png"))); // NOI18N
        btnSettings.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null), "Configuracion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel10.add(btnSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 240, 120));

        btnEjercicios.setBackground(new java.awt.Color(242, 239, 235));
        btnEjercicios.setForeground(new java.awt.Color(249, 246, 241));
        btnEjercicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista-de-ferias.png"))); // NOI18N
        btnEjercicios.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null), "Ejercicios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel10.add(btnEjercicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 240, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondo_empresa.jpg"))); // NOI18N
        jPanel10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 570));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        jTabbedPane1.addTab("Inicio", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(205, 205, 205));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(52, 52, 52));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Ferias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblNombre.setText("Nombre:");
        jPanel13.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 45, -1, -1));

        txtNombreFeria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel13.add(txtNombreFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 190, 30));

        lblUbicacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUbicacion.setForeground(new java.awt.Color(255, 255, 255));
        lblUbicacion.setText("Distrito:");
        jPanel13.add(lblUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        txtDistritoFeria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel13.add(txtDistritoFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 85, 190, 30));

        lblFechaInicio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFechaInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaInicio.setText("Fecha de Inicio:");
        jPanel13.add(lblFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 45, -1, -1));

        lblFechaFin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFechaFin.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaFin.setText("Fecha de Fin:");
        jPanel13.add(lblFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 108, -1));

        btnCancelFeria.setBackground(new java.awt.Color(205, 205, 205));
        btnCancelFeria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelFeria.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelFeria.setText("Cancelar");
        jPanel13.add(btnCancelFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 98, 30));

        btnDeleteFeria.setBackground(new java.awt.Color(205, 205, 205));
        btnDeleteFeria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteFeria.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteFeria.setText("Eliminar");
        jPanel13.add(btnDeleteFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 98, 30));

        lblCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(255, 255, 255));
        lblCategoria.setText("Categoria:");
        jPanel13.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 265, 92, -1));

        cmbCategoriaFeria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- SELECCIONE ---", "PEQUEÑA", "MEDIANA", "GRANDE" }));
        jPanel13.add(cmbCategoriaFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 190, 30));

        lblEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado:");
        jPanel13.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 60, -1));

        cmbEstadoFeria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--- SELECCIONE ---", "PENDIENTE", "VIABLE", "INVIABLE" }));
        jPanel13.add(cmbEstadoFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 85, 190, 30));

        jDateInicio.setDateFormatString("yyyy-MM-dd");
        jPanel13.add(jDateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 190, 30));

        jDateFin.setDateFormatString("yyyy-MM-dd");
        jPanel13.add(jDateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 85, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Aforo:");
        jPanel13.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 55, -1));
        jPanel13.add(txtAforoFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 190, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("<html><center><p>Monto de Inversión</p><p>incial:</p></center></html>");
        jPanel13.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, -1, -1));
        jPanel13.add(txtMontoFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 190, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Código:");
        jPanel13.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 45, -1, -1));

        txtCodigoFeria.setEditable(false);
        jPanel13.add(txtCodigoFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 190, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Categoria:");
        jPanel13.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, 20));

        btnRegisterFeria.setBackground(new java.awt.Color(205, 205, 205));
        btnRegisterFeria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegisterFeria.setForeground(new java.awt.Color(0, 0, 0));
        btnRegisterFeria.setText("Registrar");
        jPanel13.add(btnRegisterFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 98, 30));

        btnUpdateFeria.setBackground(new java.awt.Color(205, 205, 205));
        btnUpdateFeria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateFeria.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdateFeria.setText("Modificar");
        jPanel13.add(btnUpdateFeria, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 98, 30));

        jLabel10.setFont(new java.awt.Font("Roboto Condensed", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("*Generado Automaticamente");
        jPanel13.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, -1, 30));

        jPanel1.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 930, 240));

        tableFerias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Distrito", "Categoria", "Aforo", "Fecha de Inicio", "Fecha de cierre", "Monto de inversion inicial", "Estado de aprobación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableFerias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 930, 210));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto Condensed Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Lista original");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 530, -1, -1));

        btnBurbuja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ordenar.png"))); // NOI18N
        jPanel1.add(btnBurbuja, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 50, 40));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto Condensed Light", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ordenar por Categorias:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, -1, -1));

        btnListaOriginal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lista.png"))); // NOI18N
        jPanel1.add(btnListaOriginal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, 50, 40));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 580));

        jTabbedPane1.addTab("Registro de Ferias", jPanel3);

        jPanel5.setBackground(new java.awt.Color(205, 205, 205));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 15, 15));
        jLabel1.setText("LISTA DE FERIAS REGISTRADAS");
        jPanel5.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));

        btnPresupuestar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPresupuestar.setText("Presupuestar");
        jPanel5.add(btnPresupuestar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 300, 40));

        btnEstadoPresupuesto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEstadoPresupuesto.setText("Estados de Ingresos y egresos");
        jPanel5.add(btnEstadoPresupuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 300, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Reporte Presupuestal");
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 300, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Utlidad y rentabilidad");
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 300, 40));

        tableListaFerias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Distrito", "Categoria", "Aforo", "Fecha de Inicio", "Fecha de cierre", "Monto de inversion inicial", "Estado de aprobación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tableListaFerias);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 960, 360));

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

        jPanel7.setBackground(new java.awt.Color(205, 205, 205));
        jPanel7.setForeground(new java.awt.Color(204, 204, 204));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(52, 52, 52));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Registro de Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nombres:");
        jPanel14.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 137, 30));

        txt_employee_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 165, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Usuario:");
        jPanel14.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, -1));

        txt_employee_username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, 165, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Distrito");
        jPanel14.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, -1, 30));

        txt_employee_district.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_district, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 165, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Contraseña:");
        jPanel14.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Correo:");
        jPanel14.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        txt_employee_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 165, 30));

        txt_employee_password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 165, 30));

        cmb_rol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cmb_rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Auxiliar" }));
        jPanel14.add(cmb_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 165, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Rol:");
        jPanel14.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Id:");
        jPanel14.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, -1, -1));

        txt_employee_id.setEditable(false);
        txt_employee_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 165, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Apellidos:");
        jPanel14.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 135, 30));

        txt_employee_lastname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 165, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("DNI:");
        jPanel14.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 70, 30));

        txt_employee_dni.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 165, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Celular:");
        jPanel14.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, -1));

        txt_employee_telephone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel14.add(txt_employee_telephone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 165, 30));

        btn_register_employee.setBackground(new java.awt.Color(205, 205, 205));
        btn_register_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_register_employee.setForeground(new java.awt.Color(0, 0, 0));
        btn_register_employee.setText("Registrar");
        jPanel14.add(btn_register_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 110, 30));

        btn_update_employee.setBackground(new java.awt.Color(205, 205, 205));
        btn_update_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update_employee.setForeground(new java.awt.Color(0, 0, 0));
        btn_update_employee.setText("Modificar");
        jPanel14.add(btn_update_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 110, 30));

        btn_delete_employee.setBackground(new java.awt.Color(205, 205, 205));
        btn_delete_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete_employee.setForeground(new java.awt.Color(0, 0, 0));
        btn_delete_employee.setText("Eliminar");
        jPanel14.add(btn_delete_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 200, 110, 30));

        btn_cancel_employee.setBackground(new java.awt.Color(205, 205, 205));
        btn_cancel_employee.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_cancel_employee.setForeground(new java.awt.Color(0, 0, 0));
        btn_cancel_employee.setText("Cancelar");
        jPanel14.add(btn_cancel_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 110, 30));

        jLabel9.setFont(new java.awt.Font("Roboto Condensed", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("*Generado Automaticamente");
        jPanel14.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, -1, 30));

        jPanel7.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 930, 250));

        employee_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employee_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "DNI", "Distrito", "Correo electrónico", "Celular", "Usuario", "Contraseña", "Rol"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(employee_table);

        jPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 980, 250));

        jTabbedPane1.addTab("Empleados", jPanel7);

        jPanel8.setBackground(new java.awt.Color(205, 205, 205));
        jPanel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(52, 52, 52));
        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Editar Perfil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Id:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Nombre y Apellidos:");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Distrito:");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Celular:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Correo:");

        txt_id_profile.setEditable(false);

        txt_name_profile.setEditable(false);

        txt_district_profile.setEditable(false);

        txt_phone_profile.setEditable(false);

        txt_email_profile.setEditable(false);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Nueva contraseña:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Confrrmar contraseña:");

        btn_modify_data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_modify_data.setText("Modificar");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_email_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_phone_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_district_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel50))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_password_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_password_modify_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(btn_modify_data, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txt_id_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50)
                            .addComponent(txt_password_modify, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btn_modify_data, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(txt_name_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(txt_password_modify_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(txt_district_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txt_phone_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel49)
                    .addComponent(txt_email_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 20, 920, 390));

        jTabbedPane1.addTab("Configuración", jPanel8);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 1000, 600));

        pnlLogo.setBackground(new java.awt.Color(15, 15, 15));

        lblLogo.setBackground(new java.awt.Color(15, 15, 15));
        lblLogo.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 0));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Moderna_logo.jpg"))); // NOI18N

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

        pnlSecundario.setBackground(new java.awt.Color(0, 0, 0));
        pnlSecundario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Montserrat SemiBold", 1, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(249, 246, 241));
        lblTitle.setText("SISTEMA DE PRESUPUESTO DE FERIAS");
        pnlSecundario.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 520, -1));

        lblCerrar.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setText("X");
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
        });
        pnlSecundario.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 50, 50));

        label_name_user.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_name_user.setForeground(new java.awt.Color(255, 255, 255));
        pnlSecundario.add(label_name_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 140, 20));

        label_name_rol.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label_name_rol.setForeground(new java.awt.Color(255, 255, 255));
        pnlSecundario.add(label_name_rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 140, 20));

        btn_photo.setBackground(new java.awt.Color(249, 246, 241));
        btn_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/man.png"))); // NOI18N
        pnlSecundario.add(btn_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 90, -1));

        getContentPane().add(pnlSecundario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1000, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistroFeriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroFeriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistroFeriasActionPerformed

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        // TODO add your handling code here:
        setVisible(false);
        LoginView loginView = new LoginView();
        loginView.setVisible(true);
    }//GEN-LAST:event_lblCerrarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBurbuja;
    public javax.swing.JButton btnCancelFeria;
    public javax.swing.JButton btnDeleteFeria;
    public javax.swing.JButton btnEjercicios;
    public javax.swing.JButton btnEmployees;
    public javax.swing.JButton btnEstadoPresupuesto;
    public javax.swing.JButton btnListaFerias;
    public javax.swing.JButton btnListaOriginal;
    public javax.swing.JButton btnPresupuestar;
    public javax.swing.JButton btnRegisterFeria;
    public javax.swing.JButton btnRegistroFerias;
    public javax.swing.JButton btnSettings;
    public javax.swing.JButton btnUpdateFeria;
    public javax.swing.JButton btn_cancel_employee;
    public javax.swing.JButton btn_delete_employee;
    public javax.swing.JButton btn_modify_data;
    private javax.swing.JButton btn_photo;
    public javax.swing.JButton btn_register_employee;
    public javax.swing.JButton btn_update_employee;
    public javax.swing.JComboBox<String> cmbCategoriaFeria;
    public javax.swing.JComboBox<String> cmbEstadoFeria;
    public javax.swing.JComboBox<String> cmb_rol;
    public javax.swing.JLayeredPane cubiertaPestañas;
    public javax.swing.JTable employee_table;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public com.toedter.calendar.JDateChooser jDateFin;
    public com.toedter.calendar.JDateChooser jDateInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    public javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    public javax.swing.JLabel label_name_rol;
    public javax.swing.JLabel label_name_user;
    private javax.swing.JLabel lblCategoria;
    public javax.swing.JLabel lblCerrar;
    public javax.swing.JLabel lblEmployees;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaFin;
    private javax.swing.JLabel lblFechaInicio;
    public javax.swing.JLabel lblInicio;
    public javax.swing.JLabel lblListaFerias;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblRegistroFerias;
    public javax.swing.JLabel lblSettings;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUbicacion;
    public javax.swing.JPanel pnlEmployees;
    public javax.swing.JPanel pnlInicio;
    public javax.swing.JPanel pnlListaFerias;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JPanel pnlPrincipal;
    public javax.swing.JPanel pnlRegistroFerias;
    private javax.swing.JPanel pnlSecundario;
    public javax.swing.JPanel pnlSettings;
    public javax.swing.JTable tableFerias;
    public javax.swing.JTable tableListaFerias;
    public javax.swing.JTextField txtAforoFeria;
    public javax.swing.JTextField txtCodigoFeria;
    public javax.swing.JTextField txtDistritoFeria;
    public javax.swing.JTextField txtMontoFeria;
    public javax.swing.JTextField txtNombreFeria;
    public javax.swing.JTextField txt_district_profile;
    public javax.swing.JTextField txt_email_profile;
    public javax.swing.JTextField txt_employee_district;
    public javax.swing.JTextField txt_employee_dni;
    public javax.swing.JTextField txt_employee_email;
    public javax.swing.JTextField txt_employee_id;
    public javax.swing.JTextField txt_employee_lastname;
    public javax.swing.JTextField txt_employee_name;
    public javax.swing.JPasswordField txt_employee_password;
    public javax.swing.JTextField txt_employee_telephone;
    public javax.swing.JTextField txt_employee_username;
    public javax.swing.JTextField txt_id_profile;
    public javax.swing.JTextField txt_name_profile;
    public javax.swing.JPasswordField txt_password_modify;
    public javax.swing.JPasswordField txt_password_modify_confirm;
    public javax.swing.JTextField txt_phone_profile;
    // End of variables declaration//GEN-END:variables
}
