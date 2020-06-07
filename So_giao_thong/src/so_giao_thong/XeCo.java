/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so_giao_thong;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class XeCo {
    private String TenChuXe;
    private String LoaiXe;
    private int DungTich;
    private double TienThue;
    private long GiaXe;
    //getter
     public XeCo(){
         String TenChuXe="";
         String LoaiXe="";
         int DungTich =0;
         long GiaXe=0;        
     }
     public XeCo(String tcx,String lx,int dt,long gx){
        this.TenChuXe =tcx;
        this.LoaiXe =lx;
        this.DungTich =dt;
        this.GiaXe =gx;
     }
     public String getTenChuXe(){
         return TenChuXe;
        
     }
     public String getLoaiXe(){
         return LoaiXe;
     }
     public int getDungTich(){
         return DungTich;
     }

     private long getGiaXe(){
         return GiaXe;
     }
     //setter

     public void setTenChuXe(String TenChuXe){
         this.TenChuXe =TenChuXe;
     }
     public void setLoaiXe(String LoaiXe){
         this.LoaiXe =LoaiXe;
     }
     public void setDungTich(int DungTich){
         this.DungTich=DungTich;
     }
     public void setGiaXe(long GiaXe){
         this.GiaXe =GiaXe;
     }
     //tinh thue xe
     public double ThueXe(){
         if(DungTich<100){TienThue = (double) (GiaXe*0.01);            
         }if(DungTich>=100&&DungTich<=200){
             TienThue=  (double)(GiaXe*0.03);
         }if(DungTich>200){
             TienThue =(double)(GiaXe*0.05);
         }
        return (double) TienThue;
        
     }
     public void nhap(){
         Scanner nhap =new Scanner(System.in);
             System.out.println("=====Nhap Thong tin Xe=====");
             System.out.println("Ten Chu Xe:");
             TenChuXe = nhap.nextLine();
             System.out.println("Loai Xe:");
             LoaiXe =nhap.nextLine();
             System.out.println("Dung Tich Xe:");
             DungTich =nhap.nextInt();
             System.out.println("Gia Xe:");
             GiaXe= nhap.nextLong();   
     }

}