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
public class AVLTree {

    Node root;
    boolean shorter;

    AVLTree() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    Node rotateLeft(Node p) {
        if (p == null || p.right == null) {
            System.out.println("Can not rotate left!");
            return (p);
        }
        //dau tien ta lay pr la cay con phai cua p
        //sau do ta cho cay con trai cua pr lam cay con phai cua p
        //cuoi cung ta gan lai cay con trai cua pr la p
        Node pr = p.right; //1
        p.right = pr.left; //2
        pr.left = p;       //3
        return (pr);
        //pr bay gio tro thanh goc
    }

    Node rotateRight(Node p) {
        if (p == null || p.left == null) {
            System.out.println("Can not rotate right!");
            return (p);
        }
        //dau tien ta lay pr la cay con phai cua p
        //sau do ta cho cay con trai cua pr lam cay con phai cua p
        //cuoi cung ta gan lai cay con trai cua pr la p
        Node pl = p.left; //1
        p.left = pl.right; //2
        pl.right = p;       //3
        return (pl);
        //pl bay gio tro thanh goc
    }

    Node leftBal(Node p) {
        if (p.bal != -2) {
            System.out.println("No need to balance!");
        }
        Node p1, p2;
        p1 = p.left; //p1 la cay con trai
        switch (p1.bal) {
            case -1:
                p.bal = 0;
                p1.bal = 0;
                return (rotateRight(p));
            //p lech trai, p1 cx lech trai
            //day la truong hop LL, lech trai, thi ra xoay phai, sau khi xoay thi p1,p co bal = 0;
            case +1:
                //day la truong hop p lech trai, p1 lech phai, ta co LR
                p2 = p1.right;
                switch (p2.bal) {
                    case 0: //p2 co he so can bang la 0, sau khi xoay, he so can bang cua p va p1 lan luot la 0,0
                        p.bal = 0;
                        p1.bal = 0;
                        break;
                    case -1://tuong tu
                        p.bal = +1;
                        p1.bal = 0;
                        break;
                    case +1://tuong tu
                        p.bal = 0;
                        p1.bal = -1;
                        break;
                }
                p2.bal = 0;
                p.left = rotateLeft(p1);
                return (rotateRight(p));
        }
        return (p);
    }

    Node rightBal(Node p) {
        if (p.bal != +2) {
            System.out.println("No need to balance!");
        }
        Node p1, p2;
        p1 = p.right; //p1 la cay con phai
        switch (p1.bal) {
            case +1:
                p.bal = 0;
                p1.bal = 0;
                return (rotateRight(p));
            //p lech phai, p1 cx lech phai
            //day la truong hop RR, lech phai, thi ra xoay trai, sau khi xoay thi p1,p co bal = 0;
            case -1:
                //day la truong hop p lech phai, p1 lech trai, ta co RL
                p2 = p1.left;
                switch (p2.bal) {
                    case 0: //p2 co he so can bang la 0, sau khi xoay, he so can bang cua p va p1 lan luot la 0,0
                        p.bal = 0;
                        p1.bal = 0;
                        break;
                    case - 1://tuong tu
                        p.bal = 0;
                        p1.bal = +1;
                        break;
                    case +1://tuong tu
                        p.bal = -1;
                        p1.bal = 0;
                        break;
                }
                p2.bal = 0;
                p.left = rotateLeft(p1);
                return (rotateRight(p));
        }
        return (p);
    }
//truoc khi truyen, cay dang can bang, ta can tinh toan sau khi truyen vao thi sao!

    void insert(int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        Node fp, p, q;//fp is a father of node p, q is the node to be inserted.
        Node fs, s; // s is a nearest node before p, which may be unbalanced. fs is a father of s
        //s la cha cua p, fs la cha fp
        fp = null;
        p = root;
        fs = null;
        s = p;
        Node pp; // Node for temporary use

        // Find fp, s and fs. The new node will be the child of fp
        while (p != null) {
            if (p.info == x) {
                System.out.println(" The key " + x + " already exists, no insertion");
                return;
            }
            if (x < p.info) {
                fp = p;
                p = p.left;
            } else {
                fp = p;
                p = p.right;
            }
            if (p != null && p.bal != 0) {
                fs = fp;
                s = p;
            }/*Mark the node s, which may become unbalanced*/
        }
        q = new Node(x);
        if (x < fp.info) {
            fp.left = q;
        } else {
            fp.right = q;
        }
        /* Recalculate balance factors for all nodes from s to the father of q.
       If the new node q is on the left then bal is decreased by 1;if it is
       on the right then bal is increased by 1.
         */
        p = s;
        while (p != q) //tinh toan bac can bang cua p, tuc la cho tro toi phan tu moi duoc chen
        {
            if (x < p.info) {
                p.bal--;
                p = p.left;
            } else {
                p.bal++;
                p = p.right;
            }
        }//end of while(p != q)

        if (Math.abs(s.bal) != 2) { //neu bac cang bang cua s nho hon abs(2) thi can bang
            return;// The sub-tree with root s is still balanced.
        }
        if (s.bal == -2) { //mat cang bang trai, sau khi can bang, pp len lam goc
            pp = leftBal(s);
        } else {
            pp = rightBal(s); //mat can bang phai, sau khi can bang, pp len lam goc
        }

        if (fs == null) { //khi cay chi co dung 1 phan tu la root, ta gan luon pp la root
            root = pp;
            return;
        }
        if (s == fs.right) { //sau khi balance, s khong con la goc, nen ta phai cap nhat lai vi tri goc moi la pp
            // = fs.
            fs.right = pp; //if s was the right son of fs, now pp will be the right son of fs
        } else {
            fs.left = pp; //if s was the left son of fs, now pp will be the left son of fs
        }
    }
//==========================================================================

    void remove(int x) // Delete by copying
    {
        if (root == null) { //cay rong, ko xoa dc
            System.out.println(" The tree is empty, no deletion");
            return;
        }
        Node fp, p; // fp will be the father of p
        Node f, rp, p1;/*rp la nut thay the cho nut p co noi dung x,
		    f la nut cha cua nut thay the rp*/
        MyStack s = new MyStack(); //Last in first out
        p = root;
        fp = null;
        while (p != null) {
            if (p.info == x) {
                break;//Found key x
            }
            if (x < p.info) {
                fp = p;
                s.push(new SNode(fp, -1)); 
                //Snode la node dung de danh dau, chi chua thong tin la bac can bang tai node do
                p = p.left; 
                //vay thi ta co 1 stack de danh dau tree, stack nay danh dau he so can bang cua fp
                //them sang trai, he so fp = -1, cu lien tuc den het
              
            } else {
                fp = p;
                s.push(new SNode(fp, 1));
                p = p.right;
            }
        }
        if (p == null) {
            System.out.println(" The key " + x + " does not exist, no deletion");
            return;
        }
        //tuong tu nhu ben Binary Tree
        if (p.left == null && p.right == null) // p is a leaf node
        {
            if (fp == null) // The tree is one node
            {
                root = null;
            } else {
                if (fp.left == p) {
                    fp.left = null;
                } else {
                    fp.right = null;
                }
            }
        }

        if (p.left != null && p.right == null) // p has only left child
        {
            if (fp == null) // p is a root
            {
                root = p.left;
            } else {
                if (fp.left == p) // p is aleft child ; p co the la con trai hoac con phai cua fp
                {
                    fp.left = p.left;
                } else {
                    fp.right = p.left;
                }
            }
        }

        if (p.left == null && p.right != null) // p has only right child
        {
            if (fp == null) // p is a root
            {
                root = p.right;
            } else {
                if (fp.left == p) // p is aleft child
                {
                    fp.left = p.right;
                } else {
                    fp.right = p.right;
                }
            }
        }

        if (p.left != null && p.right != null) // p has both left and right children
        {//Tim nut thay the, la nut phai nhat cua cay con trai
            s.push(new SNode(p, -1)); // Di ve ben trai de tim nut thay the
            f = p; //f la cha cua rp
            rp = p.left;//Khoi dau chon rp la nut goc cay trai, sau do se
            //di ve phai de tim nut phai nhat
            while (rp.right != null) {
                f = rp; //f la nut cha cua rp
                s.push(new SNode(f, 1));
                rp = rp.right;
            }
            p.info = rp.info;
            //doi noi dung cua p va rp, roi xoa rp
            if (f == p) { //cap nhat lai vi tri node sau khi p bi xoa di, tuc la sau khi ta tim dc node rp
                //la node right most thi ta cho node rp len lam goc, va cho no tro toi con trai chinh la cha cua no la f
                p.left = rp.left;
            } else {
                f.right = rp.left;/*rp la phai nhat, do do khong co con phai
	                 vi khong con rp nen nut cha phai chi den nut sau do*/
            }
        }
        //sau khi xoa, ta can phai can bang lai cay
        //Bat dau can bang cac cay tu dinh Stack, tuc la lan nguoc ve goc
        
        //stack rong, tuc la chi co goc, sau do goc lai bi xoa nen ko lam dc gi ca!
        if (s.isEmpty()) {
            return;
        }
        //khi xoa, chieu cao cay se bi anh huong
        shorter = true;
        SNode t;
        t = (SNode) s.pop(); //bat dau xoa stack, tu node cha cua node vua bi xoa den het
        p = t.p;
        if (t.d == -1) { //thong tin can bang cua p, tuc la node ta vua xoa la cay con trai cua cha node do
            p1 = leftBal2(p); //p1 la goc cua p sau khi cay da can bang
        } else {     //thong tin can bang cua p, tuc la node ta vua xoa la cay con phai cua cha node do
            p1 = rightBal2(p);
        }

        if (s.isEmpty()) { //xoa xong het stack thi chi con moi goc, boi vi node cua cua stack chinh la cua goc mà :)
            //truong hop nay la co 2 node, xoa di 1 node thi chi con moi node goc
            root = p1;
            return; //Da o nut cuoi cung la nut goc
        }
        while (!s.isEmpty()) { //tuc la chua ve den goc dau, tuc la co nhieu hon 2 node
            t = (SNode) s.pop();
            p = t.p;

            if (t.d == -1) { //thong tin can bang cua p, tuc la node ta vua xoa la cay con trai cua cha node do
                p.left = p1;
            } else {
                p.right = p1;
            }
            if (!shorter) { //dieu kien dung o day, neu ko ngan hon dc nua thi break vong lap!
                break;
            } else {
                if (t.d == -1) {
                    p1 = leftBal2(p);
                } else {
                    p1 = rightBal2(p);
                }
            }
            if (s.isEmpty()) {
                root = p1;
                break; //Da o nut cuoi cung la nut goc
            }
        }
    }
//=====================================================
/*Input: Cay goc p co nut bi xoa nam tren cay con trai va chieu cao
	 cua cay con trai bi giam, tuc la shorter = true. Tuy nhien chi so can
	 bang cua p chua duoc tinh lai.
 Xu ly:  Viec chieu cao cay con trai giam anh huong nhu the nao den cay p?
	 neu cay p mat can bang thi can bang lai, tinh lai shorter.
 Output: Cay p da can bang, tham so h cho biet cay co bi giam chieu cao
	 so voi truoc khi xoa nut tren nhanh cay trai khong*/
//Khi goi thu tuc thi shorter=true, chieu cao cua cay con trai giam
    Node leftBal2(Node p) {
        Node p1, p2, pp;
        if (!shorter) { //can bang den khi chieu cao cay ko doi
            return (p);
        }
        pp = null;
        switch (p.bal) {  //ta truyen vao node p de tinh toan lai do can bang cua no
            case -1:/*Cay bi lech trai, chieu cao cay con trai giam 1
	    thi tro thanh can bang, nhung chieu cao cay  p van giam,
	    khong phai can bang cay, nhung tham so shorter tra ve la true,
	    nen qua trinh van tiep tuc*/
                p.bal = 0;
                pp = p;
                break;
            case 0:/*Cay von can bang, chieu cao cay con trai giam 1
	    thi tro thanh lech phai, nhung chieu cao khong giam*/
                p.bal = +1;
                shorter = false;
                pp = p;
                break;
            case +1:/*can bang lai. Cay von lech phai, chieu cao cay con trai
	    giam 1 thi dan den he so can bang nut p la 2*/
                p1 = p.right;
                switch (p1.bal) {
                    case 0://Quay trai nut P
                        //chieu cao cua cay goc p khong bi giam
                        p.bal = +1;
                        p1.bal = -1;
                        shorter = false;
                        pp = rotateLeft(p);
                        break;
                    case +1://Xoay trai nut P
                        //chieu cao cua cay goc p van bi giam
                        p.bal = 0;
                        p1.bal = 0;
                        pp = rotateLeft(p);
                        break;
                    case -1://Phep xoay kep: xoay phai p1, roi xoay trai p
                        p2 = p1.left;
                        switch (p2.bal) {
                            case 0:
                                p.bal = 0;
                                p1.bal = 0;
                                break;
                            case -1:
                                p.bal = 0;
                                p1.bal = +1;
                                break;
                            case +1:
                                p.bal = -1;
                                p1.bal = 0;
                                break;
                        }
                        p2.bal = 0;
                        p.right = rotateRight(p1);
                        pp = rotateLeft(p);
                }
                ;//End of switch(p1.bal)
        };
        return (pp);
    }

    ;//leftBal2
//---------------------------
/*Input: Cay goc p co nut bi xoa nam tren cay con phai va chieu cao
	 cua cay con phai bi giam, tuc la shorter = true. Tuy nhien chi so
	 can bang cua p chua duoc tinh lai.
 Xu ly:  Viec chieu cao cay con phai giam anh huong nhu the nao den cay p?
	 neu cay p mat can bang thi can bang lai, tinh lai shorter.
 Output: Cay p da can bang, tham so shorter cho biet cay co bi giam chieu cao
	 so voi truoc khi xoa nut tren nhanh cay phai khong*/
    Node rightBal2(Node p) {
        Node p1, p2, pp;
        pp = null;
        if (!shorter) {
            return (p);
        }
        switch (p.bal) {
            case +1:/*Cay bi lech phai, chieu cao cay con phai giam 1
	    thi tro thanh can bang, nhung chieu cao cay  p van giam,
	    khong phai can bang cay, nhung tham so shorter tra ve la true,
	    nen qua trinh van tiep tuc*/
                p.bal = 0;
                pp = p;
                break;
            case 0:/*Cay von can bang, chieu cao cay con phai giam 1
	    thi tro thanh lech trai, nhung chieu cao khong giam*/
                p.bal = -1;
                shorter = false;
                pp = p;
                break;
            case -1:/*can bang lai. Cay von lech trai, chieu cao cay con phai
	    giam 1 thi dan den he so can bang nut p la -2*/
                p1 = p.left;
                switch (p1.bal) {
                    case 0://Quay phai nut P
                        //chieu cao cua cay goc p khong bi giam
                        p.bal = -1;
                        p1.bal = +1;
                        shorter = false;
                        pp = rotateRight(p);
                        break;
                    case -1://Xoay phai nut P
                        //chieu cao cua cay goc p van bi giam
                        p.bal = 0;
                        p1.bal = 0;
                        pp = rotateRight(p);
                        break;
                    case +1://Phep xoay kep: xoay trai P1, roi xoay phai P
                        p2 = p1.right;
                        switch (p2.bal) {
                            case 0:
                                p.bal = 0;
                                p1.bal = 0;
                                break;
                            case -1:
                                p.bal = 1;
                                p1.bal = 0;
                                break;
                            case +1:
                                p.bal = 0;
                                p1.bal = -1;
                                break;
                        }
                        p2.bal = 0;
                        p.left = rotateLeft(p1);
                        pp = rotateRight(p);
                }
                ;//End of switch(p1.bal)
        };
        return (pp);
    }

    ;//rightBal2
//=====================================================
    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print("  " + p.info + "(" + p.bal + ")");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void addArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insert(new Integer(a[i]));
        }
    }

}
