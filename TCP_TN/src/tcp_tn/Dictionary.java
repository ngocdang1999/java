/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_tn;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NguyenNgocDang
 */
public class Dictionary extends UnicastRemoteObject implements Interface {

    private List<Word> list = new ArrayList<>();

    public Dictionary() throws RemoteException {
        super();
    }

    public Dictionary(List<Word> list) throws RemoteException {
        this.list = list;
    }

    public List<Word> getList() {
        return list;
    }

    public void setList(List<Word> list) {
        this.list = list;
    }

    @Override
    public String viToEn(String vi) throws Exception {
        for (Word element : list) {
            if (element.getVi().equals(vi)) {
                return element.getEn();
            }
        }
        return null;
    }

    @Override
    public String enToVi(String en) throws Exception {
        for (Word element : list) {
            if (element.getEn().equals(en)) {
                return element.getVi();
            }
        }
        return null;
    }

}