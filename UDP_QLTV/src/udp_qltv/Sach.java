/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_qltv;
public class Sach {

    public String ID;
    public String TenSach;
    public String NXB;
    public int TongSoLuong;
    public int SoLuongChoMuon;

    public Sach(String ID, String TenSach, String NXB, int TongSoLuong, int SoLuongChoMuon) {
        this.ID = ID;
        this.TenSach = TenSach;
        this.NXB = NXB;
        this.TongSoLuong = TongSoLuong;
        this.SoLuongChoMuon = SoLuongChoMuon;
    }

    public String ThongTinChiTiet() {
        return "ID: " + ID
                + "  |  Ten sach: " + TenSach
                + "  |  NXB: " + NXB
                + "  |  Tong so luong: " + TongSoLuong
                + "  |  So luong da cho muon: " + SoLuongChoMuon + "\n";
    }
}
