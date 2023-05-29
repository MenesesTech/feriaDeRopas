package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.empleado;
import com.mycompany.presupuestoferias.models.empleadoDao;
import static com.mycompany.presupuestoferias.models.empleadoDao.district_user;
import static com.mycompany.presupuestoferias.models.empleadoDao.email_user;
import static com.mycompany.presupuestoferias.models.empleadoDao.id_user;
import static com.mycompany.presupuestoferias.models.empleadoDao.lastname_user;
import static com.mycompany.presupuestoferias.models.empleadoDao.name_user;
import static com.mycompany.presupuestoferias.models.empleadoDao.phone_user;
import static com.mycompany.presupuestoferias.models.empleadoDao.rol_user;
import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class usuarioController implements ActionListener, MouseListener {

    private empleado user_employee;
    private empleadoDao userDao;
    private SystemView systemView;
    DefaultTableModel model = new DefaultTableModel();
    String rol = rol_user;

    public usuarioController(empleado user_employee, empleadoDao userDao, SystemView systemView) {
        this.user_employee = user_employee;
        this.userDao = userDao;
        this.systemView = systemView;
        //Boton registrar empleado
        this.systemView.btn_register_employee.addActionListener(this);
        //Boton modificar empleado
        this.systemView.btn_update_employee.addActionListener(this);
        //Boton eliminar empleado
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
            if (systemView.txt_employee_name.getText().equals("")
                    || systemView.txt_employee_lastname.getText().equals("")
                    || systemView.txt_employee_dni.getText().equals("")
                    || systemView.txt_employee_district.getText().equals("")
                    || systemView.txt_employee_email.getText().equals("")
                    || systemView.txt_employee_telephone.getText().equals("")
                    || String.valueOf(systemView.txt_employee_password.getPassword()).equals("")
                    || systemView.txt_employee_username.getText().equals("")
                    || systemView.cmb_rol.getSelectedItem().toString().equals("")) {

                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                user_employee.setName(systemView.txt_employee_name.getText().trim());
                user_employee.setLastName(systemView.txt_employee_lastname.getText().trim());
                user_employee.setDNI(systemView.txt_employee_dni.getText().trim());
                user_employee.setDistrict(systemView.txt_employee_district.getText().trim());
                user_employee.setEmail(systemView.txt_employee_email.getText().trim());
                user_employee.setTelephone(systemView.txt_employee_telephone.getText().trim());
                user_employee.setId(userDao.generarCodigo());
                user_employee.setUsername(systemView.txt_employee_username.getText().trim());
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
            if (systemView.txt_employee_id.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila para continuar");
            } else {
                //  Verificar que todos los campos no esten vacios
                if (systemView.txt_employee_name.getText().equals("")
                        || systemView.txt_employee_lastname.getText().equals("")
                        || systemView.txt_employee_dni.getText().equals("")
                        || systemView.txt_employee_district.getText().equals("")
                        || systemView.txt_employee_email.getText().equals("")
                        || systemView.txt_employee_telephone.getText().equals("")
                        || systemView.txt_employee_id.getText().equals("")
                        || systemView.txt_employee_username.getText().equals("")
                        || systemView.cmb_rol.getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    user_employee.setId(systemView.txt_employee_id.getText().trim());
                    user_employee.setName(systemView.txt_employee_name.getText().trim());
                    user_employee.setLastName(systemView.txt_employee_lastname.getText().trim());
                    user_employee.setDNI(systemView.txt_employee_dni.getText().trim());
                    user_employee.setDistrict(systemView.txt_employee_district.getText().trim());
                    user_employee.setEmail(systemView.txt_employee_email.getText().trim());
                    user_employee.setTelephone(systemView.txt_employee_telephone.getText().trim());
                    user_employee.setUsername(systemView.txt_employee_username.getText().trim());
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
            int row = systemView.employee_table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un empleado para eliminar");
            } else if (systemView.employee_table.getValueAt(row, 0).equals(id_user)) {
                JOptionPane.showMessageDialog(null, "No puede eliminar el usuario autenticado");
            } else {
                // Obtiene el ID del empleado seleccionado en la tabla
                String id = systemView.employee_table.getValueAt(row, 0).toString();
                // Muestra una confirmación para confirmar la eliminación
                int question = JOptionPane.showConfirmDialog(null, "¿En realidad quieres eliminar a este empleado?");

                // Si el usuario confirma la eliminación y se logra eliminar el empleado correctamente
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
                        cleanTable();
                        listAllEmployees();
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
        List<empleado> list = userDao.listUserQuery();
        model = (DefaultTableModel) systemView.employee_table.getModel();
        Object[] row = new Object[10];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getLastName();
            row[3] = list.get(i).getDNI();
            row[4] = list.get(i).getDistrict();
            row[5] = list.get(i).getEmail();
            row[6] = list.get(i).getTelephone();
            row[7] = list.get(i).getUsername();
            row[8] = list.get(i).getPassword();
            row[9] = list.get(i).getRol();
            model.addRow(row);
        }
    }

    public void EmployeeProfile() {
        systemView.txt_id_profile.setText(id_user);
        systemView.txt_name_profile.setText(name_user + " " + lastname_user);
        systemView.txt_district_profile.setText(district_user);
        systemView.txt_phone_profile.setText(phone_user);
        systemView.txt_email_profile.setText(email_user);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemView.employee_table) {
            //Capturar fila
            int row = systemView.employee_table.rowAtPoint(e.getPoint());
            //Rellenar cajas de texto  
            systemView.txt_employee_id.setText(systemView.employee_table.getValueAt(row, 0).toString());
            systemView.txt_employee_name.setText(systemView.employee_table.getValueAt(row, 1).toString());
            systemView.txt_employee_lastname.setText(systemView.employee_table.getValueAt(row, 2).toString());
            systemView.txt_employee_dni.setText(systemView.employee_table.getValueAt(row, 3).toString());
            systemView.txt_employee_district.setText(systemView.employee_table.getValueAt(row, 4).toString());
            systemView.txt_employee_email.setText(systemView.employee_table.getValueAt(row, 5).toString());
            systemView.txt_employee_telephone.setText(systemView.employee_table.getValueAt(row, 6).toString());
            systemView.txt_employee_username.setText(systemView.employee_table.getValueAt(row, 7).toString());
            systemView.cmb_rol.setSelectedItem(systemView.employee_table.getValueAt(row, 9).toString());
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
        systemView.txt_employee_name.setText("");
        systemView.txt_employee_lastname.setText("");
        systemView.txt_employee_dni.setText("");
        systemView.txt_employee_district.setText("");
        systemView.txt_employee_email.setText("");
        systemView.txt_employee_telephone.setText("");
        systemView.txt_employee_username.setText("");
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
