/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_BP;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author NguyenNgocDang
 */
public class server {
    public static void main(String[] args) throws RemoteException, MalformedURLException{
        Cal cal = new Cal();
        Registry registry = LocateRegistry.createRegistry(8888);
        Naming.rebind("rmi://localhost:8888/cal", (Remote) cal);
        System.out.println("Server Running ...");
    }
}
