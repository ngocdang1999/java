/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_rmi2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class client {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        intCalculator Intcal = (intCalculator)Naming.lookup("rmi://localhost:6666/calRemote");
        String n = new Scanner(System.in).nextLine();

        System.out.println("Kết quả là: " + Intcal.tinhDoDai(n));
    }
}
