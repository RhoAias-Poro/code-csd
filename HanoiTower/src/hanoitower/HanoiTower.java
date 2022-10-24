/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hanoitower;

import java.util.Scanner;

/**
 *
 * @author win
 */
public class HanoiTower {

    static void thapHN(int n, char a, char b, char c){
        if(n==1){
            System.out.println(" " + a + " -> " + " " + b);
        } else {
            thapHN(n - 1, a, c, b);
            thapHN(1, a, b, c);
            thapHN(n - 1, c, b, a);
        }
    }
    
    public static void main(String[] args) {
        char a, b, c;
        a = 'A'; b = 'B'; c = 'C';
        System.out.print("Enter number of tower: ");
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println();
        System.out.println("Hanoi Tower for n = " + n);
        thapHN(n, a, b, c);
        System.out.println();
    }  
}
