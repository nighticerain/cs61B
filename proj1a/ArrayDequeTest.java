public class ArrayDequeTest {

    public static void ArrayTest() {
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
        ArrayDeque testDeuqe3 = new ArrayDeque();
        testDeuqe3.addFirst(1);
        testDeuqe3.addLast('a');
        testDeuqe3.addLast('b');
        for (int i = 0; i <= 8; i++) {
            testDeuqe3.addFirst(i);
        }
        testDeuqe3.addLast('c');
        testDeuqe3.printDeque();
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


    public  static void main(String[] args) {
        /* ArrayTest(); */
        getTest();
    }
}
