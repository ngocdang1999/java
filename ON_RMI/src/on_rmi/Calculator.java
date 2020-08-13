/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package on_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author NguyenNgocDang
 */
class Calculator extends UnicastRemoteObject implements intCalculator{
    public Calculator() throws RemoteException{
        
    }
    

    @Override
    public int addNumber(int x, int y) throws RemoteException {
        System.out.println("x,y");
        return x + y;
    }
    
}


