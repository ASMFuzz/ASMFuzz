public class MyJVMTest_11572 {

    static int count = 0;

    void increment() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11572().increment();
    }
}
