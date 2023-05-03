package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.feria;
import com.mycompany.presupuestoferias.models.feriaDao;
import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class feriaController implements ActionListener, MouseListener {

    private feria feria_ropa;
    private feriaDao feriaRopaDao;
    private SystemView SystemView;

    public feriaController(feria feria_ropa, feriaDao feriaRopaDao, SystemView SystemView) {
        this.feria_ropa = feria_ropa;
        this.feriaRopaDao = feriaRopaDao;
        this.SystemView = SystemView;
        //Boton Registrar feria
        this.SystemView.btnRegisterFeria.addActionListener(this);
        //Tabla de ferias
        this.SystemView.tableFerias.addMouseListener(this);
        //Boton de Ordenar Lista por categorias
        this.SystemView.btnBurbuja.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fechaInicio = ((JTextField) SystemView.jDateInicio.getDateEditor().getUiComponent()).getText();
        String fechaFin = ((JTextField) SystemView.jDateFin.getDateEditor().getUiComponent()).getText();
        if (e.getSource() == SystemView.btnRegisterFeria) {
            // Validar si los campos obligatorios están vacíos y mostrar un mensaje de error si es necesario
            if (SystemView.txtNombre.getText().equals("")
                    || SystemView.txtUbicacion.getText().equals("")
                    || SystemView.cmbCategoria.getSelectedItem().toString().equals("")
                    || SystemView.cmbEstado.getSelectedItem().toString().equals("")
                    || SystemView.jDateInicio.getDate() == null
                    || SystemView.jDateFin.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los datos");

            } else {
                feria_ropa.setName(SystemView.txtNombre.getText().trim());
                feria_ropa.setAddress(SystemView.txtUbicacion.getText().trim());
                feria_ropa.setCategory(SystemView.cmbCategoria.getSelectedItem().toString().trim());
                feria_ropa.setStatus(SystemView.cmbEstado.getSelectedItem().toString().trim());
                feria_ropa.setDateInicio(Date.valueOf(fechaInicio));
                feria_ropa.setDateFin(Date.valueOf(fechaFin));
                feria_ropa.setOrganizador(SystemView.txtOrganizador.getText().trim());
                feria_ropa.setEmail(SystemView.txtCorreo.getText().trim());
                feria_ropa.setTelephone(SystemView.txtTelefono.getText().trim());
                if (feriaRopaDao.registroFeriaQuery(feria_ropa)) {
                    cleanTable();
                    listAllFerias();
                    JOptionPane.showMessageDialog(null, "Feria registrada con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar una Feria");
                }
            }
        }
    }

    //Metodo para listar todas las ferias
    public void listAllFerias() {
        List<feria> list = feriaRopaDao.listFeriaQuery();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) SystemView.tableFerias.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getAddress();
            row[2] = list.get(i).getCategory();
            row[3] = list.get(i).getStatus();
            row[4] = list.get(i).getDateInicio();
            row[5] = list.get(i).getDateFin();
            model.addRow(row);
        }
    }

    //Metodo Burbuja para ordenar las categorias
    public void listBurbujaFerias() {
        List<feria> list = feriaRopaDao.listFeriaQuery();
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                // Comparar las categorías de ferias adyacentes
                String category1 = list.get(j).getCategory();
                String category2 = list.get(j + 1).getCategory();
                if (category1.compareToIgnoreCase(category2) > 0) {
                    // Si la categoría de la feria j es mayor que la de la feria j + 1,
                    // intercambiar las posiciones de las ferias en la lista
                    feria temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        // Inicializar el modelo de la tabla
        DefaultTableModel model = (DefaultTableModel) SystemView.tableFerias.getModel();
        cleanTable();
        // Recorrer la lista de ferias ordenadas y agregar las filas a la tabla
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getAddress();
            row[2] = list.get(i).getCategory();
            row[3] = list.get(i).getStatus();
            row[4] = list.get(i).getDateInicio();
            row[5] = list.get(i).getDateFin();
            model.addRow(row);
        }
        SystemView.tableFerias.setModel(model);
    }

    //Metodo para limpiar tabla
    public void cleanTable() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) SystemView.tableFerias.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == SystemView.btnBurbuja) {
            listBurbujaFerias();
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
}
