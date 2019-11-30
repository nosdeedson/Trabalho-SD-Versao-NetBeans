/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fepi.sis.servidor;

import br.fepi.sis.simulaFinanciamento.CalculaValorFinanciamento;
import br.fepi.sis.simulaFinanciamento.ICalculaValorFinanciamento;
import java.rmi.registry.Registry;

/**
 *
 * @author Edson
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {

    private final int porta = 1099;
    private Registry registro;

    public Servidor() {
        ICalculaValorFinanciamento calc = new ICalculaValorFinanciamento();
        try {
            registro = LocateRegistry.createRegistry(porta);
            CalculaValorFinanciamento stub = (CalculaValorFinanciamento) UnicastRemoteObject.exportObject(calc, porta);

            registro.rebind("calculandoFinanciamento", stub);
            System.out.println("running ...");
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Servidor();
    }
}
