/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_anhviet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {

    public static void main(String[] args) {
        //doc file
        ArrayList<Word> list = new ArrayList<Word>();
        try {
            FileReader fr = new FileReader("word.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                //a[0]: english
                //a[1]: vietnamese
                //a[2]: meaning
                Word word = new Word(a[0], a[1], a[2]);
                list.add(word);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }

        //RMI
        try {
            IMyRemote obj = new Sample(list);
            LocateRegistry.createRegistry(1099);
            Naming.rebind("ABC", obj);

        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
