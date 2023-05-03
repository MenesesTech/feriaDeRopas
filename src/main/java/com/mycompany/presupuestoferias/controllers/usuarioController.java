package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.usuario;
import com.mycompany.presupuestoferias.models.usuarioDao;
import static com.mycompany.presupuestoferias.models.usuarioDao.id_user;
import static com.mycompany.presupuestoferias.models.usuarioDao.rol_user;
import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class usuarioController implements ActionListener, MouseListener {

    private usuario user_employee;
    private usuarioDao userDao;
    private SystemView systemView;
    DefaultTableModel model = new DefaultTableModel();
    String rol = rol_user;

    public usuarioController(usuario user_employee, usuarioDao userDao, SystemView systemView) {
        this.user_employee = user_employee;
        this.userDao = userDao;
        this.systemView = systemView;
        //Boton registrar usuario
        this.systemView.btn_register_employee.addActionListener(this);
        //Boton modificar usuario
        this.systemView.btn_update_employee.addActionListener(this);
        //Boton eliminar usuario
        this.systemView.btn_delete_employee.addActionListener(this);
        //Boton cancelar
        this.systemView.btn_cancel_employee.addActionListener(this);
        //Boton cambiar la contraseña
        this.systemView.btn_modify_data.addActionListener(this);
        //Tabla de usuarios
        this.systemView.employee_table.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == systemView.btn_register_employee) {
            if (systemView.txt_employee_fullname.getText().equals("")
                    || systemView.txt_employee_username.getText().equals("")
                    || systemView.txt_employee_telephone.getText().equals("")
                    || systemView.txt_employee_email.getText().equals("")
                    || String.valueOf(systemView.txt_employee_password.getPassword()).equals("")
                    || systemView.cmb_rol.getSelectedItem().toString().equals("")) {

                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                //Realizar la insercion 
                user_employee.setFull_name(systemView.txt_employee_fullname.getText().trim());
                user_employee.setUsername(systemView.txt_employee_username.getText().trim());
                user_employee.setTelephone(systemView.txt_employee_telephone.getText().trim());
                user_employee.setEmail(systemView.txt_employee_email.getText().trim());
                user_employee.setPassword(String.valueOf(systemView.txt_employee_password.getPassword()));
                user_employee.setRol(systemView.cmb_rol.getSelectedItem().toString());
                if (userDao.registerUserQuery(user_employee)) {
                    cleanTable();
                    listAllEmployees();
                    JOptionPane.showMessageDialog(null, "Empleado registrado con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar un empleado");
                }
            }
        } else if (e.getSource() == systemView.btn_update_employee) {
            if (systemView.txt_employee_id.equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila para continuar");
            } else {
                //  Verificar que todos los campos no esten vacios
                if (systemView.txt_employee_id.getText().equals("")
                        || systemView.txt_employee_fullname.getText().equals("")
                        || systemView.txt_employee_username.getText().equals("")
                        || systemView.cmb_rol.getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");

                } else {
                    //Modificar datos del usuario
                    user_employee.setId(Integer.parseInt(systemView.txt_employee_id.getText().trim()));
                    user_employee.setFull_name(systemView.txt_employee_fullname.getText().trim());
                    user_employee.setUsername(systemView.txt_employee_username.getText().trim());
                    user_employee.setTelephone(systemView.txt_employee_telephone.getText().trim());
                    user_employee.setEmail(systemView.txt_employee_email.getText().trim());
                    user_employee.setPassword(String.valueOf(systemView.txt_employee_password.getPassword()));
                    user_employee.setRol(systemView.cmb_rol.getSelectedItem().toString());
                    if (userDao.updateUserQuery(user_employee)) {
                        cleanTable();
                        cleanFields();
                        listAllEmployees();
                        JOptionPane.showMessageDialog(null, "Datos del empleado modificados con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar un empleado");
                    }
                }
            }
        } else if (e.getSource() == systemView.btn_delete_employee) {
            //Almacena numero de fila
            int row = systemView.employee_table.getSelectedRow();
            //No eliminar si no almacena numero de fila
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado para eliminar");
            } else if (systemView.employee_table.getValueAt(row, 0).equals(id_user)) {
                JOptionPane.showMessageDialog(null, "No puede eliminar el usuario autenticado");
            } else {
                //Elimina usuario
                int id = Integer.parseInt(systemView.employee_table.getValueAt(row, 0).toString());
                int question = JOptionPane.showConfirmDialog(null, "¿En realidad quieres eliminar a este empleado");
                if (question == 0 && userDao.deleteUserQuery(id) != false) {
                    cleanFields();
                    cleanTable();
                    systemView.btn_register_employee.setEnabled(true);
                    systemView.txt_employee_password.setEnabled(true);
                    listAllEmployees();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");
                }
            }
            //Boton cancelar
        } else if (e.getSource() == systemView.btn_cancel_employee) {
            cleanFields();
            systemView.btn_register_employee.setEnabled(true);
            systemView.txt_employee_password.setEnabled(true);
            systemView.txt_employee_id.setEnabled(true);

            //Boton cambiar contraseña
        } else if (e.getSource() == systemView.btn_modify_data) {
            String password = String.valueOf(systemView.txt_password_modify.getPassword());
            String confirm_password = String.valueOf(systemView.txt_password_modify_confirm.getPassword());
            //Verificar que las cajas de texto esten vacias
            if (!password.equals("") && !confirm_password.equals("")) {
                //Verificar que las contraseñas sean iguales
                if (password.equals(confirm_password)) {
                    user_employee.setPassword(String.valueOf(systemView.txt_password_modify.getPassword()));
                    //Cambio de contraseña
                    if (userDao.updateEmployeePassword(user_employee) != false) {
                        JOptionPane.showMessageDialog(null, "Contraseña modificada con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar la contraseña ");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                }
            }
        }
    }

    //Metodo para listar todos los empleados
    public void listAllEmployees() {
        List<usuario> list = userDao.listUserQuery();
        model = (DefaultTableModel) systemView.employee_table.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getFull_name();
            row[2] = list.get(i).getUsername();
            row[3] = list.get(i).getTelephone();
            row[4] = list.get(i).getEmail();
            row[5] = list.get(i).getRol();
            model.addRow(row);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemView.employee_table) {
            //Capturar fila
            int row = systemView.employee_table.rowAtPoint(e.getPoint());
            //Rellenar cajas de texto  
            systemView.txt_employee_id.setText(systemView.employee_table.getValueAt(row, 0).toString());
            systemView.txt_employee_fullname.setText(systemView.employee_table.getValueAt(row, 1).toString());
            systemView.txt_employee_username.setText(systemView.employee_table.getValueAt(row, 2).toString());
            systemView.txt_employee_telephone.setText(systemView.employee_table.getValueAt(row, 3).toString());
            systemView.txt_employee_email.setText(systemView.employee_table.getValueAt(row, 4).toString());
            systemView.cmb_rol.setSelectedItem(systemView.employee_table.getValueAt(row, 5).toString());
            //Desabilita cajas de texto 
            systemView.txt_employee_id.setEditable(false);
            systemView.txt_employee_password.setEnabled(false);
            systemView.btn_register_employee.setEnabled(false);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    public void cleanFields() {
        systemView.txt_employee_id.setText("");
        systemView.txt_employee_id.setEditable(true);
        systemView.txt_employee_fullname.setText("");
        systemView.txt_employee_username.setText("");
        systemView.txt_employee_telephone.setText("");
        systemView.txt_employee_email.setText("");
        systemView.txt_employee_password.setText("");
        systemView.cmb_rol.setSelectedIndex(0);
    }
    
    //Metodo para limpiar tabla
    public void cleanTable() {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }
}
