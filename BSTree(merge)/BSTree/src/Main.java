public class Main
 {public static void main(String [] args)
   {BSTree t = new BSTree();
    System.out.println("\n After inserting 3, 5, 1, 5, 9, 8, 2:");
    int [] a = {3,5,1,5,9,8,2};
    t.addArray(a);
    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);
    System.out.println("\n\n Ater deleting 3:");
    t.copyDele(new Integer(3));
    System.out.println("\n Pre-order traverse:");
    t.preOrder(t.root);
    System.out.println("\n In-order traverse:");
    t.inOrder(t.root);
   }
 }