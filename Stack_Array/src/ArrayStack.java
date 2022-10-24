/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.EmptyStackException;
/**
 *
 * @author win
 */
public class ArrayStack {
    protected Object[] a;
    int top, max;
    
    public ArrayStack(){
        this(50);
    }
    
    public ArrayStack(int max1){
         max = max1;
         a = new Object[max];
         top = -1;
     }
     
    protected boolean grow(){
        if(a == null){
           return(false);
         }
         int max1 = max + max/2;
         Object[] a1 = new Object[max1];
         for(int i = 0; i <= top; i++){
             a1[i] = a[i];
         }
         a = a1;
         return(true);
     }
     
    public boolean isEmpty(){
         return(top == -1);
     }
     
    public boolean isFull(){
         return(top == max - 1);
     }
     
    public void clear(){
        top = -1;
    }
     
    public void push(Object x){
        if (!isFull()){
        } else {
            return;
        }
        top++;
        a[top] = x;
    }
    
    Object top() throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return (a[top]);
    }
    
    public Object pop() throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException();
        }
        Object x = a[top];
        a[top] = null;
        top--;
        return(x);
    }
    
    public void displayAll(){
        System.out.println("Elements in the list are:");
        int i = 0;
        while(a[i] != null)
        {
            System.out.print(a[i] + " ");
            i++;
        }
        System.out.println();
    }
}
