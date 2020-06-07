/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_tap_3_ltm;

import java.io.Serializable;

/**
 *
 * @author NguyenNgocDang
 */
public class Sinhvien implements Serializable{
    private static final long serialVersionUID = 42L; // dam bao doi tuong truoc va sau Serial la 1
    private int ID, tuoi;
    private String ten;

    Sinhvien(int ID, int tuoi, String ten) {
        this.ID = ID;
        this.tuoi = tuoi;
        this.ten = ten;
    }

    Sinhvien() {
        this.ID = 9999;
        this.tuoi = 0;
        this.ten = "";
    }
    
    public int getID() {
        return ID;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getTen() {
        return ten;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public String toString() {
        return "Sinhvien [" + "ID=" + ID + ", tuoi=" + tuoi + ", ten=" + ten + ']';
    }
}
