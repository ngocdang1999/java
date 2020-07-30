/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_tn;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class ClientDictionary {
    public static void main(String[] args) throws RemoteException,
            MalformedURLException, Exception {
        Interface intDict = (Interface) Naming.lookup("rmi://localhost:6666/remoteDict");
        proccess(intDict);
    }

    public static void mainMenu() {
        System.out.println("1. Translate from English to Vietnamese");
        System.out.println("2. Translate from Vietnamese to English");
        System.out.println("3. Exit");
    }

    public static void proccess(Interface intDict) throws Exception {
        int choice = 0;
        while (choice != 3) {
            mainMenu();
            System.out.print("Your choice: ");
            choice = new Scanner(System.in).nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Type your English word here: ");
                    String word = new Scanner(System.in).nextLine();
                    System.out.println(String.format("%s: %s", word, intDict.enToVi(word) == null ? "Not valid" : intDict.enToVi(word)));
                    break;
                case 2:
                    System.out.print("Type your Vietnamese word here: ");
                    String wordVI = new Scanner(System.in).nextLine();
                    System.out.println(String.format("%s: %s", wordVI, intDict.viToEn(wordVI)));
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Your choice must be 1, 2 or 3.");
                    break;
            }
        }
    }
}
