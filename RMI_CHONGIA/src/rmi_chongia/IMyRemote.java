/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_chongia;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NguyenNgocDang
 */
public interface IMyRemote extends Remote {

    public String randomMatHang() throws RemoteException;

    public String kiemTraDuDoan(String TenMH, int n) throws RemoteException;
}
