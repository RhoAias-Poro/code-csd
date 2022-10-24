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
    Student info;
    Node next;

    public Node() {
    }
    
    
    
    Node(Student x, Node q) {
        info = x;
        next = q;
    }
    
    Node(Student x){
        this(x, null);
    }

    }

