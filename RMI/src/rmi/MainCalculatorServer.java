/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author NguyenNgocDang
 */
public class MainCalculatorServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        CalculatorImpl cal = new CalculatorImpl();
        Registry registry = LocateRegistry.createRegistry(6666);
        Naming.rebind("rmi://localhost:6666/calRemote", cal);
        System.out.println("Server Running ...");
        
    }
    
}
