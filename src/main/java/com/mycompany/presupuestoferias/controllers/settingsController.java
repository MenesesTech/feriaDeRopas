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
        this.view.lblEmployees.addMouseListener(this);
        this.view.lblSettings.addMouseListener(this);
        this.view.jTabbedPane1.addMouseListener(this);
        this.view.cubiertaPestañas.addMouseListener(this);
        this.view.btnRegistroFerias.addMouseListener(this);
        this.view.btnListaFerias.addMouseListener(this);
        this.view.btnEmployees.addMouseListener(this);
        this.view.btnSettings.addMouseListener(this);
        this.view.lblCerrar.addMouseListener(this);
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
        }else if (e.getSource() == view.lblEmployees) {
            view.jTabbedPane1.setSelectedIndex(3);
        }else if (e.getSource() == view.lblSettings) {
            view.jTabbedPane1.setSelectedIndex(4);
        }else if (e.getSource() == view.btnRegistroFerias) {
            view.jTabbedPane1.setSelectedIndex(1);
        }else if (e.getSource() == view.btnListaFerias) {
            view.jTabbedPane1.setSelectedIndex(2);
        }else if (e.getSource() == view.btnEmployees) {
            view.jTabbedPane1.setSelectedIndex(3);
        }else if (e.getSource() == view.btnSettings) {
            view.jTabbedPane1.setSelectedIndex(4);
        }
        
        
        
        
        else if (e.getSource() == view.lblCerrar) {
            System.exit(0);
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
            view.pnlInicio.setBackground(new Color(242,239,235));
            view.lblInicio.setForeground(new Color(0, 0, 0));
        } else if (e.getSource() == view.lblRegistroFerias) {
            view.pnlRegistroFerias.setBackground(new Color(242,239,235));
            view.lblRegistroFerias.setForeground(new Color(0, 0, 0));
        } else if (e.getSource() == view.lblListaFerias) {
            view.pnlListaFerias.setBackground(new Color(242,239,235));
            view.lblListaFerias.setForeground(new Color(0, 0, 0));
        }else if (e.getSource() == view.lblEmployees) {
            view.pnlEmployees.setBackground(new Color(242,239,235));
            view.lblEmployees.setForeground(new Color(0, 0, 0));
        }else if (e.getSource() == view.lblSettings) {
            view.pnlSettings.setBackground(new Color(242,239,235));
            view.lblSettings.setForeground(new Color(0, 0, 0));
        }else if (e.getSource() == view.lblCerrar) {
            view.lblCerrar.setForeground(Color.red);
        }else if (e.getSource() == view.btnRegistroFerias) {
            view.btnRegistroFerias.setBackground(new Color(191,184,180));
        }else if (e.getSource() == view.btnListaFerias) {
            view.btnListaFerias.setBackground(new Color(191,184,180));
        }else if (e.getSource() == view.btnEmployees) {
            view.btnEmployees.setBackground(new Color(191,184,180));
        }else if (e.getSource() == view.btnSettings) {
            view.btnSettings.setBackground(new Color(191,184,180));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == view.lblInicio) {
            view.pnlInicio.setBackground(new Color(0,0,0));
            view.lblInicio.setForeground(new Color(242,239,235));
        } else if (e.getSource() == view.lblRegistroFerias) {
            view.pnlRegistroFerias.setBackground(new Color(0,0,0));
            view.lblRegistroFerias.setForeground(new Color(242,239,235));
        } else if (e.getSource() == view.lblListaFerias) {
            view.pnlListaFerias.setBackground(new Color(0,0,0));
            view.lblListaFerias.setForeground(new Color(242,239,235));
        }else if (e.getSource() == view.lblEmployees) {
            view.pnlEmployees.setBackground(new Color(0,0,0));
            view.lblEmployees.setForeground(new Color(242,239,235));
        }else if (e.getSource() == view.lblSettings) {
            view.pnlSettings.setBackground(new Color(0,0,0));
            view.lblSettings.setForeground(new Color(242,239,235));
        }else if (e.getSource() == view.lblCerrar) {
            view.lblCerrar.setForeground(new Color(187,187,187));
        }else if (e.getSource() == view.btnRegistroFerias) {
            view.btnRegistroFerias.setBackground(new Color(242,239,235));
        }else if (e.getSource() == view.btnListaFerias) {
            view.btnListaFerias.setBackground(new Color(242,239,235));
        }else if (e.getSource() == view.btnEmployees) {
            view.btnEmployees.setBackground(new Color(242,239,235));
        }else if (e.getSource() == view.btnSettings) {
            view.btnSettings.setBackground(new Color(242,239,235));
        }
    }

}
