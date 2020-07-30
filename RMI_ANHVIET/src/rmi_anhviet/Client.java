/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_anhviet;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Client {

    public static void main(String[] args) {
        try {
            IMyRemote obj = (IMyRemote) Naming.lookup("rmi://localhost:1099/ABC");

            Scanner sc = new Scanner(System.in);
            int k = 0;        //bien kiem tra lua chon cua nguoi dung
            while (k != 4) {
                System.out.println("------------MENU-------------");
                System.out.println("1. Dich Anh-Viet");
                System.out.println("2. Dich Viet-Anh");
                System.out.println("3. Tra nghia tu tieng Anh");
                System.out.println("4. Thoat");
                System.out.print("Ban chon: ");
                k = Integer.parseInt(sc.nextLine());
                switch (k) {
                    case 1:
                        System.out.print("Nhap tu tieng Anh muon dich: ");
                        String english = sc.nextLine();
                        System.out.println("--> " + obj.English_to_Vietnamese(english));
                        break;
                    case 2:
                        System.out.print("Nhap tu tieng Viet muon dich: ");
                        String vietnamese = sc.nextLine();
                        System.out.println("--> " + obj.Vietnamese_to_English(vietnamese));
                        break;
                    case 3:
                        System.out.print("Nhap tu tieng Anh ban muon tra nghia: ");
                        String s = sc.nextLine();
                        System.out.println("--> " + obj.translate(s));
                        break;
                    case 4:
                        System.out.println("Cam on ban da su dung chuong trinh");
                        break;
                    default:
                        System.out.println("Nhap sai!");
                        break;
                }
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
