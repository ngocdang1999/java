/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_rmi;

import java.io.IOException;
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
        Calculator cal = new Calculator();//hàm để thực hiện tính toán
        
        Registry registry = LocateRegistry.createRegistry(6666);
        Naming.rebind("rmi://localhost:6666/calRemote", (Remote) cal);
        System.out.println("Server Running ...");
        
    }
}
