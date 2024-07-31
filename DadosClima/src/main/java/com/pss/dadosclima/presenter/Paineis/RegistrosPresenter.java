/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.presenter.Paineis;

import com.pss.dadosclima.Operacao;
import static com.pss.dadosclima.Operacao.EXCLUIR;
import static com.pss.dadosclima.Operacao.INCLUIR;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.presenter.PrincipalPresenter;
import com.pss.dadosclima.view.RegistrosFrame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author UFES
 */
public class RegistrosPresenter implements Painel{
    private RegistrosFrame view;
    private ArrayList<DadoClima> dados =new ArrayList<>();

    public RegistrosPresenter(PrincipalPresenter presenter) {
        view=new RegistrosFrame();
        
        view.setVisible(true);
        
        view.getRemoverButton().addActionListener((ActionEvent e)->{
            presenter.remMedicao(dados.get(view.getjTable1().getSelectedRow()));
        });
    }
    public void atualizar(DadoClima dado, Operacao op){
        switch(op){
            case INCLUIR:
                dados.add(dado);
                break;
            case EXCLUIR:
                dados.remove(dado);
                break;
        }
        AlimentaTabela();
        System.out.println(dados.size());
    }
    
    public void AlimentaTabela(){
        DefaultTableModel model = new DefaultTableModel((new String[]{"data","temperatura","umidade","pressão"}), 0);
        for(DadoClima x : dados ){
            model.addRow(new Object[]{(x.getData()),(x.getTemperatura()),(x.getUmidade()),(x.getPressao())});
        }
        
        
        view.getjTable1().setModel(model);
        view.getjTable1().setRowSelectionAllowed(true);
    
        view.repaint();
    }
    
     public JInternalFrame getFrame(){
        return view;
        
    }
    
}
