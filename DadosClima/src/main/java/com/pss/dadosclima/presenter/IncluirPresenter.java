/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.presenter;

import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.presenter.PrincipalPresenter;
import com.pss.dadosclima.view.IncluirFrame;
import com.pss.dadosclima.view.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author UFES
 */

public class IncluirPresenter {
    private IncluirFrame view;
    
    
    public IncluirPresenter(PrincipalPresenter presenter) {
        
        view=new IncluirFrame();
        view.setVisible(true);
        
        view.getIncluirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(Float.parseFloat(view.getTemperaturaField().getText()));
                System.out.println(Float.parseFloat(view.getUmidadeField().getText()));
                System.out.println(Float.parseFloat(view.getPressaoField().getText()));
                presenter.addMedicao(Float.parseFloat(view.getTemperaturaField().getText()), Float.parseFloat(view.getPressaoField().getText()), Float.parseFloat(view.getUmidadeField().getText()));
            }
        });
    }
    
    
     public JInternalFrame getFrame(){
        return view;
    }
}
