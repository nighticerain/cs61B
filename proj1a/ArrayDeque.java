import com.sun.deploy.security.CredentialManager;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int RFactor = 2;
    private int FIndex;
    private int LIndex;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        FIndex = items.length / 2;
        LIndex = FIndex + 1;
    }

    private void addResize(int capacity) {
        T a[] = (T[]) new Object[capacity];

        if(FIndex < LIndex && items[0] == null) {
            System.arraycopy(items, 0, a, capacity - size, size);
        }
        if(FIndex < LIndex && items[items.length - 1] == null) {
            System.arraycopy(items, 0, a, 0, size);
        }
        else {
            System.arraycopy(items, 0, a, 0, LIndex);
            int NewFIndex = size * (RFactor - 1) + FIndex - 1;
            System.arraycopy(items, FIndex, a, NewFIndex,(capacity - NewFIndex));
            FIndex = NewFIndex;
        }

        items = a;
    }

    public void addFirst(T item) {
        if(size == items.length - 1) {
            addResize((int)(size * RFactor));
        }

        items[FIndex] = item;
        FIndex -= 1;

        if(FIndex < 0) {
            FIndex = items.length - 1;
        }

        size += 1;
    }

    public void addLast(T item) {
        if(size == items.length - 1) {
            addResize((int)(size * RFactor));
        }

        items[LIndex] = item;
        LIndex += 1;

        if(LIndex > items.length - 1) {
            LIndex = 0;
        }

        size += 1;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        int PIndex = FIndex + 1;
        while(true){
            if(PIndex == LIndex) {
                break;
            }
            System.out.print(items[PIndex] + " ");
            PIndex += 1;

            if(PIndex > items.length - 1) {
                PIndex = 0;
            }
        }
    }

    public int size() {
        return size;
    }


    private void removeResize(int capacity) {
        T a[] = (T[]) new Object[capacity];
        if(FIndex > LIndex) {
            System.arraycopy(items, FIndex, a, 0, size + 1);
        }
        else {
            System.arraycopy(items, FIndex, a, 0, items.length - FIndex - 1);
            System.arraycopy(items, 0, a, items.length - FIndex - 1, LIndex);
        }
        items = a;
    }


    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T item = items[FIndex + 1];
        FIndex += 1;
        size -= 1;

        if( items.length > 16 && size < (int)(items.length * 0.25)) {
            removeResize(size * RFactor);
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T item = items[LIndex - 1];
        FIndex += 1;
        size -= 1;
        return item;
    }

    public  T get(int index) {
        int PIndex = FIndex + 1 + index;
        if(PIndex >= items.length) {
            PIndex = PIndex - items.length - 1;
        }

        if(PIndex > LIndex - 1) {
            return null;
        }
        else {
            return items[PIndex];
        }
    }

}
