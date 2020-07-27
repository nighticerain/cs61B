public class ArrayDequeTest {
    public static void arrayTest() {
        System.out.println("ArrayDeque1");
        ArrayDeque testDeque1 = new ArrayDeque();
        testDeque1.addFirst(1);
        testDeque1.addLast('a');
        testDeque1.addLast('b');
        testDeque1.addLast('c');
        for (int i = 0; i <= 8; i++) {
            testDeque1.addLast(i);
        }
        testDeque1.printDeque();
        System.out.println("");

        System.out.println("ArrayDeque2");
        ArrayDeque testDeque2 = new ArrayDeque();
        testDeque2.addFirst(1);
        testDeque2.addLast('a');
        testDeque2.addLast('b');
        testDeque2.addLast('c');
        for (int i = 0; i <= 8; i++) {
            testDeque2.addFirst(i);
        }
        testDeque2.printDeque();
        System.out.println("");

        System.out.println("ArrayDeque3");
        ArrayDeque testDeque3 = new ArrayDeque();
        testDeque3.addFirst(1);
        testDeque3.addLast('a');
        testDeque3.addLast('b');
        for (int i = 0; i <= 8; i++) {
            testDeque3.addFirst(i);
        }
        testDeque3.addLast('c');
        testDeque3.printDeque();
        System.out.println("");

    }

    public static void getTest() {
        ArrayDeque testDeque = new ArrayDeque();
        for (int i = 0; i <= 8; i++) {
            testDeque.addLast(i);
        }
        testDeque.printDeque();
        System.out.println();
        System.out.println(testDeque.get(0));
        System.out.println(testDeque.get(7));
    }

    public  static void removeTest() {
        ArrayDeque testDeque = new ArrayDeque();
        for (int i = 0; i <= 8; i++) {
            testDeque.addLast(i);
        }
        testDeque.printDeque();
        System.out.println();

        for (int i = 0; i <= 8; i++) {
            System.out.println(testDeque.removeLast());
        }
    }

    public static void removeResize() {
        ArrayDeque testDeque = new ArrayDeque();
        for (int i = 0; i <= 10; i++) {
            testDeque.addLast(i);
        }
        for (int i = 0; i <= 10; i++) {
            testDeque.addFirst(-i);
        }
        for (int i = 0; i <= 16; i++) {
            testDeque.removeFirst();
        }
        testDeque.printDeque();
    }

    public  static void main(String[] args) {
        /* arrayTest(); */
        /* getTest(); */
        /* removeTest(); */
        removeResize();
    }
}
