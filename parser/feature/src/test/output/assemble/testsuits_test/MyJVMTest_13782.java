public class MyJVMTest_13782 {

    static int i = 5;

    void method2() {
        i = 5;
        System.out.println("c2 method2 called");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13782().method2();
    }
}
