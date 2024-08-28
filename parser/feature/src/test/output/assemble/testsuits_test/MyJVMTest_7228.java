public class MyJVMTest_7228 {

    static int fCounter = 2;

    void increment() {
        fCounter++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7228().increment();
    }
}
