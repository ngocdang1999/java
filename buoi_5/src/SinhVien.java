
import java.io.Serializable;
import java.util.Date;
import javafx.scene.chart.PieChart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NguyenNgocDang
 */
//class dung trong moi truong mạng 
//cho nen phai implement serial

public class SinhVien implements Serializable{
    private int MSSV;
    private String tenSV;
    private java.util.Date NgaySinh;
    private String quequan;

    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int MSSV) {
        this.MSSV = MSSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public SinhVien(){}
    //ham tao tham so
    public SinhVien(int MSSV, String tenSV, Date NgaySinh, String quequan) {
        this.MSSV = MSSV;
        this.tenSV = tenSV;
        this.NgaySinh = NgaySinh;
        this.quequan = quequan;
    }
    //Thông tin sinh vien
    @Override
    public String toString() {
        return "SinhVien{" + "MSSV=" + MSSV + ", tenSV=" + tenSV + ", NgaySinh=" + NgaySinh + ", quequan=" + quequan + '}';
    }   
}
