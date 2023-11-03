public class LL{
    Node head;
    int size;
    //-------------------------
    class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }
    //-------------------------

    public void addFirst(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }else {
            n.next = head;
            head = n;
        }
    }

    public void addLast(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
            return;
        }

        Node  cn = head;
        while(cn.next != null){
            cn = cn.next;
        }
        cn.next = n;
    }

    public void addAtRandom(int index, int data){
        if(index < 0 || index > size){
            System.out.println("Invalid index number");
            return;
        }
        Node n = new Node(data); //it will change size
        if(index == 0){
            n.next = head;
            head = n;
            return;
        }

        Node cn = head;
        for(int i=1; i < size; i++){
            if(i == index){
                Node nn = cn.next;
                cn.next = n;
                n.next = nn;
                break;
            }
            cn = cn.next;
        }
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("List is Empty, nothing to remove");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast(){
        if(head == null){
            System.out.println("List is Empty, nothing to remove");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }
        Node cn = head;         //cn means currentNode
        Node ln = head.next;    //ln means lastNode

        while(ln.next != null){
            cn = cn.next;
            ln = ln.next;
        }
        cn.next = null;
    }

    public void removeAtRandom(int index){
        if(index > size || index < 0){
            System.out.println("Invalid index number.");
            return;
        }

        size--;
        if(index == 0 ){
            removeFirst();
            return;
        }

        Node cn = head;
        for(int i=1; i < index; i++){
            cn = cn.next;
        }
        cn.next = cn.next.next;
    }


    public void printList(){
        Node cn = head;
        System.out.print("[ ");
        while(cn != null){
            System.out.print(cn.data+" -> ");
            cn = cn.next;
        }
        System.out.print("null ]\n");
    }

    public void search(int data){
        int i = 0;
        Node cn = head;
        while(cn != null){
            if(cn.data == data){
                System.out.println("Index of "+cn.data+" is "+i);
                return;
            }
            cn = cn.next;
            i++;
        }
        System.out.println("Not Found");

    }



    public int getSize(){
        return size;
    }

    public static void main(String[] args){
        System.out.println("Linked List");
        LL l1 = new LL();
        l1.addLast(242);
        l1.addLast(399);
        l1.addLast(121);
        l1.addLast(222);
        l1.addLast(2122);
        l1.addLast(222);
        System.out.println(l1.getSize());
        l1.printList();
        l1.removeAtRandom(4);
        l1.printList();

    }
}








