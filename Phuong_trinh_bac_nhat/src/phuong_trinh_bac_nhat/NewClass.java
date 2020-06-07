/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuong_trinh_bac_nhat;

/**
 *
 * @author NguyenNgocDang
 */
public class NewClass {
    class Msg{
        public Msg(){
            System.out.println("Hello");
        }
        public void sayGoogbye(){
            System.out.println("Googbye");
        }
}
    class TestMsg extends Msg{
        public TestMsg(){
            super();
            System.out.println("Hello Java");
        }
        public void sayGoodbye(){
            System.out.println("Googbye Java");
        }
    }
    public class Demo{
        public static void main(String args[]) {
            Msg m1= new Msg();
            Msg m2= new TestMsg();
            m1.sayGoogbye();
            m2.sayGoogbye();
        }
    }
}
