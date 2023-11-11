public class DLL{
    int size;
    Node head, tail;

    //------(Node)--------
    private class Node{
        Node next, prev;
        int data;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
            size++;
        }

    }
    //--------------------

    public void addF(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
            tail = n;
            return;
        }
        n.next = head;
        head.prev = n;
        head = n;


    }

    public void addL(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
            tail = n;
            return;
        }
        tail.next = n;
        n.prev = tail;
        tail = n;
    }

    public void addAtRandom(int index, int data){
        if(index > size || index < 0){
            System.out.println("Invalid Index number...");
            return;
        }
        if(index == 0){
            addF(data);
            return;
        }
        if (index == size-1){
            addL(data);
        }
        Node n = new Node(data);
        Node cn = head;
        for(int i = 1; i<index; i++){
            cn = cn.next;
        }
        Node sn = cn.next;
        cn.next = n;
        n.prev = cn;
        n.next = sn;
        sn.prev = n;

    }

    public void removeF(){
        if(head == null ){
            System.out.println("List is Empty");
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeL(){
        if(head == null ){
            System.out.println("List is Empty");
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public void printL(){
        Node cn = head;
        System.out.print("[ ");
        while(cn != null){
            System.out.print(cn.data+" <-> ");
            cn = cn.next;
        }
        System.out.print("null ]\n");
    }

    public void removeAtRandom(int index){
        if(index > size || index < 0){
            System.out.println("Invalid Index number...");
            return;
        }
        if(index == 0){
            removeF();
            return;
        }
        if(index == size - 1){
            removeL();
            return;
        }
        Node cn = head;
        for (int i = 1; i<index; i++){
            cn = cn.next;
        }
        cn.next = cn.next.next;
        cn.next.prev = cn;
        size--;

    }

    public int getSize(){
        return size;
    }

    public void search(int data){
        Node cn = head;
        int count = 0;
        while(cn != null){
            if(cn.data == data){
                System.out.println("The index of "+data+" is: "+count);
                return;
            }
            count++;
            cn = cn.next;
        }
        System.out.println("Not Found");
    }




    public static void main(String[] args ){
        System.out.println("Hey! this is Double LinkedList");
        DLL l1 = new DLL();
        l1.addL(32);
        l1.addL(12);
        l1.addL(92);
        l1.addF(11);
        l1.addF(10);
        l1.addF(9);

        l1.printL();
        System.out.println(l1.getSize());

        System.out.println("--------------------------------");
        l1.addAtRandom(2,999);


        l1.printL();
        System.out.println(l1.getSize());
        System.out.println("--------------------------------");

        l1.removeF();

        l1.printL();
        System.out.println(l1.getSize());
        System.out.println("--------------------------------");

        l1.removeL();

        l1.printL();
        System.out.println(l1.getSize());
        System.out.println("--------------------------------");

        l1.removeAtRandom(2);

        l1.printL();
        System.out.println(l1.getSize());
        System.out.println("--------------------------------");

        l1.search(999);

        l1.printL();
        System.out.println(l1.getSize());

        System.out.println("--------------------------------");

    }
}
