/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quan_ly_sinh_vien;

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
        Scanner sa = new Scanner(System.in);
        System.out.println("Nhap thong tin 3 sinh vien: ");
        sinh_vien SV[] = new sinh_vien[3];
        for(int i=0; i<3; i++){
            System.out.print("CodeSV: ");
            int CodeSV = sa.nextInt();
            sa.nextLine();
            System.out.print("FullName: ");
            String FullName = sa.nextLine();
            System.out.print("PointLT: ");
            float PointLT = sa.nextFloat();
            System.err.print("PointTH: ");
            float PointTH = sa.nextFloat();
            SV[i] = new sinh_vien(CodeSV, FullName, PointLT, PointTH);
            System.out.println("\n--------------\n");
        }
        System.out.println("\tMASV\tHo va ten\tDiem ly thuyet\tDiem thuc hanh\tDiem trung binh");
        for(int i=0; i<3; i++){
            System.out.print("\t" + SV[i].getCodeSV());
            System.out.print("\t" + SV[i].getFullName());
            System.out.print("\t" + SV[i].getPointLT());
            System.out.print("\t\t" + SV[i].getPointTH());
            System.out.print("\t\t" + SV[i].PointTB());
            System.out.println();
        }
    }
    
}
