/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_chongia;

import com.sun.corba.se.spi.activation.Server;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenNgocDang
 */
public class Sever {
     public static void main(String[] args) throws MalformedURLException {
        //doc file
        ArrayList<MatHang> listMatHang = new ArrayList<MatHang>();
        try {
            FileReader fr = new FileReader("mathangDe8.txt");
            BufferedReader br = new BufferedReader(fr);
            String s= "";
            while((s=br.readLine())!=null){
                String[] a = s.split("\\$");
                //a[0]: ID
                //a[1]: Ten
                //a[2]: Gia tien
                MatHang mh = new MatHang(a[0], a[1], Integer.parseInt(a[2]));
                listMatHang.add(mh);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }
        
        
        //RMI
        try {
            IMyRemote obj = new Sample(listMatHang);
            LocateRegistry.createRegistry(1099);
            Naming.rebind("ABC", obj);
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
