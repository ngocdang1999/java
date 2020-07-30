/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_tn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenNgocDang
 */
public class ServerDictionary {
    public static void main(String[] args) throws RemoteException,
            MalformedURLException, Exception {
        List<Word> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("data"))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                String str[] = line.split("\\$");
                Word word = new Word();
                word.setEn(str[0]);
                word.setVi(str[1]);
                list.add(word);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Dictionary dict = new Dictionary(list);
        Registry registry = LocateRegistry.createRegistry(6666);
        Naming.bind("rmi://localhost:6666/remoteDict", dict);
        System.out.println("Server is running...");
    }
}
