package com.mycompany.presupuestoferias.controllers;

import com.mycompany.presupuestoferias.views.SystemView;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class settingsController implements MouseListener {

    private SystemView view;

    public settingsController(SystemView view) {
        this.view = view;
        this.view.lblInicio.addMouseListener(this);
        this.view.lblRegistroFerias.addMouseListener(this);
        this.view.lblListaFerias.addMouseListener(this);
        this.view.jTabbedPane1.addMouseListener(this);
        this.view.cubiertaPestañas.addMouseListener(this);
        this.view.btnRegistroFerias.addMouseListener(this);
        this.view.btnListaFerias.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.view.cubiertaPestañas.setEnabled(true);
        if (e.getSource() == view.lblInicio) {
            view.jTabbedPane1.setSelectedIndex(0);
        }else if (e.getSource() == view.lblRegistroFerias) {
            view.jTabbedPane1.setSelectedIndex(1);
            
        }else if (e.getSource() == view.lblListaFerias) {
            view.jTabbedPane1.setSelectedIndex(2);
        }else if (e.getSource() == view.btnRegistroFerias) {
            view.jTabbedPane1.setSelectedIndex(1);
        }else if (e.getSource() == view.btnListaFerias) {
            view.jTabbedPane1.setSelectedIndex(2);
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
        if (e.getSource() == view.lblInicio) {
            view.pnlInicio.setBackground(new Color(205, 205, 205));
            view.lblInicio.setForeground(new Color(0, 0, 0));
        } else if (e.getSource() == view.lblRegistroFerias) {
            view.pnlRegistroFerias.setBackground(new Color(205, 205, 205));
            view.lblRegistroFerias.setForeground(new Color(0, 0, 0));
        } else if (e.getSource() == view.lblListaFerias) {
            view.pnlListaFerias.setBackground(new Color(205, 205, 205));
            view.lblListaFerias.setForeground(new Color(0, 0, 0));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == view.lblInicio) {
            view.pnlInicio.setBackground(new Color(15, 15, 15));
            view.lblInicio.setForeground(new Color(255, 255, 255));
        } else if (e.getSource() == view.lblRegistroFerias) {
            view.pnlRegistroFerias.setBackground(new Color(15, 15, 15));
            view.lblRegistroFerias.setForeground(new Color(255, 255, 255));
        } else if (e.getSource() == view.lblListaFerias) {
            view.pnlListaFerias.setBackground(new Color(15, 15, 15));
            view.lblListaFerias.setForeground(new Color(255, 255, 255));
        }
    }

}
