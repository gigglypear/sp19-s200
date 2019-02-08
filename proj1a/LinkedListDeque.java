public class LinkedListDeque<T> {
    public class Node {
        public T x;
        public Node next;
        public Node prev;

        public Node(Node p, T i, Node n) {
            prev = p;
            x = i;
            next = n;
        }

    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new Node(null, null, null);
        Node newNode = new Node (sentinel, item, sentinel);
        sentinel.next = newNode;
        sentinel.prev = newNode;
        size = 1;
    }

    //@source: https://www.youtube.com/watch?v=JNroRiEG7U4
    //
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i ++) {
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T item) {
        size ++;
        Node firstNode = sentinel.next;
        Node temp = new Node(sentinel, item, firstNode);
        firstNode.prev = temp;
        sentinel.next = temp;
    }


    public void addLast(T item) {
        size ++;
        Node lastNode = sentinel.prev;
        Node temp = new Node(lastNode, item, sentinel);
        sentinel.prev = temp;
        lastNode.next = temp;
    }


    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
   }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p.x != null){
            System.out.print(p.x + " ");
            p = p.next;
        }
    }

    public T removeFirst() {
        Node removedNode = sentinel.next;
        if (removedNode.x == null) {
            return null;
        }
        size --;
        T removed = removedNode.x;
        Node newFirst = removedNode.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;
        return removed;

    }

    public T removeLast() {
        Node removedNode = sentinel.prev;
        if (removedNode.x == null) {
            return null;
        }
        size --;
        T removed = removedNode.x;
        Node newLast = removedNode.prev;
        sentinel.prev = newLast;
        newLast.next = sentinel;
        return removed;

    }

    public T get(int index) {
        if (index == 0) {
            return sentinel.next.x;
        }
        if (index >= size) {
            return null;
        }
        Node curr = sentinel.next.next;
        int i = 0;
        while (i < index && curr.next != null) {
            i ++;
            curr = curr.next;
        }

        return curr.x;

    }

    public T getRecursive(int index) {
        if (index == 0) {
            return sentinel.next.x;
        }
        Node curr = sentinel.next.next;
        if (curr.next == null || index == 0) {
            return curr.x;
        }
        else {
           index --;
           return getRecursive(index);
        }
    }
}