public class MyJVMTest_9397 {

    static byte[] dummy = {61,0,104,37,-126,14,47,-122,-35,-71};

    void run() {
        while (true) {
            dummy = new byte[4096];
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9397().run();
    }
}
