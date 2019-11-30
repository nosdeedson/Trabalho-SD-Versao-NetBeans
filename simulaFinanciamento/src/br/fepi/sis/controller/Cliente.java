/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fepi.sis.controller;

/**
 *
 * @author Edson
 */
import br.fepi.sis.simulaFinanciamento.CalculaValorFinanciamento;
import br.fepi.sis.simulaFinanciamento.DadosSimulacao;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Cliente {

    public Cliente() {
    }

    public double chamadaRemota(DadosSimulacao dados) {
        double valorFinanciamento = 0.0;

        try {

            CalculaValorFinanciamento proxy = (CalculaValorFinanciamento) Naming.lookup("rmi://192.168.1.103/calculandoFinanciamento");
            valorFinanciamento = proxy.calculaFinanciamento(dados);

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NotBoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return valorFinanciamento;
    }

}
