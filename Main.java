import java.util.Scanner;
// circular queue
class CQueue {
    static int[] arr;
    static int size;
    static int front = -1;
    static int rear = -1;

    CQueue(int size) {
        this.size = size;
        arr = new int[size];
    }

    public static boolean isEmpty() {
        return rear == -1 && front == -1;
    }

    public static boolean isFull() {
        return (rear + 1) % size == front;
    }

    public void add(int data) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
        //if it's the 1st element
        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }
        int res = arr[front];

        //if only 1 element is present
        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }

        return res;
    }
    public void print() {
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        } else {
            System.out.println("Circular queue:");
            int tempFront = front;
            do {
                System.out.println(arr[tempFront]);
                tempFront = (tempFront + 1) % size;
            } while (tempFront != (rear + 1) % size);
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("empty queue");
            return -1;
        }

        return arr[front];
    }
}
// queue with deque
class Deque {
    int [] arr;
    int size;
    int front;
    int rear;

    Deque(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    public void addFront(int data) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1;
        } else {
            front--;
        }

        arr[front] = data;
    }

    public void addRear(int data) {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }

        if (front == -1) {
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0;
        } else {
            rear++;
        }

        arr[rear] = data;
    }

    public int removeFront() {
        if (isEmpty()) {
            System.out.println("Empty deque");
            return -1;
        }

        int res = arr[front];

        if (front == rear) {
            front = rear = -1;
        } else {
            if (front == size - 1) {
                front = 0;
            } else {
                front++;
            }
        }

        return res;
    }

    public int removeRear() {
        if (isEmpty()) {
            System.out.println("Empty deque");
            return -1;
        }

        int res = arr[rear];

        if (front == rear) {
            front = rear = -1;
        } else {
            if (rear == 0) {
                rear = size - 1;
            } else {
                rear--;
            }
        }

        return res;
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Empty deque");
            return -1;
        }

        return arr[front];
    }

    public int peekRear() {
        if (isEmpty() || rear < 0) {
            System.out.println("Empty deque");
            return -1;
        }

        return arr[rear];
    }
    public void print() {
        if (!isEmpty()) {
            System.out.println("List is here :");
            int i = front;
            do {
                System.out.println(arr[i]);
                i = (i + 1) % size;
            } while (i != (rear + 1) % size);
        } else {
            System.out.println("Deque is empty");
        }
    }
}
//queue using Linked List
class QueueLL {
    Node front = null;
    Node rear = null;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1;
        }
        int fvalue = front.data;
        //single node
        if (front == rear) {
            rear = null;
        }
        front = front.next;
        return fvalue;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return front.data;
    }

    public void print(){
        Node cn = front;
        System.out.print("{ ");
        while(cn != null){
            System.out.print(cn.data+" -- ");
            cn = cn.next;
        }
        System.out.print("}\n");
    }
}

//Queue using Array
class QueueArr{
    int  rear, size;
    int[] arr;


    QueueArr(int size){
        this.size =size;
        arr = new int[size];
        rear = -1;
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public boolean isFull(){
        return rear == size-1;
    }

    public void enque(int val){

        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }

        arr[++rear] = val;
    }

    public int deque(){
        if(isEmpty()){
            return -1;
        }

        int f = arr[0];

        for (int i=0; i<rear; i++){
            arr[i] = arr[i+1];
        }
        rear--;
        return f;

    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        else{
            return arr[0];
        }
    }

    public void print(){
        for (int i=0; i<=rear; i++){
            System.out.print(arr[i]+" -- ");
        }
        System.out.println("\nFront: "+arr[0]);
        System.out.println("Rear: "+arr[rear]);
    }

    public int getSize(){
        return size;
    }

}
//stack using LL
class StackLL{
    Node head;
    //-----(NODE)------
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //------------------
    public void push(int data){
        Node n = new Node(data);
        if(head == null){
            head = n;
        }else{
            n.next = head;
            head = n;
        }
    }

    public int pop(){
        if(head == null){
            System.out.println("Stack is Empty. Cannot pop");
            return -1;
        } else{
            Node sn = head;
            head = head.next;
            return sn.data;
        }
    }

    public int peek(){
        if(head == null){
            System.out.println("Stack is Empty. Cannot peek");
            return -1;
        }else{
            return head.data;
        }
    }

    public void printStack(){
        if(head == null){
            System.out.println("Stack is Empty. Cannot Print");
        }else {
            Node cn = head;

            while(cn != null){
                System.out.print(cn.data+" -> ");
                cn = cn.next;
            }
            System.out.print("\n");
        }
    }

}



//stack using array
class StackAr{ //StackAr means Stack using Array
    int top, maxSize;
    int[] stackArr;

    StackAr(int maxSize){
        this.maxSize = maxSize;
        stackArr = new int[maxSize];
        top = -1;
    }

    public void push(int val){
        if(top < maxSize-1){
            stackArr[++top] = val;
        }else{
            System.out.println("Stack is Full. Cannot push");
        }
    }

    public int pop(){
        if(top == -1){
            System.out.println("stack is empty. Cannot pop");
            return -1;
        }else{
            return stackArr[top--];
        }
    }

    public int peek(){
        if(top == -1){
            System.out.println("stack is empty. Cannot peek");
            return -1;
        }else{
            return stackArr[top];
        }
    }

    public void print(){
        if (top == -1){
            System.out.println("Stack is Empty");
        }else{
            System.out.println("index, data");
            for (int i = top; i>=0; i++){
                System.out.println(i +", "+stackArr[i]);
            }
        }
    }
}

class DLL{
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


    public void printL(){
        Node cn = head;
        System.out.print("[ ");
        while(cn != null){
            System.out.print(cn.data+" <-> ");
            cn = cn.next;
        }
        System.out.print("null ]\n");
    }

}

class LL{
    Node head;
    int size;
    //--------(NODE)-----------
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

        if(index == 0 ){
            removeFirst();
            return;
        }
        size--;
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
}



public class Main {
    public static void main(String[] args) {
        mainMenu();
    }

    //******************
    // custom functions used in main

    //mainmenu
    public static void mainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello ! Welcome to My assignment ");
        System.out.println("1. LinkedLists\n2. Stack\n3. Queue");
        System.out.print("---Enter: ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("1. Single LinkedList\n2. Doubly LinkedList");
                System.out.print("---Enter: ");
                int c1 = sc.nextInt();
                if(c1 == 1){
                    singlyLLmenu();

                } else if (c1 == 2) {
                    doublyLLmenu();
                }else{
                    System.out.println("Invalid choice");
                    System.out.println("Thank you for using this program");
                }
                break;
            case 2:
                System.out.println("1. Stack using Array\n2. Stack using LinkedList");
                System.out.print("---Enter: ");
                int c2 = sc.nextInt();
                if(c2 == 1){
                    System.out.print("Enter the size of Stack: ");
                    int s = sc.nextInt();
                    stackusingArrmenu(s);
                } else if (c2 == 2) {
                    stackusingLLmenu();
                }else{
                    System.out.println("Invalid choice");
                    System.out.println("Thank you for using this program");
                }
                break;
            case 3:
                System.out.println("1. Queue using Array\n2. Queue using LinkedList" );
                System.out.print("---Enter: ");
                int c3 = sc.nextInt();
                if(c3 == 1){
                    System.out.println("1. Simple Queue\n2. Circular Queue\n3. Dequeue");
                    System.out.print("---Enter: ");
                    int l = sc.nextInt();
                    if (l == 1){
                        queueUsingArrMenu(sc);
                    } else if (l == 2) {
                        CQueue(sc);
                    } else if (l == 3) {
                        deeqemenu(sc);
                    }else {
                        System.out.println("Invalid choice");
                    }
                } else if (c3 == 2) {
                    queueUsingLLMenu(sc);
                } else{
                    System.out.println("Invalid choice");
                }
                break;
            default:
                System.out.println("Invalid choice");
                System.out.println("Thank you for using this program");
        }
    }
    //1
    static void singlyLLmenu(){
        LL l1 = new LL();
        System.out.println("Singly Linked successfully created");
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. Insert\n2. Delete\n3. Search\n4. Print\n5. Back to Main Menu");
            System.out.print("---Enter: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("1. Insert At First\n2. Insert At Last\n3. Insert At Random Location");
                    System.out.print("---Enter: ");
                    int c1 = sc.nextInt();
                    if (c1 == 1){
                        System.out.print("Enter data for add in first: ");
                        int d = sc.nextInt();
                        l1.addFirst(d);
                    } else if (c1 == 2) {
                        System.out.print("Enter data for add in last: ");
                        int d = sc.nextInt();
                        l1.addLast(d);
                    } else if (c1 == 3) {
                        System.out.print("Enter data for add At Random: ");
                        int d = sc.nextInt();
                        System.out.print("Enter index of "+d+" :");
                        int i = sc.nextInt();
                        l1.addAtRandom(i,d);
                    }else {
                        System.out.println("Invalid choice");
                        System.out.println("Thank you for using this program");
                    }
                    break;
                case 2:
                    System.out.println("1. Delete First\n2. Delete Last\n3. Delete At Random Location");
                    System.out.print("---Enter: ");
                    int c2 = sc.nextInt();
                    if (c2 == 1){
                        l1.removeFirst();
                    } else if (c2 == 2) {
                        l1.removeLast();
                    } else if (c2 == 3) {
                        System.out.print("Enter index which you want to delete: ");
                        int i = sc.nextInt();
                        l1.removeAtRandom(i);
                    }else {
                        System.out.println("Invalid choice");
                        System.out.println("Thank you for using this program");
                    }
                    break;
                case 3:
                    System.out.println("Enter Data for Search: ");
                    int d = sc.nextInt();
                    l1.search(d);
                    break;
                case 4:
                    l1.printList();
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
                    System.out.println("Thank you for using this program");
                    break;
            }
        }

    }

    //2
    static void doublyLLmenu(){
        DLL d1 = new DLL();
        System.out.println("Doubly LinkedList successfully created...");
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. Insert\n2. Print\3.Back to Main Menu");
            System.out.print("---Enter: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter data for insert: ");
                    int d = sc.nextInt();
                    d1.addL(d);
                    break;
                case 2:
                    d1.printL();
                    break;
                case 3:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }


    //3
    static void stackusingArrmenu(int s){
        StackAr s1 = new StackAr(s);
        System.out.println("Stack using Array is successfully created");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Print\n5. Back to Main Menu");
            System.out.print("---Enter: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Enter data for push: ");
                    int d = sc.nextInt();
                    s1.push(d);
                    break;
                case 2:
                    System.out.println("1. Pop with Print\n2. Pop");
                    System.out.print("---Enter: ");
                    int c2 = sc.nextInt();
                    if(c2 == 1){
                        System.out.println(s1.pop());
                    } else if (c2 == 2) {
                        s1.pop();
                    }else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.println(s1.peek());
                    break;
                case 4:
                    s1.print();
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    //4
    static void stackusingLLmenu() {
        StackLL s1 = new StackLL();
        System.out.println("Stack using LL is successfully created...");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Push\n2. Pop\n3. Peek\n4. Print\n5. Back to Main Menu");
            System.out.print("---Enter: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data for push: ");
                    int d = sc.nextInt();
                    s1.push(d);
                    break;
                case 2:
                    System.out.println("1. Pop with Print\n2. Pop");
                    System.out.print("---Enter: ");
                    int c2 = sc.nextInt();
                    if (c2 == 1) {
                        System.out.println(s1.pop());
                    } else if (c2 == 2) {
                        s1.pop();
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.println(s1.peek());
                    break;
                case 4:
                    s1.printStack();
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    //dfd
    static void queueUsingArrMenu(Scanner sc){
        System.out.print("Enter size of Queue: ");
        int s = sc.nextInt();
        QueueArr q1 = new QueueArr(s);
        System.out.println("Queue is successfully created..");

        while(true){
            System.out.println("1. Enqueue\n2. Dequeue\n3. Peek\n4. Print\n5. Back to Main Menu");
            System.out.print("---Enter: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data for Enqueue: ");
                    int d = sc.nextInt();
                    q1.enque(d);
                    break;
                case 2:
                    System.out.println("1. Deque with Print\n2. Deque");
                    System.out.print("---Enter: ");
                    int c2 = sc.nextInt();
                    if (c2 == 1) {
                        System.out.println("Dequeued :"+q1.deque());
                    } else if (c2 == 2) {
                        q1.deque();
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.println("Peek: "+q1.peek());
                    break;
                case 4:
                    q1.print();
                    break;
                case 5:
                    mainMenu();
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    //queueUsingArrMenu(sc);
    public static void queueUsingLLMenu(Scanner sc){
        QueueLL q1 = new QueueLL();
        System.out.println("Queue using LL is successfully created..");

        while(true){
            System.out.println("1. Add\n2. Remove\n3. Peek\n4. Print\n5. Back to Main Menu");
            System.out.print("----Enter: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data for Enqueue: ");
                    int d = sc.nextInt();
                    q1.add(d);
                    break;
                case 2:
                    System.out.println("1. Deque with Print\n2. Deque");
                    System.out.print("----Enter: ");
                    int c2 = sc.nextInt();
                    if (c2 == 1) {
                        System.out.println("Dequeued :"+q1.remove());
                    } else if (c2 == 2) {
                        q1.remove();
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.println("Peek: "+q1.peek());
                    break;
                case 4:
                    q1.print();
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

    }
    static void deeqemenu(Scanner sc){
        System.out.print("Enter size of Queue: ");
        int x = sc.nextInt();
        Deque q2  = new Deque (x);
        System.out.println("Queue is successfully created..");

        while(true){
            System.out.println("1.Add front \n2.Add rear\n3.Remove front \n4.Remove rear \n5.Peak front \n6.Peak rear \n7.Print queue\n8. Back to Main Menu");
            System.out.print("----Enter: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter data for add in front : ");
                    int g = sc.nextInt();
                    q2.addFront(g);
                    break;
                case 2:
                    System.out.println(" Enter data to add in rear ");
                    int g1 = sc.nextInt();
                    q2.addRear(g1);
                    break;
                case 3:
                    System.out.println("Remove the front ");
                    q2.removeFront();
                    break;
                case 4:
                    System.out.println("Remove the rear  ");
                    q2.removeRear();
                    break;
                case 5:
                    System.out.println(" Peak the first ");
                    int g2 = sc.nextInt();
                    q2.peekFront();
                case 6:
                    System.out.println(" Peak the last  ");
                    int g3 = sc.nextInt();
                    q2.peekRear();
                case 7 :
                    q2.print();
                case 8:
                    mainMenu();
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }

    static void CQueue(Scanner sc){
        System.out.print("Enter size of Queue: ");
        int y = sc.nextInt();
        CQueue q3  = new CQueue (y);
        System.out.println("Queue is successfully created..");

        while(true){
            System.out.println("1.Add in Queue \n2.Remove in queue \n3.Peek  \n4.Print \n5. Back to Main Menu ");
            System.out.print("--Enter: ");
            int cho= sc.nextInt();
            switch (cho) {
                case 1:
                    System.out.print("Enter data for addition : ");
                    int h = sc.nextInt();
                    q3.add(h);
                    break;
                case 2:
                    System.out.println(" Remove from Queue ");
                    q3.remove();
                    break;
                case 3:
                    System.out.println("Peek Function  ");
                    q3.peek();
                    break;
                case 4:
                    System.out.println("Print the queue ");
                    q3.print();
                    break;
                case 5:
                    mainMenu();
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
}
