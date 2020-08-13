/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author NguyenNgocDang
 */
public class client {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException{
        intCalculator Intcal = (intCalculator)Naming.lookup("rmi://localhost:6666/calRemote");
        int n = Intcal.addNumber(5, 10);
        System.out.println("Kết quả là: "+ n);
    }
}
