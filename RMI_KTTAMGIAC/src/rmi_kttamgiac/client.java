/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_kttamgiac;

import com.sun.security.ntlm.Client;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenNgocDang
 */
public class client {
    public static void main(String[] args) {
        try {
            remote obj = (remote) Naming.lookup("rmi://localhost:9999/ABC");

            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap a = ");
            int a = sc.nextInt();
            System.out.print("Nhap b = ");
            int b = sc.nextInt();
            System.out.print("Nhap c = ");
            int c = sc.nextInt();
            if(obj.check(a, b, c)){
                System.out.println("3 canh cua 1 tam giac!");
            } else{
                System.out.println("Khong phai tam giac");
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
