/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author NguyenNgocDang
 */
public class CalculatorImpl extends UnicastRemoteObject implements intCalculator{

    protected  CalculatorImpl() throws RemoteException{
        
    }
    @Override
    public int addNumber(int x, int y) throws RemoteException {
        System.out.println("Calculated x,y");
        return x + y; //To change body of generated methods, choose Tools | Templates.
    }
    
}
