/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day_so_nguyen_to;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class Day_so_nguyen_to {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sa = new Scanner(System.in);
        System.out.println("Nhap vao so n: ");
        int n = sa.nextInt();
        System.out.println("So nguyen to la:");
        
        for(int i = 1; i <= n; i++)
            if(Check(i))
                System.out.println("  " + i);
    }

    public static boolean Check(int n){
        if (n < 2)
            return false;
        for (int i=2; i<n; i++)
            if(n%i==0)
                return false;
        return true;
    }
}
