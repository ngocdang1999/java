/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_5;

/**
 *
 * @author NguyenNgocDang
 */
public class Bai_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PhanSo phanSo1=new PhanSo(16,3);    // tạo phân số có tử = 16 và mẫu = 4
        PhanSo phanSo2=new PhanSo(4,8); // tạo phân số có tử = 4 và mẫu = 8
         
        // gọi phương thức cộng, trừ, nhân, chia 2 phân số
        phanSo1.congPhanSo(phanSo2);
        phanSo1.truPhanSo(phanSo2);
        phanSo1.nhanPhanSo(phanSo2);
        phanSo1.chiaPhanSo(phanSo2);
    }
    
}
