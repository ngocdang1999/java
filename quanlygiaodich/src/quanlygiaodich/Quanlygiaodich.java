/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlygiaodich;

import java.util.Scanner;

/**
 *
 * @author NguyenNgocDang
 */
public class Quanlygiaodich {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

                list lgd =new list();
		Scanner in = new Scanner(System.in);
		int x;	
		do
		{
			 System.out.println("\n\t\t----------------------------------");
	         System.out.println("\t\t|0. Thoat ung dung\t\t\t\t |");
	         System.out.println("\t\t|1. Them Giao Dich Vang\t\t\t\t |");
	         System.out.println("\t\t|2. Them Giao Dich Tien Te\t\t\t |");
	         System.out.println("\t\t|3. Hien Thi Danh Sach Giao Dich\t\t |");
	         System.out.println("\t\t|4. Xem Tong So Luong cua cac Giao Dich\t\t |");
	         System.out.println("\t\t|5. Xem Trung Binh Cua Giao Dich Tien Te\t |");
	         System.out.println("\t\t|6. Hien Thi Danh Sach Giao Dich co Don Gia > 1 ngan|");
	         System.out.println("\t\t--------------------------------------");
	         x=in.nextInt();
	         switch(x)
	         {
	         	case 1:
	         		lgd.ThemGD(1);
	         		break;
	         	case 2:
	         		lgd.ThemGD(2);
	         		break;
	         	case 3:
	         		lgd.HienThiDS();
	         		break;
	         	case 4: 
	         		lgd.TongSL();
	         		break;
	         	case 5:
	         		lgd.TrungBinhGDTT();
	         		break;
	         	case 6:
	         		lgd.GiaoDich1ty();
	         		break;
	         }
		}while(x!=0);
		System.out.println("");
	}

    }
    
