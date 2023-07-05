package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.egreso;
import com.mycompany.presupuestoferias.models.egresoDao;
import com.mycompany.presupuestoferias.models.ingreso;
import com.mycompany.presupuestoferias.models.ingresoDao;
import com.mycompany.presupuestoferias.views.PresupuestoStatusView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haisenberg
 */
public class EgresoIngresoStatusController implements ActionListener {

    private PresupuestoStatusView presStatusView;
    private egreso egreso_pres;
    private egresoDao egreso_presDao;
    private ingreso ingreso_pres;
    private ingresoDao ingreso_presDao;
    private double rentabilidad;
    
    public EgresoIngresoStatusController(PresupuestoStatusView presStatusView, egreso egreso_pres, egresoDao egreso_presDao, ingreso ingreso_pres, ingresoDao ingreso_presDao) {
        this.presStatusView = presStatusView;
        this.egreso_pres = egreso_pres;
        this.egreso_presDao = egreso_presDao;
        this.ingreso_pres = ingreso_pres;
        this.ingreso_presDao = ingreso_presDao;
        this.presStatusView.btnSearch.addActionListener(this);
        this.presStatusView.btnMostrarTodo.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Botón de búsqueda
        if (e.getSource() == presStatusView.btnSearch) {
            String idFeria = presStatusView.txtIdFeriaStatus.getText().trim();
            String tipoEgreso = presStatusView.cmbTipoPresupuesto.getSelectedItem().toString();
            String categoriaEgreso = presStatusView.cmbCategoriaPresupuesto.getSelectedItem().toString();

            // Limpiar las tablas de egreso e ingreso
            cleanTableEgreso();
            cleanTableIngreso();

            // Verificar el tipo de egreso seleccionado
            if (tipoEgreso.equals("EGRESO")) {
                // Mostrar el estado de egreso
                listAllStatusEgreso(idFeria, tipoEgreso, categoriaEgreso);
            } else if (tipoEgreso.equals("INGRESO")) {
                // Mostrar el estado de ingreso
                listAllStatusIngreso(idFeria, tipoEgreso, categoriaEgreso);
            }
        } // Verificar si el evento se originó desde el botón "Mostrar Todo"
        else if (e.getSource() == presStatusView.btnMostrarTodo) {
            // Limpiar las tablas de egreso e ingreso
            cleanTableEgreso();
            cleanTableIngreso();

            // Mostrar todos los egresos e ingresos
            listAllEgreso();
            listAllIngreso();
        }
    }

    /**
     * Método para listar y mostrar el estado de los egresos según los
     * parámetros especificados.
     *
     * @param idFeria ID de la feria
     * @param tipoEgreso Tipo de egreso
     * @param categoriaEgreso Categoría de egreso
     */
    public void listAllStatusEgreso(String idFeria, String tipoEgreso, String categoriaEgreso) {
        double totalCantidad = 0;
        List<egreso> list = egreso_presDao.listStatusEgresoQuery(idFeria, tipoEgreso, categoriaEgreso);
        DefaultTableModel model = (DefaultTableModel) presStatusView.tableEgresos.getModel();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = new Object[6];
            double precioTotal = list.get(i).getCantidad() * list.get(i).getPrecio();
            totalCantidad += precioTotal;

            row[0] = list.get(i).getId();
            row[1] = list.get(i).getProductoServicio();
            row[2] = list.get(i).getCantidad();
            row[3] = list.get(i).getPrecio();
            row[4] = precioTotal;

            model.addRow(row);
        }

        for (int i = 0; i < list.size(); i++) {
            double precioTotal = (double) model.getValueAt(i, 4);
            double porcentaje = (precioTotal / totalCantidad) * 100;
            model.setValueAt(String.format("%.2f", porcentaje), i, 5);
        }

        // Establecer el valor del totalCantidad en el campo de texto
        presStatusView.txtTotalPrecioEgreso.setText(String.format("%.2f", totalCantidad));
    }

    /**
     * Método para listar y mostrar todos los egresos.
     */
    public void listAllEgreso() {
        double totalCantidad = 0;
        String idFeria = presStatusView.txtIdFeriaStatus.getText();
        List<egreso> list = egreso_presDao.listEgresoQuery(idFeria);
        DefaultTableModel model = (DefaultTableModel) presStatusView.tableEgresos.getModel();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = new Object[6];
            double precioTotal = list.get(i).getCantidad() * list.get(i).getPrecio();
            totalCantidad += precioTotal;

            row[0] = list.get(i).getId();
            row[1] = list.get(i).getProductoServicio();
            row[2] = list.get(i).getCantidad();
            row[3] = list.get(i).getPrecio();
            row[4] = precioTotal;

            model.addRow(row);
        }

        for (int i = 0; i < list.size(); i++) {
            double precioTotal = (double) model.getValueAt(i, 4);
            double porcentaje = (precioTotal / totalCantidad) * 100;
            model.setValueAt(String.format("%.2f", porcentaje), i, 5);
        }

        // Establecer el valor del totalCantidad en el campo de texto
        presStatusView.txtTotalPrecioEgreso.setText(String.format("%.2f", totalCantidad));
    }

    /**
     * Método para listar y mostrar el estado de los ingresos según los
     * parámetros especificados.
     *
     * @param idFeria ID de la feria
     * @param tipoIngreso Tipo de ingreso
     * @param categoriaIngreso Categoría de ingreso
     */
    public void listAllStatusIngreso(String idFeria, String tipoIngreso, String categoriaIngreso) {
        double totalCantidad = 0;
        List<ingreso> list = ingreso_presDao.listStatusIngresoQuery(idFeria, tipoIngreso, categoriaIngreso);
        DefaultTableModel model = (DefaultTableModel) presStatusView.tableIngresos.getModel();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = new Object[6];
            double precioTotal = list.get(i).getCantidad() * list.get(i).getPrecio();
            totalCantidad += precioTotal;

            row[0] = list.get(i).getId();
            row[1] = list.get(i).getProductoServicio();
            row[2] = list.get(i).getCantidad();
            row[3] = list.get(i).getPrecio();
            row[4] = precioTotal;

            model.addRow(row);
        }

        for (int i = 0; i < list.size(); i++) {
            double precioTotal = (double) model.getValueAt(i, 4);
            double porcentaje = (precioTotal / totalCantidad) * 100;
            model.setValueAt(String.format("%.2f", porcentaje), i, 5);
        }

        // Establecer el valor del totalCantidad en el campo de texto
        presStatusView.txtTotalPrecioIngreso.setText(String.format("%.2f", totalCantidad));
    }

    /**
     * Método para listar y mostrar todos los ingresos.
     */
    public void listAllIngreso() {
        double totalCantidad = 0;
        String idFeria = presStatusView.txtIdFeriaStatus.getText();
        List<ingreso> list = ingreso_presDao.listIngresoQuery(idFeria);
        DefaultTableModel model = (DefaultTableModel) presStatusView.tableIngresos.getModel();

        for (int i = 0; i < list.size(); i++) {
            Object[] row = new Object[6];
            double precioTotal = list.get(i).getCantidad() * list.get(i).getPrecio();
            totalCantidad += precioTotal;

            row[0] = list.get(i).getId();
            row[1] = list.get(i).getProductoServicio();
            row[2] = list.get(i).getCantidad();
            row[3] = list.get(i).getPrecio();
            row[4] = precioTotal;

            model.addRow(row);
        }

        for (int i = 0; i < list.size(); i++) {
            double precioTotal = (double) model.getValueAt(i, 4);
            double porcentaje = (precioTotal / totalCantidad) * 100;
            model.setValueAt(String.format("%.2f", porcentaje), i, 5);
        }

        // Establecer el valor del totalCantidad en el campo de texto
        presStatusView.txtTotalPrecioIngreso.setText(String.format("%.2f", totalCantidad));
    }

    /**
     * Método para limpiar la tabla de egresos.
     */
    public void cleanTableEgreso() {
        DefaultTableModel model = (DefaultTableModel) presStatusView.tableEgresos.getModel();
        model.setRowCount(0);
        presStatusView.txtTotalPrecioEgreso.setText("");
    }

    /**
     * Método para limpiar la tabla de ingresos.
     */
    public void cleanTableIngreso() {
        DefaultTableModel model = (DefaultTableModel) presStatusView.tableIngresos.getModel();
        model.setRowCount(0);
        presStatusView.txtTotalPrecioEgreso.setText("");
    }

}
