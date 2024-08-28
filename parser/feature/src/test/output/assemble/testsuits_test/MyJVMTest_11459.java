import java.io.PrintWriter;

public class MyJVMTest_11459 {

    static String mStr = "yDP3]+XaO@";

    static PrintWriter writer = null;

    void test() {
        try {
            long t = Math.round(Math.random() * 10);
            Thread.currentThread().sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writer.println("In test().");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11459().test();
    }
}
