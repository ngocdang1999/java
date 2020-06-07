
import java.io.Serializable;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NguyenNgocDang
 */
//truyen thong tin qua lai de chua cac thong tin truyen qua lại
public class Message implements Serializable{
    public static  final int XEM_DANH_SACH = 1;
    public static final int THEM_SINH_VIEN = 2;
    private int chon;
    private List<SinhVien> dsSV;

    public List<SinhVien> getDsSV() {
        return dsSV;
    }

    public void setDsSV(List<SinhVien> dsSV) {
        this.dsSV = dsSV;
    }
            
    public int getChon() {
        return chon;
    }

    public void setChon(int chon) {
        this.chon = chon;
    }
      
}
