public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int rFactor = 2;
    private int fIndex;
    private int lIndex;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        fIndex = items.length / 2;
        lIndex = fIndex + 1;
    }

    private void addResize(int capacity) {
        T[] a = (T[]) new Object[capacity];

        if (fIndex < lIndex && items[0] == null) {
            System.arraycopy(items, 0, a, capacity - size, size);
        } else if (fIndex < lIndex && items[items.length - 1] == null) {
            System.arraycopy(items, 0, a, 0, size);
        } else {
            System.arraycopy(items, 0, a, 0, lIndex);
            int newIndex = size * (rFactor - 1) + fIndex - 1;
            System.arraycopy(items, fIndex, a, newIndex, (capacity - newIndex));
            fIndex = newIndex;
        }

        items = a;
    }

    public void addFirst(T item) {
        if (size == items.length - 1) {
            addResize((int) (size * rFactor));
        }

        items[fIndex] = item;
        fIndex -= 1;

        if (fIndex < 0) {
            fIndex = items.length - 1;
        }

        size += 1;
    }

    public void addLast(T item) {
        if (size == items.length - 1) {
            addResize((int) (size * rFactor));
        }

        items[lIndex] = item;
        lIndex += 1;

        if (lIndex > items.length - 1) {
            lIndex = 0;
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
        int pIndex = fIndex + 1;
        while (true) {
            if (pIndex == lIndex) {
                break;
            }
            System.out.print(items[pIndex] + " ");
            pIndex += 1;

            if (pIndex > items.length - 1) {
                pIndex = 0;
            }
        }
    }

    public int size() {
        return size;
    }


    private void removeResize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        if (fIndex > lIndex) {
            System.arraycopy(items, fIndex, a, 0, size + 1);
        } else {
            System.arraycopy(items, fIndex, a, 0, items.length - fIndex - 1);
            System.arraycopy(items, 0, a, items.length - fIndex - 1, lIndex);
        }
        items = a;
    }


    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        if (fIndex > items.length - 2) {
            fIndex = -1;
        }

        T item = items[fIndex + 1];
        items[fIndex + 1] = null;
        fIndex += 1;
        size -= 1;

        if (items.length > 16 && size < (int) (items.length * 0.25)) {
            removeResize(size * rFactor);
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T item = items[lIndex - 1];
        items[lIndex - 1] = null;
        lIndex -= 1;
        size -= 1;

        if (lIndex < 1) {
            lIndex = items.length;
        }

        return item;
    }

    public T get(int index) {
        int pIndex = fIndex + 1 + index;
        if (pIndex > items.length - 1) {
            pIndex = pIndex - items.length;
            if (pIndex > lIndex - 1) {
                return null;
            } else {
                return items[pIndex];
            }
        } else {
            return items[pIndex];
        }
    }
}


