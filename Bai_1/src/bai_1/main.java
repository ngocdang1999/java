/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chieu dai: ");
        int dai = sc.nextInt();
        System.out.println("Nhap chieu rong: ");
        int rong = sc.nextInt();
    
    
    Hinh_chu_nhat hcn = new Hinh_chu_nhat();
        System.out.println(hcn.toString());
        hcn.setChieuDai(dai);
        hcn.setChieuRong(rong);
        System.out.println(hcn.toString());
    
    }
    
}
