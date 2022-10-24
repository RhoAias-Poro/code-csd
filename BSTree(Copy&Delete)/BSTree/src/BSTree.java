public class BSTree
 {Node root;
  BSTree() {root=null;}
  boolean isEmpty()
   {return(root==null);
   }
  public void insert(int x)
   {if(root==null)
      {root = new Node(x);
       return; 
      }
    Node f,p;
    p=root;f=null;
    while(p!=null)
     {if(p.info==x)
       {System.out.println(" The key " + x + " already exists, no insertion");
        return;
       }
      if(x<p.info)
        {f=p;p=p.left;}
        else
        {f=p;p=p.right;}
     }
    if(x<f.info)
      f.left=new Node(x);
       else
        f.right=new Node(x);
   }
  public void copyDele(int x)
   {if(root==null)
       {System.out.println(" The tree is empty, no deletion");
        return;
       }
    Node f,p; // f will be the father of p
    p=root;f=null;
    while(p!=null)
     {if(p.info==x) break;//Found key x
      if(x<p.info)
        {f=p;p=p.left;}
        else
        {f=p;p=p.right;}
     }
    if(p==null)
     {System.out.println(" The key " + x + " does not exist, no deletion");
      return;
     }
    if(p.left==null && p.right==null) // p is a leaf node
     {if(f==null) // The tree is one node
       root=null; 
        else
        {if(f.left==p)
          f.left=null;
           else
            f.right=null;
        }
      return;
     }

    if(p.left!=null && p.right==null) // p has only left child
     {if(f==null) // p is a root
       root=p.left; 
        else
        {if(f.left==p) // p is aleft child
           f.left=p.left;
            else 
             f.right=p.left;
        }
      return;
     }

    if(p.left==null && p.right!=null) // p has only right child
     {if(f==null) // p is a root
       root=p.right; 
        else
        {if(f.left==p) // p is aleft child
           f.left=p.right;
            else 
             f.right=p.right;
        }
      return;
     }

    if(p.left!=null && p.right!=null) // p has both left and right children
     {Node q,fr,rp; // p's key will be replaced by rp's one
      fr=null;
      q = p.left;
      rp = q;
      while(rp.right!=null) 
       {fr=rp; rp = rp.right;}// Find the right most node on the left sub-tree
      p.info = rp.info;
      if(fr==null) // rp is just a left son of p 
       p.left=rp.left;
        else
         fr.right=rp.left;
     }
     
   }
//=================================
  public void visit(Node p)
   {if(p==null) return;
    System.out.print("  " + p.info);
   }
  public void preOrder(Node p)
   {if(p==null) return;
    visit(p);
    preOrder(p.left);
    preOrder(p.right);
   }
  public void inOrder(Node p)
   {if(p==null) return;
    inOrder(p.left);
    visit(p);
    inOrder(p.right);
   }
  public void addArray(int [] a)
   {for(int i=0;i<a.length;i++)
      insert(a[i]);
   }
 }