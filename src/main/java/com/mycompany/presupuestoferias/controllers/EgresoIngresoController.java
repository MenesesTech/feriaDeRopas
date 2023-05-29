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
        //Boton Registrar Egreso
        this.presView.btnRegisterEgreso.addActionListener(this);
        //Boton cancelar Egreso
        this.presView.btnUpdateEgreso.addActionListener(this);
        //Boton Modificar Egreso
        this.presView.btnDeleteEgreso.addActionListener(this);
        //Boton Eliminar Egreso
        this.presView.btnCancelEgreso.addActionListener(this);
        //Tabla de Egresos
        this.presView.tableEgresos.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == presView.btnRegisterEgreso) {
            if (presView.cmbTipoPresupuesto.getSelectedItem().toString().equals("")
                    || presView.cmbCategoriaPresupuesto.getSelectedItem().toString().equals("")
                    || presView.cmbProdServicio.getSelectedItem().toString().equals("")
                    || presView.txtCantidad.getText().equals("")
                    || presView.txtPrecio.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Es obligatorio rellenar todos los datos");
            } else {
                String tipoPresupuesto = presView.cmbTipoPresupuesto.getSelectedItem().toString();
                if (tipoPresupuesto.equals("EGRESO")) {
                    if (egreso_presDao.obtenerUltimoCodigoEgreso().equals("")) {
                        egreso_pres.setId("EG001");
                    } else {
                        egreso_pres.setId(egreso_presDao.generarCodigo());
                    }
                    egreso_pres.setType(tipoPresupuesto);
                    egreso_pres.setCategory(presView.cmbCategoriaPresupuesto.getSelectedItem().toString().trim());
                    egreso_pres.setProductoServicio(presView.cmbProdServicio.getSelectedItem().toString().trim());
                    egreso_pres.setCantidad(Integer.parseInt(presView.txtCantidad.getText().trim()));
                    egreso_pres.setPrecio(Double.parseDouble(presView.txtPrecio.getText().trim()));
                    egreso_presDao.registroEgresoQuery(egreso_pres);
                    cleanFields();
                    cleanTableEgreso();
                    listAllEgreso();
                    JOptionPane.showMessageDialog(null, "Egreso registrado con éxito");
                } else if (tipoPresupuesto.equals("INGRESO")) {
                    if (ingreso_presDao.obtenerUltimoCodigoIngreso().equals("")) {
                        ingreso_pres.setId("IN001");
                    } else {
                        ingreso_pres.setId(ingreso_presDao.generarCodigo());
                    }

                    ingreso_pres.setType(tipoPresupuesto);
                    ingreso_pres.setCategory(presView.cmbCategoriaPresupuesto.getSelectedItem().toString().trim());
                    ingreso_pres.setProductoServicio(presView.cmbProdServicio.getSelectedItem().toString().trim());
                    ingreso_pres.setCantidad(Integer.parseInt(presView.txtCantidad.getText().trim()));
                    ingreso_pres.setPrecio(Double.parseDouble(presView.txtPrecio.getText().trim()));
                    ingreso_presDao.registroIngresoQuery(ingreso_pres);
                    cleanFields();
                    cleanTableIngreso();
                    listAllIngreso();
                    JOptionPane.showMessageDialog(null, "Ingreso registrado con éxito");
                }
            }
        }
    }

    public void listAllEgreso() {
        List<egreso> list = egreso_presDao.listEgresoQuery();
        DefaultTableModel model = (DefaultTableModel) presView.tableEgresos.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getType();
            row[2] = list.get(i).getCategory();
            row[3] = list.get(i).getProductoServicio();
            row[4] = list.get(i).getCantidad();
            row[5] = list.get(i).getPrecio();
            model.addRow(row);
        }
    }

    public void listAllIngreso() {
        List<ingreso> list = ingreso_presDao.listIngresoQuery();
        DefaultTableModel model = (DefaultTableModel) presView.tableIngresos.getModel();
        Object[] row = new Object[6];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getType();
            row[2] = list.get(i).getCategory();
            row[3] = list.get(i).getProductoServicio();
            row[4] = list.get(i).getCantidad();
            row[5] = list.get(i).getPrecio();
            model.addRow(row);
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
