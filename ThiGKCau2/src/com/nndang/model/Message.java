/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nndang.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author NguyenNgocDang
 */
public class Message implements Serializable{
        public static final int THEM_NHAN_VIEN_MOI = 1;
	public static final int TIM_KIEM_NHAN_VIEN = 2;
        public static final int TINH_LUONG = 3;
	
	private int chon;//SỰ LỰA CHỌN CỦA NGƯỜI DÙNG
	
	private List<Employee> dsnv;

    public int getChon() {
        return chon;
    }

    public void setChon(int chon) {
        this.chon = chon;
    }

    public List<Employee> getDsnv() {
        return dsnv;
    }

    public void setDsnv(List<Employee> dsnv) {
        this.dsnv = dsnv;
    }
	
}
