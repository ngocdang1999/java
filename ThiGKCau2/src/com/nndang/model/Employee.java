/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nndang.model;

import com.sun.jndi.toolkit.dir.SearchFilter;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author NguyenNgocDang
 */
public class Employee implements Serializable{
    private int MNV;
    private String TenNV;
    private Date Birthday;
    private String ChucVu;
    private float Luong;

    public int getMNV() {
        return MNV;
    }

    public void setMNV(int MNV) {
        this.MNV = MNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public float getLuong() {
        return Luong;
    }

    public void setLuong(float Luong) {
        this.Luong = Luong;
    }
    
    public Employee(){
        
    }

    public Employee(int MNV, String TenNV, Date Birthday, String ChucVu, float Luong) {
        this.MNV = MNV;
        this.TenNV = TenNV;
        this.Birthday = Birthday;
        this.ChucVu = ChucVu;
        this.Luong = Luong;
    }

    @Override
    public String toString() {
        return "Employee{" + "MNV=" + MNV + ", TenNV=" + TenNV + ", Birthday=" + Birthday + ", ChucVu=" + ChucVu + ", Luong=" + Luong + '}';
    }
    
    
}
