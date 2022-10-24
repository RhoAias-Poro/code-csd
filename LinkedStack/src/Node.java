/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win
 */
public class Node {
    public Object info;
    public Node next;

   Node(Object x, Node q) {
        info = x;
        next = q;
    }
    
    Node(Object x){
        this(x, null);
    }

    }
