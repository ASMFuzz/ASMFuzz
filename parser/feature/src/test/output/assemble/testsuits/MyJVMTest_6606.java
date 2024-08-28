public class MyJVMTest_6606 {

    void method1() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6606().method1();
    }
}
