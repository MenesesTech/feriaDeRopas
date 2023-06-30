package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.egreso;
import com.mycompany.presupuestoferias.models.egresoDao;
import com.mycompany.presupuestoferias.models.ingreso;
import com.mycompany.presupuestoferias.models.ingresoDao;
import com.mycompany.presupuestoferias.views.PresupuestoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EgresoIngresoController implements ActionListener, MouseListener {

    private PresupuestoView presView;
    private egreso egreso_pres;
    private egresoDao egreso_presDao;
    private ingreso ingreso_pres;
    private ingresoDao ingreso_presDao;

    public EgresoIngresoController(PresupuestoView presView, egreso egreso_pres, egresoDao egreso_presDao, ingreso ingreso_pres, ingresoDao ingreso_presDao) {
        this.presView = presView;
        this.egreso_pres = egreso_pres;
        this.egreso_presDao = egreso_presDao;
        this.ingreso_pres = ingreso_pres;
        this.ingreso_presDao = ingreso_presDao;
        // Boton Registrar Egreso
        this.presView.btnRegisterEgreso.addActionListener(this);
        // Boton cancelar Egreso
        this.presView.btnUpdateEgreso.addActionListener(this);
        // Boton Modificar Egreso
        this.presView.btnDeleteEgreso.addActionListener(this);
        // Boton Eliminar Egreso
        this.presView.btnCancelEgreso.addActionListener(this);
        // Tabla de Egresos
        this.presView.tableEgresos.addMouseListener(this);
        // Tabla de Ingresos
        this.presView.tableIngresos.addMouseListener(this);
        // Boton de Visualizar egresos e ingresos
        this.presView.btnViewsEgreIngresos.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtener el tipo de presupuesto seleccionado
        String tipoPresupuesto = presView.cmbTipoPresupuesto.getSelectedItem().toString();
        // Obtener el tipo de categoría seleccionado
        String categoryPresupuesto = presView.cmbCategoriaPresupuesto.getSelectedItem().toString();
        // Obtener el Servicio del producto seleccionado
        String servicioPresupuesto = presView.cmbProdServicio.getSelectedItem().toString();

        if (e.getSource() == presView.btnRegisterEgreso) {
            // Verificar si todos los campos obligatorios están llenos
            if (tipoPresupuesto.equals("")
                    || categoryPresupuesto.equals("")
                    || servicioPresupuesto.equals("")
                    || presView.txtCantidad.getText().equals("")
                    || presView.txtPrecio.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los datos");
            } else {
                // Procesar si es un egreso
                if (tipoPresupuesto.equals("EGRESO")) {
                    // Generar un nuevo ID para el egreso
                    if (egreso_presDao.obtenerUltimoCodigoEgreso().equals("")) {
                        egreso_pres.setId("EG001");
                    } else {
                        egreso_pres.setId(egreso_presDao.generarCodigo());
                    }
                    // Establecer los valores del egreso
                    egreso_pres.setType(tipoPresupuesto);
                    egreso_pres.setCategory(categoryPresupuesto);
                    egreso_pres.setProductoServicio(servicioPresupuesto);
                    egreso_pres.setCantidad(Integer.parseInt(presView.txtCantidad.getText().trim()));
                    egreso_pres.setPrecio(Double.parseDouble(presView.txtPrecio.getText().trim()));
                    egreso_pres.setIdFeria(presView.txtIdFeria.getText());
                    // Registrar el egreso en la base de datos
                    egreso_presDao.registroEgresoQuery(egreso_pres);
                    // Limpiar los campos y las tablas
                    cleanFields();
                    cleanTableEgreso();
                    presView.btnRegisterEgreso.setVisible(true);
                    // Actualizar la lista de egresos
                    listAllEgreso();
                    // Mostrar un mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Egreso registrado con éxito");
                } // Procesar si es un ingreso
                else if (tipoPresupuesto.equals("INGRESO")) {
                    // Generar un nuevo ID para el ingreso
                    if (ingreso_presDao.obtenerUltimoCodigoIngreso().equals("")) {
                        ingreso_pres.setId("IN001");
                    } else {
                        ingreso_pres.setId(ingreso_presDao.generarCodigo());
                    }
                    // Establecer los valores del ingreso
                    ingreso_pres.setType(tipoPresupuesto);
                    ingreso_pres.setCategory(presView.cmbCategoriaPresupuesto.getSelectedItem().toString().trim());
                    ingreso_pres.setProductoServicio(presView.cmbProdServicio.getSelectedItem().toString().trim());
                    ingreso_pres.setCantidad(Integer.parseInt(presView.txtCantidad.getText().trim()));
                    ingreso_pres.setPrecio(Double.parseDouble(presView.txtPrecio.getText().trim()));
                    ingreso_pres.setIdFeria(presView.txtIdFeria.getText());
                    // Registrar el ingreso en la base de datos
                    ingreso_presDao.registroIngresoQuery(ingreso_pres);
                    // Limpiar los campos y las tablas
                    cleanFields();
                    cleanTableIngreso();
                    // Actualizar la lista de ingresos
                    listAllIngreso();
                    // Mostrar un mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Ingreso registrado con éxito");
                }
            }
        } else if (e.getSource() == presView.btnUpdateEgreso) {
            Object selectedTipoPresupuesto = presView.cmbTipoPresupuesto.getSelectedItem();
            if (selectedTipoPresupuesto == null || selectedTipoPresupuesto.toString().equals("--- SELECCIONE ---")) {
                JOptionPane.showMessageDialog(null, "Selecciona una fila para continuar");
            } else if (tipoPresupuesto.equals("") || categoryPresupuesto.equals("") || servicioPresupuesto.equals("")
                    || presView.txtCantidad.getText().equals("") || presView.txtPrecio.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los datos");
            } else {
                int filaEgreso = presView.tableEgresos.getSelectedRow();
                int filaIngreso = presView.tableIngresos.getSelectedRow();

                // Establecer los valores del egreso
                String idEgreso = "";
                String idIngreso = "";
                if (filaEgreso != -1) {
                    idEgreso = presView.tableEgresos.getValueAt(filaEgreso, 0).toString();
                    egreso_pres.setType(tipoPresupuesto);
                    egreso_pres.setCategory(categoryPresupuesto);
                    egreso_pres.setProductoServicio(servicioPresupuesto);
                    egreso_pres.setCantidad(Integer.parseInt(presView.txtCantidad.getText().trim()));
                    egreso_pres.setPrecio(Double.parseDouble(presView.txtPrecio.getText().trim()));
                    egreso_pres.setId(idEgreso);
                    // Modificar el egreso en la base de datos
                    egreso_presDao.updateEgresoQuery(egreso_pres);
                    // Mostrar un mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Egreso modificado con éxito");
                }
                if (filaIngreso != -1) {
                    idIngreso = presView.tableIngresos.getValueAt(filaIngreso, 0).toString();
                    ingreso_pres.setType(tipoPresupuesto);
                    ingreso_pres.setCategory(categoryPresupuesto);
                    ingreso_pres.setProductoServicio(servicioPresupuesto);
                    ingreso_pres.setCantidad(Integer.parseInt(presView.txtCantidad.getText().trim()));
                    ingreso_pres.setPrecio(Double.parseDouble(presView.txtPrecio.getText().trim()));
                    ingreso_pres.setId(idIngreso);
                    // Modificar el ingreso en la base de datos
                    ingreso_presDao.updateIngresoQuery(ingreso_pres);
                    // Mostrar un mensaje de éxito
                    JOptionPane.showMessageDialog(null, "Ingreso modificado con éxito");
                }

                // Limpiar los campos y las tablas
                cleanFields();
                cleanTableEgreso();

                // Actualizar la lista de egresos
                listAllEgreso();
            }
        } else if (e.getSource() == presView.btnDeleteEgreso) {
            int filaEgreso = presView.tableEgresos.getSelectedRow();
            int filaIngreso = presView.tableIngresos.getSelectedRow();

            if (filaEgreso == -1 && filaIngreso == -1) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar un egreso o un ingreso para eliminar");
            } else if (filaEgreso != -1 || filaIngreso != -1) {
                if (filaEgreso != -1) {
                    String idEgreso = presView.tableEgresos.getValueAt(filaEgreso, 0).toString();
                    int question = JOptionPane.showConfirmDialog(null, "¿En realidad quieres eliminar este Egreso?");
                    if (question == 0 && egreso_presDao.deleteEgresoQuery(idEgreso)) {
                        cleanFields();
                        cleanTableEgreso();
                        listAllEgreso();
                        presView.btnRegisterEgreso.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Egreso eliminado con éxito");
                    }
                } else if (filaIngreso != -1) {
                    String idIngreso = presView.tableIngresos.getValueAt(filaIngreso, 0).toString();
                    int question = JOptionPane.showConfirmDialog(null, "¿En realidad quieres eliminar este Ingreso?");
                    if (question == 0 && ingreso_presDao.deleteIngresoQuery(idIngreso)) {
                        cleanFields();
                        cleanTableIngreso();
                        listAllIngreso();
                        presView.btnRegisterEgreso.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Ingreso eliminado con éxito");
                    }
                }
            }
        } else if (e.getSource() == presView.btnCancelEgreso) {
            cleanFields();
            presView.btnRegisterEgreso.setEnabled(true);
        }
    }

    public void listAllEgreso() {
        String idFeria = presView.txtIdFeria.getText();
        List<egreso> list = egreso_presDao.listEgresoQuery(idFeria);
        DefaultTableModel model1 = (DefaultTableModel) presView.tableEgresos.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getType();
            row[2] = list.get(i).getCategory();
            row[3] = list.get(i).getProductoServicio();
            row[4] = list.get(i).getCantidad();
            row[5] = list.get(i).getPrecio();
            model1.addRow(row);
        }
    }

    public int cantSeguridad() {
        int cantSeguridad = egreso_presDao.cantSeguridad(presView.txtIdFeria.getText());
        return cantSeguridad;
    }

    public void listAllIngreso() {
        String idFeria = presView.txtIdFeria.getText();
        List<ingreso> list = ingreso_presDao.listIngresoQuery(idFeria);
        DefaultTableModel model2 = (DefaultTableModel) presView.tableIngresos.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getType();
            row[2] = list.get(i).getCategory();
            row[3] = list.get(i).getProductoServicio();
            row[4] = list.get(i).getCantidad();
            row[5] = list.get(i).getPrecio();
            model2.addRow(row);
        }
    }

    //Metodo para limpiar tabla
    public void cleanTableEgreso() {
        DefaultTableModel model = (DefaultTableModel) presView.tableEgresos.getModel();

        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    public void cleanTableIngreso() {
        DefaultTableModel model = (DefaultTableModel) presView.tableIngresos.getModel();

        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == presView.btnViewsEgreIngresos) {
            if (presView.pnlViewsEgreIngresos.isVisible()) {
                presView.pnlViewsEgreIngresos.setVisible(false);
            } else {
                presView.pnlViewsEgreIngresos.setVisible(true);
                cleanTableEgreso();
                listAllEgreso();
                cleanTableIngreso();
                listAllIngreso();
            }
        } else if (e.getSource() == presView.tableEgresos) {
            //Capturar fila
            int row = presView.tableEgresos.rowAtPoint(e.getPoint());
            //Rellenar las cajas y combobox
            presView.cmbTipoPresupuesto.setSelectedItem(presView.tableEgresos.getValueAt(row, 1));
            presView.cmbCategoriaPresupuesto.setSelectedItem(presView.tableEgresos.getValueAt(row, 2));
            presView.cmbProdServicio.setSelectedItem(presView.tableEgresos.getValueAt(row, 3));
            presView.txtCantidad.setText(presView.tableEgresos.getValueAt(row, 4).toString());
            presView.txtPrecio.setText(presView.tableEgresos.getValueAt(row, 5).toString());
            //Desabilita cajas de texto 
            presView.btnRegisterEgreso.setEnabled(false);
        } else if (e.getSource() == presView.tableIngresos) {
            //Capturar fila
            int row = presView.tableEgresos.rowAtPoint(e.getPoint());
            //Rellenar las cajas y combobox
            presView.cmbTipoPresupuesto.setSelectedItem(presView.tableEgresos.getValueAt(row, 1));
            presView.cmbCategoriaPresupuesto.setSelectedItem(presView.tableEgresos.getValueAt(row, 2));
            presView.cmbProdServicio.setSelectedItem(presView.tableEgresos.getValueAt(row, 3));
            presView.txtCantidad.setText(presView.tableEgresos.getValueAt(row, 4).toString());
            presView.txtPrecio.setText(presView.tableEgresos.getValueAt(row, 5).toString());
            //Desabilita cajas de texto 
            presView.btnRegisterEgreso.setEnabled(false);
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
        presView.cmbTipoPresupuesto.setSelectedIndex(0);
        presView.cmbCategoriaPresupuesto.setSelectedIndex(0);
        presView.cmbProdServicio.setSelectedIndex(0);
        presView.txtCantidad.setText("");
        presView.txtPrecio.setText("");
    }

}
