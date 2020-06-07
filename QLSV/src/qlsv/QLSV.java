/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlsv;

import java.util.Scanner;

/**
 *
 * @author NGO THANG
 */
public class QLSV implements Comparable<QLSV>{
    private int maso;
    private String hoten;
    private String diachi;
    private String dienthoai;
    
    QLSV() {
        this.maso = 0;
        this.hoten = "";
        this.diachi = "";
        this.dienthoai = "";
    }
    QLSV ( int maso, String hoten, String diachi , String dienthoai){
        this.maso = maso ;
        this.hoten = hoten;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }
    
    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ma so : ");
        this.maso = Integer.parseInt(sc.nextLine());
        System.out.println("Ho ten: ");
        this.hoten = sc.nextLine();
        System.out.println("Dia chi: ");
        this.diachi = sc.nextLine() ;
        System.out.println("Dien thoai");
        this.dienthoai = sc.nextLine() ;
    }

    @Override
    public String toString() {
    String st = "";
    st += "\n Ma So" + this.maso;
    st += "\n Ho va ten " + this.hoten;
    st += "\n Dia chi " + this.diachi;
    st += "\n Dien thoai" + this.dienthoai;
    return st; }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    DanhSachSinhVien dssv = new DanhSachSinhVien();
    dssv.nhapDanhSachSinhVien();
    dssv.xuatDanhSachSinhVien();
    }

    @Override
    public int compareTo(QLSV o) {
        if(this.maso == o.maso)
            return 0;
        else if(this.maso> o.maso)
            return 1;
        else 
            return -1;
    }
    
    
}
