public class ArrayDequeTest {

    public static void ArrayTest() {
        System.out.println("ArrayDeque1");
        ArrayDeque TestDeque1 = new ArrayDeque();
        TestDeque1.addFirst(1);
        TestDeque1.addLast('a');
        TestDeque1.addLast('b');
        TestDeque1.addLast('c');
        for(int i = 0; i <= 8; i++) {
            TestDeque1.addLast(i);
        }
        TestDeque1.printDeque();
        System.out.println("");

        System.out.println("ArrayDeque2");
        ArrayDeque TestDeque2 = new ArrayDeque();
        TestDeque2.addFirst(1);
        TestDeque2.addLast('a');
        TestDeque2.addLast('b');
        TestDeque2.addLast('c');
        for(int i = 0; i <= 8; i++) {
            TestDeque2.addFirst(i);
        }
        TestDeque2.printDeque();
        System.out.println("");

        System.out.println("ArrayDeque3");
        ArrayDeque TestDeque3 = new ArrayDeque();
        TestDeque3.addFirst(1);
        TestDeque3.addLast('a');
        TestDeque3.addLast('b');
        for(int i = 0; i <= 8; i++) {
            TestDeque3.addFirst(i);
        }
        TestDeque3.addLast('c');
        TestDeque3.printDeque();
        System.out.println("");

    }

    public  static void main(String[] args) {
        ArrayTest();
    }
}
