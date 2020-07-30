/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author NguyenNgocDang
 */
//remote interface = đặt ta các thứ có thễ triệu gọi từ xa

public interface intCalculator extends Remote {
    public int addNumber (int x, int y) throws RemoteException; //phải có nén ngoại lệ
    //phương thức này không có thân => do đó chúng ta phãi cài đặt nó
    
}

