/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_kttamgiac;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NguyenNgocDang
 */
public interface remote extends Remote{
    public boolean check(int a,int b,int c) throws RemoteException;
}