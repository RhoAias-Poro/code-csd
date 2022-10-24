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
public class Main {

    public static void main(String[] args) {
        AVLTree t = new AVLTree();
        System.out.println(" After inserting 5, 2, 7, 1, 4, 6, 8, 3:");
        int[] a = {5, 2, 7, 1, 4, 6, 8, 3};
        t.addArray(a);

        System.out.println("\n In-order traverse:");
        t.inOrder(t.root);

        System.out.println("\n After deleting 1:");
        t.remove(new Integer(1));
        t.inOrder(t.root);
    }

}
