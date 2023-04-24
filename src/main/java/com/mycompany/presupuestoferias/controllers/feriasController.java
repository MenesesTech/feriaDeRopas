package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.models.feria;
import com.mycompany.presupuestoferias.models.feriaDao;
import static com.mycompany.presupuestoferias.models.usuarioDao.rol_user;
import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class feriasController implements ActionListener{

    private feria feria_ropa;
    private feriaDao feriaRopaDao;
    private SystemView SystemView;
    String rol = rol_user;
    DefaultTableModel model = new DefaultTableModel();

    public feriasController(feria feria_ropa, feriaDao feriaRopaDao, SystemView SystemView) {
        this.feria_ropa = feria_ropa;
        this.feriaRopaDao = feriaRopaDao;
        this.SystemView = SystemView;
        //Boton Registrar feria
        this.SystemView.btnRegisterFeria.addActionListener(this);
        //Boton Ordenar Categorias
        this.SystemView.btnOrdenarBurbuja.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SystemView.btnRegisterFeria) {
            // Validar si los campos obligatorios están vacíos y mostrar un mensaje de error si es necesario
            if (SystemView.txtNombre.getText().equals("")
                    || SystemView.txtUbicacion.getText().equals("")
                    || SystemView.cmbCategoria.getSelectedItem().toString().equals("")
                    || SystemView.cmbEstado.getSelectedItem().toString().equals("")
                    || SystemView.txtOrganizador.getText().equals("")
                    || SystemView.txtTelefono.getText().equals("")
                    || SystemView.txtCorreo.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Es obligatorio colocar el nombre de la Feria");
            } else {
                // Asignar valores a los atributos del objeto feria_ropa utilizando los valores de los campos de entrada
                feria_ropa.setName(SystemView.txtNombre.getText().trim());
                feria_ropa.setAddress(SystemView.txtUbicacion.getText().trim());
                feria_ropa.setCategory(SystemView.cmbCategoria.getSelectedItem().toString());
                feria_ropa.setStatus(SystemView.cmbEstado.getSelectedItem().toString());
                feria_ropa.setOrganizador(SystemView.txtOrganizador.getText().trim());
                feria_ropa.setTelephone(SystemView.txtTelefono.getText().trim());
                feria_ropa.setEmail(SystemView.txtCorreo.getText().trim());
                // Invocar al método de registro en la capa DAO y mostrar un mensaje de éxito o error en consecuencia
                if (feriaRopaDao.registroFeriaQuery(feria_ropa)) {
                    listAllFerias();
                    FeriasLista();
                    JOptionPane.showMessageDialog(null, "Empleado registrado con exito");
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al registrar un empleado");
                }
            }
        }
    }

    public void listAllFerias() {
        if (rol.equals("Administrador")) {
            // Verificar si rol está inicializado y es igual a "Administrador"

            // Obtener la lista de ferias
            List<feria> list = feriaRopaDao.listFeriaQuery();

            // Inicializar el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) SystemView.tableFerias.getModel();

            // Recorrer la lista de ferias y agregar las filas a la tabla
            Object[] row = new Object[6];//Definimos la cantidad de columnas de la tabla
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
    }

    public void listBurbujaFerias() {
        // Obtener la lista de ferias
        List<feria> list = feriaRopaDao.listFeriaQuery();

        // Ordenar la lista por categoría usando el método de burbuja
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

        // Limpiar la tabla antes de agregar las filas ordenadas
        model.setRowCount(0);

        // Recorrer la lista de ferias ordenadas y agregar las filas a la tabla
        Object[] row = new Object[6];//Definimos la cantidad de columnas de la tabla
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
    
    public void FeriasLista() {
        if (rol.equals("Administrador")) {
            // Verificar si rol está inicializado y es igual a "Administrador"

            // Obtener la lista de ferias
            List<feria> list = feriaRopaDao.listAllFeria();

            // Inicializar el modelo de la tabla
            DefaultTableModel model = (DefaultTableModel) SystemView.tableListaFerias.getModel();

            // Recorrer la lista de ferias y agregar las filas a la tabla
            Object[] row = new Object[9];//Definimos la cantidad de columnas de la tabla
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
            SystemView.tableFerias.setModel(model);
        }
    }
}
