/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.presenter.Paineis;

import com.pss.dadosclima.Operacao;
import static com.pss.dadosclima.Operacao.EXCLUIR;
import static com.pss.dadosclima.Operacao.INCLUIR;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.view.UltimaFrame;
import java.util.ArrayList;
import javax.swing.JInternalFrame;

/**
 *
 * @author UFES
 */
public class UltimoPresenter implements Painel{
    private UltimaFrame view;
    private ArrayList<DadoClima> dados =new ArrayList<>();

    public UltimoPresenter() {
        view=new UltimaFrame();
        
        view.setVisible(true);
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
        view.getDataField().setText(dados.get(dados.size()-1).getData().toString());
        view.getTemperaturaField().setText(String.valueOf(dados.get(dados.size()-1).getTemperatura()));
        view.getUmidadeField().setText(String.valueOf(dados.get(dados.size()-1).getUmidade()));
        view.getPressaoField().setText(String.valueOf(dados.get(dados.size()-1).getPressao()));
        view.repaint();
    }
     public JInternalFrame getFrame(){
        return view;
    }
}
