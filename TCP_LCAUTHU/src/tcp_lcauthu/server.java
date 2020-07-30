/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_lcauthu;

import com.sun.corba.se.spi.activation.Server;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NguyenNgocDang
 */
public class server {
      public static void main(String[] args) {
        //doc file
        ArrayList<CauThu> listCauThu = new ArrayList<CauThu>();
        try {
            FileReader fr = new FileReader("cauthu.txt");
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s = br.readLine()) != null) {
                String[] a = s.split("\\$");
                //a[0]: ID
                //a[1]: ten
                //a[2]: nam sinh
                //a[3]: vi tri
                //a[4]: luong thang mac dinh
                CauThu cauthu = new CauThu(a[0], a[1], Integer.parseInt(a[2]), a[3], Float.parseFloat(a[4]));
                listCauThu.add(cauthu);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
        }

        //ket noi TCP
        try {
            ServerSocket myServer = new ServerSocket(1111);
            System.out.println("Server TCP da duoc khoi tao, cho doi Client ket noi...");
            while (true) {
                Socket socket = myServer.accept();
                System.out.println("Client da ket noi!");
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                int k = 0;
                while (k != 4) {
                    k = dis.readInt();

                    switch (k) {
                        case 1:
                            String s = dis.readUTF();
                            String[] a = s.split("\\$");
                            //a[0]: ID
                            //a[1]: ten
                            //a[2]: nam sinh
                            //a[3]: vi tri
                            //a[4]: luong thang mac dinh
                            CauThu cauthu = new CauThu(a[0], a[1], Integer.parseInt(a[2]), a[3], Float.parseFloat(a[4]));
                            listCauThu.add(cauthu);
                            dos.writeUTF("Them thanh cong!");
                            break;
                        case 2:
                            String ThongTinTatCaCauThu = "";
                            for (CauThu ct : listCauThu) {
                                ThongTinTatCaCauThu += ct.ThongTinChiTiet();
                            }
                            dos.writeUTF(ThongTinTatCaCauThu);
                            break;
                        case 3:
                            String id = dis.readUTF();
                            int sotran = dis.readInt();
                            for (CauThu ct : listCauThu) {
                                if(ct.ID.equals(id)){
                                    dos.writeFloat(ct.tinhTongLuong(sotran));
                                }
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
