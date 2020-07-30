/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi_kttamgiac;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author NguyenNgocDang
 */
public class check extends UnicastRemoteObject implements remote{
    public check() throws RemoteException {
        super();
    }
    @Override
     public boolean check(int a, int b, int c) throws RemoteException {
        if (a + b > c && a + c > b && +c > a) {
            return true;
        }
        return false;
    }
}
