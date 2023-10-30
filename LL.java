
public class LL {
    private int size;
    private Node head;

    //Node
    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    public void addLast(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }else{
            Node lastN = head; //nn means new node
            while(lastN.next != null){
                lastN = lastN.next;
            }
            lastN.next = n;

        }
    }

    public void addInMiddle(int index, int data){
        if(index > size || index < 0){
            System.out.println("Invalid index value");
            return;
        }
        Node n = new Node(data);

        if (head == null || index == 0 ){
            n.next = head;
            head = n;
            return;
        }

        Node cn = head;
        for(int i=1; i<size; i++){
            if(i == index){
                Node nextN = cn.next;
                cn.next = n;
                n.next = nextN;
                break;
            }
            cn = cn.next;
        }

    }

    public void removeFirst(){
        if(head == null){
            System.out.println("Empty list, Nothing to delete");
            return;
        }
        head = head.next;
        size--;
    }

    public void removeLast(){
        if(head == null){
            System.out.println("Empty list, Nothing to delete");
            return;
        }
        size--;
        if(head.next == null){
            head = null;
            return;
        }

        Node cn = head;
        Node lastN = head.next;
        while(lastN.next != null){
            cn = cn.next;
            lastN = lastN.next;
        }
        cn.next = null;
    }

    public void removeAtRandom(int index){
        if(index > size || index < 0){
            System.out.println("Invalid index number");
        }
        else if(index == 0){
            removeFirst();
        }
        else{
            // Regular case: Traverse the list to the node before the one to be removed
            Node cn = head;
            int count = 0;
            while (cn != null && count < index - 1) {
                cn = cn.next;
                count++;
            }

            // Remove the node by updating references
            cn.next = cn.next.next;
            size--;
        }
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

    public void printList(){
        Node cn = head;
        System.out.print("[ ");
        while(cn != null){
            System.out.print(cn.data+" -> ");
            cn = cn.next;
        }
        System.out.print("null ]\n");
    }

    public int getSize(){
        return (size);
    }

    public int get(int index){
        Node n = head;
        int count= 0;

        while(n != null){
            if(index == count){
                return n.data;
            }
            n = n.next;
            count++;
        }
        return 0;
    }





    public static void main(String[] args) {

        LL l1 = new LL();
        l1.addFirst(4);
        l1.addLast(7);
        l1.addLast(74);
        l1.addLast(4);
        l1.addLast(37);
        System.out.println(l1.getSize());
        l1.printList();
        l1.removeAtRandom(5);
        System.out.println(l1.getSize());
        l1.printList();
    }
}