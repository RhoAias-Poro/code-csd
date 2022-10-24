/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AVLTree_Insert_Dele_1626;

/**
 *
 * @author WIN1064
 */
public class Node {

    int info;
    int bal; //balance; left -1; right +1
    Node left, right;

    Node(int x) {
        info = x;
        left = right = null;
        bal = 0;

    }

    
}
