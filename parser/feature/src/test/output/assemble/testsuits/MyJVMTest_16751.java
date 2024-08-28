public class MyJVMTest_16751 {

    static int fCounter = 0;

    void increment() {
        fCounter++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16751().increment();
    }
}
