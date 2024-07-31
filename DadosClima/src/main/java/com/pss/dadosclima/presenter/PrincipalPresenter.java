/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.presenter;

import com.pss.dadosclima.log.Logger;
import com.pss.dadosclima.Operacao;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.presenter.Paineis.GraficoPresenter;
import com.pss.dadosclima.presenter.Paineis.UltimoPresenter;
import com.pss.dadosclima.presenter.Paineis.MediaPresenter;
import com.pss.dadosclima.presenter.Paineis.RegistrosPresenter;
import com.pss.dadosclima.presenter.Paineis.Painel;
import com.pss.dadosclima.view.PrincipalView;
import java.util.ArrayList;

/**
 *
 * @author UFES
 */
public class PrincipalPresenter {
    private PrincipalView view;
    private ArrayList<Painel> paineis= new ArrayList<>();
    private int numregistros=0;

    public PrincipalPresenter() {
    view=new PrincipalView();
        view.getDesktopPane().add(new IncluirPresenter(this).getFrame());
        RegistarPainel(new MediaPresenter());
        RegistarPainel(new UltimoPresenter());
        RegistarPainel(new RegistrosPresenter(this));
        RegistarPainel(new GraficoPresenter());
        paineis.forEach((n)-> view.getDesktopPane().add(n.getFrame()) );
        
        
    view.repaint();
    
    }
    public void RegistarPainel(Painel painel){
        paineis.add(painel);
        
    }
    
    public void addMedicao(float temperatura,  float pressao, float umidade){
        notificarPaineis(new DadoClima(temperatura,pressao,umidade), Operacao.INCLUIR);
         Logger.log("INSERT - Temperatura: " + temperatura + ", Pressão: " + pressao + ", Umidade: " + umidade);
    }
    public void remMedicao(DadoClima dado){
        notificarPaineis(dado, Operacao.EXCLUIR);
          Logger.log("DELETE - Temperatura: " + dado.getTemperatura() + ", Pressão: " + dado.getPressao() + ", Umidade: " + dado.getUmidade());
    }
    
    private void notificarPaineis(DadoClima dado, Operacao op){
        paineis.forEach((n) -> n.atualizar(dado, op));
        switch(op){
            case INCLUIR:
                numregistros++;
                break;
            case EXCLUIR:
                numregistros--;
                break;
        }    
        view.getQuantidadeLabel().setText(String.valueOf(numregistros));
    }
    
    
}
