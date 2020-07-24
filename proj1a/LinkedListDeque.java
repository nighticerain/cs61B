public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;

    private class TNode {
        public TNode prev;
        public TNode next;
        public T item;
        public TNode(TNode p, TNode n, T i) {
            prev = p;
            next = n;
            item = i;
        }
    }

    /* Create an empty Deque */
    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        TNode NewTNode = new TNode(null, null, item);
        NewTNode.next = sentinel.next;
        NewTNode.prev = sentinel;
        sentinel.next.prev = NewTNode;
        sentinel.next = NewTNode;
        size += 1;
    }

    public void addLast(T item) {
        TNode NewTNode = new TNode(null, null, item);
        NewTNode.prev = sentinel.prev;
        NewTNode.next = sentinel;
        sentinel.prev.next = NewTNode;
        sentinel.prev = NewTNode;
        size += 1;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        /*
        else if(sentinel.next == sentinel) {
            return true;
        }
        */
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if(isEmpty()) {
            System.out.println("Deque is empty");
        }
        else {
            TNode p = sentinel;
            while(p.next != sentinel){
                System.out.print(p.next.item + " ");
                p = p.next;
            }
        }
    }

    public T removeFirst() {
        if(sentinel.next == null || sentinel.next == sentinel) {
            return null;
        }
        else {
            TNode first = sentinel.next;
            first.next.prev = sentinel;
            sentinel.next = first.next;
            first.prev = null;
            first.next = null;
            size -= 1;
            return first.item;
        }
    }

    public T removeLast() {
        if(sentinel.prev == null || sentinel.prev == sentinel) {
            return  null;
        }
        else {
            TNode first = sentinel.next;
            first.next.prev = sentinel;
            sentinel.next = first.next;
            first.prev = null;
            first.next = null;
            size -= 1;
            return first.item;
        }
    }

    public T get(int index) {
        int i = 0;
        TNode p = sentinel;

        while(p.next != sentinel) {
            if(i == index) {
                return p.next.item;
            }
            p = p.next;
            i += 1;
        }
        return null;
    }

    public T getRecursive(int index) {
        if(index > size - 1) {
            return null;
        }
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, TNode p) {
        if (index == 0) {
            return p.item;
        }
        else{
            return getRecursive(index - 1, p.next);
        }
    }
}