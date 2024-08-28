import java.io.PrintWriter;

public class MyJVMTest_3600 {

    void test() {
        try {
            long t = Math.round(Math.random() * 10);
            Thread.currentThread().sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        writer.println("In test().");
    }

    static PrintWriter writer = new PrintWriter(System.out);

    static TestObj testObj = new TestObj("This is a test.", writer);

    static int loopNum = 100;

    void run() {
        for (int i = 0; i < loopNum; i++) {
            testObj.test();
            writer.println(testObj);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3600().run();
    }
}
