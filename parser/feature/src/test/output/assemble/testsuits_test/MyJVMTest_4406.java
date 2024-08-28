public class MyJVMTest_4406 {

    static int i = 0;

    void method2() {
        i = 5;
        System.out.println("c2 method2 called");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4406().method2();
    }
}
