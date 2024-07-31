/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pss.dadosclima.presenter.Paineis;

import com.pss.dadosclima.Operacao;
import com.pss.dadosclima.model.DadoClima;
import javax.swing.JInternalFrame;

/**
 *
 * @author UFES
 */
public interface Painel {
    public void atualizar(DadoClima clima, Operacao op );
    public JInternalFrame getFrame();
}
