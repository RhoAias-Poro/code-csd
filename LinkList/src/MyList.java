
public class MyList {
   Node head, tail;
   
   MyList() // Contructor emy Single_List
   {
       head = tail = null;
   }
   
   boolean isEmpty() // Check SingleList is empty or not
   {
       return (head == null);
   }
   
   void clear(){ // Clear SingleList, but not delete single node
       head = tail = null; 
   }
   
   void addLast(Student x) // Add a node to the last of the linklist
   {
       Node q = new Node(x); //info = x , next = null
       {
           if(isEmpty()){
               head = tail = q;
               return ;
           }
           tail.next = q;
           tail = q; // update lại biến tail
       }
   }
   
   void visit(Node p) // print the info of node that have been visit
   {
       if( p != null)
       {
           System.out.println(p.info);
       }
   }
   
   void traverse() // visit alll the of it's Node
   {
       Node p = head;
       while(p!= null)
       {
           visit(p);
           p=p.next;
       }
       System.out.println();
   }
   
   void addMany(String[] a,  int[] b)
   {
       int n, i;
       n = a.length;
       for(i = 0; i < n; i++)
       {
           addLast(new Student(a[i], b[i]));
       }
   }
   Node searchByName(String xName)
   {
       Node p = head;
       while(p!=null)
       {
           if(p.info.name.equals(xName))
           {
               return(p);
           }
           p=p.next;
       }
       return null;
   }
   
   Node searchByAge(int xAge)
   {
       Node p = head;
       while(p!=null)
       {
           if(p.info.age == xAge)
           {
               return(p);
           }
           p=p.next;
       }
       return null;
   }
   
   void addFirst(Student x)
   {
       head = new Node(x, head);
   }
   
    // Insert after Node q, a new Node with info x
   void insertAfter(Node q, Student x)
   {
       if(isEmpty() || q == null)
       {
           return;
       }
       Node q1 = q.next;
       Node p = new Node(x, q1);
       q.next = p;
       if(tail == q)
       {
           tail = p;
       }
   }
   
   void insertBefore(Node q, Student x)
   {
       if(isEmpty() || q == null)
       {
           return;
       }
       
       if(q == head)
       {
           addFirst(x);
           return;
       }
       
       Node f = head;
       while(f!=null && f.next != q)
       {
           f = f.next;
       }
       if(f == null) return;
       insertAfter(f, x);
   }
   
   void removeFirst()
   {
       if(isEmpty())
       {
           tail = null;
           return;
       }
       head=head.next;
       /*if(head == null) 
       {  
           tail = null;
       }*/
   }
   
   
    void remove(Node q)
   {
       if(isEmpty() || q == null)
       {
           return;
       }
       if(q == head)
       {
           removeFirst();
           return;
       }
       // Find a node before the Node which we want to remove
       Node f = head;
       while( f!= null & f.next != q)
       {
           f=f.next;
       }
       
       if(f==null) return;
       
       f.next = q.next;
       if(f.next == null) // if q is tail
       {
           tail = f;
       }
   }
    
    //Remove node with name = xName
    void remove(String xName)
    {
        Node q = searchByName(xName);
        remove(q);
    }
    
    // remove 1 node with age = xAge ( the first node it find)
    void remove(int xAge)
    {
       Node q = searchByAge(xAge);
       remove(q);
    }
    
    // remove all the node with age = xAge
    void removeAll(int xAge)
    {
        Node q;
        while(true)
        {
            q = searchByAge(xAge);
            if(q == null) break;
            remove(q);
        }
    }
    
    // Return node at the position k
    Node pos(int k)
    {
        int i = 0;
        Node p = head;
        while(p != null)
        {
            if(i == k) return(p);
            i++;
            p=p.next;
        }
        return null;
    }
    
    void removePos(int k)
    {
        Node q = pos(k);
        remove(q);
    }
    
    void sortByName()
    {
        Node pi, pj;
        Student x;
        pi = head;
        while(pi != null)
        {
            pj = pi.next;
            while(pj != null)
            {
                if(pj.info.name.compareTo(pi.info.name) < 0)
                {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
    
    void sortByAge()
    {
        Node pi, pj;
        Student x;
        pi = head;
        while(pi!=null)
        {
            pj=pi.next;
            while(pj!=null)
            {
                if(pj.info.age < pi.info.age)
                {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj=pj.next;
            }
            pi=pi.next;
        }
    }
    
    //return the size of linklist
    int size()
    {
        int i = 0;
        Node p = head;
        while(p!=null)
        {
            i++;
            p=p.next;
        }
        return i;
    }
    
    //return array of student
    Student[] toArray()
    {
        int i, n;
        n = size();
        Student[] a = new Student[n];
        Node p = head;
        i = 0;
        while(p!=null)
        {
            a[i++] = new Student(p.info.name, p.info.age);
            p=p.next;
        }
        return a;
    }
    
    void reverse()
    {
        MyList t = new MyList(); // create new list
        Node p = head;
        while(p!= null)
        {
            t.addFirst(new Student(p.info.name, p.info.age));
            p=p.next;
        }
        head = t.head;
        tail = t.tail;
    }
    
    Node findMaxAge()
    {
        if(isEmpty()) return (null);
        Node q, p;
        p = q = head;
        int maxAge = head.info.age;
        p = p.next;
        while(p!=null)
        {
            if(p.info.age > maxAge)
            {
                maxAge = p.info.age;
                q = p;
            }
            p = p.next; 
        }
        return q;
    }
    
     Node findMinAge()
    {
        if(isEmpty()) return (null);
        Node q, p;
        p = q = head;
        int minAge = head.info.age;
        p = p.next;
        while(p!=null)
        {
            if(p.info.age < minAge)
            {
                minAge = p.info.age;
                q = p;
            }
            p = p.next; 
        }
        return q;
    }
    
    //Put studentx into node p
    void setData(Node p, Student x)
    {
        if(p != null)
        {
            p.info = x;
        }
    }
    
    // sort from node with index k to node with index h
    void sortByAge(int k, int h)
    {
        if(k > h) return;
        if(k < 0) k = 0;
        int n = size();
        if(h > n-1)
        {
            h = n - 1;
        }
        Node u = pos(k);
        Node v = pos(h+1);
        Node pi, pj;
        Student x;
        pi = u;
        while(pi != v)
        {
            pj = pi.next;
            while(pj != v)
            {
               if(pj.info.age < pi.info.age)
                {
                    x = pi.info;
                    pi.info = pj.info;
                    pj.info = x;
                }
                pj=pj.next; 
            }
            pi = pi.next;
        }
    }
    
    void reverse(int k, int h)
    {
        if(k > h) return;
        if(k < 0) k = 0;
        int n = size();
        if(h > n-1 || k < 0)
        {
            return;
        }
        Student[] a = toArray(); // convert list to array
        int i = k;
        int j = h;
        Student x;
        while(i < j)
        {
            x=a[i];
            a[i] = a[j];
            a[j] = x;
            i++;
            j--;
        }
        //convert all array to list
        clear();
        for(i = 0; i < n; i++)
        {
            addLast(a[i]);
        }
    }
}
