public class MyJVMTest_16102 {

    void method1() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16102().method1();
    }
}
