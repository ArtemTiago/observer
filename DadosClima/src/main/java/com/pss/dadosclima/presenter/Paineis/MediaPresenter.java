/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.presenter.Paineis;

import com.pss.dadosclima.Operacao;
import static com.pss.dadosclima.Operacao.EXCLUIR;
import static com.pss.dadosclima.Operacao.INCLUIR;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.view.MediaFrame;
import java.util.ArrayList;
import javax.swing.JInternalFrame;


/**
 *
 * @author UFES
 */
public class MediaPresenter implements Painel{
    private MediaFrame view;
    private ArrayList<DadoClima> dados= new ArrayList<>();

    public MediaPresenter() {
        view=new MediaFrame();
        
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
        view.getTemperaturaField().setText(String.valueOf(GetMedias().get(0)));
        view.getPressaoField().setText(String.valueOf(GetMedias().get(1)));
        view.getUmidadeField().setText(String.valueOf(GetMedias().get(2)));
        view.repaint();
    }
    
    public ArrayList<Float> GetMedias(){
       float i=0,j=0,k = 0;
       ArrayList<Float> medias = new ArrayList<>();    
        for (DadoClima x :dados){
            i+=x.getTemperatura();
            j+=x.getPressao();
            k+=x.getUmidade();
        }
        medias.add((i/dados.size()));
        medias.add((j/dados.size()));
        medias.add((k/dados.size()));
        return medias;
}
    
     public JInternalFrame getFrame(){
        return view;
    }
}
