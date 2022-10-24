
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author win
 */
public class MyList {
    Node head, tail;
    
    MyList(){
        head = tail = null;
    }
    
     //return true if Mylist is empty otherwise return false
    boolean isEmpty() {
        return head == null;
    } 
    
//clear list, stop managing it (not deleteing)
    void clear(){
        head = tail = null;
    }
    
    //insert a new node to the end of list
    void addLast(Student x) {
     Node q = new Node(x);   //create a Node with info = x; next = null
     if(isEmpty()) {
         head = tail = q;
         return;
     }
        tail.next = q;
        tail = q;
    }
    
//visit means print out info
    void visit(Node p){
        if(p!=null){
            System.out.println(p.info);
        }
    }
    
    //traverse every node in the list
    void traverse() 
    {Node p = head;
     while(p != null) {
         visit(p);
         p=p.next;
     }
      System.out.println();
    }
    
    void addMany(String[] a, int[] b){
        int n, i;
        n = a.length;
        for(i = 0; i < n; i++){
            addLast(new Student(a[i],b[i]));
    }
   }
    
    Node searchByName(String xName){
        Node p = head;
        while(p!=null){
            if(p.info.name.equals(xName)){
                return (p);
            }
            p = p.next;
        }
        return (null);
    }
    
    Node searchByAge(int xAge){
        Node p = head;
        while(p!=null){
            if(p.info.age == xAge){
                return (p);
            }
            p=p.next;
        }
        return(null);
    }
    
    void addFirst(Student x){
        head = new Node(x, head);
    }
    
    //Insert after node q, a node with info x
    void insertAfter(Node q, Student x){
        if(isEmpty() || q==null){
            return;
        }
        Node q1 = q.next;
        Node p = new Node(x, q1); //create node p with info = x, next = q1
        q.next = p;
        if (tail == q){ //if q is last node
            tail = p;   //update new last node
        }
    }
    
    //Insert before node q, a new node with info x
    
    void insertBefore(Node q, Student x){
        if(isEmpty() || q ==null){
            return;
        }
        if(q == head){ //if q is first node
            addFirst(x);
            return;
        }
        //find a node before node q
        Node f = head;
        while(f != null && f.next != q){
            f = f.next;
        }
        //if not found, then q does not consist
        if(f == null){ 
            return;
        }
        insertAfter(f,x);
    }
    
    // 6th function
    void removeFirst(){
        if(isEmpty()){
            return;
        }
        head = head.next;
        if(head == null){
            tail = null;
        }
    }
    
    //remove node pointed by q
    void remove(Node q){
        if(isEmpty() || q ==null){
            return;
        }
        if ( q == head){
            removeFirst();
            return;
        }
        //Find a node before the note which we want ot rmeove
        Node f = head;
        while(f!=null && f.next != q){
            f = f.next;
        }
        //if not found
        if (f == null){
            return;
        }
        Node q1 = q.next; //q1 is the note after which we want to remove
        f.next = q1; //ignore node q
        if (f.next == null){ //if q is the tail
            tail = f;
        }
    }
    
    // F7: remove a node with name
    void remove(String xName){
        Node q = searchByName(xName);
        remove(q);
    }
    
    //F8:remove using age
    void remove(int xAge){
        Node q = searchByAge(xAge);
        remove(q);
    }
    
    //F9:
    void removeAll(int xAge){
        Node q;
        while(true){
            q = searchByAge(xAge);
            if(q==null){
                break;
            }
            remove(q);
        }
    }
    
    //*10*
    Node pos(int k){
        int i =0;
        Node p = head;
        while(p!=null){
            if(i==k){
                return(p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }
    
    //11: remove a node with pos k
    void removePos(int k){
        Node q = pos(k);
        remove(q);
    }
    
    //12:
    void sortByName(){
        Node pi, pj;
        Student x;
        pi = head;
        while(pi != null){
            pj = pi.next;
            while(pj != null){
                if(pj.info.name.compareTo(pi.info.name)<0){
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
    
    //13:
    void sortByAge(){
        Node pi, pj;
        Student x;
        pi = head;
        while(pi != null){
            pj = pi.next;
            while(pj != null){
                if(pj.info.age < pi.info.age){
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
    
    //14:
    int size() {
        int i = 0;
        Node p = head;
        while(p != null){
            i++;
            p = p.next;
        }
        return i;
    }
    
    //15: covert list into array
    Student[] toArray() {
        int i, n;
        n = size();
        Student[] a = new Student[n];
        Node p = head;
        i = 0;
        while(p != null){ //put an element into array step by step
            a[i++] =  new Student(p.info.name, p.info.age);
            p = p.next;
        }
        return(a);
    }
    
    //16:
    void reverse() {
        //construct a new list
        MyList t = new MyList();
        Node p = head;
        while(p != null) {
            t.addFirst(new Student(p.info.name, p.info.age));
            p = p.next;
        }
        head = t.head;
        tail = t.tail;
    }
    
    //17:
    Node findMaxAge() {
        if(isEmpty()){
            return (null);
        }
        int maxAge;
        Node p, q;
        p = q = head;
        maxAge = head.info.age;
        p = p.next;
        while(p != null){
            if(p.info.age > maxAge){
                maxAge = p.info.age;
                q = p;
            } 
            p = p.next;
    }
        return(q);
  }
    
    //18:
    Node findMinAge(){
        if(isEmpty()){
            return (null);
        }
        int minAge;
        Node p, q;
        p = q = head;
        minAge = head.info.age;
        p = p.next;
        while(p != null){
            if(p.info.age > minAge){
                minAge = p.info.age;
                q = p;
            } 
            p = p.next;
       }
        return(q);
    }
    
    //19: put Student x into Node p
    void setData(Node p, Student x){
        if(p != null){
            p.info = x;
        }
    }
    
    //20: Sort from node with index k to node with index h
    void sortByAge(int k, int h){
        if(k > h){
            return;
        }
        if(k < 0){    
            k = 0;
        }
        int n = size();
        if (h > n - 1){
            h = n - 1;
    }
        Node u = pos(k); //frist node in the sequence is u
        Node v = pos(h+1);//v is last node in the sequence
        Node pi, pj;
        Student x;
        pi = u;
        while( pi != v) {
            pj = pi.next;
            while(pj != v){
                if(pj.info.age < pi.info.age){
            x = pi.info;
            pi.info = pj.info;
            pj.info = x;
        }   
        pj = pj.next;
      } 
     pi = pi.next;
    }
  }
  
//21:
    void reverse(int k, int h){
         if(k > h){
            return;
        }
        int n  = size();
        int i, j;
        if(k<0 || h>n-1){
            return;
        }     
        Student[] a = toArray(); //convert list intoArray
        i = k;
        j = h;
        Student x;
        while(i < j){
            x = a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
        //Convert all array into list
        clear();
        for(i = 0; i<n; i++){
            addLast(a[i]);
        }
   }
} //end MyList


