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
public class SNode {
    Node p;
    int d; //degree, left child -1, right child +1 // phai tru trai
    SNode(Node p1, int d1){
        p = p1;
        d = d1;
    }
}
