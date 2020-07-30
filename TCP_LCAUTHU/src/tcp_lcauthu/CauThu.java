/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_lcauthu;

/**
 *
 * @author NguyenNgocDang
 */
public class CauThu {
    public String ID;
    public String Ten;
    public int NamSinh;
    public String ViTriThiDau;
    public float LuongThangMacDinh;

    public CauThu(String ID, String Ten, int NamSinh, String ViTriThiDau, float LuongThangMacDinh) {
        this.ID = ID;
        this.Ten = Ten;
        this.NamSinh = NamSinh;
        this.ViTriThiDau = ViTriThiDau;
        this.LuongThangMacDinh = LuongThangMacDinh;
    }

    public String ThongTinChiTiet() {
        return "ID: " + this.ID
                + "  |  Ten: " + this.Ten
                + "  |  Nam sinh: " + this.NamSinh
                + "  |  Vi tri thi dau: " + this.ViTriThiDau
                + "  |  Luong thang mac dinhL " + this.LuongThangMacDinh + "\n";
    }

    public float tinhTongLuong(int n) {
        //n: so tran thi dau trong thang cua cau thu
        float TienThuongViTri = 0f;
        switch (this.ViTriThiDau) {
            case "Thu Mon":
                TienThuongViTri = LuongThangMacDinh * 1.5f / 100;
                break;
            case "Tien Dao":
                TienThuongViTri = LuongThangMacDinh * 2.5f / 100;
                break;
            case "Tien Ve":
            case "Hau Ve":
                TienThuongViTri = LuongThangMacDinh * 2.0f / 100;
                break;
        }

        return LuongThangMacDinh + n * TienThuongViTri;
    }
}
