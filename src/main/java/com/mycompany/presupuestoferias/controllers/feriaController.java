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
    private SystemView systemView;

    public feriaController(feria feria_ropa, feriaDao feriaRopaDao, SystemView systemView) {
        this.feria_ropa = feria_ropa;
        this.feriaRopaDao = feriaRopaDao;
        this.systemView = systemView;
        //Boton Registrar feria
        this.systemView.btnRegisterFeria.addActionListener(this);
        //Boton cancelar Feria
        this.systemView.btnCancelFeria.addActionListener(this);
        //Tabla de ferias
        this.systemView.tableFerias.addMouseListener(this);
        //Boton de Ordenar Lista por categorias
        this.systemView.btnBurbuja.addMouseListener(this);
        //Tabla de ferias
        this.systemView.tableListaFerias.addMouseListener(this);
        //Boton de Lista original
        this.systemView.btnListaOriginal.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fechaInicio = ((JTextField) systemView.jDateInicio.getDateEditor().getUiComponent()).getText();
        String fechaFin = ((JTextField) systemView.jDateFin.getDateEditor().getUiComponent()).getText();
        if (e.getSource() == systemView.btnRegisterFeria) {
            // Validar si los campos obligatorios están vacíos y mostrar un mensaje de error si es necesario
            if (systemView.txtNombre.getText().equals("")
                    || systemView.txtUbicacion.getText().equals("")
                    || systemView.cmbCategoria.getSelectedItem().toString().equals("")
                    || systemView.cmbEstado.getSelectedItem().toString().equals("")
                    || systemView.jDateInicio.getDate() == null
                    || systemView.jDateFin.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los datos");

            } else {
                feria_ropa.setName(systemView.txtNombre.getText().trim());
                feria_ropa.setAddress(systemView.txtUbicacion.getText().trim());
                feria_ropa.setCategory(systemView.cmbCategoria.getSelectedItem().toString().trim());
                feria_ropa.setStatus(systemView.cmbEstado.getSelectedItem().toString().trim());
                feria_ropa.setDateInicio(Date.valueOf(fechaInicio));
                feria_ropa.setDateFin(Date.valueOf(fechaFin));
                feria_ropa.setOrganizador(systemView.txtOrganizador.getText().trim());
                feria_ropa.setEmail(systemView.txtCorreo.getText().trim());
                feria_ropa.setTelephone(systemView.txtTelefono.getText().trim());
                if (feriaRopaDao.registroFeriaQuery(feria_ropa)) {
                    cleanFields();
                    cleanTable();
                    listAllFerias();
                    JOptionPane.showMessageDialog(null, "Feria registrada con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar una Feria");
                }
            }
        }else if (e.getSource() == systemView.btnCancelFeria) {
            cleanFields();
            systemView.txtNombre.setEditable(true);
            systemView.txtUbicacion.setEditable(true);
        }
    }

    //Metodo para listar todas las ferias en la lista secundaria
    public void listAllFerias() {
        List<feria> list = feriaRopaDao.listFeriaQuery();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) systemView.tableFerias.getModel();
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

    //Metodo para listar todas las ferias en la lista Principal
    public void listAllFeriasPrincipal() {
        List<feria> list = feriaRopaDao.listFeriaPrincipalQuery();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) systemView.tableListaFerias.getModel();
        Object[] row = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getAddress();
            row[2] = list.get(i).getDateInicio();
            row[3] = list.get(i).getDateFin();
            row[4] = list.get(i).getOrganizador();
            row[5] = list.get(i).getTelephone();
            row[6] = list.get(i).getEmail();
            row[7] = list.get(i).getCategory();
            row[8] = list.get(i).getStatus();
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
        DefaultTableModel model = (DefaultTableModel) systemView.tableFerias.getModel();
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
        systemView.tableFerias.setModel(model);
    }

    //Metodo para limpiar tabla
    public void cleanTable() {
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) systemView.tableFerias.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == systemView.btnBurbuja) {
            listBurbujaFerias();
        } else if (e.getSource() == systemView.btnListaOriginal) {
            cleanTable();
            listAllFerias();
        } else if (e.getSource() == systemView.tableFerias) {
            //Capturar fila
            int row = systemView.tableFerias.rowAtPoint(e.getPoint());
            //Rellenar  cajas de texto
            systemView.txtNombre.setText(systemView.tableFerias.getValueAt(row, 0).toString());
            systemView.txtUbicacion.setText(systemView.tableFerias.getValueAt(row, 1).toString());
            systemView.cmbCategoria.setSelectedItem(systemView.tableFerias.getValueAt(row, 2).toString());
            systemView.cmbEstado.setSelectedItem(systemView.tableFerias.getValueAt(row, 3).toString());
            systemView.jDateInicio.setDate((Date)systemView.tableFerias.getValueAt(row, 4));
            systemView.jDateFin.setDate((Date)systemView.tableFerias.getValueAt(row, 5));
            //Desactivar cajas de texto
            systemView.txtNombre.setEditable(false);
            systemView.txtUbicacion.setEditable(false);
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
    public void cleanFields(){
        systemView.txtNombre.setText("");
        systemView.txtUbicacion.setText("");
        systemView.jDateInicio.setDate(null);
        systemView.jDateFin.setDate(null);
        systemView.cmbCategoria.setSelectedIndex(0);
        systemView.cmbEstado.setSelectedIndex(0);
        systemView.txtOrganizador.setText("");
        systemView.txtCorreo.setText("");
        systemView.txtTelefono.setText("");
    }
    
}
