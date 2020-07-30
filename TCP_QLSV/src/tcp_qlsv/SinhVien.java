/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_qlsv;

public class SinhVien {

    public String Ten;
    public String NgaySinh;
    public String MaSV;
    public String QueQuan;

    public SinhVien(String ten, String ngaysinh, String masv, String quequan) {
        this.Ten = ten;
        this.NgaySinh = ngaysinh;
        this.MaSV = masv;
        this.QueQuan = quequan;
    }

    public String ThongTinSV() {
        return "Ten: " + this.Ten + "  |  Ngay sinh: " + this.NgaySinh + "  |  Ma SV: " + this.MaSV + "  |  Que quan: " + this.QueQuan;
    }
}
