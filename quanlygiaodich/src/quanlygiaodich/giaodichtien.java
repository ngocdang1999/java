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
public class giaodichtien extends giaodich{
    private float TiGia;
    private int LoaiTienTe;

    public giaodichtien() {
        super();
        this.TiGia = TiGia;
        this.LoaiTienTe = LoaiTienTe;
    }

    public giaodichtien(float TiGia, int LoaiTienTe, int MaGiaoDich, String NgayThang, float DonGia, float ThanhTien, int SoLuong) {
        super();
        this.TiGia = TiGia;
        this.LoaiTienTe = LoaiTienTe;
    }

    public float getTiGia() {
        return TiGia;
    }

    public void setTiGia(float TiGia) {
        this.TiGia = TiGia;
    }

    public int getLoaiTienTe() {
        return LoaiTienTe;
    }

    public void setLoaiTienTe(int LoaiTienTe) {
        this.LoaiTienTe = LoaiTienTe;
    }

    public void nhap(){
        super.nhap();
        System.out.println("Tỉ giá: ");
        TiGia = in.nextFloat();
        System.out.println("Loại tiền tệ: ");
        LoaiTienTe = in.nextInt();
    }
    
    public double TTien()
	{
		if(LoaiTienTe==1)
			return this.getDonGia()*this.getSoLuong();
		else
			return this.getDonGia()*this.getSoLuong()*this.getTiGia();
	}
	
	public String toString()
	{
		String temp;
		if(LoaiTienTe==1)
			temp="VND";
		else if(LoaiTienTe==2)
			temp="USD";
		else
			temp="EURO";
		return "Giao Dich Tien Te: " + super.toString() + "' Ti Gia: " + TiGia 
				+ ", Loai Tien Te: " + temp + ", ThanhTien: " + TTien() + "]";
	}

}

























