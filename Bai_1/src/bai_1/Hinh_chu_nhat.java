/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

/**
 *
 * @author NguyenNgocDang
 */
public class Hinh_chu_nhat {
    private float dai;
    private float rong;
    
    Hinh_chu_nhat(){
        this.dai = 0.0f;
        this.rong = 0.0f;
    }

    Hinh_chu_nhat(float dai, float rong) {
        this.dai = dai;
        this.rong = rong;
    }
    
    
    public void setChieuDai (float dai){
        this.dai = dai;
    }
    
    public float getChieuDai(){
        return this.dai;
    }
    
    public void setChieuRong(float rong) {
        this.rong = rong;
    }
    
    public float getChiecRong(){
        return this.rong;
    }
    
    public float tinhDienTich(){
        return (this.dai*this.rong);
    }
    
    public float tinhChuVi(){
        return (this.dai+this.rong)*2;
    }
    
    public String toString(){
        String st = "";
        st += "Chieu dai: " + this.dai;
        st += "Chieu rong: " + this.rong;
        st += "Dien tich: " + this.tinhDienTich();
        st += "Chu vi: " + this.tinhChuVi();
        return st;
    }
}
