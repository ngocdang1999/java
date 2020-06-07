/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuong_trinh_bac_nhat;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class Phuong_trinh_bac_nhat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap he so a:)");
        int hesoa = sc.nextInt();
        System.out.println("Nhap he so b:)");
        int hesob = sc.nextInt();
        if(hesoa==0){
            if(hesob==0)
                System.out.println("Phuong trinh vo dinh.");
            else
                System.out.println("Phuong trinh vo nghiem.");
        }
        else{
            System.out.println("Phuong trinh có nghiem x: " + ((float)-hesob/hesoa));
    }
    }
    
}
