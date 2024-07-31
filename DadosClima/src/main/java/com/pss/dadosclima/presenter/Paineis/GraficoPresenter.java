/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pss.dadosclima.presenter.Paineis;

import com.pss.dadosclima.Operacao;
import com.pss.dadosclima.model.DadoClima;
import com.pss.dadosclima.view.GraficoFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author UFES
 */
public class GraficoPresenter implements Painel{
   private GraficoFrame view;
   private ArrayList<DadoClima> dados = new ArrayList<>();

    public GraficoPresenter() {
        view=new GraficoFrame();
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
        
        GeraGrafico();
    }
    public void GeraGrafico(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        float tempMin = Float.MAX_VALUE;
        float tempMax = Float.MIN_VALUE;
        
        float umMin = Float.MAX_VALUE;
        float umMax = Float.MIN_VALUE;
        
        float prMin = Float.MAX_VALUE;
        float prMax = Float.MIN_VALUE;
    
    for (DadoClima dado : dados) {
        
        float temp = dado.getTemperatura();
        float um=dado.getUmidade();
        float pr=dado.getPressao();
        
        if (temp < tempMin) tempMin = temp;
        
        if (temp > tempMax) tempMax = temp;
        
        if (um < umMin) umMin = um;
        
        if (um > umMax) umMax = um;
        
        if (pr < prMin) prMin = pr;
        
        if (pr > prMax) prMax = pr;
        
    }
    dataset.clear();
    // Adiciona os valores mínimo e máximo ao dataset
    dataset.addValue(tempMin, "Mínimo", "Temperatura");
    dataset.addValue(tempMax, "Máximo", "Temperatura");
    dataset.addValue(umMin, "Mínimo", "Umidade");
    dataset.addValue(umMax, "Máximo", "Umidade");
    dataset.addValue(prMin, "Mínimo", "Pressão");
    dataset.addValue(prMax, "Máximo", "Pressão");
    
        JFreeChart maxminchart =ChartFactory.createBarChart("Máximas e Mínimas Globais", "", "", dataset, PlotOrientation.VERTICAL, true, true, true);
        
        var chartpanel =new ChartPanel(maxminchart);
        
        chartpanel.setVisible(true);
        view.setVisible(true);
        view.getChartPanel().removeAll();
        view.getChartPanel().setLayout(new BorderLayout());
        view.getChartPanel().add(chartpanel, BorderLayout.CENTER);
        view.getChartPanel().revalidate();
        view.getChartPanel().repaint();
        view.pack();
        
        
    }
    public JInternalFrame getFrame(){
        return view;
    }
   
}
