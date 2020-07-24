public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int r_factor = 2;
    private int f_index;
    private int l_index;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        f_index = items.length / 2;
        l_index = f_index + 1;
    }

    private void addResize(int capacity) {
        T a[] = (T[]) new Object[capacity];

        if (f_index < l_index && items[0] == null) {
            System.arraycopy(items, 0, a, capacity - size, size);
        }
        if (f_index < l_index && items[items.length - 1] == null) {
            System.arraycopy(items, 0, a, 0, size);
        }
        else {
            System.arraycopy(items, 0, a, 0, l_index);
            int New_f_index = size * (r_factor - 1) + f_index - 1;
            System.arraycopy(items, f_index, a, New_f_index,(capacity - New_f_index));
            f_index = New_f_index;
        }

        items = a;
    }

    public void addFirst(T item) {
        if (size == items.length - 1) {
            addResize((int)(size * r_factor));
        }

        items[f_index] = item;
        f_index -= 1;

        if (f_index < 0) {
            f_index = items.length - 1;
        }

        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length - 1) {
            addResize((int)(size * r_factor));
        }

        items[l_index] = item;
        l_index += 1;

        if (l_index > items.length - 1) {
            l_index = 0;
        }

        size += 1;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        int PIndex = f_index + 1;
        while(true){
            if (PIndex == l_index) {
                break;
            }
            System.out.print(items[PIndex] + " ");
            PIndex += 1;

            if (PIndex > items.length - 1) {
                PIndex = 0;
            }
        }
    }

    public int size() {
        return size;
    }


    private void removeResize(int capacity) {
        T a[] = (T[]) new Object[capacity];
        if (f_index > l_index) {
            System.arraycopy(items, f_index, a, 0, size + 1);
        }
        else {
            System.arraycopy(items, f_index, a, 0, items.length - f_index - 1);
            System.arraycopy(items, 0, a, items.length - f_index - 1, l_index);
        }
        items = a;
    }


    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T item = items[f_index + 1];
        f_index += 1;
        size -= 1;

        if ( items.length > 16 && size < (int)(items.length * 0.25)) {
            removeResize(size * r_factor);
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T item = items[l_index - 1];
        f_index += 1;
        size -= 1;
        return item;
    }

    public  T get(int index) {
        int PIndex = f_index + 1 + index;
        if (PIndex >= items.length) {
            PIndex = PIndex - items.length - 1;
        }

        if (PIndex > l_index - 1) {
            return null;
        }
        else {
            return items[PIndex];
        }
    }

}
