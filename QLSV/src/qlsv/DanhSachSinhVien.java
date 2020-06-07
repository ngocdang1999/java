/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv;

import com.sun.java.swing.plaf.windows.WindowsTreeUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author NGO THANG
 */
public class DanhSachSinhVien {
    ArrayList<QLSV> listsv;
    
    DanhSachSinhVien(){
        listsv =  new ArrayList();
    }
    
    public void nhapDanhSachSinhVien(){
        Scanner sc = new Scanner(System.in);
        String traloi;
        do{
            QLSV sv = new QLSV();
            sv.nhapThongTin();
            listsv.add(sv);
            System.out.println("Ban co nhap tiep hay ko <t/k>?");
            traloi = sc.nextLine();
        } while(traloi.equals("t"));
    }
    
    public void timSinhVien(int maso){
        
    }
    public void timSinhVien(String hoten){
        
    }
    
    public void xuatDanhSachSinhVien(){
        Collections.sort(listsv);
        for(QLSV sv:listsv)
            System.out.println(sv.toString());
        
        //for (int i=0; i < listsv.size(); i++)
        // System.out.println(listsv.get(i).toString());
    }
}
