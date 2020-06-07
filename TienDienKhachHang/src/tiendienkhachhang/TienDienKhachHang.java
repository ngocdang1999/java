/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendienkhachhang;

/**
 *
 * @author NguyenNgocDang
 */
public class TienDienKhachHang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        QuanLyKhachHang qlkh = new QuanLyKhachHang();
        qlkh.NhapKhachHang();
        qlkh.XuatKhachHang();
        qlkh.xuatTheoThangNam(11, 2019);
        qlkh.sortTheoMaSo();
        qlkh.XuatKhachHang();
        qlkh.sortTheoThanhTien();
        qlkh.XuatKhachHang();
    }
    
}
