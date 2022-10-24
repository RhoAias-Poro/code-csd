/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVLTree_Insert_Dele_1626;

import java.util.LinkedList;

/**
 *
 * @author WIN1064
 */
public class MyStack {

    LinkedList a;

    MyStack() {
        a = new LinkedList();
    }
    
    boolean isEmpty(){
        return  (a.isEmpty());
    }
    
    void push(Object x){
        a.add(x);
    }
    
    Object pop(){
        return (a.removeLast());
    }
        

}
