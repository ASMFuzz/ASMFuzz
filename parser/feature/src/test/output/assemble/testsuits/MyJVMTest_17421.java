public class MyJVMTest_17421 {

    void method2() {
        for (int i = 20; i < 40; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17421().method2();
    }
}
