package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.feria;
import com.mycompany.presupuestoferias.models.feriaDao;
import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class feriasController implements ActionListener {

    private feria feria_ropa;
    private feriaDao feriaRopaDao;
    private SystemView SystemView;

    public feriasController(feria feria_ropa, feriaDao feriaRopaDao, SystemView SystemView) {
        this.feria_ropa = feria_ropa;
        this.feriaRopaDao = feriaRopaDao;
        this.SystemView = SystemView;
        this.SystemView.btnRegisterFeria.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SystemView.btnRegisterFeria) {
            if (SystemView.txtNombre.getText().equals("")
                    || SystemView.txtUbicacion.getText().equals("")
                    || SystemView.cmbCategoria.getSelectedItem().toString().equals("")
                    || SystemView.cmbEstado.getSelectedItem().toString().equals("")
                    || SystemView.txtOrganizador.getText().equals("")
                    || SystemView.txtTelefono.getText().equals("")
                    || SystemView.txtCorreo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Es obligatorio colocar el nombre de la Feria");
            } else {
                feria_ropa.setName(SystemView.txtNombre.getText().trim());
                feria_ropa.setAddress(SystemView.txtUbicacion.getText().trim());
                feria_ropa.setCategory(SystemView.cmbCategoria.getSelectedItem().toString());
                feria_ropa.setStatus(SystemView.cmbEstado.getSelectedItem().toString());
                feria_ropa.setOrganizador(SystemView.txtOrganizador.getText().trim());
                feria_ropa.setTelephone(SystemView.txtTelefono.getText().trim());
                feria_ropa.setEmail(SystemView.txtCorreo.getText().trim());
                if (feriaRopaDao.registroFeriaQuery(feria_ropa)) {
                    JOptionPane.showMessageDialog(null, "Empleado registrado con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar un empleado");
                }
            }
        }
    }

}
