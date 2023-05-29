package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.feria;
import com.mycompany.presupuestoferias.models.feriaDao;
import com.mycompany.presupuestoferias.views.PresupuestoView;
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
        //Boton Modificar feria
        this.systemView.btnUpdateFeria.addActionListener(this);
        //Boton Eliminar Feria
        this.systemView.btnDeleteFeria.addActionListener(this);
        //Tabla de ferias
        this.systemView.tableFerias.addMouseListener(this);
        //Boton de Ordenar Lista por categorias
        this.systemView.btnBurbuja.addMouseListener(this);
        //Tabla de ferias
        this.systemView.tableListaFerias.addMouseListener(this);
        //Boton de Lista original
        this.systemView.btnListaOriginal.addMouseListener(this);
        this.systemView.btnPresupuestar.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fechaInicio = ((JTextField) systemView.jDateInicio.getDateEditor().getUiComponent()).getText();
        String fechaFin = ((JTextField) systemView.jDateFin.getDateEditor().getUiComponent()).getText();
        if (e.getSource() == systemView.btnRegisterFeria) {
            if (systemView.txtNombreFeria.getText().equals("")
                    || systemView.txtDistritoFeria.getText().equals("")
                    || systemView.txtAforoFeria.getText().equals("")
                    || systemView.jDateInicio.getDate() == null
                    || systemView.jDateFin.getDate() == null
                    || systemView.txtMontoFeria.getText().equals("")
                    || systemView.cmbEstadoFeria.getSelectedItem().toString().equals("")
                    || systemView.cmbCategoriaFeria.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los datos");

            } else {
                feria_ropa.setName(systemView.txtNombreFeria.getText().trim());
                feria_ropa.setDistrict(systemView.txtDistritoFeria.getText().trim());
                feria_ropa.setAforo(Integer.parseInt(systemView.txtAforoFeria.getText().trim()));
                feria_ropa.setDateInicio(Date.valueOf(fechaInicio));
                feria_ropa.setDateFin(Date.valueOf(fechaFin));
                feria_ropa.setMonto(Double.parseDouble(systemView.txtMontoFeria.getText().trim()));
                if (feriaRopaDao.obtenerUltimoCodigoFeria().equals("")) {
                    feria_ropa.setId("F0001");
                } else {
                    feria_ropa.setId(feriaRopaDao.generarCodigo());
                }
                feria_ropa.setStatus(systemView.cmbEstadoFeria.getSelectedItem().toString().trim());
                feria_ropa.setCategory(systemView.cmbCategoriaFeria.getSelectedItem().toString().trim());
                if (feriaRopaDao.registroFeriaQuery(feria_ropa)) {
                    cleanFields();
                    cleanTable();
                    listAllFerias();
                    listAllFeriasPrincipal();
                    JOptionPane.showMessageDialog(null, "Feria registrada con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar una Feria");
                }
            }
        } else if (e.getSource() == systemView.btnUpdateFeria) {
            if (systemView.txtCodigoFeria.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila para continuar");
            } else {
                //  Verificar que todos los campos no esten vacios
                if (systemView.txtNombreFeria.getText().equals("")
                        || systemView.txtDistritoFeria.getText().equals("")
                        || systemView.txtAforoFeria.getText().equals("")
                        || systemView.jDateInicio.getDate() == null
                        || systemView.jDateFin.getDate() == null
                        || systemView.txtMontoFeria.getText().equals("")
                        || systemView.txtCodigoFeria.getText().equals("")
                        || systemView.cmbEstadoFeria.getSelectedItem().toString().equals("")
                        || systemView.cmbCategoriaFeria.getSelectedItem().toString().equals("")) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {
                    feria_ropa.setName(systemView.txtNombreFeria.getText().trim());
                    feria_ropa.setDistrict(systemView.txtDistritoFeria.getText().trim());
                    feria_ropa.setAforo(Integer.parseInt(systemView.txtAforoFeria.getText().trim()));
                    feria_ropa.setDateInicio(Date.valueOf(fechaInicio));
                    feria_ropa.setDateFin(Date.valueOf(fechaFin));
                    feria_ropa.setMonto(Double.parseDouble(systemView.txtMontoFeria.getText().trim()));
                    feria_ropa.setStatus(systemView.cmbEstadoFeria.getSelectedItem().toString().trim());
                    feria_ropa.setCategory(systemView.cmbCategoriaFeria.getSelectedItem().toString().trim());
                    if (feriaRopaDao.updateFairQuery(feria_ropa)) {
                        cleanTable();
                        cleanFields();
                        listAllFerias();
                        listAllFeriasPrincipal();
                        JOptionPane.showMessageDialog(null, "Datos de la feria modificados con exito");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar una feria");
                    }
                }
            }
        } else if (e.getSource() == systemView.btnDeleteFeria) {
            //Almacena numero de fila
            int row = systemView.tableFerias.getSelectedRow();
            //No eliminar si no almacena numero de fila
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una feria para eliminar");
            } else {
                //Elimina feria
                String id = systemView.tableFerias.getValueAt(row, 0).toString();
                int question = JOptionPane.showConfirmDialog(null, "¿En realidad quieres eliminar esta feria?");
                if (question == 0 && feriaRopaDao.deleteFairQuery(id) != false) {
                    cleanFields();
                    cleanTable();
                    systemView.btn_register_employee.setEnabled(true);
                    systemView.txt_employee_password.setEnabled(true);
                    listAllFerias();
                    listAllFeriasPrincipal();
                    JOptionPane.showMessageDialog(null, "Feria eliminada con exito");
                }
            }
        } else if (e.getSource() == systemView.btnCancelFeria) {
            cleanFields();
            systemView.txtCodigoFeria.setEditable(true);
            systemView.btnRegisterFeria.setEnabled(true);
        }
    }

    //Metodo para listar todas las ferias despues del registro
    public void listAllFerias() {
        List<feria> list = feriaRopaDao.listFeriaQuery();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) systemView.tableFerias.getModel();
        Object[] row = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getDistrict();
            row[3] = list.get(i).getCategory();
            row[4] = list.get(i).getAforo();
            row[5] = list.get(i).getDateInicio();
            row[6] = list.get(i).getDateFin();
            row[7] = list.get(i).getMonto();
            row[8] = list.get(i).getStatus();
            model.addRow(row);
        }
    }

    //Metodo para listar todas las ferias para los presupuestos
    public void listAllFeriasPrincipal() {
        List<feria> list = feriaRopaDao.listFeriaQuery();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) systemView.tableListaFerias.getModel();
        Object[] row = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getDistrict();
            row[3] = list.get(i).getCategory();
            row[4] = list.get(i).getAforo();
            row[5] = list.get(i).getDateInicio();
            row[6] = list.get(i).getDateFin();
            row[7] = list.get(i).getMonto();
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
        Object[] row = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getDistrict();
            row[3] = list.get(i).getCategory();
            row[4] = list.get(i).getAforo();
            row[5] = list.get(i).getDateInicio();
            row[6] = list.get(i).getDateFin();
            row[7] = list.get(i).getMonto();
            row[8] = list.get(i).getStatus();
            model.addRow(row);
        }
        systemView.tableFerias.setModel(model);
    }

    //Metodo para limpiar tabla
    public void cleanTable() {
        DefaultTableModel model1 = (DefaultTableModel) systemView.tableFerias.getModel();
        DefaultTableModel model2 = (DefaultTableModel) systemView.tableListaFerias.getModel();

        int rowCount1 = model1.getRowCount();
        for (int i = rowCount1 - 1; i >= 0; i--) {
            model1.removeRow(i);
        }

        int rowCount2 = model2.getRowCount();
        for (int i = rowCount2 - 1; i >= 0; i--) {
            model2.removeRow(i);
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
            systemView.txtCodigoFeria.setText(systemView.tableFerias.getValueAt(row, 0).toString());
            systemView.txtNombreFeria.setText(systemView.tableFerias.getValueAt(row, 1).toString());
            systemView.txtDistritoFeria.setText(systemView.tableFerias.getValueAt(row, 2).toString());
            systemView.cmbCategoriaFeria.setSelectedItem(systemView.tableFerias.getValueAt(row, 3).toString());
            systemView.txtAforoFeria.setText(systemView.tableFerias.getValueAt(row, 4).toString());
            systemView.jDateInicio.setDate((Date) systemView.tableFerias.getValueAt(row, 5));
            systemView.jDateFin.setDate((Date) systemView.tableFerias.getValueAt(row, 6));
            systemView.txtMontoFeria.setText(systemView.tableFerias.getValueAt(row, 7).toString());
            systemView.cmbEstadoFeria.setSelectedItem(systemView.tableFerias.getValueAt(row, 8).toString());
            //Desactivar cajas de texto
            systemView.btnRegisterFeria.setEnabled(false);
        } else if (e.getSource() == systemView.btnPresupuestar) {
            //Almacena numero de fila
            int row = systemView.tableListaFerias.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar una feria");
            } else {
                PresupuestoView presView = new PresupuestoView();
                presView.setVisible(true);
            }
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
        systemView.txtCodigoFeria.setText("");
        systemView.txtNombreFeria.setText("");
        systemView.txtDistritoFeria.setText("");
        systemView.jDateInicio.setDate(null);
        systemView.jDateFin.setDate(null);
        systemView.cmbCategoriaFeria.setSelectedIndex(0);
        systemView.cmbEstadoFeria.setSelectedIndex(0);
        systemView.txtAforoFeria.setText("");
        systemView.txtMontoFeria.setText("");
    }

}
