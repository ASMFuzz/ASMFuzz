public class MyJVMTest_9013 {

    static byte[] dummy = {-124,108,-45,-40,78,-10,-13,-123,97,-66};

    void run() {
        while (true) {
            dummy = new byte[4096];
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9013().run();
    }
}
