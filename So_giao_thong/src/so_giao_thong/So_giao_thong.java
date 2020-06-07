/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so_giao_thong;

/**
 *
 * @author NguyenNgocDang
 */
public class So_giao_thong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        XeCo xc =new XeCo();
        xc.nhap();
        System.out.println("Ten Chu Xe:\t"+xc.getTenChuXe()+"\tLoai XE:"+xc.getLoaiXe()+"\tTien thue phai dong:"+xc.ThueXe());


}
}

