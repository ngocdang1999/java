/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI_BP;

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
        intCal Intcal = (intCal)Naming.lookup("rmi://localhost:8888/cal");
        int n = new Scanner(System.in).nextInt();

        System.out.println("Kết quả là: " + Intcal.tinhBP(n));
    }
}
