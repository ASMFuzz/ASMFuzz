public class MyJVMTest_2312 {

    static int count = 0;

    void increment() {
        count++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2312().increment();
    }
}
