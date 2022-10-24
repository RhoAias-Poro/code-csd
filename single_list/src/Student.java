/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win
 */
public class Student {
    String name;
    int age;
    
    Student(){
    }

    public Student(String xName, int xAge) {
        name = xName;
        age = xAge;
    }
  
    public String toString(){
        return("("+name+","+age+")");
    }
}
