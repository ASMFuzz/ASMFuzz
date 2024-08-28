public class MyJVMTest_5015 {

    void foo() {
        Integer i = 100;
        do {
            return;
        } while (i++ < 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5015().foo();
    }
}
