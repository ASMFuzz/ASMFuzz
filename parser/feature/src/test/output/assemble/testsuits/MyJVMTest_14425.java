public class MyJVMTest_14425 {

    void foo() {
        Integer i = 100;
        do {
            return;
        } while (i++ < 10);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14425().foo();
    }
}
