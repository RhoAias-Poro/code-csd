/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author win
 */
public class Stack_Array_1 {
    public static void main(String[] args){
        int choice;
        int x, k;
        Scanner s = new Scanner(System.in);
        LinkedStack a = new LinkedStack();
        while(true){
            System.out.println();
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Display all");
            System.out.println("0. Exit");
            System.out.print("   Your selection (0 -> 4):  ");
            choice = s.nextInt();
            if (choice == 0){
                break;
            }
            switch(choice){
                case 1:
                    System.out.print("Enter the value to be pushed: ");
                    x = s.nextInt();
                    x = new Integer(x);
                    a.push(x);
                    break;
                
                case 2:
                    System.out.println("The element at the top is "+a.top());
                    break;
                    
                case 3:
                    System.out.println("The element poped is "+a.pop());
                    break;
                    
                case 4:
                    a.displayAll();
                    break;
            }
        }
    }
}
